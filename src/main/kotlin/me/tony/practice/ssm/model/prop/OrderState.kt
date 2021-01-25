package me.tony.practice.ssm.model.prop

import me.tony.practice.ssm.model.prop.trait.WithCode

/**
 * @author tony.zhuby
 */
enum class OrderState(override val code: Int) : WithCode {

    ORDERED(1),
    PAYED(2),
    SHIPPED(3),
    CANCELED(4),
    RECEIVED(5),
    FINISH(6)
}