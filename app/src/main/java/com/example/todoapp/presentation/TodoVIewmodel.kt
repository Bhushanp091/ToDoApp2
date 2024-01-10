package com.example.todoapp.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Delete
import androidx.room.Update
import com.example.todoapp.model.Dummytodos
import com.example.todoapp.model.Todos
import com.example.todoapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoVIewmodel @Inject constructor(private val repository: Repository) :ViewModel() {

//     var todoList = mutableStateListOf<Todos>()
    private val _todoList = MutableStateFlow<List<Todos>>(emptyList())
    val todoList = _todoList.asStateFlow()

    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getAllTodo().distinctUntilChanged()
                .collect{listtodo->
                    if(listtodo.isNullOrEmpty()){
                        Log.d("Empty","EmptyLisy")
                    }else{
                        _todoList.value = listtodo
                    }
                }
        }
    }

    fun AddTodo(todos: Todos)=viewModelScope.launch { repository.addTodo(todos = todos)  }

    fun Delete(todos: Todos)=viewModelScope.launch { repository.deletedTodo(todos = todos) }

    fun Update(todos: Todos)=viewModelScope.launch { repository.updateTodo(todos = todos) }




}