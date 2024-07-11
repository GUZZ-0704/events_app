package com.example.events_app.api

import com.example.events_app.models.Lugar
import com.example.events_app.models.Lugares
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APILugar {

    @GET("lugares")
    fun getLugares(
    ): Call<Lugares>

    @GET("lugares/{id}")
    fun getLugarById(
        @Path("id") id: Int
    ): Call<Lugar>

    @POST("lugares")
    fun createLugar(
        @Body lugar: Lugar
    ): Call<Lugar>

    @PUT("lugares/{id}")
    fun updateLugar(
        @Path("id") id: Int,
        @Body lugar: Lugar
    ): Call<Lugar>

    @DELETE("lugares/{id}")
    fun deleteLugar(
        @Path("id") id: Int
    ): Call<Void>
}
