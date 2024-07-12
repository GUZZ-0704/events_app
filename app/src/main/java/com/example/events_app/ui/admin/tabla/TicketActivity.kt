package com.example.events_app.ui.admin.tabla

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.events_app.R
import com.example.events_app.databinding.ActivityTicketBinding
import com.example.events_app.models.Ticket
import com.example.events_app.repositories.PreferencesRepository
import com.example.events_app.ui.adapters.ReservationAdapter
import com.example.events_app.ui.adapters.TicketAdapter

class TicketActivity : AppCompatActivity(), TicketAdapter.OnTicketClickListener {
    lateinit var binding: ActivityTicketBinding
    private val model: TicketViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val token = PreferencesRepository.getToken(this)
        if (token != null) {
            model.getTickets(token)
        }

        setupRecyclerView()
        setupViewModelObservers()
    }

    private fun setupRecyclerView() {
        binding.lstTicket.apply {
            this.adapter = TicketAdapter(arrayListOf(), this@TicketActivity)
            this.layoutManager = LinearLayoutManager(this@TicketActivity)
        }
    }

    private fun setupViewModelObservers() {
        var token = PreferencesRepository.getToken(this)
        model.ticketsList.observe(this) { tickets ->
            if (tickets.isEmpty()) {
                // Si no hay tickets, actualiza el adaptador directamente para evitar esperas innecesarias
                val adapter = binding.lstTicket.adapter as TicketAdapter
                adapter.updateData(arrayListOf())
            } else {
                // Observa ticketsCompletos para actualizar la lista de tickets cargados
                model.ticketsCompletos.observe(this) { completeTickets ->
                    val adapter = binding.lstTicket.adapter as TicketAdapter
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
    }

    override fun onTicketClick(ticket: Ticket) {
        model.deleteTicket(PreferencesRepository.getToken(this)!!, ticket.idticket)
    }

    override fun onEditTicketClick(ticket: Ticket) {
        TODO("Not yet implemented")
    }

    override fun onDeleteTicketClick(ticket: Ticket) {
        TODO("Not yet implemented")
    }
}