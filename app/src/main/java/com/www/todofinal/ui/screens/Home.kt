package com.www.todofinal.ui.screens

import android.app.Application
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import com.www.todofinal.MainActivity
import com.www.todofinal.viewModel.HomeViewModel

@Composable
fun Home(navHostController: NavHostController, x: MainActivity) {
    val viewModel= ViewModelProvider(x)[HomeViewModel::class.java]
    val list=viewModel.todoAll.observeAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally ){
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2) , modifier = Modifier.weight(1f)
        ) {
            list.value?.let {
                items(it.size){ item->
                    OutlinedCard( modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                        .clickable {
                            navHostController.navigate("edit")
                        }
                    ) {
                        Row {
                            Text(text = it[item].title, modifier = Modifier
                                .padding(8.dp)
                                .weight(1f), fontSize = 24.sp)

                            Icon(
                                Icons.Default.Delete,
                                contentDescription = "delete",
                                tint = Color.Red,
                                modifier = Modifier
                                    .weight(.25f)
                                    .padding(top = 17.dp, end = 8.dp)
                                    .clickable(onClick = { viewModel.dltTodo(it[item]) })
                            )

                        }
                        Row {
                            var checked by remember {
                                mutableStateOf(it[item].check)
                            }
                            Text(modifier = Modifier.padding(10.dp), fontSize = 18.sp, text = it[item].note)
                            Checkbox(checked = checked, onCheckedChange ={change->
                                checked=change} )
                            
                        }

                    }
                }
            }
        }
        Button(onClick = {
            navHostController.navigate("edit")},modifier = Modifier.padding(vertical = 16.dp)) {
            Text(text = " New ToDo")
        }
    }
}