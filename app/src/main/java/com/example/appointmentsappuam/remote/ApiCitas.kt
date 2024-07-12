package com.example.appointmentsappuam.remote

import com.example.appointmentsappuam.model.CitasItem
import com.example.appointmentsappuam.model.ListCitas
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiCitas {
    @GET("citas/all")
    suspend fun getAll(): Response<ListCitas>

    @GET("citas/citasByUsuario")
    suspend fun getAll(@Query("idUsuario") idUsuario : String): Response<ListCitas>

    @POST("citas/create")
    suspend fun create(@Body citas : CitasItem): Response<CitasItem>

}