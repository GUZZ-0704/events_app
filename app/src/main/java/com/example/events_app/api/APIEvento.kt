package com.example.events_app.api

import com.example.events_app.models.Evento
import com.example.events_app.models.Eventos
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIEvento {
    @GET("eventos")
    fun getEventos(): Call<Eventos>

    @GET("eventos/{id}")
    fun getEventoById(
        @Path("id") id: Int
    ): Call<Eventos>

    @POST("eventos")
    fun addEvento(
        @Header("Authorization") token: String,
        @Body evento: Evento
    ): Call<Eventos>

    @PUT("eventos/{id}")
    fun updateEvento(
        @Header("Authorization") token: String,
        @Body evento: Evento,
        @Path("id") id: Int
    ): Call<Eventos>

    @DELETE("eventos/{id}")
    fun deleteEvento(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>


    @GET("cantidad_tickets_vendidos_evento/{id}")
    fun getCantidadTicketsVendidosEvento(
        @Path("id") id: Int
    ): Call<Int>

    @GET("calcular_ingresos_evento/{id}")
    fun getCalcularIngresosEvento(
        @Path("id") id: Int
    ): Call<Double>

    @GET("calcular_costo_total_evento/{id}")
    fun getCalcularCostoTotalEvento(
        @Path("id") id: Int
    ): Call<Double>

    @GET("calcular_rentabilidad_evento/{id}")
    fun getCalcularRentabilidadEvento(
        @Path("id") id: Int
    ): Call<Double>

    @PUT("asignar_lugar_evento/{idevento}/{idlugar}")
    fun getAsignarLugarEvento(
        @Header("Authorization") token: String,
        @Path("idevento") idevento: Int,
        @Path("idlugar") idlugar: Int
    ): Call<Eventos>

    @GET("patrocinadores_evento/{id}")
    fun getPatrocinadoresEvento(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Eventos>


}