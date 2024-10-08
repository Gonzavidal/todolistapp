package com.example.todolistapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.data.model.Task
import com.example.todolistapp.domain.usecase.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel(
    private val addTaskUseCase: AddTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val getTasksUseCase: GetTasksUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        viewModelScope.launch {
            getTasksUseCase().collect {
                _tasks.value = it
            }
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch { addTaskUseCase(task) }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch { deleteTaskUseCase(task) }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch { updateTaskUseCase(task) }
    }
}