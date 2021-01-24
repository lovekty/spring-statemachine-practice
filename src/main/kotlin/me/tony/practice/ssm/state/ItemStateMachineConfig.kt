package me.tony.practice.ssm.state

import me.tony.practice.ssm.dal.entity.ItemInfoRecord
import me.tony.practice.ssm.event.ItemEvent
import me.tony.practice.ssm.model.prop.ItemState
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.config.EnableStateMachineFactory
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer
import org.springframework.statemachine.listener.StateMachineListener
import org.springframework.statemachine.persist.StateMachineRuntimePersister
import java.util.*

/**
 * @author tony.zhuby
 * @date 2021/1/24
 */
@Configuration
@EnableStateMachineFactory(name = ["itemStateMachineFactory"])
class ItemStateMachineConfig(
    @Qualifier("itemStateMachineListener") val listener: StateMachineListener<ItemState, ItemEvent>,
    @Qualifier("itemStateMachineRuntimePersister") val persister: StateMachineRuntimePersister<ItemState, ItemEvent, ItemInfoRecord>
) :
    EnumStateMachineConfigurerAdapter<ItemState, ItemEvent>() {

    override fun configure(states: StateMachineStateConfigurer<ItemState, ItemEvent>) {
        states.withStates().initial(ItemState.OPEN)
            .states(EnumSet.allOf(ItemState::class.java))
    }

    override fun configure(config: StateMachineConfigurationConfigurer<ItemState, ItemEvent>) {
        config.withConfiguration().listener(listener)
            .and()
            .withPersistence().runtimePersister(persister)
    }

    override fun configure(transitions: StateMachineTransitionConfigurer<ItemState, ItemEvent>) {
        transitions.withExternal()
            .source(ItemState.OPEN).target(ItemState.PROCESSING)
            .event(ItemEvent.START_PROCESS)
            .and()
            .withChoice()
    }
}