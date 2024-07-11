package com.example.events_app.repositories

import com.example.events_app.api.APIEncargado
import com.example.events_app.models.Encargado
import com.example.events_app.models.Encargados
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object EncargadoRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIEncargado::class.java)

    fun getAllEncargados(token: String, success: (Encargados?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllEncargados(token).enqueue(object : Callback<Encargados> {
            override fun onResponse(res: Call<Encargados>, response: Response<Encargados>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load encargados"))
                }
            }

            override fun onFailure(res: Call<Encargados>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getEncargado(token: String, id: Int, success: (Encargado?) -> Unit, failure: (Throwable) -> Unit) {
        service.getEncargadoById(token, id).enqueue(object : Callback<Encargado> {
            override fun onResponse(res: Call<Encargado>, response: Response<Encargado>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load encargado"))
                }
            }

            override fun onFailure(res: Call<Encargado>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addEncargado(token: String, encargado: Encargado, success: (Encargado?) -> Unit, failure: (Throwable) -> Unit) {
        service.createEncargado(token, encargado).enqueue(object : Callback<Encargado> {
            override fun onResponse(res: Call<Encargado>, response: Response<Encargado>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add encargado"))
                }
            }

            override fun onFailure(res: Call<Encargado>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateEncargado(token: String, encargado: Encargado, id: Int, success: (Encargado?) -> Unit, failure: (Throwable) -> Unit) {
        service.updateEncargado(token,id, encargado).enqueue(object : Callback<Encargado> {
            override fun onResponse(res: Call<Encargado>, response: Response<Encargado>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update encargado"))
                }
            }

            override fun onFailure(res: Call<Encargado>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteEncargado(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteEncargado(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete encargado"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}
