package com.example.events_app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.events_app.databinding.ItemTablaBinding
import com.example.events_app.models.Tabla

class TablaAdapter (
    private val tablas: ArrayList<Tabla>,
    private val listener: OnTablaClickListener
): RecyclerView.Adapter<TablaAdapter.TablaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TablaViewHolder {
        val binding = ItemTablaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TablaViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TablaViewHolder, position: Int) {
        holder.bind(tablas[position])
    }

    override fun getItemCount(): Int = tablas.size

    inner class TablaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tabla: Tabla) {
            val binding = ItemTablaBinding.bind(itemView)
            binding.lblTableName.text = tabla.name
            binding.root.setOnClickListener {
                listener.onTablaClicked(tabla)
            }
        }
    }

    interface OnTablaClickListener {
        fun onTablaClicked(tabla: Tabla)
    }
}
