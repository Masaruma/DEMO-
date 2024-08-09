package com.example.demo

import org.springframework.stereotype.Service

interface JsonPlaceHolderService {
    fun getAll() : List<JsonPlaceHolder>?
    fun savePost(jsonPlaceHolder: JsonPlaceHolder): JsonPlaceHolder?
}

@Service
class JsonPlaceHolderServiceImpl( val jsonPlaceHolderClient: JsonPlaceHolderClient): JsonPlaceHolderService {
    override fun getAll(): List<JsonPlaceHolder>? =
        jsonPlaceHolderClient.getAll()


    override fun savePost(jsonPlaceHolder: JsonPlaceHolder): JsonPlaceHolder? =
         jsonPlaceHolderClient.savePost(jsonPlaceHolder)

}