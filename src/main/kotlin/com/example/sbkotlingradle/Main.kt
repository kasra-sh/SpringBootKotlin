package com.example.sbkotlingradle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class SbKotlinGradleApplication

fun main(args: Array<String>) {
    runApplication<SbKotlinGradleApplication>(*args)
}

@Configuration
class AppConfig: WebMvcConfigurer {

//    @Autowired
//    lateinit var interceptor: TestInterceptor

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(TestInterceptor())
    }
}