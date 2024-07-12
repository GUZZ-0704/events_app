package com.example.events_app.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events_app.models.Espectador
import com.example.events_app.models.Ticket
import com.example.events_app.repositories.EspectadorRepository

class ProfileViewModel: ViewModel() {
    private val _espectador: MutableLiveData<Espectador> by lazy {
        MutableLiveData<Espectador>()
    }
    val espectador: LiveData<Espectador> get() = _espectador


    fun getEspectador(token : String){
        EspectadorRepository.getEspectadorByToken(token,token,
            success = {
                _espectador.value = it
            },
            failure = {
                it.printStackTrace()
            })
    }
}