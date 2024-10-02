package com.example.todolistapp.di

import android.app.Application
import androidx.room.Room
import com.example.todolistapp.data.database.TaskDatabase
import com.example.todolistapp.data.repository.TaskRepository
import com.example.todolistapp.domain.usecase.*
import com.example.todolistapp.presentation.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
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

    // Use Cases
    factory { AddTaskUseCase(get()) }
    factory { DeleteTaskUseCase(get()) }
    factory { GetTasksUseCase(get()) }
    factory { UpdateTaskUseCase(get()) }

    // ViewModel
    viewModel {
        TaskViewModel(
            addTaskUseCase = get(),
            deleteTaskUseCase = get(),
            getTasksUseCase = get(),
            updateTaskUseCase = get()
        )
    }
}
