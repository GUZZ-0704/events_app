package com.example.events_app.api

import com.example.events_app.models.Material
import com.example.events_app.models.Materiales
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIMaterial {

    @GET("materiales")
    fun getAllMateriales(
        @Header("Authorization") token: String
    ): Call<Materiales>

    @GET("materiales/{id}")
    fun getMaterialById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Material>

    @POST("materiales")
    fun createMaterial(
        @Header("Authorization") token: String,
        @Body material: Material
    ): Call<Material>

    @PUT("materiales/{id}")
    fun updateMaterial(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body material: Material
    ): Call<Material>

    @DELETE("materiales/{id}")
    fun deleteMaterial(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>
}
