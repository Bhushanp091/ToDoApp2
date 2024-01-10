package com.example.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.todoapp.model.Todos
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM todoList")
    fun getAllTodo():Flow<List<Todos>>

    @Query("SELECT * FROM todoList WHERE id=:id")
    fun getTOdofromId(id:Int):Todos

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodo(todo:Todos)

    @Upsert
    suspend fun updateTodo(todo: Todos)

    @Delete
    suspend fun deleteTodo(todo: Todos)


}