package com.example.todolistapp.data.repository

import com.example.todolistapp.data.dao.TaskDao
import com.example.todolistapp.data.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {
    fun getTasks(): Flow<List<Task>> {
        return taskDao.getTasks()
    }

    suspend fun addTask(task: Task) {
        taskDao.addTask(task)
    }

    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }
}
