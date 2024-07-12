package com.example.events_app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.events_app.databinding.ItemDatoBinding
import com.example.events_app.models.Evento

class DatoAdapter(
    private val eventos : ArrayList<Evento>,
    private val listener: EventAdapter.OnEventoClickListener
): RecyclerView.Adapter<DatoAdapter.DatoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatoAdapter.DatoViewHolder {
        val binding = ItemDatoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DatoViewHolder(binding.root)
    }


    override fun onBindViewHolder(holder: DatoAdapter.DatoViewHolder, position: Int) {
        holder.bind(eventos[position])
    }

    override fun getItemCount(): Int = eventos.size

    fun updateData(newData: ArrayList<Evento>) {
        eventos.clear()
        eventos.addAll(newData)
        notifyDataSetChanged()
    }

    inner class DatoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(evento: Evento) {
            val binding = ItemDatoBinding.bind(itemView)
            binding.lblDato.text = evento.nombreevento
            binding.btnEditDato.setOnClickListener {
                listener.onEditEventClick(evento)
            }
            binding.btnDeleteDato.setOnClickListener {
                listener.onDeleteEventClick(evento)
            }
            binding.root.setOnClickListener {
                listener.onEventoClick(evento)
            }
        }
    }
}