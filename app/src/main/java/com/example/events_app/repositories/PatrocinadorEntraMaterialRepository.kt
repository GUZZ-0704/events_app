package com.example.events_app.repositories

import com.example.events_app.api.APIPatrocinadorEntraMaterial
import com.example.events_app.models.PatrocinadorEntraMaterial
import com.example.events_app.models.PatrocinadorEntraMateriales
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PatrocinadorEntraMaterialRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIPatrocinadorEntraMaterial::class.java)

    fun getAllPatrocinadorEntraMaterial(token: String, success: (PatrocinadorEntraMateriales?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllPatrocinadorEntraMaterial(token).enqueue(object : Callback<PatrocinadorEntraMateriales> {
            override fun onResponse(res: Call<PatrocinadorEntraMateriales>, response: Response<PatrocinadorEntraMateriales>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load patrocinador entra materiales"))
                }
            }

            override fun onFailure(res: Call<PatrocinadorEntraMateriales>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getPatrocinadorEntraMaterialById(token: String, id: Int, success: (PatrocinadorEntraMaterial?) -> Unit, failure: (Throwable) -> Unit) {
        service.getPatrocinadorEntraMaterialById(token, id).enqueue(object : Callback<PatrocinadorEntraMaterial> {
            override fun onResponse(res: Call<PatrocinadorEntraMaterial>, response: Response<PatrocinadorEntraMaterial>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load patrocinador entra material"))
                }
            }

            override fun onFailure(res: Call<PatrocinadorEntraMaterial>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addPatrocinadorEntraMaterial(token: String, patrocinadorEntraMaterial: PatrocinadorEntraMaterial, success: (PatrocinadorEntraMaterial?) -> Unit, failure: (Throwable) -> Unit) {
        service.createPatrocinadorEntraMaterial(token, patrocinadorEntraMaterial).enqueue(object : Callback<PatrocinadorEntraMaterial> {
            override fun onResponse(res: Call<PatrocinadorEntraMaterial>, response: Response<PatrocinadorEntraMaterial>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add patrocinador entra material"))
                }
            }

            override fun onFailure(res: Call<PatrocinadorEntraMaterial>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updatePatrocinadorEntraMaterial(token: String, patrocinadorEntraMaterial: PatrocinadorEntraMaterial, id: Int, success: (PatrocinadorEntraMaterial?) -> Unit, failure: (Throwable) -> Unit) {
        service.updatePatrocinadorEntraMaterial(token, id, patrocinadorEntraMaterial).enqueue(object : Callback<PatrocinadorEntraMaterial> {
            override fun onResponse(res: Call<PatrocinadorEntraMaterial>, response: Response<PatrocinadorEntraMaterial>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update patrocinador entra material"))
                }
            }

            override fun onFailure(res: Call<PatrocinadorEntraMaterial>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deletePatrocinadorEntraMaterial(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deletePatrocinadorEntraMaterial(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete patrocinador entra material"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}
