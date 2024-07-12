package com.example.events_app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.events_app.databinding.ItemTicketBinding
import com.example.events_app.models.Ticket

class TicketAdapter(
    private val tickets: ArrayList<Ticket>,
    private val listener: TicketAdapter.OnTicketClickListener
): RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketAdapter.TicketViewHolder {
        val binding = ItemTicketBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TicketViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TicketAdapter.TicketViewHolder, position: Int) {
        holder.bind(tickets[position])
    }

    override fun getItemCount(): Int = tickets.size

    fun updateData(newData: ArrayList<Ticket>) {
        tickets.clear()
        tickets.addAll(newData)
        notifyDataSetChanged()
    }

    inner class TicketViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(ticket: Ticket) {
            val binding = ItemTicketBinding.bind(itemView)
            binding.lblTicketItem.text = ticket.tipo_ticket
            binding.lblEspectadorId.text = ticket.idespectador.toString()
            binding.btnEditTicket.setOnClickListener {
                listener.onEditTicketClick(ticket)
            }
            binding.btnDeleteTicket.setOnClickListener {
                listener.onDeleteTicketClick(ticket)
            }
            binding.btnDeleteTicket.setOnClickListener {
                listener.onTicketClick(ticket)
            }
        }
    }

    interface OnTicketClickListener {
        fun onTicketClick(ticket: Ticket)
        fun onEditTicketClick(ticket: Ticket)
        fun onDeleteTicketClick(ticket: Ticket)
    }
}