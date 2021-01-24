package me.tony.practice.ssm.state

import me.tony.practice.ssm.dal.entity.ItemInfoRecord
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.id
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.visible
import me.tony.practice.ssm.dal.mapper.ItemInfoMapper
import me.tony.practice.ssm.dal.mapper.select
import me.tony.practice.ssm.dal.mapper.selectOne
import me.tony.practice.ssm.event.ItemEvent
import me.tony.practice.ssm.model.prop.ItemState
import org.mybatis.dynamic.sql.where.condition.IsEqualTo
import org.springframework.statemachine.StateMachineContext
import org.springframework.statemachine.persist.AbstractPersistingStateMachineInterceptor
import org.springframework.statemachine.persist.StateMachineRuntimePersister
import org.springframework.statemachine.support.DefaultStateMachineContext
import org.springframework.statemachine.support.StateMachineInterceptor
import org.springframework.stereotype.Component

/**
 * @author tony.zhuby
 * @date 2021/1/25
 */
@Component
class ItemStateMachineRuntimePersister(val mapper:ItemInfoMapper) : AbstractPersistingStateMachineInterceptor<ItemState, ItemEvent, Long>(),
    StateMachineRuntimePersister<ItemState, ItemEvent, Long> {
    override fun write(context: StateMachineContext<ItemState, ItemEvent>?, contextObj: Long) {
        TODO("Not yet implemented")
    }

    override fun read(contextObj: Long): StateMachineContext<ItemState, ItemEvent> {
        val record = mapper.selectOne {
            and(id, IsEqualTo.of { contextObj })
                .and(visible, IsEqualTo.of { true })
        }
        return DefaultStateMachineContext<ItemState, ItemEvent>()
    }

    override fun getInterceptor(): StateMachineInterceptor<ItemState, ItemEvent> {
        return this
    }
}