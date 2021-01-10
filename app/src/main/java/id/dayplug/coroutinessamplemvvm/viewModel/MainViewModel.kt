package id.dayplug.coroutinessamplemvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.dayplug.coroutinessamplemvvm.network.model.Dog
import id.dayplug.coroutinessamplemvvm.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainViewModel : ViewModel(){
    val dog  = MutableLiveData<Dog>()
    val error  = MutableLiveData<String>()
    private val repository = MainRepository()

    fun getData(){
        viewModelScope.launch {
            try{
                dog.value = repository.getData()
            }catch (throwable: Throwable){
                when(throwable){
                    is IOException -> error.value = "Network Error"
                    is HttpException -> {
                        val code = throwable.code()
                        val message = throwable.message()
                        error.value = "$code - $message"
                    }
                    else -> error.value = "Failed, something wrong"
                }
            }
        }
    }

}