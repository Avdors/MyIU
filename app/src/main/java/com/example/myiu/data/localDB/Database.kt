package com.example.myiu.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myiu.data.models.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract val taskDao: TaskDao
}