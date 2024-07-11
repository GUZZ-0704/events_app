package com.example.events_app.models

typealias Espectadores = ArrayList<Espectador>

class Espectador(
    var nombreespectador: String,
    var email: String,
    var password : String,
    var token : String,
    var rol : String
) {
    var idespectador: Int = 0
    override fun toString(): String {
        return "Espectador(nombreespectador='$nombreespectador', email='$email', password='$password', token='$token', rol='$rol')"
    }
}