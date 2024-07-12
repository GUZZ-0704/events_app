package com.example.events_app.repositories

import android.util.Log
import com.example.events_app.api.APITicket
import com.example.events_app.models.Ticket
import com.example.events_app.models.Tickets
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object TicketRepository {

    fun getTicketsList(token: String,success: (Tickets?) -> Unit, failure: (Throwable) -> Unit) {
        val retrofit = RetrofitRepository.getReotrofitInstanceWithToken(token)
        val service = retrofit.create(APITicket::class.java)
        service.getTickets().enqueue(object : Callback<Tickets> {
            override fun onResponse(res: Call<Tickets>, response: Response<Tickets>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load tickets"))
                }
            }

            override fun onFailure(res: Call<Tickets>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getTicket(token: String,ticketId: Int, success: (Ticket?) -> Unit, failure: (Throwable) -> Unit) {
        val retrofit = RetrofitRepository.getReotrofitInstanceWithToken(token)
        val service = retrofit.create(APITicket::class.java)
        service.getTicketById(ticketId).enqueue(object : Callback<Tickets> {
            override fun onResponse(res: Call<Tickets>, response: Response<Tickets>) {
                if (response.isSuccessful) {
                    success(response.body()?.get(0))
                } else {
                    failure(Exception("Failed to load ticket"))
                }
            }

            override fun onFailure(res: Call<Tickets>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getTicketsListByEspectador(token: String, espectadorId: Int, success: (Tickets?) -> Unit, failure: (Throwable) -> Unit) {
        val retrofit = RetrofitRepository.getReotrofitInstanceWithToken(token)
        val service = retrofit.create(APITicket::class.java)
        service.getTicketsByEspectador(espectadorId).enqueue(object : Callback<Tickets> {
            override fun onResponse(res: Call<Tickets>, response: Response<Tickets>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    Log.e("TicketRepository", "Failed to load tickets: HTTP ${response.code()} - ${response.message()}")
                    failure(Exception("Failed to load tickets: HTTP ${response.code()} - ${response.message()}"))
                }
            }

            override fun onFailure(res: Call<Tickets>, t: Throwable) {
                Log.e("TicketRepository", "Network request failed", t)
                failure(t)
            }
        })
    }

    fun addTicket(token: String, ticket: Ticket, success: (Ticket?) -> Unit, failure: (Throwable) -> Unit) {
        val retrofit = RetrofitRepository.getReotrofitInstanceWithToken(token)
        val service = retrofit.create(APITicket::class.java)
        service.addTicket(ticket).enqueue(object : Callback<Tickets> {
            override fun onResponse(res: Call<Tickets>, response: Response<Tickets>) {
                if (response.isSuccessful) {
                    success(response.body()?.get(0))
                } else {
                    // Mejora el manejo de errores proporcionando más información
                    val errorMessage = "Failed to add ticket: HTTP ${response.code()} - ${response.errorBody()?.string()}"
                    Log.e("TicketRepository", errorMessage)
                    failure(Exception(errorMessage))
                }
            }

            override fun onFailure(res: Call<Tickets>, t: Throwable) {
                Log.e("TicketRepository", "Network request failed", t)
                failure(t)
            }
        })
    }

    fun deleteTicket(token: String, ticketId: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        val retrofit = RetrofitRepository.getReotrofitInstanceWithToken(token)
        val service = retrofit.create(APITicket::class.java)
        service.deleteTicket(ticketId).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete ticket"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateTicket(token: String, ticket: Ticket, ticketId: Int, success: (Ticket?) -> Unit, failure: (Throwable) -> Unit) {
        val retrofit = RetrofitRepository.getReotrofitInstanceWithToken(token)
        val service = retrofit.create(APITicket::class.java)
        service.updateTicket(ticket, ticketId).enqueue(object : Callback<Ticket> {
            override fun onResponse(res: Call<Ticket>, response: Response<Ticket>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update ticket"))
                }
            }

            override fun onFailure(res: Call<Ticket>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getTicketComplete(token: String, ticketId: Int, success: (Ticket?) -> Unit, failure: (Throwable) -> Unit) {
        val retrofit = RetrofitRepository.getReotrofitInstanceWithToken(token)
        val service = retrofit.create(APITicket::class.java)
        service.getTicketComplete(ticketId).enqueue(object : Callback<Tickets> {
            override fun onResponse(res: Call<Tickets>, response: Response<Tickets>) {
                if (response.isSuccessful) {
                    success(response.body()!!.get(0))
                } else {
                    failure(Exception("Failed to load tickets"))
                }
            }

            override fun onFailure(res: Call<Tickets>, t: Throwable) {
                failure(t)
            }
        })
    }


}