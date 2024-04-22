package com.example.practico2.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practico2.databinding.IngredienteListItemBinding
import com.example.practico2.models.Ingrediente

class IngredienteAdapter(
    private val Ingredientes: ArrayList<Ingrediente>,
    private val listener: OnIngredienteClickListener

) : RecyclerView.Adapter<IngredienteAdapter.IngredienteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredienteViewHolder {
        val binding =
            IngredienteListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return IngredienteViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return Ingredientes.size
    }

    override fun onBindViewHolder(holder: IngredienteViewHolder, position: Int) {
        val ingrediente = Ingredientes[position]
        holder.bind(ingrediente, listener)
    }

    fun clear() {
        Ingredientes.clear()
        notifyDataSetChanged()
    }

    fun addAll(list: ArrayList<Ingrediente>) {
        Ingredientes.addAll(list)
        notifyDataSetChanged()
    }

    class IngredienteViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(ingrediente: Ingrediente, listener: OnIngredienteClickListener) {
            val binding = IngredienteListItemBinding.bind(itemView)
            binding.btn1.text = ingrediente.ingrediente1
            binding.btn2.text = ingrediente.ingrediente2
            if (ingrediente.ingrediente1Pressed) {
                //make button seem pressed
                binding.blackLayerBtn1.visibility = View.VISIBLE
            } else {
                binding.blackLayerBtn1.visibility = View.INVISIBLE
            }
            if (ingrediente.ingrediente2Pressed) {
                //make button seem pressed
                binding.blackLayerBtn2.visibility = View.VISIBLE
            } else {
                binding.blackLayerBtn2.visibility = View.INVISIBLE
            }
            binding.btn1.setOnClickListener {
                listener.onBtn1Click(ingrediente)
            }
            binding.btn2.setOnClickListener {
                listener.onBtn2Click(ingrediente)
            }
        }
    }

    interface OnIngredienteClickListener {
        fun onBtn1Click(ingrediente: Ingrediente)
        fun onBtn2Click(ingrediente: Ingrediente)

    }

}