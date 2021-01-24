package me.tony.practice.ssm.model.prop

import me.tony.practice.ssm.model.prop.trait.WithCode


/**
 * @author tony.zhuby
 */
enum class ItemState(override val code: Int) : WithCode {
    OPEN(1),
    PROCESSING(2),
    CLOSE(10)
}