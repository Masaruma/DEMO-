package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

interface JsonPlaceHolderService {
    fun getAll() : List<JsonPlaceHolder>?
    fun savePost(jsonPlaceHolder: JsonPlaceHolder): JsonPlaceHolder?
}

@Service
class JsonPlaceHolderServiceImpl(val restClientBuilder: RestClient.Builder): JsonPlaceHolderService {
    override fun getAll(): List<JsonPlaceHolder>? {
        val jsonPlaceHolderResponse = restClientBuilder
            .build()
            .get()
            .uri("https://jsonplaceholder.org/posts")
            .retrieve()
            .body<List<JsonPlaceHolder>>()

        return jsonPlaceHolderResponse
    }

    override fun savePost(jsonPlaceHolder: JsonPlaceHolder): JsonPlaceHolder? {
        TODO("Not yet implemented")
    }
}