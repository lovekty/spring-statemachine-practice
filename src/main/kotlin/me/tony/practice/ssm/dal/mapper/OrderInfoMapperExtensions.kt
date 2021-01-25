/*
 * Auto-generated file. Created by MyBatis Generator
 */
package me.tony.practice.ssm.dal.mapper

import me.tony.practice.ssm.dal.entity.OrderInfoRecord
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.addTime
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.id
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.orderSkuInfo
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.orderSpuInfo
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.orderState
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.orderType
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.updateTime
import me.tony.practice.ssm.dal.mapper.OrderInfoDynamicSqlSupport.OrderInfo.visible
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun OrderInfoMapper.count(completer: CountCompleter) =
    countFrom(this::count, OrderInfo, completer)

fun OrderInfoMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, OrderInfo, completer)

fun OrderInfoMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun OrderInfoMapper.insert(record: OrderInfoRecord) =
    insert(this::insert, record, OrderInfo) {
        map(orderSpuInfo).toProperty("orderSpuInfo")
        map(orderSkuInfo).toProperty("orderSkuInfo")
        map(orderState).toProperty("orderState")
        map(orderType).toProperty("orderType")
        map(visible).toProperty("visible")
    }

fun OrderInfoMapper.insertSelective(record: OrderInfoRecord) =
    insert(this::insert, record, OrderInfo) {
        map(orderSpuInfo).toPropertyWhenPresent("orderSpuInfo", record::orderSpuInfo)
        map(orderSkuInfo).toPropertyWhenPresent("orderSkuInfo", record::orderSkuInfo)
        map(orderState).toPropertyWhenPresent("orderState", record::orderState)
        map(orderType).toPropertyWhenPresent("orderType", record::orderType)
        map(visible).toPropertyWhenPresent("visible", record::visible)
    }

private val columnList = listOf(id, orderSpuInfo, orderSkuInfo, orderState, orderType, addTime, updateTime, visible)

fun OrderInfoMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, OrderInfo, completer)

fun OrderInfoMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, OrderInfo, completer)

fun OrderInfoMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, OrderInfo, completer)

fun OrderInfoMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun OrderInfoMapper.update(completer: UpdateCompleter) =
    update(this::update, OrderInfo, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: OrderInfoRecord) =
    apply {
        set(orderSpuInfo).equalTo(record::orderSpuInfo)
        set(orderSkuInfo).equalTo(record::orderSkuInfo)
        set(orderState).equalTo(record::orderState)
        set(orderType).equalTo(record::orderType)
        set(visible).equalTo(record::visible)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: OrderInfoRecord) =
    apply {
        set(orderSpuInfo).equalToWhenPresent(record::orderSpuInfo)
        set(orderSkuInfo).equalToWhenPresent(record::orderSkuInfo)
        set(orderState).equalToWhenPresent(record::orderState)
        set(orderType).equalToWhenPresent(record::orderType)
        set(visible).equalToWhenPresent(record::visible)
    }

fun OrderInfoMapper.updateByPrimaryKey(record: OrderInfoRecord) =
    update {
        set(orderSpuInfo).equalTo(record::orderSpuInfo)
        set(orderSkuInfo).equalTo(record::orderSkuInfo)
        set(orderState).equalTo(record::orderState)
        set(orderType).equalTo(record::orderType)
        set(visible).equalTo(record::visible)
        where(id, isEqualTo(record::id))
    }

fun OrderInfoMapper.updateByPrimaryKeySelective(record: OrderInfoRecord) =
    update {
        set(orderSpuInfo).equalToWhenPresent(record::orderSpuInfo)
        set(orderSkuInfo).equalToWhenPresent(record::orderSkuInfo)
        set(orderState).equalToWhenPresent(record::orderState)
        set(orderType).equalToWhenPresent(record::orderType)
        set(visible).equalToWhenPresent(record::visible)
        where(id, isEqualTo(record::id))
    }