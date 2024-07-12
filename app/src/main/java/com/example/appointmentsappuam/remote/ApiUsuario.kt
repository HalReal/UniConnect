package com.example.appointmentsappuam.remote

import com.example.appointmentsappuam.model.Usuario
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiUsuario {
    @POST("usuario/login")
    suspend fun login(@Query("cif") cif : String,
                      @Query("password") password : String): Response<Usuario>

    }