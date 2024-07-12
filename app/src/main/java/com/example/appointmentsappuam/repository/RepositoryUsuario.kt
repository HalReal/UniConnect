package com.example.appointmentsappuam.repository

import android.util.Log
import com.example.appointmentsappuam.model.Usuario
import com.example.appointmentsappuam.remote.ApiAdapter
import com.example.appointmentsappuam.remote.ApiUsuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import retrofit2.Response

class RepositoryUsuario : CoroutineScope by MainScope() {
    val apiUsuario : ApiUsuario by lazy {
        ApiAdapter.getInstance().create(ApiUsuario :: class.java)
    }

    suspend fun login(cif:String,password : String) : Result<Usuario> {
        val retorno : Usuario
        return try {
            val response : Response<Usuario> = apiUsuario.login(cif,password)
            retorno = response.body() as Usuario
            Log.d("OK", "${retorno}")
            Result.success(retorno)
        } catch (e : Exception) {
            Log.d("error", "${e.message}")
            Result.failure(e)
        }
    }

}