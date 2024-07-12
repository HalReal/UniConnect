package com.example.appointmentsappuam.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.appointmentsappuam.entity.Citas

interface CitasDAO {
    @Insert
    suspend fun insertObj(obj : Citas)

    @Insert
    suspend fun insertList(obj : List<Citas>)

    @Update
    suspend fun update(obj : Citas)

    @Delete
    suspend fun deleteObj(obj : Citas)

    @Delete
    suspend fun deleteList(obj : List<Citas>)

    @Query("DELETE FROM CITAS")
    suspend fun deleteAll()

    @Query("SELECT * FROM CITAS")
    suspend fun selectAll(): List<Citas>

    @Query("SELECT * FROM CITAS WHERE id = :pid")
    suspend fun findById(pid : String) : Citas

}