/*
 * Auto-generated file. Created by MyBatis Generator
 */
package me.tony.practice.ssm.dal.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import me.tony.practice.ssm.model.prop.OrderState
import me.tony.practice.ssm.model.prop.OrderType
import org.mybatis.dynamic.sql.SqlTable

object OrderInfoDynamicSqlSupport {
    object OrderInfo : SqlTable("order_info") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val orderSpuInfo = column<String>("order_spu_info", JDBCType.VARCHAR)

        val orderSkuInfo = column<String>("order_sku_info", JDBCType.VARCHAR)

        val orderState = column<OrderState>("order_state", JDBCType.INTEGER)

        val orderType = column<OrderType>("order_type", JDBCType.INTEGER)

        val addTime = column<LocalDateTime>("add_time", JDBCType.TIMESTAMP)

        val updateTime = column<LocalDateTime>("update_time", JDBCType.TIMESTAMP)

        val visible = column<Boolean>("is_visible", JDBCType.BIT)
    }
}