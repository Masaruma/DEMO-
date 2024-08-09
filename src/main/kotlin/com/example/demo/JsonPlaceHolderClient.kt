package com.example.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Component
class JsonPlaceHolderClient(val restClient: RestClient) {
    fun getAll(): List<JsonPlaceHolder>? =
         restClient
            .get()
            .uri("/posts")
            .retrieve()
            .body<List<JsonPlaceHolder>>()


    fun savePost(jsonPlaceHolder: JsonPlaceHolder) : JsonPlaceHolder? =
        restClient
            .post()
            .uri("/posts")
            .body(jsonPlaceHolder)
            .retrieve()
            .body(JsonPlaceHolder::class.java)

}

@Configuration
class RestClientConfig {
    @Value("\${baseUrl}")
    lateinit var baseUrl : String
    @Bean
    fun restClient(builder: RestClient.Builder):RestClient {
        return builder.baseUrl(baseUrl).build()
    }
}