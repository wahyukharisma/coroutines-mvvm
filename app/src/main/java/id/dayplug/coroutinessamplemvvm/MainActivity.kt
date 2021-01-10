package id.dayplug.coroutinessamplemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import id.dayplug.coroutinessamplemvvm.databinding.ActivityMainBinding
import id.dayplug.coroutinessamplemvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        with(binding){
            btnGet.setOnClickListener {
                viewModel.getData()
            }

            viewModel.dog.observe(this@MainActivity,{
                dog ->
                    Glide.with(this@MainActivity)
                        .load(dog.message)
                        .centerCrop()
                        .into(ivDog)
            })

            viewModel.error.observe(this@MainActivity,{
                error ->
                    Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
            })
        }
    }
}