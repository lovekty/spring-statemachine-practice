package me.tony.practice.ssm

import me.tony.practice.ssm.dal.entity.OrderInfoRecord
import me.tony.practice.ssm.event.OrderEvent
import me.tony.practice.ssm.model.prop.OrderState
import me.tony.practice.ssm.model.prop.OrderType
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.messaging.support.MessageBuilder
import org.springframework.statemachine.config.StateMachineFactory
import org.springframework.statemachine.persist.StateMachinePersister
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(value = SpringRunner::class)
class AppTests {

    @Autowired
    @Qualifier("orderStateMachineFactory")
    lateinit var factory: StateMachineFactory<OrderState, OrderEvent>

    @Autowired
    lateinit var persister: StateMachinePersister<OrderState, OrderEvent, OrderInfoRecord>

    @Autowired
    lateinit var appCtx: ApplicationContext

    @Test
    fun loadContext() {
        val bean = appCtx.getBean("orderStateMachineFactory")
        println(bean)
    }

    @Test
    fun testOrder() {
        val sm = factory.stateMachine
        sm.start()
        sm.sendEvent(MessageBuilder.withPayload(OrderEvent.ORDER).build())
        val record = OrderInfoRecord(
            orderSpuInfo = "spu info",
            orderSkuInfo = "sku info",
            orderType = OrderType.NORMAL
        )
        persister.persist(sm, record)
    }

}
