package com.example.events_app.repositories

import com.example.events_app.api.APIEvento
import com.example.events_app.models.Evento
import com.example.events_app.models.Eventos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object EventoRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIEvento::class.java)

    fun getEventosList(success: (Eventos?) -> Unit, failure: (Throwable) -> Unit) {
        service.getEventos().enqueue(object : Callback<Eventos> {
            override fun onResponse(res: Call<Eventos>, response: Response<Eventos>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load eventos"))
                }
            }

            override fun onFailure(res: Call<Eventos>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getEvento(eventoId: Int, success: (Evento?) -> Unit, failure: (Throwable) -> Unit) {
        service.getEventoById(eventoId).enqueue(object : Callback<Evento> {
            override fun onResponse(res: Call<Evento>, response: Response<Evento>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load evento"))
                }
            }

            override fun onFailure(res: Call<Evento>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addEvento(token: String, evento: Evento, success: (Evento?) -> Unit, failure: (Throwable) -> Unit) {
        service.addEvento(token, evento).enqueue(object : Callback<Evento> {
            override fun onResponse(res: Call<Evento>, response: Response<Evento>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add evento"))
                }
            }

            override fun onFailure(res: Call<Evento>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateEvento(token: String, evento: Evento, eventoId: Int, success: (Evento?) -> Unit, failure: (Throwable) -> Unit) {
        service.updateEvento(token, evento, eventoId).enqueue(object : Callback<Evento> {
            override fun onResponse(res: Call<Evento>, response: Response<Evento>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update evento"))
                }
            }

            override fun onFailure(res: Call<Evento>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteEvento(token: String, eventoId: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteEvento(token, eventoId).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete evento"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getCantidadTicketsVendidosEvento(eventoId: Int, success: (Int?) -> Unit, failure: (Throwable) -> Unit) {
        service.getCantidadTicketsVendidosEvento(eventoId).enqueue(object : Callback<Int> {
            override fun onResponse(res: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to get cantidad tickets vendidos evento"))
                }
            }

            override fun onFailure(res: Call<Int>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getCalcularIngresosEvento(eventoId: Int, success: (Double?) -> Unit, failure: (Throwable) -> Unit) {
        service.getCalcularIngresosEvento(eventoId).enqueue(object : Callback<Double> {
            override fun onResponse(res: Call<Double>, response: Response<Double>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to get calcular ingresos evento"))
                }
            }

            override fun onFailure(res: Call<Double>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getCalcularCostoTotalEvento(eventoId: Int, success: (Double?) -> Unit, failure: (Throwable) -> Unit) {
        service.getCalcularCostoTotalEvento(eventoId).enqueue(object : Callback<Double> {
            override fun onResponse(res: Call<Double>, response: Response<Double>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to get calcular costo total evento"))
                }
            }

            override fun onFailure(res: Call<Double>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getCalcularRentabilidadEvento(eventoId: Int, success: (Double?) -> Unit, failure: (Throwable) -> Unit) {
        service.getCalcularRentabilidadEvento(eventoId).enqueue(object : Callback<Double> {
            override fun onResponse(res: Call<Double>, response: Response<Double>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to get calcular rentabilidad evento"))
                }
            }

            override fun onFailure(res: Call<Double>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getAsignarLugarEvento(token: String, eventoId: Int, lugarId: Int, success: (Evento?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAsignarLugarEvento(token, eventoId, lugarId).enqueue(object : Callback<Evento> {
            override fun onResponse(res: Call<Evento>, response: Response<Evento>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to asignar lugar evento"))
                }
            }

            override fun onFailure(res: Call<Evento>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getPatrocinadoresEvento(token: String, eventoId: Int, success: (Evento?) -> Unit, failure: (Throwable) -> Unit) {
        service.getPatrocinadoresEvento(token, eventoId).enqueue(object : Callback<Evento> {
            override fun onResponse(res: Call<Evento>, response: Response<Evento>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to get patrocinadores evento"))
                }
            }

            override fun onFailure(res: Call<Evento>, t: Throwable) {
                failure(t)
            }
        })
    }

}