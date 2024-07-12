package com.example.events_app.api

import com.example.events_app.models.Espectador
import com.example.events_app.models.Espectadores
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIEspectador {
    @GET("espectadores")
    fun getEspectadores(
        @Header("Authorization") token: String
    ): Call<Espectadores>

    @GET("espectadores/{id}")
    fun getEspectadorById(
        @Header("Authorization") token: String,
        @Header("id") id: Int
    ): Call<Espectador>

    @GET("espectadores/token/{token}")
    fun getEspectadorByToken(
        @Header("Authorization") token: String,
        @Path("token") tokenEspectador: String
    ): Call<Espectadores>

    @POST("espectadores")
    fun addEspectador(
        @Header("Authorization") token: String,
        @Body espectador: Espectador
    ): Call<Espectador>

    @PUT("espectadores/{id}")
    fun updateEspectador(
        @Header("Authorization") token: String,
        @Body espectador: Espectador,
        @Path("id") id: Int
    ): Call<Espectador>

    @DELETE("espectadores/{id}")
    fun deleteEspectador(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>

    @POST("espectadores/login")
    fun loginEspectador(
        @Body espectador: Espectador
    ): Call<Espectadores>

    @POST("espectadores/register")
    fun registerEspectador(
        @Body espectador: Espectador
    ): Call<Espectadores>

}