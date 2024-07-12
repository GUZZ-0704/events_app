package com.example.events_app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.events_app.databinding.ItemEventoBinding
import com.example.events_app.models.Evento

class EventAdapter (
    private var events: ArrayList<Evento>,
    private val listener: OnEventoClickListener
): RecyclerView.Adapter<EventAdapter.EventoViewHolder>() {

    fun updateEventList(newList: ArrayList<Evento>) {
        events = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val binding = ItemEventoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EventoViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event, listener)
    }

    fun updateData(events: ArrayList<Evento>) {
        this.events.clear()
        this.events = events
        notifyDataSetChanged()
    }

    class EventoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: Evento, listener: OnEventoClickListener) {
            val binding = ItemEventoBinding.bind(itemView)
            binding.txtNameEvent.text = event.nombreevento
            Glide.with(itemView.context)
                .load(event.logo)
                .into(binding.imgEvent)
            binding.root.setOnClickListener {
                listener.onEventoClick(event)
            }
        }
    }

    interface OnEventoClickListener {
        fun onEventoClick(event: Evento)
    }
}