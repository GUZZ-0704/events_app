package com.example.events_app.repositories

import com.example.events_app.api.APITicket
import com.example.events_app.models.Ticket
import com.example.events_app.models.Tickets
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object TicketRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APITicket::class.java)

    fun getTicketsList(token: String,success: (Tickets?) -> Unit, failure: (Throwable) -> Unit) {
        service.getTickets(token).enqueue(object : Callback<Tickets> {
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
        service.getTicketById(token,ticketId).enqueue(object : Callback<Ticket> {
            override fun onResponse(res: Call<Ticket>, response: Response<Ticket>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load ticket"))
                }
            }

            override fun onFailure(res: Call<Ticket>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getTicketsListByEspectador(token: String,espectadorId: Int, success: (Tickets?) -> Unit, failure: (Throwable) -> Unit) {
        service.getTicketsByEspectador(token,espectadorId).enqueue(object : Callback<Tickets> {
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

    fun addTicket(token: String, ticket: Ticket, success: (Ticket?) -> Unit, failure: (Throwable) -> Unit) {
        service.addTicket(token, ticket).enqueue(object : Callback<Ticket> {
            override fun onResponse(res: Call<Ticket>, response: Response<Ticket>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add ticket"))
                }
            }

            override fun onFailure(res: Call<Ticket>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteTicket(token: String, ticketId: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteTicket(token, ticketId).enqueue(object : Callback<Void> {
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
        service.updateTicket(token, ticket, ticketId).enqueue(object : Callback<Ticket> {
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


}