package com.example.practico2.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practico2.R
import com.example.practico2.databinding.ActivityMainBinding
import com.example.practico2.models.Ingrediente
import com.example.practico2.ui.adapters.IngredienteAdapter

class MainActivity : AppCompatActivity(), IngredienteAdapter.OnIngredienteClickListener{
    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupRecyclerView()
        setupViewModelObservers()
        setUpButton()
        model.loadIngredientes()
    }

    private fun setUpButton() {
        binding.btnVerRecetas.setOnClickListener {
            onBtnVerRecetasClick()
        }
    }

    private fun setupViewModelObservers() {
        model.IngredienteList.observe(this) {
            val adapter = binding.lstIngredientes.adapter as IngredienteAdapter
            adapter.clear()
            if (it != null) {
                adapter.addAll(it)
            }
        }
        model.lstVerReceta.observe(this) {
            if (it != null) {
                val intent = Intent(this, RecetaActivity::class.java)
                intent.putExtra("recetas", it)
                startActivity(intent)
            }
        }
    }

    private fun setupRecyclerView() {
        val adapter =IngredienteAdapter(
            arrayListOf(),
            this
        )
        binding.lstIngredientes.adapter = adapter
        binding.lstIngredientes.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
    }

    private fun onBtnVerRecetasClick() {
        model.verRecetas()
    }
    override fun onBtn1Click(ingrediente: Ingrediente) {
        model.updateIngrediente1(ingrediente.ingrediente1)

    }

    override fun onBtn2Click(ingrediente: Ingrediente) {
        model.updateIngrediente2(ingrediente.ingrediente2)
    }

}