package com.example.myiu.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.myiu.data.models.TaskModel
import com.example.myiu.domain.repository.TaskCall

class TaskUseCase (private val taskCall: TaskCall){

    fun getAllTask(): LiveData<List<TaskModel>> {
        return taskCall.getAllTask()
    }

    fun getFilter(type:String, completed:String): LiveData<List<TaskModel>> {
        return taskCall.getFilter(type,completed)
    }

    suspend fun startMigration(context: Context){
        taskCall.startMigration(context)
    }

    suspend fun updateTask(taskModel: TaskModel){
       taskCall.updateTask(taskModel)
    }
    suspend fun updateDb(context: Context){
        taskCall.updateDb(context)
    }


}