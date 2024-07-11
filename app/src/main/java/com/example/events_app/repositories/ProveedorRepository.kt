package com.example.events_app.repositories

import com.example.events_app.api.APIProveedor
import com.example.events_app.models.Proveedor
import com.example.events_app.models.Proveedores
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ProveedorRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIProveedor::class.java)

    fun getAllProveedores(token: String, success: (Proveedores?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllProveedores(token).enqueue(object : Callback<Proveedores> {
            override fun onResponse(res: Call<Proveedores>, response: Response<Proveedores>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load proveedores"))
                }
            }

            override fun onFailure(res: Call<Proveedores>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getProveedorById(token: String, id: Int, success: (Proveedor?) -> Unit, failure: (Throwable) -> Unit) {
        service.getProveedorById(token, id).enqueue(object : Callback<Proveedor> {
            override fun onResponse(res: Call<Proveedor>, response: Response<Proveedor>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load proveedor"))
                }
            }

            override fun onFailure(res: Call<Proveedor>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addProveedor(token: String, proveedor: Proveedor, success: (Proveedor?) -> Unit, failure: (Throwable) -> Unit) {
        service.createProveedor(token, proveedor).enqueue(object : Callback<Proveedor> {
            override fun onResponse(res: Call<Proveedor>, response: Response<Proveedor>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add proveedor"))
                }
            }

            override fun onFailure(res: Call<Proveedor>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateProveedor(token: String, proveedor: Proveedor, id: Int, success: (Proveedor?) -> Unit, failure: (Throwable) -> Unit) {
        service.updateProveedor(token,id, proveedor).enqueue(object : Callback<Proveedor> {
            override fun onResponse(res: Call<Proveedor>, response: Response<Proveedor>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update proveedor"))
                }
            }

            override fun onFailure(res: Call<Proveedor>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteProveedor(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteProveedor(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete proveedor"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}
