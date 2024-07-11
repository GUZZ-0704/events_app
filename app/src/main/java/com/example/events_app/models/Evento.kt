package com.example.events_app.models

typealias Eventos = ArrayList<Evento>

class Evento (
    var nombreevento: String,
    var fechainicio: String,
    var fechafin: String,
    var idcliente: Int,
    var idlugar: Int,
    var costototal: Double,
    var cupos: Int
) {
    override fun toString(): String {
        return "Evento(nombreevento='$nombreevento', fechainicio='$fechainicio', fechafin='$fechafin', idcliente=$idcliente, idlugar=$idlugar, costototal=$costototal, cupos=$cupos)"
    }
    var idevento: Int = 0
}