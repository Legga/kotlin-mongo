# kotlin-mongo issue

I am using Kotlin Mongo coroutine driver with data classes, which are supposed to be automatically serialized/deserialized using default codec.
Instead when creating a new item in a collection, I get a "codec not found" error:
`org.bson.codecs.configuration.CodecConfigurationException: Can't find a codec for CodecCacheKey{clazz=class com.example.kotlinmongo.SampleEntity, types=null}.`

To reproduce:

1. Start the local mongo instance with `docker compose up -d`
2. Start the app by running `./gradlew bootRun`
3. Make an HTTP POST request with no parameters to `http://localhost:8080/api/test`
