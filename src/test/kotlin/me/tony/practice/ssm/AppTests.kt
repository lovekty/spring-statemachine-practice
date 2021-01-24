package me.tony.practice.ssm

import me.tony.practice.ssm.dal.entity.ItemInfoRecord
import me.tony.practice.ssm.dal.mapper.ItemInfoDynamicSqlSupport.ItemInfo.visible
import me.tony.practice.ssm.dal.mapper.ItemInfoMapper
import me.tony.practice.ssm.dal.mapper.insertSelective
import me.tony.practice.ssm.dal.mapper.select
import me.tony.practice.ssm.model.prop.ItemState
import org.junit.jupiter.api.Test
import org.mybatis.dynamic.sql.where.condition.IsEqualTo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AppTests {

    @Autowired
    lateinit var mapper: ItemInfoMapper

    @Test
    fun testInsert() {
        val entity = ItemInfoRecord(
            itemName = "demo item",
            itemState = ItemState.CLOSE,
            itemDescription = "demo item description"
        )
        mapper.insertSelective(entity)
    }

    @Test
    fun testSelect() {
        val result = mapper.select {
            and(visible, IsEqualTo.of { true })

        }
        result.forEach {
            println(it)
        }
    }

}
