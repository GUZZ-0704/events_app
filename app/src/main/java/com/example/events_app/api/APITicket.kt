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
import retrofit2.http.Path

interface APITicket {
    @GET("tickets")
    fun getTickets(
    ): Call<Tickets>

    @GET("tickets/{id}")
    fun getTicketById(
        @Path("id") id: Int
    ): Call<Tickets>

    @GET("tickets/espectador/{id}")
    fun getTicketsByEspectador(
        @Path("id") id: Int
    ): Call<Tickets>

    @POST("tickets")
    fun addTicket(
        @Body ticket: Ticket
    ): Call<Tickets>

    @DELETE("tickets/{id}")
    fun deleteTicket(
        @Path("id") id: Int
    ): Call<Void>

    @PUT("tickets/{id}")
    fun updateTicket(
        @Body ticket: Ticket,
        @Path("id") id: Int
    ): Call<Ticket>

    @GET("tickets/evento/{id}")
    fun getTicketComplete(
        @Path("id") id: Int
    ): Call<Tickets>
}