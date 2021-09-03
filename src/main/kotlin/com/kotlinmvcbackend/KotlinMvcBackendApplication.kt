package com.kotlinmvcbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinMvcBackendApplication

fun main(args: Array<String>) {
	runApplication<KotlinMvcBackendApplication>(*args)
}
