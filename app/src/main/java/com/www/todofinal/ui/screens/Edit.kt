package com.www.todofinal.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import com.www.todofinal.MainActivity
import com.www.todofinal.data.roomdb.Todo
import com.www.todofinal.viewModel.EditViewModel

@Composable
fun Edit(navController: NavHostController, x: MainActivity) {
    val viewModel2= ViewModelProvider(x)[EditViewModel::class.java]



    var note by remember {
        mutableStateOf("")
    }
    var title by remember {
        mutableStateOf("")
    }
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(13.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(20.dp))
    {
        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            TextField(value = title, onValueChange = {title=it},
                label = { Text(text = "Title") },
                modifier = Modifier
                    .padding(start = 10.dp, top = 25.dp, end = 10.dp, bottom = 25.dp)
                    .wrapContentSize()
                    .fillMaxWidth(),
                textStyle = TextStyle(fontStyle = FontStyle.Italic, fontSize = 20.sp)
            )

            TextField(modifier = Modifier
                .padding(start = 10.dp, top = 30.dp, end = 10.dp, bottom = 25.dp)
                .wrapContentSize()
                .fillMaxWidth()
                , value = note,
                onValueChange ={note=it},
                label ={ Text(text = "Enter Note") }
                , shape = MaterialTheme.shapes.large
            )
                ExtendedFloatingActionButton(modifier = Modifier.padding(start = 45.dp, top = 20.dp),
                    text = { Text(text = "Save ") },
                    icon = { Icon(imageVector = Icons.Default.Done, contentDescription ="saveicon" ) },
                    onClick = {viewModel2.addTodo(Todo(title = title, note = note, check = false,id=0))
                        navController.popBackStack() })

        }
    }


}