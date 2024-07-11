package com.example.events_app.repositories

import com.example.events_app.api.APIPatrocinioEvento
import com.example.events_app.models.PatrocinioEvento
import com.example.events_app.models.PatrocinioEventos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PatrocinioEventoRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIPatrocinioEvento::class.java)

    fun getAllPatrocinios(token: String, success: (PatrocinioEventos?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllPatrocinios(token).enqueue(object : Callback<PatrocinioEventos> {
            override fun onResponse(res: Call<PatrocinioEventos>, response: Response<PatrocinioEventos>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load patrocinios"))
                }
            }

            override fun onFailure(res: Call<PatrocinioEventos>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getPatrocinioById(token: String, id: Int, success: (PatrocinioEvento?) -> Unit, failure: (Throwable) -> Unit) {
        service.getPatrocinioById(token, id).enqueue(object : Callback<PatrocinioEvento> {
            override fun onResponse(res: Call<PatrocinioEvento>, response: Response<PatrocinioEvento>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load patrocinio"))
                }
            }

            override fun onFailure(res: Call<PatrocinioEvento>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addPatrocinio(token: String, patrocinio: PatrocinioEvento, success: (PatrocinioEvento?) -> Unit, failure: (Throwable) -> Unit) {
        service.createPatrocinio(token, patrocinio).enqueue(object : Callback<PatrocinioEvento> {
            override fun onResponse(res: Call<PatrocinioEvento>, response: Response<PatrocinioEvento>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add patrocinio"))
                }
            }

            override fun onFailure(res: Call<PatrocinioEvento>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updatePatrocinio(token: String, patrocinio: PatrocinioEvento, id: Int, success: (PatrocinioEvento?) -> Unit, failure: (Throwable) -> Unit) {
        service.updatePatrocinio(token, id, patrocinio).enqueue(object : Callback<PatrocinioEvento> {
            override fun onResponse(res: Call<PatrocinioEvento>, response: Response<PatrocinioEvento>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update patrocinio"))
                }
            }

            override fun onFailure(res: Call<PatrocinioEvento>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deletePatrocinio(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deletePatrocinio(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete patrocinio"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}
