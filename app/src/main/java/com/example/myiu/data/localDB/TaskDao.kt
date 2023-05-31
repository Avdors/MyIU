package com.example.myiu.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myiu.data.models.TaskModel

@Dao
interface TaskDao {


    @Insert
    suspend fun insertTask(taskModel: TaskModel)

    @Query("SELECT * FROM task_data_table")
    fun getAllTask(): LiveData<List<TaskModel>>

    @Query("DELETE FROM task_data_table")
    suspend fun clear()

    @Update
    suspend fun updateTask(taskModel: TaskModel)

    @Query("SELECT * FROM task_data_table WHERE task_type == :type AND task_completed == :completed")
    fun getFilter(type:String, completed:String): LiveData<List<TaskModel>>

    @Query("SELECT * FROM task_data_table WHERE task_type == :type AND task_completed == :completed")
    fun getImportant(type:String, completed:String): LiveData<List<TaskModel>>

    @Query("SELECT * FROM task_data_table WHERE task_type == :type AND task_completed == :completed")
    fun getUrgent(type:String, completed:String): LiveData<List<TaskModel>>

    @Query("SELECT * FROM task_data_table WHERE task_type == :type AND task_completed == :completed")
    fun getImportantAndUrgent(type:String, completed:String): LiveData<List<TaskModel>>

    @Query("SELECT * FROM task_data_table WHERE task_type == :type AND task_completed == :completed")
    fun getNotImportantAndUrgent(type:String, completed:String): LiveData<List<TaskModel>>
}