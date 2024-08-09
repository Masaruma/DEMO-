package com.example.demo


import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.context.annotation.Import
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers.*
import org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess


@RestClientTest(JsonPlaceHolderClient::class)
@Import(RestClientConfig::class)
class JsonPlaceHolderClientTest {

    val objectMapper = ObjectMapper()
    @Autowired
    private lateinit var mockServer: MockRestServiceServer

    @Autowired
    private lateinit var jsonPlaceHolderClient: JsonPlaceHolderClient

    @BeforeEach
    fun setup() {
        mockServer.reset()
    }


    @Test
    fun `should call mock server return fetched posts at GET Request`() {

        val expected = listOf(JsonPlaceHolder(
            id = 2,
            slug = "lorem-ipsum",
            url = "https://jsonplaceholder.org/posts/lorem-ipsum",
            title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            content = "Ante taciti nulla sit libero orci sed nam. Sagittis suspendisse gravida ornare iaculis cras nullam varius ac ullamcorper. Nunc euismod hendrerit netus ligula aptent potenti. Aliquam volutpat nibh scelerisque at. Ipsum molestie phasellus euismod sagittis mauris, erat ut. Gravida morbi, sagittis blandit quis ipsum mi mus semper dictum amet himenaeos. Accumsan non congue praesent interdum habitasse turpis orci. Ante curabitur porttitor ullamcorper sagittis sem donec, inceptos cubilia venenatis ac. Augue fringilla sodales in ullamcorper enim curae; rutrum hac in sociis! Scelerisque integer varius et euismod aenean nulla. Quam habitasse risus nullam enim. Ultrices etiam viverra mattis aliquam? Consectetur velit vel volutpat eget curae;. Volutpat class mus elementum pulvinar! Nisi tincidunt volutpat consectetur. Primis morbi pulvinar est montes diam himenaeos duis elit est orci. Taciti sociis aptent venenatis dui malesuada dui justo faucibus primis consequat volutpat. Rhoncus ante purus eros nibh, id et hendrerit pellentesque scelerisque vehicula sollicitudin quam. Hac class vitae natoque tortor dolor dui praesent suspendisse. Vehicula euismod tincidunt odio platea aenean habitasse neque ad proin. Bibendum phasellus enim fames risus eget felis et sem fringilla etiam. Integer.",
            image = "https://dummyimage.com/800x430/FFFFFF/lorem-ipsum.png&text=jsonplaceholder.org",
            thumbnail = "https://dummyimage.com/200x200/FFFFFF/lorem-ipsum.png&text=jsonplaceholder.org",
            status = "published",
            category = "lorem",
            publishedAt = "04/02/2023 13:25:21",
            updatedAt = "14/03/2023 17:22:20",
            userId = 1
        ))

        mockServer
            .expect(requestTo("https://jsonplaceholder.org/posts"))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(objectMapper.writeValueAsString(expected), MediaType.APPLICATION_JSON))

        val allPosts = jsonPlaceHolderClient.getAll()

        mockServer.verify()

        assertThat(allPosts).isEqualTo(expected)
    }

    @Test
    fun `should call mock server at Post Request`() {
        mockServer
            .expect(requestTo("https://jsonplaceholder.org/posts"))
            .andExpect(method(HttpMethod.POST))
            .andRespond(withSuccess())

        val sampleJsonHolder = JsonPlaceHolderBuilder().build()
        jsonPlaceHolderClient.savePost(sampleJsonHolder)

        mockServer.verify()
    }


    @Test
    fun `should call mock server with post data given through savePort argument`() {

        val expected = JsonPlaceHolder(
            id = 2,
            slug = "lorem-ipsum",
            url = "https://jsonplaceholder.org/posts/lorem-ipsum",
            title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            content = "Ante taciti nulla sit libero orci sed nam. Sagittis suspendisse gravida ornare iaculis cras nullam varius ac ullamcorper. Nunc euismod hendrerit netus ligula aptent potenti. Aliquam volutpat nibh scelerisque at. Ipsum molestie phasellus euismod sagittis mauris, erat ut. Gravida morbi, sagittis blandit quis ipsum mi mus semper dictum amet himenaeos. Accumsan non congue praesent interdum habitasse turpis orci. Ante curabitur porttitor ullamcorper sagittis sem donec, inceptos cubilia venenatis ac. Augue fringilla sodales in ullamcorper enim curae; rutrum hac in sociis! Scelerisque integer varius et euismod aenean nulla. Quam habitasse risus nullam enim. Ultrices etiam viverra mattis aliquam? Consectetur velit vel volutpat eget curae;. Volutpat class mus elementum pulvinar! Nisi tincidunt volutpat consectetur. Primis morbi pulvinar est montes diam himenaeos duis elit est orci. Taciti sociis aptent venenatis dui malesuada dui justo faucibus primis consequat volutpat. Rhoncus ante purus eros nibh, id et hendrerit pellentesque scelerisque vehicula sollicitudin quam. Hac class vitae natoque tortor dolor dui praesent suspendisse. Vehicula euismod tincidunt odio platea aenean habitasse neque ad proin. Bibendum phasellus enim fames risus eget felis et sem fringilla etiam. Integer.",
            image = "https://dummyimage.com/800x430/FFFFFF/lorem-ipsum.png&text=jsonplaceholder.org",
            thumbnail = "https://dummyimage.com/200x200/FFFFFF/lorem-ipsum.png&text=jsonplaceholder.org",
            status = "published",
            category = "lorem",
            publishedAt = "04/02/2023 13:25:21",
            updatedAt = "14/03/2023 17:22:20",
            userId = 1
        )

        mockServer.expect(requestTo("https://jsonplaceholder.org/posts"))
            .andExpect(content().string(objectMapper.writeValueAsString(expected)))
        .andRespond(withSuccess())

        jsonPlaceHolderClient.savePost(expected)

        mockServer.verify()
    }

}