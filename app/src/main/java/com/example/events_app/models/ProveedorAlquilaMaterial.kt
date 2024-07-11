package com.example.events_app.models

typealias ProveedorAlquilaMateriales = ArrayList<ProveedorAlquilaMaterial>

class ProveedorAlquilaMaterial(
    var idproveedor: Int,
    var idmaterial: Int,
    var fechainicio: String,
    var fechafin: String
) {
    override fun toString(): String {
        return "ProveedorAlquilaMaterial(idproveedor='$idproveedor', idmaterial='$idmaterial', fechainicio='$fechainicio', fechafin='$fechafin')"
    }

    var idproveedormaterial: Int = 0
}