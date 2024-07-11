package com.example.events_app.models

typealias Materiales = ArrayList<Material>

class Material(
    var nombrematerial: String,
    var cantidad: Int,
    var idactividad: Int,
    var precio: Double
) {
    override fun toString(): String {
        return "Material(nombrematerial='$nombrematerial', cantidad=$cantidad, idactividad=$idactividad, precio=$precio)"
    }
    var idmaterial: Int = 0
}