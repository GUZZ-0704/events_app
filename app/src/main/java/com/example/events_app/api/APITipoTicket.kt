package com.example.events_app.api

import com.example.events_app.models.TipoTicket
import com.example.events_app.models.TipoTickets
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APITipoTicket {

    @GET("tipotickets")
    fun getAllTipoTickets(
        @Header("Authorization") token: String
    ): Call<TipoTickets>

    @GET("tipotickets/{id}")
    fun getTipoTicketById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<TipoTicket>

    @POST("tipotickets")
    fun createTipoTicket(
        @Header("Authorization") token: String,
        @Body tipoTicket: TipoTicket
    ): Call<TipoTicket>

    @PUT("tipotickets/{id}")
    fun updateTipoTicket(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body tipoTicket: TipoTicket
    ): Call<TipoTicket>

    @DELETE("tipotickets/{id}")
    fun deleteTipoTicket(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>
}
