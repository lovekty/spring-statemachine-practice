package me.tony.practice.ssm

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.type.classreading.MetadataReaderFactory

@SpringBootApplication
class App {

    @Autowired
    lateinit var a:MetadataReaderFactory

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<App>(*args)
        }
    }
}
