package com.example.events_app.api

import com.example.events_app.models.Encargado
import com.example.events_app.models.Encargados
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIEncargado {

    @GET("encargados")
    fun getAllEncargados(
        @Header("Authorization") token: String
    ): Call<Encargados>

    @GET("encargados/{id}")
    fun getEncargadoById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Encargado>

    @POST("encargados")
    fun createEncargado(
        @Header("Authorization") token: String,
        @Body encargado: Encargado
    ): Call<Encargado>

    @PUT("encargados/{id}")
    fun updateEncargado(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body encargado: Encargado
    ): Call<Encargado>

    @DELETE("encargados/{id}")
    fun deleteEncargado(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>
}
