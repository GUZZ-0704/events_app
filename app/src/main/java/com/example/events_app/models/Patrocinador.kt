package com.example.events_app.models

typealias Patrocinadores = ArrayList<Patrocinador>

class Patrocinador(
    var nombrepatrocinador: String,
    var tipopatrocinio: String
) {
    override fun toString(): String {
        return "Patrocinador(nombrepatrocinador='$nombrepatrocinador', tipopatrocinio='$tipopatrocinio')"
    }
    var idpatrocinador: Int = 0
}