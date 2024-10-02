package com.example.todolistapp.presentation.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolistapp.data.model.Task
import com.example.todolistapp.presentation.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsState()

    TaskList(
        tasks = tasks,
        onUpdateTask = { task -> viewModel.updateTask(task) },
        onDeleteTask = { task -> viewModel.deleteTask(task) })
}


@Composable
fun TaskList(tasks: List<Task>, onUpdateTask: (Task) -> Unit, onDeleteTask: (Task) -> Unit) {
    LazyColumn {
        items(tasks) { task ->
            TaskItem(task = task, onUpdateTask = onUpdateTask, onDeleteTask = onDeleteTask)
        }
    }
}

@Composable
fun TaskItem(task: Task, onUpdateTask: (Task) -> Unit, onDeleteTask: (Task) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = task.title, style = MaterialTheme.typography.titleLarge)
            Text(text = task.description, style = MaterialTheme.typography.bodyMedium)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { onUpdateTask(task.copy(isComplete = !task.isComplete)) }) {
                    Text(if (task.isComplete) "Mark Incomplete" else "Mark Complete")
                }
                Button(onClick = { onDeleteTask(task) }) {
                    Text("Delete")
                }
            }
        }
    }
}