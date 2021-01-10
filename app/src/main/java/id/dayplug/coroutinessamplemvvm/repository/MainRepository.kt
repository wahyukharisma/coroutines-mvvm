package id.dayplug.coroutinessamplemvvm.repository

import id.dayplug.coroutinessamplemvvm.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainRepository {

    /**
     * Coroutines function get random dog data,
     * Simplified coroutines with retrofit without build in callback from retrofit
     */
    suspend fun getData() =
        withContext(Dispatchers.IO) {
            RetrofitClient.dogService.getData()
        }
}