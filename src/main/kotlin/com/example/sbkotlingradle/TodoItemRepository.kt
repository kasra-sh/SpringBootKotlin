package com.example.sbkotlingradle

import org.springframework.data.jpa.repository.JpaRepository

interface TodoItemRepository : JpaRepository<TodoItem, Long>