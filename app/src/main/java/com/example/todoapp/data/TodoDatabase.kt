package com.example.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.model.Todos


@Database(
    entities = [Todos::class],
    version = 11,
    exportSchema = false

)
abstract class TodoDatabase:RoomDatabase() {
    abstract fun Tododao():TodoDao
}