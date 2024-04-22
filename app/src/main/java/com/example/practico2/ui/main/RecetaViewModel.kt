package com.example.practico2.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practico2.models.Receta

class RecetaViewModel: ViewModel(){

    private val _recetaList: MutableLiveData<ArrayList<Receta>> by lazy {
        MutableLiveData<ArrayList<Receta>>(null)
    }
    val recetaList: LiveData<ArrayList<Receta>> get() = _recetaList

    private val _instruccion: MutableLiveData<String> by lazy {
        MutableLiveData<String>(null)
    }
    val instruccion: LiveData<String> get() = _instruccion

    fun loadRecetas(ingredientes: ArrayList<String>) {
        val list = _recetaList.value
        val newList = arrayListOf<Receta>()
        list?.forEach {
            if (it.ingredientes.containsAll(ingredientes)){
                newList.add(it)
            }
        }
        _recetaList.value = newList
    }

    fun updateInstruccion(receta: Receta){
        _instruccion.value = receta.instrucciones
    }

    fun createRecetas(){
        _recetaList.value = arrayListOf(
            Receta(
                "Pan",
                arrayListOf("Harina", "Levadura", "Sal", "Agua"),
                "Mezclar los ingredientes y hornear",
            ),
            Receta(
                "Torta",
                arrayListOf("Harina", "Azucar", "Huevo", "Leche"),
                "Mezclar los ingredientes y hornear",
            ),
            Receta(
                "Pizza",
                arrayListOf("Harina", "Levadura", "Sal", "Aceite", "Tomate", "Queso"),
                """
<h1>Ingredientes:</h1> <br>

    <b>Para la masa:</b><br>
    2 tazas de harina de trigo<br>
    1 cucharadita de levadura seca activa<br>
    1/2 cucharadita de sal<br>
    1 cucharada de aceite de oliva<br>
    3/4 taza de agua tibia<br>
    
    Para la cobertura:<br>
    1 taza de salsa de tomate (puedes prepararla mezclando tomate triturado con sal y aceite de oliva)<br>
    200g de queso mozzarella rallado<br>
<br>
<h1>Instrucciones:</h1><br>

<b>Preparar la masa:</b><br>
En un bol grande, mezcla la harina, la levadura y la sal.<br>
Agrega el aceite de oliva y el agua tibia a la mezcla de harina. Mezcla hasta formar una masa pegajosa.<br>
Amasa la masa sobre una superficie enharinada durante unos 5-7 minutos, o hasta que esté suave y elástica.<br>
Forma una bola con la masa y colócala en un bol ligeramente engrasado. Cubre el bol con un paño limpio y deja reposar en un lugar cálido durante aproximadamente 1 hora, o hasta que la masa haya duplicado su tamaño.<br>
<b>Preparar la cobertura:</b><br>
Precalienta tu horno a 220°C (425°F).<br>
Extiende la masa en una bandeja para hornear o en una piedra para pizza, formando el tamaño y grosor deseados.<br>
Cubre la masa con la salsa de tomate.<br>
<b>Agregar el queso:</b><br>
Espolvorea el queso mozzarella rallado uniformemente sobre la salsa de tomate.<br>
<b>Hornear la pizza:</b><br>
Hornea la pizza en el horno precalentado durante 12-15 minutos, o hasta que la masa esté dorada en los bordes y el queso esté burbujeante y ligeramente dorado.<br>
<b>Servir:</b><br>
Retira la pizza del horno y deja que repose durante unos minutos antes de cortarla.<br>
Sirve caliente y disfruta de tu pizza casera con una cobertura simple pero deliciosa.
            """.trimIndent(),
            ),
            Receta(
                "Tarta",
                arrayListOf("Harina", "Azucar", "Huevo", "Leche", "Fruta"),
                "Mezclar los ingredientes y hornear",
            ),
            Receta(
                "Galletas",
                arrayListOf("Harina", "Azucar", "Huevo", "Manteca"),
                "Mezclar los ingredientes y hornear",
            )
        )
    }
}