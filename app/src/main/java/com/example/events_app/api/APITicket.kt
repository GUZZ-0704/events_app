package com.example.events_app.api

import com.example.events_app.models.Ticket
import com.example.events_app.models.Tickets
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface APITicket {
    @GET("tickets")
    fun getTickets(
        @Header("Authorization") token: String
    ): Call<Tickets>

    @GET("tickets/{id}")
    fun getTicketById(
        @Header("Authorization") token: String,
        @Header("id") id: Int
    ): Call<Ticket>

    @GET("tickets/espectador/{id}")
    fun getTicketsByEspectador(
        @Header("Authorization") token: String,
        @Header("id") id: Int
    ): Call<Tickets>

    @POST("tickets")
    fun addTicket(
        @Header("Authorization") token: String,
        @Body ticket: Ticket
    ): Call<Ticket>

    @DELETE("tickets/{id}")
    fun deleteTicket(
        @Header("Authorization") token: String,
        @Header("id") id: Int
    ): Call<Void>

    @PUT("tickets/{id}")
    fun updateTicket(
        @Header("Authorization") token: String,
        @Body ticket: Ticket,
        @Header("id") id: Int
    ): Call<Ticket>
}