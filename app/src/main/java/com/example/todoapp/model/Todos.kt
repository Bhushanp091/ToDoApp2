package com.example.todoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("todoList")
data class Todos(
    @ColumnInfo("title")
    val title:String,
    @ColumnInfo("description")
    val description:String,
    @ColumnInfo("date")
    val Date:String,
    @ColumnInfo("category")
    val Category:String,
    @ColumnInfo("isChecked")
    val isChecked : Boolean ,
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,

)
