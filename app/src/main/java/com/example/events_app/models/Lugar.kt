package com.example.events_app.models

typealias Lugares = ArrayList<Lugar>

class Lugar(
    var nombrelugar: String,
    var direccion: String,
    var capacidad: Int
) {
    override fun toString(): String {
        return "Lugar(nombrelugar='$nombrelugar', direccion='$direccion', capacidad=$capacidad)"
    }
    var idlugar: Int = 0
}