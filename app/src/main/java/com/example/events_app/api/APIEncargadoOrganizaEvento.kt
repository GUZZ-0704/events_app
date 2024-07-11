package com.example.events_app.api

import com.example.events_app.models.EncargadoOrganizaEvento
import com.example.events_app.models.EncargadosOrganizanEventos
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface APIEncargadoOrganizaEvento {

    @GET("encargado_organiza_evento")
    fun getAllEncargadosOrganizanEventos(
        @Header("Authorization") token: String
    ): Call<EncargadosOrganizanEventos>

    @GET("encargado_organiza_evento/{idEncargado}/{idEvento}")
    fun getEncargadoOrganizaEventoById(
        @Header("Authorization") token: String,
        @Path("idEncargado") idEncargado: Int,
        @Path("idEvento") idEvento: Int
    ): Call<EncargadoOrganizaEvento>

    @POST("encargado_organiza_evento")
    fun createEncargadoOrganizaEvento(
        @Header("Authorization") token: String,
        @Body encargadoOrganizaEvento: EncargadoOrganizaEvento
    ): Call<EncargadoOrganizaEvento>

    @DELETE("encargado_organiza_evento/{idEncargado}/{idEvento}")
    fun deleteEncargadoOrganizaEvento(
        @Header("Authorization") token: String,
        @Path("idEncargado") idEncargado: Int,
        @Path("idEvento") idEvento: Int
    ): Call<Void>
}
