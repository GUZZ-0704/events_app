package com.example.events_app.ui.admin.tabla.dato

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.events_app.R
import com.example.events_app.databinding.ActivityTablaBinding
import com.example.events_app.models.Evento
import com.example.events_app.ui.adapters.DatoAdapter
import com.example.events_app.ui.adapters.EventAdapter

class TablaActivity : AppCompatActivity(), EventAdapter.OnEventoClickListener {
    lateinit var binding: ActivityTablaBinding
    val model: TablaViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTablaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupRecyclerView()
        setupViewModelObservers()
    }

    override fun onResume() {
        super.onResume()
        model.fetchEventsList()
    }

    private fun setupViewModelObservers() {
        model.eventList.observe(this) { events ->
            val adapter = binding.lstDatos.adapter as DatoAdapter
            adapter.updateData(events)
        }
    }

    private fun setupRecyclerView() {
        val adapter = DatoAdapter(arrayListOf(), this)
        binding.lstDatos.layoutManager = LinearLayoutManager(this)
        binding.lstDatos.adapter = adapter
    }

    override fun onEventoClick(event: Evento) {
        TODO("Not yet implemented")
    }

    override fun onEditEventClick(event: Evento) {
        TODO("Not yet implemented")
    }

    override fun onDeleteEventClick(event: Evento) {
        TODO("Not yet implemented")
    }
}