package com.example.myiu.presentation.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myiu.data.models.TaskModel
import com.example.myiu.domain.useCase.TaskUseCase
import kotlinx.coroutines.launch

class TaskViewModel(private val taskUseCase: TaskUseCase): ViewModel() {

    val loadTask = taskUseCase.getAllTask()


    fun getFilter(type:String, completed:String):
            LiveData<List<TaskModel>> {
        return taskUseCase.getFilter(type, completed)
    }
    fun migration(context: Context) = viewModelScope.launch {
        taskUseCase.startMigration(context)

    }
}