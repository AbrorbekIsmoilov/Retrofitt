package com.abrorbek_uz.retrofitt

import com.abrorbek_uz.retrofitt.models.TodoGetResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("plan")
    fun getAllTodo():Call<List<TodoGetResponseItem>>
    
}