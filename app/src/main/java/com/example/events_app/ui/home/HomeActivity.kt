package com.example.events_app.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.events_app.R
import com.example.events_app.databinding.ActivityHomeBinding
import com.example.events_app.models.Espectador
import com.example.events_app.models.Evento
import com.example.events_app.repositories.PreferencesRepository
import com.example.events_app.ui.adapters.EventAdapter
import com.example.events_app.ui.admin.AdminHomeActivity
import com.example.events_app.ui.event.EventDetailActivity
import com.example.events_app.ui.reservation.ReservationActivity
import com.example.events_app.ui.user.ProfileActivity

class HomeActivity : AppCompatActivity(), EventAdapter.OnEventoClickListener {
    lateinit var binding : ActivityHomeBinding
    val model : HomeViewModel by viewModels()
    lateinit var espectador : Espectador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupRecyclerView()
        setupEventListeners()
        setupViewModelObservers()
        val token = PreferencesRepository.getToken(this)
        if(token != null) {
            checkAdmin(token)
        }
        if (token == null) {
            setupPublicView()
        }
    }

    private fun checkAdmin(token: String) {
        model.checkAdmin(token)
    }

    override fun onResume() {
        super.onResume()
        model.fetchEventsList()
    }

    private fun setupRecyclerView() {
        val adapter = EventAdapter(arrayListOf(), this)
        binding.lstEvents.layoutManager = LinearLayoutManager(this)
        binding.lstEvents.adapter = adapter
    }

    private fun setupEventListeners() {
        binding.apply {
            btnHome.isEnabled = false
            btnProfile.setOnClickListener {
                val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
                startActivity(intent)
            }
            btnReservations.setOnClickListener {
                val intent = Intent(this@HomeActivity, ReservationActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setupViewModelObservers() {
        model.eventList.observe(this) {
            val adapter = (binding.lstEvents.adapter as EventAdapter)
            adapter.updateData(it)
        }
        model.goToAdmin.observe(this) {
            if (it) {
                val intent = Intent(this, AdminHomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun setupPublicView() {
        binding.apply {
            btnProfile.isEnabled = false
            btnProfile.visibility = android.view.View.GONE
            btnReservations.isEnabled = false
            btnReservations.visibility = android.view.View.GONE
        }
    }

    override fun onEventoClick(event: Evento) {
        val intent = Intent(this, EventDetailActivity::class.java)
        intent.putExtra("eventID", event.idevento)
        Log.d("HomeActivity", "Opening event detail for event ${event.idevento}")
        startActivity(intent)
    }

    override fun onEditEventClick(event: Evento) {
        TODO("Not yet implemented")
    }

    override fun onDeleteEventClick(event: Evento) {
        TODO("Not yet implemented")
    }
}