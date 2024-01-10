package com.example.todoapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.ui.theme.BlueTheme
import com.example.todoapp.ui.theme.DarkTheme
import com.example.todoapp.ui.theme.DarkThemeShade

@Composable
fun TextFields(
    text:String,
    label:String,
    onTextChange:(String)->Unit,
){
    OutlinedTextField(
        value = text,
        onValueChange =onTextChange,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
        focusedTextColor = Color.LightGray,
        focusedContainerColor = DarkThemeShade,
        unfocusedContainerColor = DarkThemeShade,
        disabledContainerColor = Color.White,
    ), label = { Text(text = label) })
}

@Composable
fun btn(
    modifier: Modifier = Modifier,
    onAdd:()->Unit,
    navController: NavController
){
    Button(onClick = { onAdd() ;navController.popBackStack()}) {
        Text(text = "Add")
    }
}