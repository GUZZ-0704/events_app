package com.example.events_app.repositories

import com.example.events_app.api.APILugar
import com.example.events_app.models.Lugar
import com.example.events_app.models.Lugares
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LugarRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APILugar::class.java)

    fun getLugaresList(success: (Lugares?) -> Unit, failure: (Throwable) -> Unit) {
        service.getLugares().enqueue(object : Callback<Lugares> {
            override fun onResponse(res: Call<Lugares>, response: Response<Lugares>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load lugares"))
                }
            }

            override fun onFailure(res: Call<Lugares>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getLugar(lugarId: Int, success: (Lugar?) -> Unit, failure: (Throwable) -> Unit) {
        service.getLugarById(lugarId).enqueue(object : Callback<Lugares> {
            override fun onResponse(res: Call<Lugares>, response: Response<Lugares>) {
                if (response.isSuccessful) {
                    success(response.body()?.get(0))
                } else {
                    failure(Exception("Failed to load lugar"))
                }
            }

            override fun onFailure(res: Call<Lugares>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addLugar(lugar: Lugar, success: (Lugar?) -> Unit, failure: (Throwable) -> Unit) {
        service.createLugar(lugar).enqueue(object : Callback<Lugar> {
            override fun onResponse(res: Call<Lugar>, response: Response<Lugar>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add lugar"))
                }
            }

            override fun onFailure(res: Call<Lugar>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateLugar(lugarId: Int, lugar: Lugar, success: (Lugar?) -> Unit, failure: (Throwable) -> Unit) {
        service.updateLugar(lugarId, lugar).enqueue(object : Callback<Lugar> {
            override fun onResponse(res: Call<Lugar>, response: Response<Lugar>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update lugar"))
                }
            }

            override fun onFailure(res: Call<Lugar>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteLugar(lugarId: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteLugar(lugarId).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete lugar"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }




}