package com.example.practico2.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practico2.R
import com.example.practico2.databinding.ActivityRecetaBinding
import com.example.practico2.models.Receta
import com.example.practico2.ui.adapters.RecetaAdapter

class RecetaActivity : AppCompatActivity(), RecetaAdapter.OnRecetaClickListener {
    private lateinit var binding: ActivityRecetaBinding
    private val model: RecetaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecetaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.receta)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //receive intent
        val recetas = intent.getStringArrayListExtra("recetas") as ArrayList<String>
        model.createRecetas()
        loadrecetas(recetas)
        setupRecyclerView()
        setupViewModelObservers()
    }

    private fun loadrecetas(recetas: ArrayList<String>) {
        model.loadRecetas(recetas)
    }

    private fun setupViewModelObservers() {
        model.recetaList.observe(this) {
            val adapter = binding.lstRecetas.adapter as RecetaAdapter
            adapter.clear()
            if (it != null) {
                adapter.addAll(it)
            }
        }
        model.instruccion.observe(this) {
            if (it != null) {
                intent = Intent(this, InstruccionesActivity::class.java)
                intent.putExtra("instruccion", it)
                startActivity(intent)
            }
        }
    }

    private fun setupRecyclerView(){
        val adapter = RecetaAdapter(
            arrayListOf(),
            this
        )
        binding.lstRecetas.adapter = adapter
        binding.lstRecetas.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
    }

    override fun onRecetaClick(receta: Receta) {
        model.updateInstruccion(receta)
    }

}