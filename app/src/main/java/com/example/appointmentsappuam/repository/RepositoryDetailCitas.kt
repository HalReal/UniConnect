package com.example.appointmentsappuam.repository

import android.content.Context
import com.example.appointmentsappuam.db.DatabaseApp
import com.example.appointmentsappuam.entity.Citas

class RepositoryDetailCitas(context: Context) {

    val db = DatabaseApp.getDataBase(context)

    suspend fun getDetail(id : String) : Citas {
        val agenda = db.agendaDAO().findById(id)
        return agenda
    }
}