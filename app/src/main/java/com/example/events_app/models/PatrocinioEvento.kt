package com.example.events_app.models

typealias PatrocinioEventos = ArrayList<PatrocinioEvento>

class PatrocinioEvento(
    var idevento: Int,
    var idpatrocinador: Int,
    var monto: Double
) {
    override fun toString(): String {
        return "PatrocinioEvento(idevento=$idevento, idpatrocinador=$idpatrocinador, monto=$monto)"
    }
    var idpatrocinio: Int = 0
}