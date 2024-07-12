package com.example.events_app.models

typealias Espectadores = ArrayList<Espectador>

class Espectador(
    var nombreEspectador: String,
    var email: String,
    var password : String,
    var token : String,
    var rol : String
) {
    var idespectador: Int = 0
    override fun toString(): String {
        return "Espectador(nombreespectador='$nombreEspectador', email='$email', password='$password', token='$token', rol='$rol')"
    }

    var nombreespectador: String = ""

    constructor(email: String, password: String) : this("", email, password, "", "")

    constructor(nombreEspectador: String, email: String, password: String) : this(nombreEspectador, email, password, "", "")
}