package com.example.events_app.ui.login

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events_app.models.Espectador
import com.example.events_app.repositories.EspectadorRepository
import com.example.events_app.repositories.PreferencesRepository

class LoginViewModel: ViewModel() {
    private val _goToHome: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val goToHome: LiveData<Boolean> get() = _goToHome

    private val _errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }
    val errorMessage: LiveData<String> get() = _errorMessage

    fun login(email: String, password: String, context: Context) {
        val espectador = Espectador(email, password)
        EspectadorRepository.loginEspectador(espectador,
            success = {
                if(it == null) {
                    _errorMessage.value = "Usuario o contraseña incorrectos"
                    return@loginEspectador
                }
                _errorMessage.value = ""
                Log.d("MainViewModel", "Token: ${it.token}")
                val token: String = it.token!!
                PreferencesRepository.saveToken(token, context)
                _goToHome.value = true
            }, failure = {
                it.printStackTrace()
            })
    }
}