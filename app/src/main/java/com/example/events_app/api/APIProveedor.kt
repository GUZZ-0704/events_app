package com.example.events_app.api

import com.example.events_app.models.Proveedor
import com.example.events_app.models.Proveedores
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIProveedor {

    @GET("proveedores")
    fun getAllProveedores(
        @Header("Authorization") token: String
    ): Call<Proveedores>

    @GET("proveedores/{id}")
    fun getProveedorById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Proveedor>

    @POST("proveedores")
    fun createProveedor(
        @Header("Authorization") token: String,
        @Body proveedor: Proveedor
    ): Call<Proveedor>

    @PUT("proveedores/{id}")
    fun updateProveedor(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body proveedor: Proveedor
    ): Call<Proveedor>

    @DELETE("proveedores/{id}")
    fun deleteProveedor(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Void>
}
