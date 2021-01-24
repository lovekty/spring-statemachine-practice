/*
 * Auto-generated file. Created by MyBatis Generator
 */
package me.tony.practice.ssm.dal.entity

import java.time.LocalDateTime
import me.tony.practice.ssm.model.prop.ItemState
import me.tony.practice.ssm.model.prop.ItemType

data class ItemInfoRecord(
    var id: Long? = null,
    var itemName: String? = null,
    var itemState: ItemState? = null,
    var itemType: ItemType? = null,
    var itemDescription: String? = null,
    var addTime: LocalDateTime? = null,
    var updateTime: LocalDateTime? = null,
    var visible: Boolean? = null
)