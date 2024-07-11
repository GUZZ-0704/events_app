package com.example.events_app.api

import com.example.events_app.models.PatrocinadorEntraMaterial
import com.example.events_app.models.PatrocinadorEntraMateriales
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIPatrocinadorEntraMaterial {

    @GET("patrocinador_entra_material")
    fun getAllPatrocinadorEntraMaterial(
        @Header("Authorization") token: String
    ): Call<PatrocinadorEntraMateriales>

    @GET("patrocinador_entra_material/{id}")
    fun getPatrocinadorEntraMaterialById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<PatrocinadorEntraMaterial>

    @POST("patrocinador_entra_material")
    fun createPatrocinadorEntraMaterial(
        @Header("Authorization") token: String,
        @Body patrocinadorEntraMaterial: PatrocinadorEntraMaterial
    ): Call<PatrocinadorEntraMaterial>

    @PUT("patrocinador_entra_material/{id}")
    fun updatePatrocinadorEntraMaterial(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body patrocinadorEntraMaterial: PatrocinadorEntraMaterial
    ): Call<PatrocinadorEntraMaterial>

    @DELETE("patrocinador_entra_material/{id}")
    fun deletePatrocinadorEntraMaterial(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>
}
