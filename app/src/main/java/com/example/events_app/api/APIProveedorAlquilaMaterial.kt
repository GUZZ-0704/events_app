package com.example.events_app.api

import com.example.events_app.models.ProveedorAlquilaMaterial
import com.example.events_app.models.ProveedorAlquilaMateriales
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIProveedorAlquilaMaterial {

    @GET("proveedor_alquila_material")
    fun getAllProveedorAlquilaMaterial(
        @Header("Authorization") token: String
    ): Call<ProveedorAlquilaMateriales>

    @GET("proveedor_alquila_material/{id}")
    fun getProveedorAlquilaMaterialById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<ProveedorAlquilaMaterial>

    @POST("proveedor_alquila_material")
    fun createProveedorAlquilaMaterial(
        @Header("Authorization") token: String,
        @Body proveedorAlquilaMaterial: ProveedorAlquilaMaterial
    ): Call<ProveedorAlquilaMaterial>

    @PUT("proveedor_alquila_material/{id}")
    fun updateProveedorAlquilaMaterial(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body proveedorAlquilaMaterial: ProveedorAlquilaMaterial
    ): Call<ProveedorAlquilaMaterial>

    @DELETE("proveedor_alquila_material/{id}")
    fun deleteProveedorAlquilaMaterial(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>
}
