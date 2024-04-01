package com.www.todofinal.data.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(todo: Todo)

    @Delete
    suspend fun dlt(todo: Todo)

    @Query("SELECT * FROM Todo")
    fun showAll():LiveData<List<Todo>>

    @Query("SELECT * FROM Todo WHERE id= :id")
    fun edit(id:Int):Todo



}