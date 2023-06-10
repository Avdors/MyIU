package com.example.myiu.data.api


import com.example.myiu.data.models.TaskApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("getTask.php")
    fun getTask(@Query("email") email: String): Call<ArrayList<TaskApiModel>>
    @GET("updateTask.php")
    fun updateTask(
        @Query("id") id: Int,
        @Query("name") name: String,
        @Query("info") info: String,
        @Query("email") email: String,
        @Query("type") type: String,
        @Query("dateStart") dateStart: String,
        @Query("dateEnd") dateEnd: String,
        @Query("completed") completed: String
    )
}