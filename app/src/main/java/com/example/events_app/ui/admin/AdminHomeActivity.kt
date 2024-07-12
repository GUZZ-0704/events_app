package com.example.events_app.ui.admin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.events_app.R
import com.example.events_app.databinding.ActivityAdminHomeBinding
import com.example.events_app.models.Tabla
import com.example.events_app.repositories.PreferencesRepository
import com.example.events_app.ui.adapters.TablaAdapter
import com.example.events_app.ui.admin.tabla.TicketActivity
import com.example.events_app.ui.admin.tabla.dato.TablaActivity
import com.example.events_app.ui.login.LoginActivity

class AdminHomeActivity : AppCompatActivity() , TablaAdapter.OnTablaClickListener{
    lateinit var binding: ActivityAdminHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAdminHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupRecyclerView()
        setupEventListeners()
    }

    private fun setupEventListeners() {
        binding.btnLogutAdmin.setOnClickListener {
            PreferencesRepository.logout(this)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupRecyclerView() {
        val adapter = TablaAdapter(ArrayList(Tabla.entries), this)
        binding.lstTabla.layoutManager = LinearLayoutManager(this)
        binding.lstTabla.adapter = adapter
    }

    override fun onTablaClicked(tabla: Tabla) {
        when(tabla){
            Tabla.EVENTOS -> {
                val intent = Intent(this, TablaActivity::class.java)
                startActivity(intent)
            }
            Tabla.ESPECTADORES -> {
                val intent = Intent(this, TablaActivity::class.java)
                startActivity(intent)
            }
            Tabla.TICKETS -> {
                val intent = Intent(this, TicketActivity::class.java)
                startActivity(intent)
            }
            Tabla.CLIENTES -> {
                val intent = Intent(this, TablaActivity::class.java)
                startActivity(intent)
            }
            Tabla.LUGARES -> {
                val intent = Intent(this, TablaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}