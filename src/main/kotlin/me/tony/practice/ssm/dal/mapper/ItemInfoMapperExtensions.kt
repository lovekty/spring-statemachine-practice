/*
 * Auto-generated file. Created by MyBatis Generator
 */
package me.tony.practice.ssm.dal.mapper

import me.tony.practice.ssm.dal.entity.ItemInfoRecord
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.addTime
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.id
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.itemDescription
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.itemName
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.itemState
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.itemType
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.updateTime
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.visible
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun ItemInfoMapper.count(completer: CountCompleter) =
    countFrom(this::count, ItemInfo, completer)

fun ItemInfoMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, ItemInfo, completer)

fun ItemInfoMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun ItemInfoMapper.insert(record: ItemInfoRecord) =
    insert(this::insert, record, ItemInfo) {
        map(itemName).toProperty("itemName")
        map(itemState).toProperty("itemState")
        map(itemType).toProperty("itemType")
        map(itemDescription).toProperty("itemDescription")
        map(visible).toProperty("visible")
    }

fun ItemInfoMapper.insertSelective(record: ItemInfoRecord) =
    insert(this::insert, record, ItemInfo) {
        map(itemName).toPropertyWhenPresent("itemName", record::itemName)
        map(itemState).toPropertyWhenPresent("itemState", record::itemState)
        map(itemType).toPropertyWhenPresent("itemType", record::itemType)
        map(itemDescription).toPropertyWhenPresent("itemDescription", record::itemDescription)
        map(visible).toPropertyWhenPresent("visible", record::visible)
    }

private val columnList = listOf(id, itemName, itemState, itemType, itemDescription, addTime, updateTime, visible)

fun ItemInfoMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, ItemInfo, completer)

fun ItemInfoMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, ItemInfo, completer)

fun ItemInfoMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, ItemInfo, completer)

fun ItemInfoMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun ItemInfoMapper.update(completer: UpdateCompleter) =
    update(this::update, ItemInfo, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ItemInfoRecord) =
    apply {
        set(itemName).equalTo(record::itemName)
        set(itemState).equalTo(record::itemState)
        set(itemType).equalTo(record::itemType)
        set(itemDescription).equalTo(record::itemDescription)
        set(visible).equalTo(record::visible)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ItemInfoRecord) =
    apply {
        set(itemName).equalToWhenPresent(record::itemName)
        set(itemState).equalToWhenPresent(record::itemState)
        set(itemType).equalToWhenPresent(record::itemType)
        set(itemDescription).equalToWhenPresent(record::itemDescription)
        set(visible).equalToWhenPresent(record::visible)
    }

fun ItemInfoMapper.updateByPrimaryKey(record: ItemInfoRecord) =
    update {
        set(itemName).equalTo(record::itemName)
        set(itemState).equalTo(record::itemState)
        set(itemType).equalTo(record::itemType)
        set(itemDescription).equalTo(record::itemDescription)
        set(visible).equalTo(record::visible)
        where(id, isEqualTo(record::id))
    }

fun ItemInfoMapper.updateByPrimaryKeySelective(record: ItemInfoRecord) =
    update {
        set(itemName).equalToWhenPresent(record::itemName)
        set(itemState).equalToWhenPresent(record::itemState)
        set(itemType).equalToWhenPresent(record::itemType)
        set(itemDescription).equalToWhenPresent(record::itemDescription)
        set(visible).equalToWhenPresent(record::visible)
        where(id, isEqualTo(record::id))
    }