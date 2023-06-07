package com.abrorbek_uz.retrofitt

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.abrorbek_uz.currencyconverter.Adapters.MyAdapter
import com.abrorbek_uz.retrofitt.databinding.ActivityMainBinding
import com.abrorbek_uz.retrofitt.models.TodoGetResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy {  ActivityMainBinding.inflate(layoutInflater) }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ApiClient.getRetrofitService().getAllTodo()
            .enqueue(object : Callback<List<TodoGetResponseItem>>{
                override fun onResponse(
                    call: Call<List<TodoGetResponseItem>>,
                    response: Response<List<TodoGetResponseItem>>
                ) {
                    if (response.isSuccessful && response.body()!=null){
                        Log.d(ContentValues.TAG, "onResponse: ${response.body()}")
                        Toast.makeText(this@MainActivity, "${response.body()}", Toast.LENGTH_SHORT).show()
                        binding.apply {
                            val dataList = response.body()
                            val adapter = MyAdapter(dataList!!) // dataList o'rniga kerakli ma'lumotlar ro'yhatini o'tkazing
                            rv.adapter = adapter
                        }

                    }
                }

                override fun onFailure(call: Call<List<TodoGetResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Internet ulanmagan", Toast.LENGTH_SHORT).show()
                }

            })
    }
}