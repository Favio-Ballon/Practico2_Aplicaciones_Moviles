package com.example.practico2.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practico2.databinding.RecetaListItemBinding
import com.example.practico2.models.Receta

class RecetaAdapter(
    private val Recetas: ArrayList<Receta>,
    private val listener: OnRecetaClickListener
) : RecyclerView.Adapter<RecetaAdapter.RecetaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val binding =
            RecetaListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return RecetaViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return Recetas.size
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        val receta = Recetas[position]
        holder.bind(receta, listener)
    }

    fun clear() {
        Recetas.clear()
        notifyDataSetChanged()
    }

    fun addAll(list: ArrayList<Receta>) {
        Recetas.addAll(list)
        notifyDataSetChanged()
    }

    class RecetaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(receta: Receta, listener: OnRecetaClickListener) {
            val binding = RecetaListItemBinding.bind(itemView)
            binding.txtNombre.text = receta.nombre
            binding.txtNombre.setOnClickListener {
                listener.onRecetaClick(receta)
            }
        }
    }


interface OnRecetaClickListener {
    fun onRecetaClick(receta: Receta)
}
}