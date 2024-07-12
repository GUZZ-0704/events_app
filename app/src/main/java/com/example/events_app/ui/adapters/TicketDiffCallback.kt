package com.example.events_app.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.events_app.models.Ticket

class TicketDiffCallback(private val oldList: List<Ticket>, private val newList: List<Ticket>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].idticket == newList[newItemPosition].idticket
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}