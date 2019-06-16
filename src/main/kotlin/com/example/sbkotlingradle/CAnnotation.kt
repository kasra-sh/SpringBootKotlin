package com.example.sbkotlingradle

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class CAnnotation(val value: Int)