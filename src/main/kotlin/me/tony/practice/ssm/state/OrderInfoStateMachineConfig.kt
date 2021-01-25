package me.tony.practice.ssm.state

import me.tony.practice.ssm.dal.entity.OrderInfoRecord
import me.tony.practice.ssm.event.OrderEvent
import me.tony.practice.ssm.model.prop.OrderState
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.config.EnableStateMachineFactory
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer
import org.springframework.statemachine.listener.StateMachineListener
import org.springframework.statemachine.listener.StateMachineListenerAdapter
import org.springframework.statemachine.persist.DefaultStateMachinePersister
import org.springframework.statemachine.persist.StateMachinePersister
import org.springframework.statemachine.persist.StateMachineRuntimePersister
import org.springframework.statemachine.transition.Transition
import java.util.*

/**
 * @author tony.zhuby
 * @date 2021/1/24
 */
@Configuration
@EnableStateMachineFactory(name = ["orderStateMachineFactory"])
class OrderInfoStateMachineConfig(
    @Qualifier("orderStateMachineRuntimePersister") val persister: StateMachineRuntimePersister<OrderState, OrderEvent, OrderInfoRecord>
) :
    EnumStateMachineConfigurerAdapter<OrderState, OrderEvent>() {

    override fun configure(states: StateMachineStateConfigurer<OrderState, OrderEvent>) {
        states.withStates().initial(OrderState.ORDERED)
            .states(EnumSet.allOf(OrderState::class.java))
    }

    override fun configure(config: StateMachineConfigurationConfigurer<OrderState, OrderEvent>) {
        config.withConfiguration().listener(orderStateMachineListener()).machineId("orderStateMachine")
            .and()
            .withPersistence().runtimePersister(persister)
    }

    override fun configure(transitions: StateMachineTransitionConfigurer<OrderState, OrderEvent>) {
        transitions.withExternal()
            .source(OrderState.ORDERED).target(OrderState.PAYED)
            .event(OrderEvent.PAY)
            .and()
            .withChoice()
    }

    @Bean
    fun orderStateMachineListener(): StateMachineListener<OrderState, OrderEvent> {
        return object : StateMachineListenerAdapter<OrderState, OrderEvent>() {
            val log: Logger = LoggerFactory.getLogger(this.javaClass)
            override fun transition(transition: Transition<OrderState, OrderEvent>) {
                log.info("transition from ${transition.source.id} to ${transition.target.id}")
            }
        }
    }

    @Bean
    fun persister(): StateMachinePersister<OrderState, OrderEvent, OrderInfoRecord> {
        return DefaultStateMachinePersister(persister)
    }
}