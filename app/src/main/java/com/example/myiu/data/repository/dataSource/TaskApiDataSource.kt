package com.example.myiu.data.repository.dataSource

import android.content.Context
import com.example.myiu.presentation.TaskForType

interface TaskApiDataSource {
    fun startMigration(context: Context)
    fun updateBD(id:Int, name:String, info: String, email: String, type: String, dateStart: String, dateEnd: String, completed: String)
}