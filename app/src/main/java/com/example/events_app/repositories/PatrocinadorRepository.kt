package com.example.events_app.repositories

import com.example.events_app.api.APIPatrocinador
import com.example.events_app.models.Patrocinador
import com.example.events_app.models.Patrocinadores
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PatrocinadorRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIPatrocinador::class.java)

    fun getAllPatrocinadores(token: String, success: (Patrocinadores?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllPatrocinadores(token).enqueue(object : Callback<Patrocinadores> {
            override fun onResponse(res: Call<Patrocinadores>, response: Response<Patrocinadores>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load patrocinadores"))
                }
            }

            override fun onFailure(res: Call<Patrocinadores>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getPatrocinadorById(token: String, id: Int, success: (Patrocinador?) -> Unit, failure: (Throwable) -> Unit) {
        service.getPatrocinadorById(token, id).enqueue(object : Callback<Patrocinador> {
            override fun onResponse(res: Call<Patrocinador>, response: Response<Patrocinador>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load patrocinador"))
                }
            }

            override fun onFailure(res: Call<Patrocinador>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addPatrocinador(token: String, patrocinador: Patrocinador, success: (Patrocinador?) -> Unit, failure: (Throwable) -> Unit) {
        service.createPatrocinador(token, patrocinador).enqueue(object : Callback<Patrocinador> {
            override fun onResponse(res: Call<Patrocinador>, response: Response<Patrocinador>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add patrocinador"))
                }
            }

            override fun onFailure(res: Call<Patrocinador>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updatePatrocinador(token: String, patrocinador: Patrocinador, id: Int, success: (Patrocinador?) -> Unit, failure: (Throwable) -> Unit) {
        service.updatePatrocinador(token, id, patrocinador).enqueue(object : Callback<Patrocinador> {
            override fun onResponse(res: Call<Patrocinador>, response: Response<Patrocinador>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update patrocinador"))
                }
            }

            override fun onFailure(res: Call<Patrocinador>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deletePatrocinador(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deletePatrocinador(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete patrocinador"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}
