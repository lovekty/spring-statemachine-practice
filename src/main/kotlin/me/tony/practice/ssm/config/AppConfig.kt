package me.tony.practice.ssm.config

import me.tony.practice.ssm.event.ItemEvent
import me.tony.practice.ssm.model.prop.ItemState
import me.tony.practice.ssm.model.prop.mybatis.WithCodeEnumTypeHandlerConfigCustomizer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.listener.StateMachineListener
import org.springframework.statemachine.listener.StateMachineListenerAdapter
import org.springframework.statemachine.transition.Transition

/**
 * @author tony.zhuby
 */
@Configuration
class AppConfig {

    @Bean
    fun mybatisCustomizer(): WithCodeEnumTypeHandlerConfigCustomizer {
        return WithCodeEnumTypeHandlerConfigCustomizer(setOf("me.tony.practice.sm.model.prop"))
    }

    @Bean
    fun itemStateMachineListener(): StateMachineListener<ItemState, ItemEvent> {
        return object : StateMachineListenerAdapter<ItemState, ItemEvent>() {
            val log: Logger = LoggerFactory.getLogger(this.javaClass)
            override fun transition(transition: Transition<ItemState, ItemEvent>) {
                log.info("transition from ${transition.source.id} to ${transition.target.id}")
            }
        }
    }
}