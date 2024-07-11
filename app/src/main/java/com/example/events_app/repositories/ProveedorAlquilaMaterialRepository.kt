package com.example.events_app.repositories

import com.example.events_app.api.APIProveedorAlquilaMaterial
import com.example.events_app.models.ProveedorAlquilaMaterial
import com.example.events_app.models.ProveedorAlquilaMateriales
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ProveedorAlquilaMaterialRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIProveedorAlquilaMaterial::class.java)

    fun getAllProveedorAlquilaMaterial(token: String, success: (ProveedorAlquilaMateriales?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllProveedorAlquilaMaterial(token).enqueue(object : Callback<ProveedorAlquilaMateriales> {
            override fun onResponse(res: Call<ProveedorAlquilaMateriales>, response: Response<ProveedorAlquilaMateriales>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load proveedor alquila materiales"))
                }
            }

            override fun onFailure(res: Call<ProveedorAlquilaMateriales>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getProveedorAlquilaMaterialById(token: String, id: Int, success: (ProveedorAlquilaMaterial?) -> Unit, failure: (Throwable) -> Unit) {
        service.getProveedorAlquilaMaterialById(token, id).enqueue(object : Callback<ProveedorAlquilaMaterial> {
            override fun onResponse(res: Call<ProveedorAlquilaMaterial>, response: Response<ProveedorAlquilaMaterial>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load proveedor alquila material"))
                }
            }

            override fun onFailure(res: Call<ProveedorAlquilaMaterial>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addProveedorAlquilaMaterial(token: String, proveedorAlquilaMaterial: ProveedorAlquilaMaterial, success: (ProveedorAlquilaMaterial?) -> Unit, failure: (Throwable) -> Unit) {
        service.createProveedorAlquilaMaterial(token, proveedorAlquilaMaterial).enqueue(object : Callback<ProveedorAlquilaMaterial> {
            override fun onResponse(res: Call<ProveedorAlquilaMaterial>, response: Response<ProveedorAlquilaMaterial>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add proveedor alquila material"))
                }
            }

            override fun onFailure(res: Call<ProveedorAlquilaMaterial>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateProveedorAlquilaMaterial(token: String, proveedorAlquilaMaterial: ProveedorAlquilaMaterial, id: Int, success: (ProveedorAlquilaMaterial?) -> Unit, failure: (Throwable) -> Unit) {
        service.updateProveedorAlquilaMaterial(token, id, proveedorAlquilaMaterial).enqueue(object : Callback<ProveedorAlquilaMaterial> {
            override fun onResponse(res: Call<ProveedorAlquilaMaterial>, response: Response<ProveedorAlquilaMaterial>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update proveedor alquila material"))
                }
            }

            override fun onFailure(res: Call<ProveedorAlquilaMaterial>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteProveedorAlquilaMaterial(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteProveedorAlquilaMaterial(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete proveedor alquila material"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}
