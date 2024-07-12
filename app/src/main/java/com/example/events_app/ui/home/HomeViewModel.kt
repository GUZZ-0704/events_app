package com.example.events_app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events_app.models.Eventos
import com.example.events_app.repositories.EventoRepository

class HomeViewModel: ViewModel() {
    private val _eventList: MutableLiveData<Eventos> by lazy {
        MutableLiveData<Eventos>(Eventos())
    }
    val eventList: LiveData<Eventos> get() = _eventList

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


}