package com.example.events_app.api

import com.example.events_app.models.Patrocinador
import com.example.events_app.models.Patrocinadores
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIPatrocinador {

    @GET("patrocinadores")
    fun getAllPatrocinadores(
        @Header("Authorization") token: String
    ): Call<Patrocinadores>

    @GET("patrocinadores/{id}")
    fun getPatrocinadorById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Patrocinador>

    @POST("patrocinadores")
    fun createPatrocinador(
        @Header("Authorization") token: String,
        @Body patrocinador: Patrocinador
    ): Call<Patrocinador>

    @PUT("patrocinadores/{id}")
    fun updatePatrocinador(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body patrocinador: Patrocinador
    ): Call<Patrocinador>

    @DELETE("patrocinadores/{id}")
    fun deletePatrocinador(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>
}
