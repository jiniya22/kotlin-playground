package xyz.applebox.kotlin

import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@SpringBootApplication
class R2dbcApplication {

    @Bean
    fun initializer(connectionFactory: ConnectionFactory) =
        ConnectionFactoryInitializer().apply {
            setConnectionFactory(connectionFactory)
            val populator = ResourceDatabasePopulator(ClassPathResource("scripts/schema.sql"))
            populator.setContinueOnError(true)
            setDatabasePopulator(populator)
        }
}

fun main(args: Array<String>) {
    runApplication<R2dbcApplication>(*args)
}