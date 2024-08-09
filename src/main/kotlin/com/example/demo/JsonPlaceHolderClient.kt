package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.client.*

@Component
class JsonPlaceHolderClient(val restClient: RestClient) {
    fun getAll(): List<JsonPlaceHolder>? {
        val jsonPlaceHolderResponse = restClient
            .get()
            .uri("https://jsonplaceholder.org/posts")
            .retrieve()
            .body<List<JsonPlaceHolder>>()

        return jsonPlaceHolderResponse
    }

    fun savePost(jsonPlaceHolder: JsonPlaceHolder) {
        restClient
            .post()
            .uri("https://jsonplaceholder.org/posts")
            .body(jsonPlaceHolder)
            .retrieve()
    }
}

@Configuration
class RestClientConfig {
    @Bean
    fun restClient(builder: RestClient.Builder):RestClient {
        return builder.build()
    }
}