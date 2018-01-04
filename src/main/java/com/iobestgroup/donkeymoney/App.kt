package com.iobestgroup.donkeymoney

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
@PropertySources(PropertySource("classpath:application.properties"), PropertySource("classpath:application-database.properties"))
open class App {

    @Bean
    open fun bCryptPasswordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder()


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(App::class.java, *args)
        }
    }
}
