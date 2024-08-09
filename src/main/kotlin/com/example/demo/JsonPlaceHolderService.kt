package com.example.demo

import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

interface JsonPlaceHolderService {
    fun getAll() : List<JsonPlaceHolder>?
    fun savePost(jsonPlaceHolder: JsonPlaceHolder): JsonPlaceHolder?
}

@Service
class JsonPlaceHolderServiceImpl(val restClientBuilder: RestClient.Builder, val jsonPlaceHolderClient: JsonPlaceHolderClient): JsonPlaceHolderService {
    override fun getAll(): List<JsonPlaceHolder>? {
        return jsonPlaceHolderClient.getAll()
    }

    override fun savePost(jsonPlaceHolder: JsonPlaceHolder): JsonPlaceHolder? {
        val saved = restClientBuilder
            .build()
            .post()
            .uri("https://jsonplaceholder.org/posts")
            .contentType(MediaType.APPLICATION_JSON)
            .body(jsonPlaceHolder)
            .retrieve()
            .body<JsonPlaceHolder>()

        return saved
    }
}