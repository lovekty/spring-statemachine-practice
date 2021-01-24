/*
 * Auto-generated file. Created by MyBatis Generator
 */
package me.tony.practice.ssm.dal.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import me.tony.practice.ssm.model.prop.ItemState
import me.tony.practice.ssm.model.prop.ItemType
import org.mybatis.dynamic.sql.SqlTable

object ItemInfoDynamicSqlSupport {
    object ItemInfo : SqlTable("item_info") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val itemName = column<String>("item_name", JDBCType.VARCHAR)

        val itemState = column<ItemState>("item_state", JDBCType.INTEGER)

        val itemType = column<ItemType>("item_type", JDBCType.INTEGER)

        val itemDescription = column<String>("item_description", JDBCType.VARCHAR)

        val addTime = column<LocalDateTime>("add_time", JDBCType.TIMESTAMP)

        val updateTime = column<LocalDateTime>("update_time", JDBCType.TIMESTAMP)

        val visible = column<Boolean>("is_visible", JDBCType.BIT)
    }
}