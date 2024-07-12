package com.example.events_app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events_app.models.Eventos
import com.example.events_app.repositories.EspectadorRepository
import com.example.events_app.repositories.EventoRepository

class HomeViewModel: ViewModel() {
    private val _eventList: MutableLiveData<Eventos> by lazy {
        MutableLiveData<Eventos>(Eventos())
    }
    val eventList: LiveData<Eventos> get() = _eventList

    private val _goToAdmin: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val goToAdmin: LiveData<Boolean> get() = _goToAdmin

    fun fetchEventsList() {
        EventoRepository.getEventosList(
            success = { events ->
                events?.let {
                    _eventList.value = it
                }
            },
            failure = {
                it.printStackTrace()
            })
    }

    fun checkAdmin(token: String) {
        EspectadorRepository.getEspectadorByToken(token, token,
            success = {
                if (it?.rol == "admin") {
                    _goToAdmin.value = true
                }
            },
            failure = {
                it.printStackTrace()
            })
    }


}