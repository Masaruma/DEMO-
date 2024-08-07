package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JsonPlaceHolderController(val jsonPlaceHolderServiceImpl: JsonPlaceHolderServiceImpl) {

    @GetMapping("/api/v1/posts")
    fun getAllPosts ():List<JsonPlaceHolder>? {
        val jsonPlaceHolderResponse = jsonPlaceHolderServiceImpl.getAll()
        return jsonPlaceHolderResponse
    }
}