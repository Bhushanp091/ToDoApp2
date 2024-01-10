package com.example.todoapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.todoapp.components.TextFields
import com.example.todoapp.components.btn
import com.example.todoapp.model.Todos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTodo(
    navController: NavController,
    onAdd:(Todos)->Unit
){
    var inputText by remember { mutableStateOf("") }
    var inputdescription by remember { mutableStateOf("") }



    Column {
        TopAppBar(title = { Text(text = "Add Todo")})
        TextFields(text = inputText, label = "Title", onTextChange ={
            if (it.all {char->
                char.isWhitespace()||char.isLetter()
                })inputText=it
        } )

        TextFields(text = inputdescription, label = "Description", onTextChange ={
            if (it.all {char->
                    char.isWhitespace()||char.isLetter()
                })inputdescription=it
        } )

        btn(onAdd = {
            if(inputdescription.isNotEmpty()&&inputText.isNotEmpty()){
                onAdd(Todos(title = inputText, description = inputdescription,"","",false))
            inputText = ""
            inputdescription=""
            }
        }, navController = navController )
    }

}