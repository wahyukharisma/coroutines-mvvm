package id.dayplug.coroutinessamplemvvm.network

import id.dayplug.coroutinessamplemvvm.network.model.Dog
import retrofit2.http.GET

/**
 * Base interface for make request function to Dog API
 * @see [link]("https://dog.ceo/dog-api/)
 */
interface DogNetwork {

    /**
     * Interface for get random dog photo
     */
    @GET("breeds/image/random")
        suspend fun getData() : Dog
}