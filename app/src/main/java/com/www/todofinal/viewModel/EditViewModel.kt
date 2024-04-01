package com.www.todofinal.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.www.todofinal.data.repository.TodoRepo
import com.www.todofinal.data.roomdb.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class EditViewModel @Inject constructor(
private  val repo: TodoRepo
):ViewModel() {

    fun addTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO) {
            repo.addTodo(todo)
        }
    }

    fun editTodo(id:Int){
            repo.edit(id)

    }

}