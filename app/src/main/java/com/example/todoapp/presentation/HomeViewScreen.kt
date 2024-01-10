package com.example.todoapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.components.TodoBoxView
import com.example.todoapp.model.Dummytodos
import com.example.todoapp.model.Todos
import com.example.todoapp.ui.theme.BlueTheme
import com.example.todoapp.ui.theme.DarkTheme
import com.example.todoapp.ui.theme.DarkThemeShade
import com.example.todoapp.ui.theme.ToDoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeViewScreen(
    todo:List<Todos>,
    navController: NavController,
    onUpdate:(Todos)->Unit,
    onDelete:(Todos)->Unit

){
    Column (

    ){
        Scaffold(
            containerColor = DarkTheme,
            topBar = {
                TopAppBar(
                    title = { Text(text = "ToDos", color = Color.LightGray) },
                    actions = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription =null,
                            tint = BlueTheme,
                            modifier = Modifier.padding(8.dp),

                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(DarkThemeShade)
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navController.navigate("addTodoScreen") },
                    containerColor = BlueTheme) {
                    Icon(imageVector = Icons.Default.Add,
                        contentDescription ="Add" ,
                        tint = DarkTheme)
                }
            }

        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier.padding(paddingValues)
        ){

          items(todo) { todo ->
              TodoBoxView(title = todo.title,
                  description = todo.description,
                  showCheckBox = todo.isChecked,
                  onDelete = {onDelete(todo)},
                  onClick = {
                      onUpdate(
                          Todos(
                              title = todo.title,
                              description = todo.description,
                              Date = todo.Date,
                              Category = todo.Category,
                              isChecked = it
                          )
                      )
                      onDelete(todo)
                  }
              )}
          }

    }
    }

    }


