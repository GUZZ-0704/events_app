package com.example.events_app.models

typealias TipoTickets = ArrayList<TipoTicket>

class TipoTicket(
    var descripcion: String,
    var precio: Double
) {
    override fun toString(): String {
        return "TipoTicket(descripcion='$descripcion', precio=$precio)"
    }
    var idtipoticket: Int = 0
}