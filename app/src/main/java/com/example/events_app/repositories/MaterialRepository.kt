package com.example.events_app.repositories

import com.example.events_app.api.APIMaterial
import com.example.events_app.models.Material
import com.example.events_app.models.Materiales
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MaterialRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIMaterial::class.java)

    fun getAllMateriales(token: String, success: (Materiales?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllMateriales(token).enqueue(object : Callback<Materiales> {
            override fun onResponse(res: Call<Materiales>, response: Response<Materiales>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load materiales"))
                }
            }

            override fun onFailure(res: Call<Materiales>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getMaterial(token: String, id: Int, success: (Material?) -> Unit, failure: (Throwable) -> Unit) {
        service.getMaterialById(token, id).enqueue(object : Callback<Material> {
            override fun onResponse(res: Call<Material>, response: Response<Material>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load material"))
                }
            }

            override fun onFailure(res: Call<Material>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addMaterial(token: String, material: Material, success: (Material?) -> Unit, failure: (Throwable) -> Unit) {
        service.createMaterial(token, material).enqueue(object : Callback<Material> {
            override fun onResponse(res: Call<Material>, response: Response<Material>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add material"))
                }
            }

            override fun onFailure(res: Call<Material>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateMaterial(token: String, material: Material, id: Int, success: (Material?) -> Unit, failure: (Throwable) -> Unit) {
        service.updateMaterial(token, id, material).enqueue(object : Callback<Material> {
            override fun onResponse(res: Call<Material>, response: Response<Material>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update material"))
                }
            }

            override fun onFailure(res: Call<Material>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteMaterial(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteMaterial(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete material"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}
