package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.client.RestClient
import kotlin.test.assertEquals


@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = [
        "baseUrl=http://localhost:8888"
    ]
)
class JsonPlaceHolderIT {

    @LocalServerPort
    var port: Int = 0
    val restClient = RestClient.create()

    @Test
    fun `get all posts`() {
        val responseEntity = restClient
            .get()
            .uri("http://localhost:$port/api/v1/posts")
            .retrieve()
            .toEntity(Array<JsonPlaceHolder>::class.java)

        // assertEquals - 'org.junit' and 'Kotlin.test' packages

        assertEquals(HttpStatus.OK, responseEntity.statusCode)
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.headers.contentType)
    }

    @Test
    fun `save post`() {
        val requestBody = JsonPlaceHolderBuilder().build()
        val responseEntity = restClient
            .post()
            .uri("http://localhost:$port/api/v1/posts")
            .body(requestBody)
            .retrieve()
            .toBodilessEntity()

        assertEquals(HttpStatus.CREATED, responseEntity.statusCode)

    }
}