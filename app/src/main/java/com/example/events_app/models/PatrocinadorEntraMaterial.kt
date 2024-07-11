package com.example.events_app.models

typealias PatrocinadorEntraMateriales = ArrayList<PatrocinadorEntraMaterial>

class PatrocinadorEntraMaterial(
    var idpatrocinador: Int,
    var idmaterial : Int,
    var fecha : String
) {
    override fun toString(): String {
        return "PatrocinadorEntraMaterial(idpatrocinador='$idpatrocinador', idmaterial='$idmaterial', fecha='$fecha')"
    }

    var idpatrocinadormaterial: Int = 0
}