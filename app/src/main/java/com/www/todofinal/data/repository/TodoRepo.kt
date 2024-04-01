package com.www.todofinal.data.repository

import androidx.lifecycle.LiveData
import com.www.todofinal.data.roomdb.Todo
import com.www.todofinal.data.roomdb.TodoDao


class TodoRepo(private val dao:TodoDao) {
    val all:LiveData<List<Todo>> = dao.showAll()
    suspend fun addTodo(todo: Todo){
        dao.add(todo)
    }
    suspend fun dltTodo(todo: Todo){
        dao.dlt(todo)
    }
   fun edit(id:Int){
        dao.edit(id)
    }
}