package com.example.events_app.ui.main

import androidx.lifecycle.ViewModel
import com.example.events_app.R
import com.example.events_app.models.WelcomeMessage
import com.example.events_app.models.WelcomeMessagesDB

class MainViewModel: ViewModel() {
    fun setupData() {
        WelcomeMessagesDB.welcomeMessages.add(WelcomeMessage(1, R.drawable.prueba4))
        WelcomeMessagesDB.welcomeMessages.add(WelcomeMessage(2, R.drawable.prueba3))
    }
}