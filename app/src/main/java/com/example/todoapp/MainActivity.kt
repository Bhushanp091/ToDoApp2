package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.components.TodoBoxView
import com.example.todoapp.model.Dummytodos
import com.example.todoapp.model.Todos
import com.example.todoapp.presentation.AddTodo
import com.example.todoapp.presentation.HomeViewScreen
import com.example.todoapp.presentation.TodoVIewmodel
import com.example.todoapp.ui.theme.ToDoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewmodel by viewModels<TodoVIewmodel>()
                    val navController = rememberNavController()


                    NavHost(navController = navController, startDestination = "home" ){
                        composable("home"){
                            val todolist = viewmodel.todoList.collectAsState().value
                            HomeViewScreen(todo = todolist,navController, onUpdate = {viewmodel.Update(it)}, onDelete = {viewmodel.Delete(it)})
                        }
                        composable("addTodoScreen"){
                            AddTodo(navController, onAdd = {viewmodel.AddTodo(it)})
                        }
                    }


                }
            }
        }
    }
}

