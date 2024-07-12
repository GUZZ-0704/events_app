package com.example.events_app.ui.user

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.events_app.R
import com.example.events_app.databinding.ActivityProfileBinding
import com.example.events_app.models.Espectador
import com.example.events_app.repositories.PreferencesRepository
import com.example.events_app.ui.home.HomeActivity
import com.example.events_app.ui.login.LoginActivity
import com.example.events_app.ui.reservation.ReservationActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    val model: ProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var token = PreferencesRepository.getToken(this)
        Log.d("ProfileActivity", "Token: $token")
        if (token != null) {
            model.getEspectador(token)
        }
        setupViewModelObservers()
        setupEventListeners()
    }

    private fun setupViewModelObservers() {
        model.espectador.observe(this) {
            if (it != null) {
                displayEspectadorDetails(it)
            }
        }
    }

    fun displayEspectadorDetails(espectador: Espectador) {
        binding.lblFullnameProfile.text = espectador.nombreespectador
        Log.d("ProfileActivity", "Espectador: $espectador")
        binding.imgProfileUser.setImageResource(R.drawable.img)
    }

    fun setupEventListeners() {
        binding.btnProfileProfileUserActivity.isEnabled = false
        binding.btnHomeProfileUserActivity.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnReservationsProfileUserActivity.setOnClickListener {
            val intent = Intent(this, ReservationActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnLogOut.setOnClickListener {
            PreferencesRepository.logout(this)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}

