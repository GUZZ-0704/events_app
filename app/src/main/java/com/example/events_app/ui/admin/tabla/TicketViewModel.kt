package com.example.events_app.ui.admin.tabla

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events_app.models.Ticket
import com.example.events_app.repositories.TicketRepository
import com.example.events_app.repositories.TicketRepository.getTicketComplete

class TicketViewModel: ViewModel() {
    private val _ticketsList = MutableLiveData<ArrayList<Ticket>>(arrayListOf())
    val ticketsList: LiveData<ArrayList<Ticket>> = _ticketsList

    private val _ticketsCompletos = MutableLiveData<ArrayList<Ticket>>(arrayListOf())
    val ticketsCompletos: LiveData<ArrayList<Ticket>> = _ticketsCompletos

    fun getTickets(token: String) {
        TicketRepository.getTicketsList(token,
            success = { tickets ->
                _ticketsList.value = tickets!!
                val completedTickets = ArrayList<Ticket>()
                if (tickets.isEmpty()) {
                    _ticketsCompletos.postValue(completedTickets)
                } else {
                    var remainingTickets = tickets.size
                    tickets.forEach { ticket ->
                        getTicketComplete(token, ticket.idticket) { completedTicket ->
                            completedTickets.add(completedTicket)
                            remainingTickets--
                            if (remainingTickets == 0) {
                                _ticketsCompletos.postValue(completedTickets)
                            }
                        }
                    }
                }
            },
            failure = {
                it.printStackTrace()
            })
    }

    fun deleteTicket(token: String, ticketId: Int) {
        TicketRepository.deleteTicket(token, ticketId,
            success = {
                getTickets(token)
            },
            failure = {
                it.printStackTrace()
            })
    }

    fun getTicketComplete(token: String, ticketId: Int, completion: (Ticket) -> Unit){
        TicketRepository.getTicketComplete(token, ticketId,
            success = { ticket ->
                completion(ticket!!)
            },
            failure = {
                it.printStackTrace()
            })
    }
}