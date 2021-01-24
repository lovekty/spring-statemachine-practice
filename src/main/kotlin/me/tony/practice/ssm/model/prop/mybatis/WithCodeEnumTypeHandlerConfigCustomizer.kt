package me.tony.practice.ssm.model.prop.mybatis

import me.tony.practice.ssm.model.prop.trait.WithCode
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.JdbcType
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.core.io.support.ResourcePatternResolver
import org.springframework.core.type.classreading.CachingMetadataReaderFactory
import org.springframework.core.type.classreading.MetadataReaderFactory
import org.springframework.util.ClassUtils
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*

/**
 * @author tony.zhuby
 */
class WithCodeEnumTypeHandlerConfigCustomizer(private val packages: Set<String>) : ConfigurationCustomizer,
    ApplicationContextAware {

    private lateinit var context: ApplicationContext
    private val metadataReaderFactory: MetadataReaderFactory = CachingMetadataReaderFactory()

    override fun customize(configuration: Configuration?) {
        configuration?.let { conf ->
            resolveClasses().forEach {
                conf.typeHandlerRegistry.register(it, GenericWithCodeEnumTypeHandler(it))
            }
        }
    }

    override fun setApplicationContext(ctx: ApplicationContext) {
        context = ctx
    }

    private fun resolveClasses(): Set<Class<Enum<*>>> {
        @Suppress("UNCHECKED_CAST")
        return packages.flatMap { pkg ->
            context.getResources(
                "${ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX}${ClassUtils.convertClassNameToResourcePath(pkg)}/*.class"
            ).map {
                metadataReaderFactory.getMetadataReader(it).classMetadata.className
            }.map {
                Class.forName(it)
            }.filter {
                it.isEnum && WithCode::class.java.isAssignableFrom(it)
            }.map {
                it as Class<Enum<*>>
            }
        }.toSet()
    }
}

private class GenericWithCodeEnumTypeHandler(clazz: Class<Enum<*>>) : BaseTypeHandler<Enum<*>>() {
    private val codeMap: Map<Int, Enum<*>> = EnumSet.allOf(clazz).associateBy { (it as WithCode).code }
    override fun setNonNullParameter(ps: PreparedStatement?, i: Int, parameter: Enum<*>?, jdbcType: JdbcType?) {
        (parameter as? WithCode)?.let {
            ps?.setInt(i, it.code)
        }
    }

    override fun getNullableResult(rs: ResultSet?, columnName: String?): Enum<*>? {
        return columnName?.let { name ->
            rs?.getInt(name)?.let { if (it == 0 && rs.wasNull()) null else codeMap[it] }
        }
    }

    override fun getNullableResult(rs: ResultSet?, columnIndex: Int): Enum<*>? {
        return rs?.getInt(columnIndex)?.let { if (it == 0 && rs.wasNull()) null else codeMap[it] }
    }

    override fun getNullableResult(cs: CallableStatement?, columnIndex: Int): Enum<*>? {
        return cs?.getInt(columnIndex)?.let { if (it == 0 && cs.wasNull()) null else codeMap[it] }
    }

}