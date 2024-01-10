package com.example.todoapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.theme.BlueTheme
import com.example.todoapp.ui.theme.DarkTheme

@Composable
fun TodoBoxView(
    title:String,
    description:String,
    showCheckBox:Boolean,
    onDelete:()->Unit,
    onClick: (Boolean) -> Unit
){


    Row (
        modifier = Modifier
            .clickable {onDelete()  }
            .padding(8.dp)
            .fillMaxWidth()
            .background(DarkTheme),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column {
            Text(
                text = title,
                color = Color.LightGray,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = description,
                color = Color.LightGray,
                style = MaterialTheme.typography.bodySmall
            )
        }
        CircularCheckbox(showCheckBox = showCheckBox, onClick = {onClick(it)})
    }
    Divider(modifier = Modifier.padding(10.dp))
}



@Composable
fun CircularCheckbox(
    showCheckBox: Boolean,
    onClick:(Boolean)->Unit,
) {
    var isCheckedState by remember { mutableStateOf(showCheckBox) }

    Box(
        modifier = Modifier
            .size(45.dp)
            .padding(8.dp)
            .background(
                color = if (isCheckedState) BlueTheme else Color.DarkGray,
                shape = CircleShape
            )
            .clickable{
                isCheckedState = !isCheckedState
                onClick(isCheckedState)
            },
        contentAlignment = Alignment.Center
    ) {
        if (isCheckedState) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

