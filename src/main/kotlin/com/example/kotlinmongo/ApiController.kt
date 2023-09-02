package com.example.kotlinmongo

import com.mongodb.kotlin.client.coroutine.MongoClient
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController {

    @PostMapping("/test")
    suspend fun test() {
        val client = MongoClient.create("mongodb://root:example@localhost:27017/")
        val db = client.getDatabase("my-sample-db")

        val collection = db.getCollection<SampleEntity>("TradeLog")

        val newEntity = SampleEntity(ObjectId(),"Alpha")
        collection.insertOne(newEntity)
    }

}

data class SampleEntity(
    @BsonId val id: ObjectId? = null,
    val name: String
)