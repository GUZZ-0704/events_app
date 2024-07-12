package com.example.events_app.repositories

import com.example.events_app.api.APITipoTicket
import com.example.events_app.models.TipoTicket
import com.example.events_app.models.TipoTickets
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object TipoTicketRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APITipoTicket::class.java)

    fun getAllTipoTickets(success: (TipoTickets?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllTipoTickets().enqueue(object : Callback<TipoTickets> {
            override fun onResponse(res: Call<TipoTickets>, response: Response<TipoTickets>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load tipo tickets"))
                }
            }

            override fun onFailure(res: Call<TipoTickets>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getTipoTicket(token: String, id: Int, success: (TipoTicket?) -> Unit, failure: (Throwable) -> Unit) {
        service.getTipoTicketById(token, id).enqueue(object : Callback<TipoTicket> {
            override fun onResponse(res: Call<TipoTicket>, response: Response<TipoTicket>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load tipo ticket"))
                }
            }

            override fun onFailure(res: Call<TipoTicket>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addTipoTicket(token: String, tipoTicket: TipoTicket, success: (TipoTicket?) -> Unit, failure: (Throwable) -> Unit) {
        service.createTipoTicket(token, tipoTicket).enqueue(object : Callback<TipoTicket> {
            override fun onResponse(res: Call<TipoTicket>, response: Response<TipoTicket>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add tipo ticket"))
                }
            }

            override fun onFailure(res: Call<TipoTicket>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateTipoTicket(token: String, tipoTicket: TipoTicket, id: Int, success: (TipoTicket?) -> Unit, failure: (Throwable) -> Unit) {
        service.updateTipoTicket(token, id, tipoTicket).enqueue(object : Callback<TipoTicket> {
            override fun onResponse(res: Call<TipoTicket>, response: Response<TipoTicket>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update tipo ticket"))
                }
            }

            override fun onFailure(res: Call<TipoTicket>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteTipoTicket(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteTipoTicket(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete tipo ticket"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}
