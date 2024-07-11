package com.example.events_app.models

typealias EncargadosOrganizanEventos = ArrayList<EncargadoOrganizaEvento>

class EncargadoOrganizaEvento(
    var idencargado: Int,
    var idevento: Int
) {
    override fun toString(): String {
        return "Encargado_organiza_evento(idencargado=$idencargado, idevento=$idevento)"
    }
    var idencargado_organiza_evento: Int = 0
}