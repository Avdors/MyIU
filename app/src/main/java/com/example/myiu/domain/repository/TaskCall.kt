package com.example.myiu.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.myiu.data.models.TaskModel

interface TaskCall {

    fun getAllTask(): LiveData<List<TaskModel>>
    fun getFilter(type:String, completed:String): LiveData<List<TaskModel>>
    suspend fun startMigration(context: Context)
    suspend fun updateTask(taskModel: TaskModel)
    suspend fun updateDb(context: Context)
}