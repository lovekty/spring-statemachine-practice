package me.tony.practice.ssm.state

import me.tony.practice.ssm.model.prop.ItemState
import org.springframework.statemachine.StateMachineContext
import org.springframework.statemachine.StateMachineContextRepository
import java.awt.event.ItemEvent

/**
 * @author tony.zhuby
 * @date 2021/1/24
 */
class ItemRepository : StateMachineContextRepository<ItemState, ItemEvent, StateMachineContext<ItemState, ItemEvent>> {
    override fun save(context: StateMachineContext<ItemState, ItemEvent>, id: String) {
//        context.get
    }

    override fun getContext(id: String?): StateMachineContext<ItemState, ItemEvent> {
        TODO("Not yet implemented")
    }
}