package com.example.events_app.ui.reservation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events_app.models.Espectador
import com.example.events_app.models.Ticket
import com.example.events_app.repositories.EspectadorRepository
import com.example.events_app.repositories.TicketRepository

class ReservationViewModel: ViewModel() {

    private val _espectador: MutableLiveData<Espectador> by lazy {
        MutableLiveData<Espectador>()
    }
    val espectador: LiveData<Espectador> get() = _espectador

    private val _ticketsList = MutableLiveData<ArrayList<Ticket>>(arrayListOf())
    val ticketsList: LiveData<ArrayList<Ticket>> = _ticketsList

    private val _ticketsCompletos = MutableLiveData<ArrayList<Ticket>>(arrayListOf())
    val ticketsCompletos: LiveData<ArrayList<Ticket>> = _ticketsCompletos


    fun getEspectador(token : String){
        EspectadorRepository.getEspectadorByToken(token,token,
            success = {
                _espectador.value = it
            },
            failure = {
                it.printStackTrace()
            })
    }

    fun getReservations(token: String, espectadorId: Int){
        TicketRepository.getTicketsListByEspectador(token, espectadorId,
            success = { tickets ->
                _ticketsList.value = tickets!!
                Log.d("ReservationViewModel", "Tickets: $tickets")
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

    fun getTicketComplete(token: String, ticketId: Int, completion: (Ticket) -> Unit){
        TicketRepository.getTicketComplete(token, ticketId,
            success = { ticket ->
                completion(ticket!!)
            },
            failure = {
                it.printStackTrace()
            })
    }

    fun addTicketCompletos(ticket: Ticket){
        _ticketsCompletos.value?.add(ticket)
    }


}