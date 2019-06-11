package com.example.sbkotlingradle

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/todoItems")
class TodoItemController(
        @Autowired val todoItemService: TodoItemService) {

    @GetMapping("/xml", produces = [MediaType.APPLICATION_XML_VALUE])
    fun getAllXml() = TodoItemsXml(todoItemService.findAll())

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll()= todoItemService.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = todoItemService.findById(id)

    @PostMapping
    fun post(@RequestBody item: TodoItem) = todoItemService.save(item)

    @PutMapping
    fun put(@RequestBody item: TodoItem) = todoItemService.save(item)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = todoItemService.delete(id)
}