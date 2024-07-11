package com.example.events_app.models

typealias Clientes = ArrayList<Cliente>

class Cliente(
    var nombre: String,
    var direccion : String,
    var telefono : String,
    var email : String,
    var imageurl : String
) {
    override fun toString(): String {
        return "Cliente(nombre='$nombre', direccion='$direccion', telefono='$telefono', email='$email', imageurl='$imageurl')"
    }
    var idcliente: Int = 0
}