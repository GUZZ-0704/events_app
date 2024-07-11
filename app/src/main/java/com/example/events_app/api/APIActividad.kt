package com.example.events_app.api

import com.example.events_app.models.Actividad
import com.example.events_app.models.Actividades
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIActividad {

    @GET("actividades")
    fun getAllActividades(
        @Header("Authorization") token: String
    ): Call<Actividades>

    @GET("actividades/{id}")
    fun getActividadById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Actividad>

    @POST("actividades")
    fun createActividad(
        @Header("Authorization") token: String,
        @Body actividad: Actividad
    ): Call<Actividad>

    @PUT("actividades/{id}")
    fun updateActividad(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body actividad: Actividad
    ): Call<Actividad>

    @DELETE("actividades/{id}")
    fun deleteActividad(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>

    @GET("calcular_costo_materiales_actividad/{id}")
    fun calcularCostoMaterialesActividad(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Double>
}
