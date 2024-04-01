package com.www.todofinal.data.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val note:String,
    var check:Boolean

)