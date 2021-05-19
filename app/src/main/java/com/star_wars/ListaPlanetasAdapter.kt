package com.star_wars

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.star_wars.model.ListaPlanetasModel

class ListaPlanetasAdapter(
    private val context: Context,
    private val listaPlanetasList: List<ListaPlanetasModel>
    ) : RecyclerView.Adapter<ListaPlanetasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaPlanetasViewHolder =
        ListaPlanetasViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_planetas_item, parent, false))

    override fun onBindViewHolder(holder: ListaPlanetasViewHolder, position: Int) {
        val planeta = listaPlanetasList[position]
        var lista = planeta.results
        Log.i("state", lista.toString())
        holder.tvNomePlanetaItem.text = planeta.name
    }

    override fun getItemCount(): Int = listaPlanetasList.size

}

class ListaPlanetasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvNomePlanetaItem: TextView = itemView.findViewById(R.id.tv_nome_planeta_item)

}