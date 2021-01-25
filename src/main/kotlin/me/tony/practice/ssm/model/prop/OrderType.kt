package me.tony.practice.ssm.model.prop

import me.tony.practice.ssm.model.prop.trait.WithCode

/**
 * @author tony.zhuby
 */
enum class OrderType(override val code: Int) : WithCode {
    NORMAL(1),
    DISCOUNT(2)
}