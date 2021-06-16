package com.tangzhihong.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
class DemoApplication {

    fun main(args: Array<String>) {
        SpringApplication.run(DemoApplication::class.java, *args)
    }
}