package com.example.todolistapp.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.todolistapp.R


@Composable
fun AddTaskScreen(onAddTask: (String , String) -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(stringResource(id = R.string.title)) },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(stringResource(id = R.string.description)) },
            modifier = Modifier.fillMaxWidth()
        )
        //   Spacer(modifier= Modifier.height(16.dp))
        Button(
            onClick = {
                onAddTask(title, description)
                title = ""
                description = ""
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = title.isNotBlank() && description.isNotBlank(),
            // colors = ButtonColors(Purple700,White, Color.Gray, White),
            //shape = RoundedCornerShape(5.dp)
        ) {
            Text(stringResource(id = R.string.add_taks_button))
        }
    }
}