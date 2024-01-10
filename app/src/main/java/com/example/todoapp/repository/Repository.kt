package com.example.todoapp.repository

import com.example.todoapp.data.TodoDao
import com.example.todoapp.model.Todos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val todoDao: TodoDao) {

    suspend fun addTodo(todos: Todos) = todoDao.addTodo(todo = todos)
    suspend fun updateTodo(todos: Todos) = todoDao.updateTodo(todo = todos)
    suspend fun deletedTodo(todos: Todos)= todoDao.deleteTodo(todo = todos )
    fun getAllTodo():Flow<List<Todos>> = todoDao.getAllTodo().flowOn(Dispatchers.IO).conflate()

}