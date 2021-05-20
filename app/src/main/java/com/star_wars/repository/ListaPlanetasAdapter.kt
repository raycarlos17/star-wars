package com.star_wars

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.star_wars.model.Planeta
import com.star_wars.repository.ListaPlanetasViewHolder
import kotlinx.android.synthetic.main.lista_planetas_item.view.*

class ListaPlanetasAdapter(private val listaPlaneta: List<Planeta>, private val onClick: ((Planeta) -> Unit)): RecyclerView.Adapter<ListaPlanetasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaPlanetasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_planetas_item, parent, false)
        return ListaPlanetasViewHolder(view)
    }

    override fun getItemCount(): Int = listaPlaneta.size

    override fun onBindViewHolder(holder: ListaPlanetasViewHolder, position: Int) {
        val planeta = listaPlaneta[position]

        holder.itemView.apply {
            tv_nome_planeta_item.text = planeta.name
            setOnClickListener { onClick(planeta) }
        }
    }
}