package com.example.todolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.todolistapp.ui.theme.TodolistappTheme
import com.example.todolistapp.presentation.view.TaskScreen
import com.example.todolistapp.presentation.viewmodel.TaskViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodolistappTheme {
                val viewModel: TaskViewModel = koinViewModel()
                TaskScreen(viewModel = viewModel)
            }
        }
    }
}
