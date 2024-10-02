package com.example.todolistapp.domain.usecase

import com.example.todolistapp.data.model.Task
import com.example.todolistapp.data.repository.TaskRepository

class DeleteTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        repository.deleteTask(task)
    }
}

