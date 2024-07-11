package com.example.events_app.models

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
}