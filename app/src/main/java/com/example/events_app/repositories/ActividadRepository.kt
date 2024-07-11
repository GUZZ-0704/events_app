package com.example.events_app.repositories

import com.example.events_app.api.APIActividad
import com.example.events_app.models.Actividad
import com.example.events_app.models.Actividades
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ActividadRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIActividad::class.java)

    fun getAllActividades(token: String, success: (Actividades?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllActividades(token).enqueue(object : Callback<Actividades> {
            override fun onResponse(res: Call<Actividades>, response: Response<Actividades>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load actividades"))
                }
            }

            override fun onFailure(res: Call<Actividades>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getActividad(token: String, id: Int, success: (Actividad?) -> Unit, failure: (Throwable) -> Unit) {
        service.getActividadById(token, id).enqueue(object : Callback<Actividad> {
            override fun onResponse(res: Call<Actividad>, response: Response<Actividad>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load actividad"))
                }
            }

            override fun onFailure(res: Call<Actividad>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addActividad(token: String, actividad: Actividad, success: (Actividad?) -> Unit, failure: (Throwable) -> Unit) {
        service.createActividad(token, actividad).enqueue(object : Callback<Actividad> {
            override fun onResponse(res: Call<Actividad>, response: Response<Actividad>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add actividad"))
                }
            }

            override fun onFailure(res: Call<Actividad>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateActividad(token: String, actividad: Actividad, id: Int, success: (Actividad?) -> Unit, failure: (Throwable) -> Unit) {
        service.updateActividad(token, id, actividad).enqueue(object : Callback<Actividad> {
            override fun onResponse(res: Call<Actividad>, response: Response<Actividad>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update actividad"))
                }
            }

            override fun onFailure(res: Call<Actividad>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteActividad(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteActividad(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete actividad"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun calcularCostoMaterialesActividad(token: String, id: Int, success: (Double?) -> Unit, failure: (Throwable) -> Unit) {
        service.calcularCostoMaterialesActividad(token, id).enqueue(object : Callback<Double> {
            override fun onResponse(res: Call<Double>, response: Response<Double>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to calculate cost of materials for actividad"))
                }
            }

            override fun onFailure(res: Call<Double>, t: Throwable) {
                failure(t)
            }
        })
    }
}
