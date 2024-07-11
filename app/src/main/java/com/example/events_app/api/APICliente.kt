package com.example.events_app.api

import com.example.events_app.models.Cliente
import com.example.events_app.models.Clientes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APICliente {

    @GET("clientes")
    fun getAllClientes(
        @Header("Authorization") token: String
    ): Call<Clientes>

    @GET("clientes/{id}")
    fun getClienteById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Cliente>

    @POST("clientes")
    fun createCliente(
        @Header("Authorization") token: String,
        @Body cliente: Cliente
    ): Call<Cliente>

    @PUT("clientes/{id}")
    fun updateCliente(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body cliente: Cliente
    ): Call<Cliente>

    @DELETE("clientes/{id}")
    fun deleteCliente(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>

    @DELETE("clientes_completamente/{id}")
    fun deleteClienteCompletamente(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>
}
