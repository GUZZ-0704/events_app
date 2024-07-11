package com.example.events_app.api

import com.example.events_app.models.PatrocinioEvento
import com.example.events_app.models.PatrocinioEventos
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIPatrocinioEvento {

    @GET("patrocinio_eventos")
    fun getAllPatrocinios(
        @Header("Authorization") token: String
    ): Call<PatrocinioEventos>

    @GET("patrocinio_eventos/{id}")
    fun getPatrocinioById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<PatrocinioEvento>

    @POST("patrocinio_eventos")
    fun createPatrocinio(
        @Header("Authorization") token: String,
        @Body patrocinio: PatrocinioEvento
    ): Call<PatrocinioEvento>

    @PUT("patrocinio_eventos/{id}")
    fun updatePatrocinio(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body patrocinio: PatrocinioEvento
    ): Call<PatrocinioEvento>

    @DELETE("patrocinio_eventos/{id}")
    fun deletePatrocinio(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>
}
