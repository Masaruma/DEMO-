package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class JsonPlaceHolderController(val jsonPlaceHolderServiceImpl: JsonPlaceHolderServiceImpl) {

    @GetMapping("/api/v1/posts")
    fun getAllPosts ():List<JsonPlaceHolder>? =
         jsonPlaceHolderServiceImpl.getAll()

    @PostMapping("/api/v1/posts")
    @ResponseStatus(HttpStatus.CREATED)
    fun savePost(@RequestBody jsonPlaceHolder: JsonPlaceHolder): JsonPlaceHolder? =
        jsonPlaceHolderServiceImpl.savePost(jsonPlaceHolder)

    /*
    When you do a POST request, we an return HTTP Status code 201 and include a header called as Location with the url of the new resource created

    HTTP 1.1 /api/v1/posts POST
    {
    }

    Response:
    HTTP 201 CREATED
    Location: http://localhost:8080/api/v1/posts/1
    */

}