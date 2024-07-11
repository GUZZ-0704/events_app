package com.example.events_app.models

typealias Actividades = ArrayList<Actividad>

class Actividad(
    var nombreactividad: String,
    var horainicio: String,
    var horafin: String,
    var idevento: Int,
    var costototal: Double
) {
    override fun toString(): String {
        return "Actividad(nombreactividad='$nombreactividad', horainicio='$horainicio', horafin='$horafin', idevento=$idevento, costototal=$costototal)"
    }
    var idactividad: Int = 0
}