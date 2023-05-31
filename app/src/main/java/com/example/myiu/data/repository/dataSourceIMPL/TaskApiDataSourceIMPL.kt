package com.example.myiu.data.repository.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import com.example.myiu.R
import com.example.myiu.data.api.ApiClient
import com.example.myiu.data.models.TaskApiModel
import com.example.myiu.data.models.TaskModel
import com.example.myiu.data.repository.dataSource.TaskApiDataSource
import com.example.myiu.data.repository.dataSource.TaskDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskApiDataSourceIMPL (private val taskDataSource: TaskDataSource):
    TaskApiDataSource {
    override fun startMigration(context: Context) {
        var email: String? = "test"
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val savedValue = sharedPreferences.getString("email", "default value")
        if(savedValue != null) {

           email = savedValue.toString()
        }
        val call = ApiClient.instance?.api?.getTask()
        call?.enqueue(object : Callback<ArrayList<TaskApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<TaskApiModel>>,
                response: Response<ArrayList<TaskApiModel>>
            ) {


                var loadTask: ArrayList<TaskApiModel>? = null

                loadTask?.clear()

                loadTask = (response.body() as ArrayList<TaskApiModel>?)!!

                for (audit in loadTask) {
                    audit.id?.let {
                        TaskModel(
                            it,
                            audit.name.toString(),
                            audit.info.toString(),
                            audit.email.toString(),
                            audit.type.toString(),
                            audit.dateStart.toString(),
                            audit.dateEnd.toString(),
                            audit.completed.toString()

                        )
                    }?.let {
                        taskDataSource.insertTask(
                            it
                        )
                    }

                }

                Toast.makeText(context, R.string.download.toString(), Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<ArrayList<TaskApiModel>>, t: Throwable) {
                Toast.makeText(context, R.string.notinternet.toString(), Toast.LENGTH_SHORT).show()

            }
        })


    }
}