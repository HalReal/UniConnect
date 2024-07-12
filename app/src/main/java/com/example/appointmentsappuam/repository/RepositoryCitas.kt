package com.example.appointmentsappuam.repository

import android.content.Context
import android.util.Log
import com.example.appointmentsappuam.db.DatabaseApp
import com.example.appointmentsappuam.entity.Citas
import com.example.appointmentsappuam.model.CitasItem
import com.example.appointmentsappuam.model.ListCitas
import com.example.appointmentsappuam.remote.ApiAdapter
import com.example.appointmentsappuam.remote.ApiCitas
import retrofit2.Response

class RepositoryCitas(private val context: Context) {
    val apiCitas : ApiCitas by lazy {
        ApiAdapter.getInstance().create(ApiCitas :: class.java)
    }

    suspend fun getAll(idUsuario : String) : Result<ListCitas> {
        val retorno : ListCitas
        return try {
            val response : Response<ListCitas> = apiCitas.getAll()
            retorno = response.body() as ListCitas
            Log.d("OK", "${retorno}")
            Result.success(retorno)
        } catch (e : Exception) {
            Log.d("error", "${e.message}")
            Result.failure(e)
        }
    }

    suspend fun updateAgenda(lista : List<Citas>) {
        val db = DatabaseApp.getDataBase(context)
        db.agendaDAO().deleteAll()
        db.agendaDAO().insertList(lista)
    }

    suspend fun createCita(agendaItem: CitasItem): Result<CitasItem> {
        val retorno : CitasItem
        return try {
            val response : Response<CitasItem> = apiCitas.create(agendaItem)
            retorno = response.body() as CitasItem
            Result.success(retorno)
        } catch (e : Exception) {
            Log.d ("error","${e.message}")
            Result.failure(e)
        }
    }
}