package com.example.practico2.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practico2.models.Ingrediente

class MainViewModel: ViewModel(){
    private val _IngredienteList: MutableLiveData<ArrayList<Ingrediente>> by lazy {
        MutableLiveData<ArrayList<Ingrediente>>(null)
    }
    val IngredienteList: LiveData<ArrayList<Ingrediente>> get() = _IngredienteList

    private val _lstVerReceta: MutableLiveData<ArrayList<String>> by lazy {
        MutableLiveData<ArrayList<String>>(null)
    }
    val lstVerReceta: LiveData<ArrayList<String>> get() = _lstVerReceta

    fun loadIngredientes() {
        _IngredienteList.value = arrayListOf(
            Ingrediente(
                "Leche",
                false,
                "Huevo",
                false
            ),
            Ingrediente(
                "Papa",
                false,
                "Harina",
                false
            ),
            Ingrediente(
                "Carne",
                false,
                "Arroz",
                false
            ),
            Ingrediente(
                "Lechuga",
                false,
                "Manteca",
                false
            ),
            Ingrediente(
                "Cebolla",
                false,
                "Pollo",
                false
            ),
            Ingrediente(
                "Tomate",
                false,
                "Queso",
                false
            )
        )
    }
    fun updateIngrediente1(ingredienteNombre: String) {
        val list = _IngredienteList.value
        val index = list?.indexOfFirst { it.ingrediente1 == ingredienteNombre }
        if (index != null) {
            list[index].ingrediente1Pressed = !list[index].ingrediente1Pressed
        }
        _IngredienteList.value = list
    }
    fun updateIngrediente2(ingredienteNombre: String) {
        val list = _IngredienteList.value
        val index = list?.indexOfFirst { it.ingrediente2 == ingredienteNombre }
        if (index != null) {
            list[index].ingrediente2Pressed = !list[index].ingrediente2Pressed
        }
        _IngredienteList.value = list
    }

    fun verRecetas() {
        val list = _IngredienteList.value
        val lstVerReceta = arrayListOf<String>()
        list?.forEach {
            if (it.ingrediente1Pressed) {
                lstVerReceta.add(it.ingrediente1)
            }
            if (it.ingrediente2Pressed){
                lstVerReceta.add(it.ingrediente2)
            }
        }
        _lstVerReceta.value = lstVerReceta
    }
}