package com.example.sbkotlingradle

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "Todos")
data class TodoItemsXml(
        @JacksonXmlProperty(localName = "Todo")
        @JacksonXmlElementWrapper(useWrapping = false)
        var items: List<TodoItem>
)
