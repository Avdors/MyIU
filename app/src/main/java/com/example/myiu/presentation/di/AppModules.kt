package com.example.myiu.presentation.di

import androidx.room.Room
import com.example.myiu.data.localDB.Database
import com.example.myiu.data.repository.dataSource.TaskApiDataSource
import com.example.myiu.data.repository.dataSource.TaskDataSource
import com.example.myiu.data.repository.dataSourceIMPL.TaskApiDataSourceIMPL
import com.example.myiu.data.repository.dataSourceIMPL.TaskDataSourceIMPL
import com.example.myiu.data.repository.repository.TaskRepository
import com.example.myiu.domain.repository.TaskCall
import com.example.myiu.domain.useCase.TaskUseCase
import com.example.myiu.presentation.viewModel.TaskViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleTask = module {

    single {
        Room.databaseBuilder(androidContext(), Database::class.java,
            "localDB").build()
    }

    single { get<Database>().taskDao }


    single<TaskDataSource> {
        TaskDataSourceIMPL(
            get()
        )
    }

    single<TaskApiDataSource> {
        TaskApiDataSourceIMPL(
            get()
        )
    }

    single<TaskCall> { TaskRepository(get(),get()) }
// делаем иньекцию
    single { TaskUseCase(get()) }

    viewModel { TaskViewModel(get()) }

}