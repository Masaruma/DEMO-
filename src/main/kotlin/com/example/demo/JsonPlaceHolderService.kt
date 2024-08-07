package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Service
class JsonPlaceHolderServiceImpl(val restClientBuilder: RestClient.Builder) {
    fun getAll(): List<JsonPlaceHolder>? {
        val jsonPlaceHolderResponse = restClientBuilder
            .build()
            .get()
            .uri("https://jsonplaceholder.org/posts")
            .retrieve()
            .body<List<JsonPlaceHolder>>()

        return jsonPlaceHolderResponse
    }
}