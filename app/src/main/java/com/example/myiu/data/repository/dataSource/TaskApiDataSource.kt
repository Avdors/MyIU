package com.example.myiu.data.repository.dataSource

import android.content.Context
import com.example.myiu.presentation.TaskForType

interface TaskApiDataSource {
    fun startMigration(context: Context)
    fun updateDb(context: Context)
}