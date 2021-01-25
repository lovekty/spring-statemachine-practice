/*
 * Auto-generated file. Created by MyBatis Generator
 */
package me.tony.practice.ssm.dal.entity

import java.time.LocalDateTime
import me.tony.practice.ssm.model.prop.OrderState
import me.tony.practice.ssm.model.prop.OrderType

data class OrderInfoRecord(
    var id: Long? = null,
    var orderSpuInfo: String? = null,
    var orderSkuInfo: String? = null,
    var orderState: OrderState? = null,
    var orderType: OrderType? = null,
    var addTime: LocalDateTime? = null,
    var updateTime: LocalDateTime? = null,
    var visible: Boolean? = null
)