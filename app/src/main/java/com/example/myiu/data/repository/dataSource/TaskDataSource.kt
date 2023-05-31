package com.example.myiu.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.example.myiu.data.models.TaskModel


interface TaskDataSource {

    fun insertTask(taskModel: TaskModel)

    fun getAllTask(): LiveData<List<TaskModel>>

    fun getFilter(type:String, completed:String): LiveData<List<TaskModel>>

    fun getImportant(): LiveData<List<TaskModel>>

    fun getUrgent(): LiveData<List<TaskModel>>

    fun getImportantAndUrgent(): LiveData<List<TaskModel>>

    fun getNotImportantAndUrgent(): LiveData<List<TaskModel>>

    fun updateTask(taskModel: TaskModel)

    fun clear()
}