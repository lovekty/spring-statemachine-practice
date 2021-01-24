package me.tony.practice.ssm.model.prop

import me.tony.practice.ssm.model.prop.trait.WithCode


/**
 * @author tony.zhuby
 */
enum class ItemType(override val code: Int) : WithCode {
    TYPE_A(1),
    TYPE_B(2),
    TYPE_C(3)
}