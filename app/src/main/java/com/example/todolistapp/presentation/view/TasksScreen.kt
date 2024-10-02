package com.example.todolistapp.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolistapp.data.model.Task
import com.example.todolistapp.presentation.viewmodel.TaskViewModel

@Composable
fun TaskScreen(
    viewModel: TaskViewModel
){
    val tasks by viewModel.tasks.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AddTaskScreen(onAddTask = { title, description ->
            viewModel.addTask(
                Task(
                    id = tasks.size + 1,
                    title = title,
                    description = description,
                    isComplete = false
                )
            )
        })
        Spacer(modifier = Modifier.height(16.dp))
        TaskListScreen(viewModel = viewModel)
    }
}