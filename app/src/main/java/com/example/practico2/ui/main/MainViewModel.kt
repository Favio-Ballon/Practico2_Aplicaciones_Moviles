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

    fun loadIngredientes() {
        _IngredienteList.value = arrayListOf(
            Ingrediente(
               "Leche",
                false,
                "Huevo",
                false
        ),
            Ingrediente(
                "Azucar",
                false,
                "Harina",
                false
            ),
            Ingrediente(
                "Sal",
                false,
                "Aceite",
                false
            ),
            Ingrediente(
                "Levadura",
                false,
                "Manteca",
                false
            ),
            Ingrediente(
                "Polvo de hornear",
                false,
                "Vainilla",
                false
            )
        )
    }

}