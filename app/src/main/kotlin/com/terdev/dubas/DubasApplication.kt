package com.terdev.dubas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.terdev.dubas", "com.terdev.rolrul", "com.terdev.context"])
class DubasApplication

fun main(args: Array<String>) {
    runApplication<DubasApplication>(*args)
}