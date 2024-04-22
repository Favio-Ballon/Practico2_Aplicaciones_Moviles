package com.example.practico2.ui.main

import android.os.Bundle
import android.text.Html
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practico2.R
import com.example.practico2.databinding.ActivityInstruccionesBinding

class InstruccionesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInstruccionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityInstruccionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.intrucciones)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val instruccion = intent.getStringExtra("instruccion")
        binding.txtInstruccion.text = Html.fromHtml(instruccion, Html.FROM_HTML_MODE_COMPACT)
        binding.txtInstruccion.movementMethod = android.text.method.LinkMovementMethod.getInstance()
    }
}