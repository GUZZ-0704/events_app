package com.example.events_app.repositories

import com.example.events_app.api.APIEspectador
import com.example.events_app.models.Espectador
import com.example.events_app.models.Espectadores
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object EspectadorRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIEspectador::class.java)

    fun getEspectadoresList(token: String,success: (Espectadores?) -> Unit, failure: (Throwable) -> Unit) {
        service.getEspectadores(token).enqueue(object : Callback<Espectadores> {
            override fun onResponse(res: Call<Espectadores>, response: Response<Espectadores>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load espectadores"))
                }
            }

            override fun onFailure(res: Call<Espectadores>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getEspectador(token: String, id: Int, success: (Espectador?) -> Unit, failure: (Throwable) -> Unit) {
        service.getEspectadorById(token, id).enqueue(object : Callback<Espectador> {
            override fun onResponse(res: Call<Espectador>, response: Response<Espectador>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load espectador"))
                }
            }

            override fun onFailure(res: Call<Espectador>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getEspectadorByToken(token: String, tokenEspectador: String, success: (Espectador?) -> Unit, failure: (Throwable) -> Unit) {
        service.getEspectadorByToken(token, tokenEspectador).enqueue(object : Callback<Espectador> {
            override fun onResponse(res: Call<Espectador>, response: Response<Espectador>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load espectador"))
                }
            }

            override fun onFailure(res: Call<Espectador>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addEspectador(token: String, espectador: Espectador, success: (Espectador?) -> Unit, failure: (Throwable) -> Unit) {
        service.addEspectador(token, espectador).enqueue(object : Callback<Espectador> {
            override fun onResponse(res: Call<Espectador>, response: Response<Espectador>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add espectador"))
                }
            }

            override fun onFailure(res: Call<Espectador>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateEspectador(token: String, espectador: Espectador, id: Int, success: (Espectador?) -> Unit, failure: (Throwable) -> Unit) {
        service.updateEspectador(token, espectador, id).enqueue(object : Callback<Espectador> {
            override fun onResponse(res: Call<Espectador>, response: Response<Espectador>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update espectador"))
                }
            }

            override fun onFailure(res: Call<Espectador>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteEspectador(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteEspectador(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete espectador"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun loginEspectador(espectador: Espectador, success: (Espectador?) -> Unit, failure: (Throwable) -> Unit) {
        service.loginEspectador(espectador).enqueue(object : Callback<Espectador> {
            override fun onResponse(res: Call<Espectador>, response: Response<Espectador>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to login espectador"))
                }
            }

            override fun onFailure(res: Call<Espectador>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun registerEspectador(espectador: Espectador, success: (Espectador?) -> Unit, failure: (Throwable) -> Unit) {
        service.registerEspectador(espectador).enqueue(object : Callback<Espectador> {
            override fun onResponse(res: Call<Espectador>, response: Response<Espectador>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to register espectador"))
                }
            }

            override fun onFailure(res: Call<Espectador>, t: Throwable) {
                failure(t)
            }
        })
    }


}