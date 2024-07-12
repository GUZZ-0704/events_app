package com.example.events_app.ui.register

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events_app.models.Espectador
import com.example.events_app.repositories.EspectadorRepository
import com.google.gson.JsonParseException
import java.io.IOException

class RegisterViewModel: ViewModel() {
    private val _goToLogin: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val goToLogin: LiveData<Boolean> get() = _goToLogin

    private val _errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }
    val errorMessage: LiveData<String> get() = _errorMessage

    fun register(email: String, password: String, name: String, context: Context) {
        var espectador = Espectador(name, email, password)
        Log.d("RegisterViewModel", "User: ${espectador}")
        EspectadorRepository.registerEspectador(espectador, success = { espectador ->
            if (espectador == null) {
                _errorMessage.value = "Error al registrar: Usuario nulo"
            } else {
                Log.d("RegisterViewModel", "User: ${espectador.email}, ${espectador}")
                _goToLogin.value = true
            }
        }, failure = { exception ->
            _errorMessage.value = when (exception) {
                is IOException -> "Error de conexión. Por favor, verifica tu conexión a Internet."
                is JsonParseException -> "Error al procesar la respuesta del servidor. Por favor, intenta de nuevo más tarde."
                else -> "Error desconocido al registrar: ${exception.localizedMessage}"
            }
            exception.printStackTrace()
        })
    }
}