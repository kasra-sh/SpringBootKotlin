package com.example.sbkotlingradle

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@Api("Todo", tags = ["Todo"], description = "Manage Todo Items")
@RestController
@RequestMapping("/api/todoItems")
class TodoItemController(
        @Autowired val todoItemService: TodoItemService) {

    @GetMapping("/xml", produces = [MediaType.APPLICATION_XML_VALUE])
    fun getAllXml() = TodoItemsXml(todoItemService.findAll())

    @CAnnotation(5)
    @ApiOperation("Get All Todo JSON", notes = "Get All as Json")
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll()= todoItemService.findAll()

    @GetMapping("/{id}")
    fun getById(@ApiParam(allowableValues = "0,1,2") @PathVariable id: Long) = todoItemService.findById(id)

    @PostMapping
    fun post(@RequestBody item: TodoItem) = todoItemService.save(item)

    @PutMapping
    fun put(@RequestBody item: TodoItem) = todoItemService.save(item)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = todoItemService.delete(id)
}