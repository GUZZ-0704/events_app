package com.example.events_app.ui.event

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events_app.models.Espectador
import com.example.events_app.models.Evento
import com.example.events_app.models.Lugar
import com.example.events_app.models.Ticket
import com.example.events_app.models.TipoTickets
import com.example.events_app.repositories.EventoRepository
import com.example.events_app.repositories.LugarRepository
import com.example.events_app.repositories.TicketRepository
import com.example.events_app.repositories.TipoTicketRepository

class EventDetailViewModel: ViewModel() {
    private val _event: MutableLiveData<Evento?> by lazy {
        MutableLiveData<Evento?>(null)
    }
    val event: LiveData<Evento?> get() = _event

    private val _place: MutableLiveData<Lugar?> by lazy {
        MutableLiveData<Lugar?>(null)
    }

    val place: LiveData<Lugar?> get() = _place

    private val _TipoTickets: MutableLiveData<TipoTickets?> by lazy {
        MutableLiveData<TipoTickets?>(null)
    }

    val TipoTickets: LiveData<TipoTickets?> get() = _TipoTickets

    fun loadEvent(eventId: Int) {
        EventoRepository.getEvento(eventId,
            success = {
                _event.value = it
            },
            failure = {
                it.printStackTrace()
            })
    }

    fun loadPlace(eventoId: Int) {
        var evento = Evento()
        EventoRepository.getEvento(eventoId,
            success = {
                evento = it!!
                LugarRepository.getLugar(evento.idlugar,
                    success = {
                        _place.value = it
                    },
                    failure = {
                        it.printStackTrace()
                    })
            },
            failure = {
                it.printStackTrace()
            })
    }

    fun loadTypeTickets(token : String) {
        TipoTicketRepository.getAllTipoTickets(token,
            success = {
                _TipoTickets.value = it
            },
            failure = {
                it.printStackTrace()
            })
    }

    fun reservarTicket(token: String, idTipoTicket: Int, idEspectador: Int, idEvento: Int, retryCount: Int = 3) {
        val ticket = Ticket(idEvento, idEspectador, idTipoTicket)
        var currentAttempt = 0

        fun tryAddTicket() {
            TicketRepository.addTicket(token, ticket,
                success = {
                    Log.d("Ticket", "Ticket added")
                },
                failure = {
                    it.printStackTrace()
                    if (currentAttempt < retryCount) {
                        currentAttempt++
                        Log.d("Ticket", "Retry attempt $currentAttempt")
                        tryAddTicket()
                    } else {
                        Log.e("Ticket", "Failed to add ticket after $retryCount attempts")
                    }
                })
        }

        tryAddTicket()
    }


}