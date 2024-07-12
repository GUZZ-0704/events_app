package com.example.events_app.ui.event

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.events_app.R
import com.example.events_app.databinding.ActivityEventDetailBinding
import com.example.events_app.models.Espectador
import com.example.events_app.models.Espectadores
import com.example.events_app.models.Evento
import com.example.events_app.models.Lugar
import com.example.events_app.models.TipoTickets
import com.example.events_app.repositories.EspectadorRepository
import com.example.events_app.repositories.LugarRepository.updateLugar
import com.example.events_app.repositories.PreferencesRepository
import com.example.events_app.ui.adapters.PhotoAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class EventDetailActivity : AppCompatActivity(), PhotoAdapter.OnPhotoClickListener {
    lateinit var binding: ActivityEventDetailBinding
    val model : EventDetailViewModel by viewModels()
    lateinit var lugar: Lugar
    lateinit var espectador : Espectador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEventDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val token= PreferencesRepository.getToken(this)
        Log.d("EventDetailActivity", "Token: $token")
        if (token != null) {
            getEspectador(token)
        }
        var eventId = intent.getIntExtra("eventID", -1)
        Log.d("EventDetailActivity", "Event ID: $eventId")
        if (eventId != -1) {
            model.loadEvent(eventId)
            Log.d("EventDetailActivity", "Loading event")
            model.loadPlace(eventId)
            Log.d("EventDetailActivity", "Loading place")

            model.loadTypeTickets()
            Log.d("EventDetailActivity", "Loading tickets")
        }
        setupEventListeners()
        setupRecyclerView()
        setupViewModelObservers()


    }

    override fun onResume() {
        super.onResume()
        var eventId = intent.getIntExtra("eventID", -1)
        if (eventId != -1) {
            model.loadEvent(eventId)
            model.loadPlace(eventId)
        }
    }

    private fun getEspectador(token: String){
        EspectadorRepository.getEspectadorByToken(token,token,
            success = {
                espectador = it!!
            },
            failure = {
                it.printStackTrace()
            })
    }

    private fun setupViewModelObservers() {
        model.place.observe(this) {
            if (it == null) {
                return@observe
            }
            updateEvenData(it)
        }
        model.event.observe(this) {
            if (it == null) {
                return@observe
            }
            setupEventData(it)
            val adapter = (binding.lstPhotos.adapter as PhotoAdapter)
            adapter.updateData(it.fotos)
        }
        model.TipoTickets.observe(this) {
            if (it == null) {
                return@observe
            }
            setupTicketData(it)
        }
    }

    private fun setupEventListeners() {
        binding.apply {
            txtCantidad.isEnabled = false
            btnMakeReservation.setOnClickListener {
                layoutReservation.visibility = android.view.View.VISIBLE
            }
            btnReservar.setOnClickListener {
                val token = PreferencesRepository.getToken(this@EventDetailActivity)
                if (token == null) {
                    layoutReservation.visibility = android.view.View.GONE
                    Toast.makeText(this@EventDetailActivity, "Por favor, inicie sesión", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                // Validar que los campos no estén vacíos
                if (txtPrecio.text.isEmpty() || txtCantidad.text.isEmpty()) {
                    layoutReservation.visibility = android.view.View.GONE
                    Toast.makeText(this@EventDetailActivity, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val opcion = rdgTipoTicket.checkedRadioButtonId
                Log.d("EventDetailActivity", "Opcion: $opcion")
                val cantidad = txtCantidad.text.toString().toInt()

                val eventoId = intent.getIntExtra("eventID", -1)
                if (token != null && eventoId != -1) {
                    // Utilizar coroutine para manejar retraso entre solicitudes
                    lifecycleScope.launch {
                        for (i in 1..cantidad) {
                            delay(1000) // Esperar 1 segundo entre cada solicitud
                            model.reservarTicket(token, opcion, espectador.idespectador, eventoId)
                        }
                        layoutReservation.visibility = android.view.View.GONE
                    }
                }
                layoutReservation.visibility = android.view.View.GONE
            }
        }
    }


    private fun updateEvenData(lugar: Lugar) {
        binding.apply {
            txtPlace.text = lugar.nombrelugar
            txtAddress.text = lugar.direccion
        }
    }

    private fun setupRecyclerView() {
        binding.lstPhotos.apply {
            this.adapter = PhotoAdapter(ArrayList(), this@EventDetailActivity)
            layoutManager = LinearLayoutManager(this@EventDetailActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setupEventData(event: Evento) {
        binding.apply {
            lblEventName.text = event.nombreevento
            txtStartDate.text = formatFecha(event.fechainicio)
            Log.d("EventDetailActivity", "Event start date: ${event.fechainicio}")
            txtEndDate.text = formatFecha(event.fechafin)
/*            txtPlace.text = lugar?.nombrelugar
            txtAddress.text = lugar?.direccion*/
            txtCupos.text = event.cupos.toString()
        }

        Glide.with(this)
            .load(event.logo)
            .into(binding.imgEventDetail)
    }

    private fun setupTicketData(tipoTickets: TipoTickets) {
        val precios = ArrayList<Double>()
        val radioGroup = binding.rdgTipoTicket
        for (tipoTicket in tipoTickets) {
            val radioButton = android.widget.RadioButton(this)
            radioButton.text = "${tipoTicket.descripcion}"
            radioButton.id = tipoTicket.idtipoticket
            radioGroup.addView(radioButton)
            precios.add(tipoTicket.precio)
        }
        val opcion = radioGroup.checkedRadioButtonId
        Log.d("EventDetailActivity", "Opcion: $opcion")
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val precio = precios[checkedId - 1]
            binding.txtPrecio.text = precio.toString()
        }


    }

    override fun onPhotoClick(photo: String) {
        Glide.with(this)
            .load(photo)
            .into(binding.imgPhotoDetail)
        binding.imgPhotoDetail.visibility = android.view.View.VISIBLE
        binding.imgPhotoDetail.setOnClickListener{
            binding.imgPhotoDetail.visibility = android.view.View.GONE
        }
    }

    fun formatFecha(fecha: String): String {
        val formatoEntrada = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        formatoEntrada.timeZone = TimeZone.getTimeZone("UTC")
        val fechaParseada = formatoEntrada.parse(fecha)

        val formatoSalida = SimpleDateFormat("HH:mm, dd, MMMM, yyyy", Locale.getDefault())
        formatoSalida.timeZone = TimeZone.getDefault() // Ajusta a la zona horaria local

        return fechaParseada?.let { formatoSalida.format(it) } ?: ""
    }
}