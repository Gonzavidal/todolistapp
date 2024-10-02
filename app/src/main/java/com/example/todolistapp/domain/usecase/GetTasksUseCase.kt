package com.example.todolistapp.domain.usecase


import com.example.todolistapp.data.model.Task
import com.example.todolistapp.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasksUseCase(private val repository: TaskRepository) {
    operator fun invoke(): Flow<List<Task>> {
        return repository.getTasks()
    }
}