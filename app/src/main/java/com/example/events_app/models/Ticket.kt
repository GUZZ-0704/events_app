package com.example.events_app.models

import com.example.events_app.repositories.PreferencesRepository
import com.example.events_app.repositories.TipoTicketRepository

typealias Tickets = ArrayList<Ticket>

class Ticket(
    var idevento: Int,
    var idespectador: Int,
    var idtipoticket: Int
) {
    override fun toString(): String {
        return "Ticket(idevento=$idevento, idespectador=$idespectador, idtipoticket=$idtipoticket)"
    }

    var idticket: Int = 0

    var evento: String = ""
    var espectador: String = ""
    var tipo_ticket: String = ""
}