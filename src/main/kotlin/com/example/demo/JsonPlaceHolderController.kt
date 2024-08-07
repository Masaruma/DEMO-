package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class JsonPlaceHolderController(val jsonPlaceHolderServiceImpl: JsonPlaceHolderServiceImpl) {

    @GetMapping("/api/v1/posts")
    fun getAllPosts ():List<JsonPlaceHolder>? {
        val jsonPlaceHolderResponse = jsonPlaceHolderServiceImpl.getAll()
        return jsonPlaceHolderResponse
    }

    @PostMapping("/api/v1/posts")
    @ResponseStatus(HttpStatus.CREATED)
    fun savePost(@RequestBody jsonPlaceHolder: JsonPlaceHolder): JsonPlaceHolder? {
         return jsonPlaceHolderServiceImpl.savePost(jsonPlaceHolder)
    }
}