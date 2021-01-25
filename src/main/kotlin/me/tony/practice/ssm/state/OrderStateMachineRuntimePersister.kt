package me.tony.practice.ssm.state

import me.tony.practice.ssm.dal.entity.OrderInfoRecord
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.id
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.orderState
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.visible
import me.tony.practice.ssm.dal.mapper.OrderInfoMapper
import me.tony.practice.ssm.dal.mapper.insertSelective
import me.tony.practice.ssm.dal.mapper.selectOne
import me.tony.practice.ssm.dal.mapper.update
import me.tony.practice.ssm.event.OrderEvent
import me.tony.practice.ssm.model.prop.OrderState
import org.mybatis.dynamic.sql.where.condition.IsEqualTo
import org.springframework.statemachine.StateMachineContext
import org.springframework.statemachine.persist.StateMachineRuntimePersister
import org.springframework.statemachine.support.DefaultExtendedState
import org.springframework.statemachine.support.DefaultStateMachineContext
import org.springframework.statemachine.support.StateMachineInterceptor
import org.springframework.statemachine.support.StateMachineInterceptorAdapter
import org.springframework.stereotype.Component

/**
 * @author tony.zhuby
 * @date 2021/1/25
 */
@Component
class OrderStateMachineRuntimePersister(val mapper: OrderInfoMapper) :
    StateMachineInterceptorAdapter<OrderState, OrderEvent>(),
    StateMachineRuntimePersister<OrderState, OrderEvent, OrderInfoRecord> {
    override fun write(context: StateMachineContext<OrderState, OrderEvent>, contextObj: OrderInfoRecord?) {
        contextObj?.let {
            if (context.event == OrderEvent.ORDER && contextObj.id == null) {
                mapper.insertSelective(contextObj)
            } else if (contextObj.id != null && contextObj.orderState != null) {
                mapper.update {
                    set(orderState).equalToWhenPresent(context.state)
                    where(id, IsEqualTo.of { contextObj.id })
                    where(orderState, IsEqualTo.of { contextObj.orderState })
                    where(visible, IsEqualTo.of { true })
                }
            } else {
                0
            }
        }?.apply {
            if (this == 0) {
                throw RuntimeException()
            }
        }

    }

    override fun read(contextObj: OrderInfoRecord?): StateMachineContext<OrderState, OrderEvent>? {
        return contextObj?.let { record ->
            if (record.id != null)
                mapper.selectOne {
                    where(id, IsEqualTo.of { record.id })
                    where(visible, IsEqualTo.of { true })
                }
            else
                record
        }?.let {
            DefaultStateMachineContext(
                it.orderState,
                null,
                mapOf(),
                DefaultExtendedState(mapOf("orderItem" to it))
            )
        }
    }

    override fun getInterceptor(): StateMachineInterceptor<OrderState, OrderEvent> {
        return this
    }
}