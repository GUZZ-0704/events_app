package com.example.events_app.models

typealias Proveedores = ArrayList<Proveedor>

class Proveedor(
    var nombreproveedor: String,
    var telefono: String,
    var email: String
) {
    override fun toString(): String {
        return "Proveedor(nombreproveedor='$nombreproveedor', telefono='$telefono', email='$email')"
    }
    var idproveedor: Int = 0
}