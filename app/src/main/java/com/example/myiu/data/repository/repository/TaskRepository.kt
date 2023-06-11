package com.example.myiu.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.myiu.data.models.TaskModel
import com.example.myiu.data.repository.dataSource.TaskApiDataSource
import com.example.myiu.data.repository.dataSource.TaskDataSource
import com.example.myiu.domain.repository.TaskCall


class TaskRepository (private val taskApiDataSource: TaskApiDataSource,
                      private val taskDataSource: TaskDataSource
): TaskCall {
    override fun getAllTask(): LiveData<List<TaskModel>> {
        return taskDataSource.getAllTask()
    }

    override fun getFilter(type: String, completed: String): LiveData<List<TaskModel>> {
     return taskDataSource.getFilter(type, completed)
    }

    override suspend fun startMigration(context: Context) {
        taskDataSource.clear()
        taskApiDataSource.startMigration(context)
    }

    override suspend fun updateTask(taskModel: TaskModel) {
        taskDataSource.updateTask(taskModel)
    }

    override suspend fun updateDb(context: Context) {
        taskApiDataSource.updateDb(context)
    }




}