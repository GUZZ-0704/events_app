package com.example.events_app.models

typealias Encargados = ArrayList<Encargado>

class Encargado(
    var nombre: String,
    var telefono: String,
    var email: String
) {
    override fun toString(): String {
        return "Encargado(nombre='$nombre', telefono='$telefono', email='$email')"
    }
    var idencargado: Int = 0
}