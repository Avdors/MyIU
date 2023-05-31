package com.example.myiu.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.example.myiu.data.localDB.TaskDao
import com.example.myiu.data.models.TaskModel
import com.example.myiu.data.repository.dataSource.TaskDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskDataSourceIMPL (private val dao: TaskDao): TaskDataSource {

   var important: String = "important"
    var urgent: String = "urgent"
    var imp_and_urgent: String = "important and urgent"
    var not_imp_and_urgen: String = "not important and urgent"
    var empty: String = ""

    override fun insertTask(taskModel: TaskModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertTask(taskModel)}
    }

    override fun getAllTask(): LiveData<List<TaskModel>> {
        return dao.getAllTask()
    }

    override fun getFilter(type: String, completed: String): LiveData<List<TaskModel>> {
        return dao.getFilter(type, completed)
    }

    override fun getImportant(): LiveData<List<TaskModel>> {
        return dao.getImportant(important, empty)
    }

    override fun getUrgent(): LiveData<List<TaskModel>> {
        return dao.getUrgent(urgent, empty)
    }

    override fun getImportantAndUrgent(): LiveData<List<TaskModel>> {
        return dao.getImportantAndUrgent(imp_and_urgent, empty)
    }

    override fun getNotImportantAndUrgent(): LiveData<List<TaskModel>> {
        return dao.getNotImportantAndUrgent(not_imp_and_urgen, empty)
    }

    override fun updateTask(taskModel: TaskModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.updateTask(taskModel)}
    }

    override fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }
}