package com.example.myiu.data.api


import com.example.myiu.data.models.TaskApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("getTask.php")
    fun getTask(@Query("email") email: String): Call<ArrayList<TaskApiModel>>
}