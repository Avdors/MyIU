package com.example.myiu.data.repository.dataSource

import android.content.Context

interface TaskApiDataSource {
    fun startMigration(context: Context)
}