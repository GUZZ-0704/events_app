package com.example.events_app.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.events_app.databinding.ItemReservaBinding
import com.example.events_app.models.Ticket

class ReservationAdapter(
    private var reservations: ArrayList<Ticket>,
    private val listener: OnTicketClickListener
): RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder>() {

    fun updateData(newList: ArrayList<Ticket>) {
        Log.d("ReservationAdapter", "updateData llamado con ${newList.size} elementos.")
        reservations.clear()
        reservations.addAll(newList)
        Log.d("ReservationAdapter", "Notificando cambios al adaptador.")
        notifyDataSetChanged() // Notifica al adaptador que los datos han cambiado
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val binding = ItemReservaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReservationViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return reservations?.size?: 0
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        val reservation = reservations[position]
        holder.bind(reservation, listener)
    }

    class ReservationViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView) {
        fun bind(reservation: Ticket, listener: OnTicketClickListener) {
            val binding = ItemReservaBinding.bind(itemView)
            binding.lblTipoTicket.text = reservation.tipo_ticket
            binding.lblEventNameItem.text = reservation.evento
        }
    }

    interface OnTicketClickListener {
        fun onTicketClick(ticket: Ticket)
    }
}