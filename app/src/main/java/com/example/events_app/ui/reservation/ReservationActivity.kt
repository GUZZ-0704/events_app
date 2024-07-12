package com.example.events_app.ui.reservation

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
import com.example.events_app.databinding.ActivityReservationBinding
import com.example.events_app.models.Ticket
import com.example.events_app.repositories.PreferencesRepository
import com.example.events_app.ui.adapters.ReservationAdapter
import com.example.events_app.ui.user.ProfileActivity

class ReservationActivity : AppCompatActivity(), ReservationAdapter.OnTicketClickListener {
    lateinit var binding: ActivityReservationBinding
    private val model: ReservationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityReservationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var token = PreferencesRepository.getToken(this)
        Log.d("ReservationActivity", "Token: $token")
        if (token != null) {
            model.getEspectador(token)
        }


        setupRecyclerView()
        setupViewModelObservers()
        setupEventListeners()

    }

    private fun setupEventListeners() {
        binding.btnHomeHomeActivity.setOnClickListener {
            finish()
        }

        binding.btnProfileAppointmentActivity.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        binding.lstReservation.apply {
            this.adapter = ReservationAdapter(arrayListOf(), this@ReservationActivity)
            this.layoutManager = LinearLayoutManager(this@ReservationActivity)
        }
    }

    private fun setupViewModelObservers() {
        var token = PreferencesRepository.getToken(this)
        model.ticketsList.observe(this) { tickets ->
            if (tickets.isEmpty()) {
                // Si no hay tickets, actualiza el adaptador directamente para evitar esperas innecesarias
                val adapter = binding.lstReservation.adapter as ReservationAdapter
                adapter.updateData(arrayListOf())
            } else {
                // Observa ticketsCompletos para actualizar la lista de tickets cargados
                model.ticketsCompletos.observe(this) { completeTickets ->
                    val adapter = binding.lstReservation.adapter as ReservationAdapter
                    adapter.updateData(completeTickets)
                }

                // Solicita la carga de los tickets
                tickets.forEach { ticket ->
                    model.getTicketComplete(token!!, ticket.idticket) { completedTicket ->
                        // Este método asume que getTicketComplete maneja la adición de tickets a ticketsCompletos
                        // y que ticketsCompletos notifica a sus observadores una vez que se añade un ticket
                    }
                }
            }
        }

        model.espectador.observe(this) {
            var espectador = model.espectador.value
            Log.d("ReservationActivity", "Espectador: $espectador")
            if (espectador != null) {
                token?.let { model.getReservations(it, espectador.idespectador) }
            }
        }
    }

    override fun onTicketClick(ticket: Ticket) {
        TODO("Not yet implemented")
    }
}