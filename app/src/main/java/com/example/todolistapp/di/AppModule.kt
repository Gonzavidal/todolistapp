package com.example.todolistapp.di

import android.app.Application
import androidx.room.Room
import com.example.todolistapp.data.database.TaskDatabase
import com.example.todolistapp.data.repository.TaskRepository
import org.koin.dsl.module

val appModule = module {

    // Database
    single {
        Room.databaseBuilder(
            get<Application>(),
            TaskDatabase::class.java, "task_database"
        ).build()
    }

    single { get<TaskDatabase>().taskDao() }

    // Repository
    single { TaskRepository(get()) }
}