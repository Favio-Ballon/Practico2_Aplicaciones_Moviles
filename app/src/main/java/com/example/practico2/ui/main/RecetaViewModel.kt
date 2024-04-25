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
                """
<h1>Receta de Pan Casero</h1><br>

<h2>Ingredientes:</h2><br>
- 500 g de harina de trigo<br>
- 300 ml de agua tibia<br>
- 7 g de levadura seca (o 20 g de levadura fresca)<br>
- 10 g de sal<br>
- 15 ml de aceite de oliva (opcional)<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Activar la levadura:</h3><br>
- En un pequeño recipiente, mezcla la levadura con un poco de agua tibia y una pizca de azúcar. Deja reposar durante unos 10 minutos hasta que la levadura se active y comience a burbujear.<br><br>

<h3>2. Preparar la masa:</h3><br>
- En un bol grande, mezcla la harina y la sal. Haz un hueco en el centro y vierte la levadura activada junto con el resto del agua tibia. Si decides usar aceite de oliva, agrégalo también en este punto.<br><br>

<h3>3. Amasar:</h3><br>
- Mezcla todos los ingredientes hasta formar una masa homogénea y suave. Puedes hacer esto a mano sobre una superficie enharinada o utilizando una amasadora eléctrica con el accesorio de gancho para amasar. Amasa durante unos 10-15 minutos hasta que la masa esté elástica.<br><br>

<h3>4. Dejar reposar:</h3><br>
- Forma una bola con la masa y colócala en un bol ligeramente engrasado con aceite. Cubre el bol con un paño limpio y deja reposar la masa en un lugar cálido durante aproximadamente 1 hora o hasta que haya duplicado su tamaño.<br><br>

<h3>5. Dar forma al pan:</h3><br>
- Una vez que la masa haya duplicado su tamaño, sácala del bol y colócala sobre una superficie enharinada. Dale forma al pan según tu preferencia: redondo, alargado, etc.<br><br>

<h3>6. Segundo reposo:</h3><br>
- Coloca el pan en una bandeja para hornear previamente enharinada o sobre papel para hornear. Cubre nuevamente con un paño limpio y deja reposar durante otros 30-45 minutos.<br><br>

<h3>7. Precalentar el horno:</h3><br>
- Mientras el pan reposa por segunda vez, precalienta tu horno a 220°C.<br><br>

<h3>8. Hornear:</h3><br>
- Una vez que el pan haya vuelto a aumentar ligeramente de tamaño, haz unos cortes en la parte superior con un cuchillo afilado o unas tijeras. Esto ayudará a que el pan se expanda uniformemente durante el horneado. Luego, coloca el pan en el horno precalentado y hornea durante unos 25-30 minutos o hasta que esté dorado y suene hueco al golpear la parte inferior.<br><br>

<h3>9. Enfriar:</h3><br>
- Una vez horneado, saca el pan del horno y déjalo enfriar sobre una rejilla antes de cortarlo. ¡Y listo! Ya tienes tu pan casero recién horneado.<br><br>

                """.trimIndent(),
            ),
            Receta(
                "Torta",
                arrayListOf("Harina", "Azucar", "Huevo", "Leche"),
                """
<h1>Receta de Torta Básica</h1><br>

<h2>Ingredientes:</h2><br>
- 2 tazas de harina de trigo<br>
- 1 taza de azúcar<br>
- 3 huevos<br>
- 1 taza de leche<br>
- 1/2 taza de mantequilla derretida<br>
- 1 cucharada de polvo de hornear<br>
- 1 cucharadita de extracto de vainilla (opcional)<br>
- Una pizca de sal<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Precalentar el horno:</h3><br>
- Precalienta tu horno a 180°C. Engrasa y enharina un molde para pastel o forra el fondo con papel pergamino.<br><br>

<h3>2. Mezclar los ingredientes secos:</h3><br>
- En un tazón grande, mezcla la harina, el azúcar, el polvo de hornear y la sal.<br><br>

<h3>3. Mezclar los ingredientes húmedos:</h3><br>
- En otro tazón, bate los huevos ligeramente. Agrega la leche, la mantequilla derretida y el extracto de vainilla (si lo estás usando). Mezcla bien.<br><br>
<h3>4. Combinar los ingredientes:</h3><br>
- Vierte los ingredientes líquidos sobre los ingredientes secos y mezcla hasta que estén bien combinados.
<h3>5. Verter la mezcla en el molde:</h3><br>
- Vierte la mezcla en el molde preparado y alisa la superficie con una espátula.<br><br>
<h3>6. Hornear:</h3><br>
- Coloca el molde en el horno precalentado y hornea durante aproximadamente 30-35 minutos, o hasta que al insertar un palillo en el centro, este salga limpio.<br><br>
<h3>7. Enfriar y decorar:</h3><br>
- Una vez horneada, saca la torta del horno y déjala enfriar en el molde durante unos 10 minutos. Luego, transfiérela a una rejilla para que se enfríe completamente.<br><br>
<h3>8. Decorar (opcional):</h3><br>
- Una vez que la torta esté completamente fría, puedes decorarla como prefieras. Puedes espolvorear azúcar en polvo, glasearla con un glaseado de tu elección o simplemente servirla tal como está.
""".trimIndent(),
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
                "Tortilla de carne, papas y huevos",
                arrayListOf("Carne", "Papa", "Huevo", "Cebolla"),
                """
<h1>Receta de Tortilla de Carne, Papas y Huevos</h1><br>

<h2>Ingredientes:</h2><br>
- 3 papas medianas, peladas y cortadas en cubos pequeños<br>
- 200 g de carne picada (puede ser de res, pollo, cerdo o una mezcla)<br>
- 1 cebolla pequeña, picada<br>
- 4 huevos<br>
- Sal y pimienta al gusto<br>
- Aceite de oliva o vegetal para freír<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Preparar los ingredientes:</h3><br>
- En una sartén grande, calienta un poco de aceite a fuego medio. Añade las papas cortadas en cubos y fríelas hasta que estén doradas y tiernas. Retira las papas de la sartén y déjalas escurrir sobre papel absorbente.<br><br>

<h3>2. Cocinar la carne y la cebolla:</h3><br>
- En la misma sartén, agrega un poco más de aceite si es necesario y añade la cebolla picada. Cocina hasta que esté transparente y luego agrega la carne picada. Cocina la carne hasta que esté bien cocida y dorada. Condimenta con sal y pimienta al gusto.<br><br>

<h3>3. Batir los huevos:</h3><br>
- En un tazón grande, bate los huevos y sazona con sal y pimienta al gusto.<br><br>

<h3>4. Combinar los ingredientes:</h3><br>
- Agrega las papas fritas y la mezcla de carne y cebolla a los huevos batidos. Mezcla todo bien para asegurarte de que todos los ingredientes estén distribuidos de manera uniforme.<br><br>

<h3>5. Cocinar la tortilla:</h3><br>
- Calienta un poco más de aceite en la sartén a fuego medio. Vierte la mezcla de huevo, carne y papas en la sartén caliente y extiéndela uniformemente con una espátula. Cocina la tortilla a fuego medio-bajo durante unos 8-10 minutos, o hasta que los bordes estén dorados y la parte superior esté casi cocida.<br><br>

<h3>6. Dar la vuelta a la tortilla:</h3><br>
- Coloca un plato grande sobre la sartén y con cuidado da la vuelta a la tortilla sobre el plato. Desliza la tortilla nuevamente en la sartén para cocinar el otro lado. Cocina durante otros 5-7 minutos, o hasta que esté dorada y completamente cocida por dentro.<br><br>

<h3>7. Servir:</h3><br>
- Una vez que la tortilla esté lista, retírala de la sartén y colócala en un plato. Corta en porciones y sirve caliente. ¡Disfruta tu tortilla de carne, papas y huevos!
                """.trimIndent()
            ),
            Receta(
                "Arroz a la criolla con carne",
                arrayListOf("Carne", "Arroz", "Tomate", "Cebolla"),
                """
<h1>Receta de Arroz a la Criolla con Carne</h1><br>

<h2>Ingredientes:</h2><br>
- 2 tazas de arroz blanco<br>
- 500 g de carne de res (puede ser carne para guisar o bistec), cortada en trozos pequeños<br>
- 1 cebolla grande, picada<br>
- 2 dientes de ajo, picados<br>
- 1 pimiento rojo, cortado en cubitos<br>
- 1 zanahoria grande, cortada en cubitos<br>
- 1 lata de tomate triturado (400g)<br>
- 2 tazas de caldo de carne o agua<br>
- 1 cucharadita de comino molido<br>
- 1 cucharadita de páprika o ají molido<br>
- Sal y pimienta al gusto<br>
- Aceite de oliva<br>
- Perejil fresco picado para decorar (opcional)<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Preparar la carne:</h3><br>
- En una olla grande o una sartén profunda, calienta un poco de aceite de oliva a fuego medio-alto. Agrega la carne cortada en trozos y sazona con sal y pimienta al gusto. Cocina la carne hasta que esté dorada por todos lados. Retira la carne de la olla y reserva.<br><br>

<h3>2. Sofreír los vegetales:</h3><br>
- En la misma olla, agrega un poco más de aceite si es necesario. Añade la cebolla, el ajo, el pimiento rojo y la zanahoria. Cocina, revolviendo ocasionalmente, hasta que las verduras estén tiernas.<br><br>

<h3>3. Agregar el arroz y las especias:</h3><br>
- Añade el arroz a la olla y mezcla bien con las verduras. Agrega el comino molido, la páprika (o ají molido), sal y pimienta al gusto. Cocina por unos minutos más, revolviendo constantemente.<br><br>

<h3>4. Incorporar el tomate triturado y el caldo:</h3><br>
- Vierte el tomate triturado sobre el arroz y mezcla bien. Luego, añade el caldo de carne o agua caliente. Asegúrate de que el líquido cubra completamente el arroz.<br><br>

<h3>5. Cocinar a fuego lento:</h3><br>
- Vuelve a colocar la carne dorada en la olla con el arroz y las verduras. Reduce el fuego a bajo, tapa la olla y deja cocinar el arroz a fuego lento hasta que esté tierno y haya absorbido todo el líquido. Esto debería tomar alrededor de 15-20 minutos. Revuelve ocasionalmente para evitar que el arroz se pegue al fondo de la olla.<br><br>

<h3>6. Reposar y servir:</h3><br>
- Una vez que el arroz esté listo, retira la olla del fuego y deja reposar durante unos minutos con la tapa puesta. Esto ayudará a que el arroz termine de absorber cualquier exceso de líquido y se asiente. Sirve el arroz a la criolla con carne caliente, espolvoreado con perejil fresco picado si lo deseas.<br><br>

¡Disfruta de este sabroso arroz a la criolla con carne, lleno de sabor y textura!```

                    """.trimIndent(),
            ),
            Receta(
                "Tarta de cebolla y queso",
                arrayListOf("Cebolla", "Queso", "Harina", "Manteca"),
                """
<h1>Receta de Tarta de Cebolla y Queso con Masa Casera</h1><br>

<h2>Ingredientes para la masa:</h2><br>
- 200 g de harina de trigo<br>
- 100 g de manteca fría, cortada en cubos pequeños<br>
- 1 pizca de sal<br>
- 3-4 cucharadas de agua fría<br><br>

<h2>Ingredientes para el relleno:</h2><br>
- 3 cebollas grandes, cortadas en rodajas finas<br>
- 200 g de queso rallado (puedes usar queso gruyere, mozzarella, o el de tu preferencia)<br>
- 3 huevos<br>
- 200 ml de crema de leche (nata para montar)<br>
- 1 cucharada de aceite de oliva<br>
- Sal y pimienta al gusto<br>
- Perejil fresco picado para decorar (opcional)<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Preparar la masa:</h3><br>
- En un tazón grande, mezcla la harina y la sal. Agrega la manteca fría y, usando tus manos o un cortador de masa, incorpora la manteca a la harina hasta que la mezcla tenga una textura arenosa.<br>
- Agrega el agua fría, una cucharada a la vez, mezclando con las manos hasta que la masa se una y puedas formar una bola. Envuelve la masa en film transparente y refrigérala durante al menos 30 minutos.<br><br>

<h3>2. Precalentar el horno y preparar la masa:</h3><br>
- Precalienta tu horno a 180°C (350°F). Retira la masa del refrigerador y extiéndela sobre una superficie enharinada hasta que tenga el grosor deseado para tu tarta. Forra un molde para tarta engrasado con la masa y recorta el exceso de los bordes.<br><br>

<h3>3. Preparar el relleno:</h3><br>
- Mientras la masa se enfría en el molde, calienta el aceite de oliva en una sartén grande a fuego medio. Agrega las rodajas de cebolla y cocina lentamente hasta que estén suaves y caramelizadas, esto puede tomar alrededor de 20-30 minutos. Revuelve ocasionalmente.<br><br>

<h3>4. Preparar la mezcla de huevos y crema:</h3><br>
- En un tazón grande, bate los huevos y la crema de leche hasta que estén bien combinados. Sazona con sal y pimienta al gusto.<br><br>

<h3>5. Ensamblar la tarta:</h3><br>
- Una vez que la masa esté lista, esparce las cebollas caramelizadas sobre la base de la tarta. Espolvorea el queso rallado sobre las cebollas.<br><br>

<h3>6. Verter la mezcla de huevos y crema:</h3><br>
- Vierte la mezcla de huevos y crema sobre las cebollas y el queso en el molde para tarta.<br><br>

<h3>7. Hornear:</h3><br>
- Hornea la tarta en el horno precalentado durante unos 25-30 minutos, o hasta que esté dorada y cuajada en el centro.<br><br>

<h3>8. Enfriar y servir:</h3><br>
- Una vez lista, retira la tarta del horno y déjala enfriar durante unos minutos antes de cortarla en porciones. Espolvorea con perejil fresco picado si lo deseas y sirve caliente o a temperatura ambiente. ¡Disfruta de tu deliciosa tarta de cebolla y queso con masa casera!<br><br>
                    """.trimIndent()
            ),
            Receta(
                "Pollo al horno con papas",
                arrayListOf("Pollo", "Papa", "Cebolla", "Tomate"),
                """
<h1>Receta de Pollo al Horno con Papas, Tomate y Cebolla</h1><br>

<h2>Ingredientes:</h2><br>
- 1 pollo entero (aproximadamente 1.5 - 2 kg), lavado y limpio<br>
- 4 papas grandes, peladas y cortadas en trozos grandes<br>
- 2 tomates grandes, cortados en rodajas<br>
- 1 cebolla grande, cortada en rodajas<br>
- 4 dientes de ajo, picados<br>
- 2 cucharadas de aceite de oliva<br>
- 1 cucharadita de tomillo seco<br>
- 1 cucharadita de romero seco<br>
- 1 cucharadita de pimentón dulce<br>
- Sal y pimienta al gusto<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Precalentar el horno:</h3><br>
- Precalienta tu horno a 200°C (390°F).<br><br>

<h3>2. Preparar el pollo y las verduras:</h3><br>
- Seca el pollo con papel de cocina. En un tazón pequeño, mezcla el aceite de oliva, el ajo picado, el tomillo, el romero, el pimentón dulce, sal y pimienta. Unta esta mezcla por toda la superficie del pollo y dentro de la cavidad.<br>
- Coloca el pollo en una bandeja para hornear. Alrededor del pollo, distribuye las papas cortadas en trozos y las rodajas de tomate y cebolla.<br><br>

<h3>3. Hornear:</h3><br>
- Coloca la bandeja en el horno precalentado y hornea durante aproximadamente 1 hora y 15 minutos, o hasta que el pollo esté dorado y cocido por completo. El tiempo de cocción puede variar dependiendo del tamaño del pollo y de tu horno.<br><br>

<h3>4. Comprobar la cocción:</h3><br>
- Para asegurarte de que el pollo esté completamente cocido, puedes insertar un termómetro de cocina en la parte más gruesa del muslo. La temperatura interna debe alcanzar al menos 75°C (165°F).<br><br>

<h3>5. Servir:</h3><br>
- Una vez que el pollo esté listo, retira la bandeja del horno y deja reposar el pollo durante unos minutos antes de cortarlo en porciones. Sirve el pollo al horno con las papas, tomates y cebollas calientes como acompañamiento. ¡Disfruta de esta deliciosa comida casera con un toque de tomate y cebolla!<br><br>
          """.trimIndent()
            ),
            Receta(
                "Pastel de carne",
                arrayListOf("Carne", "Papa", "Cebolla", "Tomate"),
                """
<h1>Receta de Pastel de Carne</h1><br>

<h2>Ingredientes:</h2><br>
- 500 g de carne molida (puede ser de res, cerdo, pollo o una mezcla)<br>
- 2 cucharadas de aceite de oliva<br>
- 1 cebolla grande, picada<br>
- 2 dientes de ajo, picados<br>
- 2 zanahorias, peladas y ralladas<br>
- 2 ramas de apio, picadas<br>
- 1 taza de guisantes (pueden ser frescos o congelados)<br>
- 2 cucharadas de salsa de tomate<br>
- 1 cucharadita de tomillo seco<br>
- 1 cucharadita de romero seco<br>
- 1 cucharadita de pimentón dulce<br>
- Sal y pimienta al gusto<br>
- Puré de papas para cubrir el pastel (puedes hacerlo casero o usar puré de papas comprado)<br>
- Queso rallado (opcional, para gratinar)<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Preparar el relleno:</h3><br>
- En una sartén grande, calienta el aceite de oliva a fuego medio-alto. Agrega la cebolla y el ajo picados y cocina hasta que estén dorados y fragantes.<br>
- Agrega la carne molida a la sartén y cocina hasta que esté dorada y cocida por completo. Añade las zanahorias ralladas, el apio picado y los guisantes. Cocina por unos minutos hasta que las verduras estén tiernas.<br>
- Incorpora la salsa de tomate, el tomillo, el romero, el pimentón dulce, sal y pimienta al gusto. Mezcla bien y cocina por unos minutos más. Retira del fuego y reserva.<br><br>

<h3>2. Preparar el puré de papas:</h3><br>
- Si estás haciendo puré de papas casero, pela y corta las papas en trozos grandes. Cocínalas en agua con sal hasta que estén tiernas. Escúrrelas y haz un puré con un poco de mantequilla y leche caliente. Si estás usando puré de papas comprado, caliéntalo según las instrucciones del paquete.<br><br>

<h3>3. Armar el pastel de carne:</h3><br>
- Precalienta tu horno a 180°C (350°F). Engrasa ligeramente un molde para hornear.<br>
- Coloca la mezcla de carne en el fondo del molde para hornear y extiéndela uniformemente.<br>
- Cubre la carne con una capa de puré de papas, alisando la superficie con una espátula.<br><br>

<h3>4. Hornear:</h3><br>
- Coloca el pastel de carne en el horno precalentado y hornea durante aproximadamente 30-40 minutos, o hasta que el puré de papas esté dorado en la parte superior y el pastel esté burbujeante en los bordes.<br><br>

<h3>5. Servir:</h3><br>
- Una vez que el pastel de carne esté listo, retíralo del horno y déjalo reposar durante unos minutos antes de cortarlo en porciones. Si lo deseas, espolvorea queso rallado sobre la capa de puré de papas y gratina en el horno durante unos minutos más hasta que el queso esté dorado y burbujeante. Sirve caliente y disfruta de este reconfortante plato casero.<br><br>
            """.trimIndent()
                ),
            Receta(
                "Ensalada de pollo",
                arrayListOf("Pollo", "Lechuga", "Tomate", "Cebolla"),
                """
<h1>Receta de Ensalada de Pollo</h1><br>

<h2>Ingredientes:</h2><br>
- 2 pechugas de pollo cocidas y desmenuzadas<br>
- 4 tazas de lechuga fresca, lavada y cortada en trozos pequeños<br>
- 1/2 pepino, cortado en rodajas finas<br>
- 1/2 pimiento rojo, cortado en tiras<br>
- 1/2 cebolla roja, cortada en rodajas finas<br>
- 1 tomate grande, cortado en rodajas o en cubos<br>
- 1 aguacate maduro, cortado en rodajas o en cubos<br>
- 1/4 de taza de nueces o almendras picadas (opcional)<br>
- Aderezo de tu elección (vinagreta balsámica, aderezo ranch, aderezo de mostaza y miel, etc.)<br>
- Sal y pimienta al gusto<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Cocinar el pollo:</h3><br>
- Hierve o cocina al vapor las pechugas de pollo hasta que estén completamente cocidas. Una vez cocidas, déjalas enfriar y luego desmenúzalas o córtalas en trozos pequeños.<br><br>

<h3>2. Preparar los vegetales:</h3><br>
- En un tazón grande, combina la lechuga, el pepino, el pimiento rojo, la cebolla roja, el tomate y el aguacate. Si deseas, también puedes añadir las nueces o almendras picadas para darle un toque crujiente a la ensalada.<br><br>

<h3>3. Agregar el pollo:</h3><br>
- Agrega el pollo desmenuzado o cortado en trozos a la ensalada.<br><br>

<h3>4. Aderezar:</h3><br>
- Vierte el aderezo de tu elección sobre la ensalada. Mezcla bien para asegurarte de que todos los ingredientes estén cubiertos uniformemente con el aderezo.<br><br>

<h3>5. Salpimentar al gusto:</h3><br>
- Agrega sal y pimienta al gusto y mezcla nuevamente.<br><br>

<h3>6. Servir:</h3><br>
- Sirve la ensalada de pollo en platos individuales y disfrútala como un almuerzo ligero o una cena rápida y saludable.<br><br>
""".trimIndent()
            ),
            Receta(
                "Sopa de verduras",
                arrayListOf( "Papa", "Cebolla", "Tomate"),
                """
<h1>Receta de Sopa de Verduras</h1><br>

<h2>Ingredientes:</h2><br>
- 2 papas grandes, peladas y cortadas en cubos<br>
- 1 cebolla grande, picada<br>
- 2 tomates grandes, cortados en cubos<br>
- 2 zanahorias, peladas y cortadas en rodajas<br>
- 2 tallos de apio, picados<br>
- 2 dientes de ajo, picados<br>
- 1 litro de caldo de verduras (puedes usar caldo casero o comprado)<br>
- 2 cucharadas de aceite de oliva<br>
- Sal y pimienta al gusto<br>
- Perejil fresco picado para decorar (opcional)<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Sofreír las verduras:</h3><br>
- En una olla grande, calienta el aceite de oliva a fuego medio. Agrega la cebolla y el ajo picados y cocina hasta que estén transparentes y fragantes.<br>
- Añade las papas, los tomates, las zanahorias y el apio a la olla. Salpimienta al gusto y saltea por unos minutos.<br><br>

<h3>2. Cocinar la sopa:</h3><br>
- Vierte el caldo de verduras sobre las verduras en la olla. Lleva la sopa a ebullición, luego reduce el fuego y deja cocinar a fuego lento durante unos 20-25 minutos, o hasta que las verduras estén tiernas.<br><br>

<h3>3. Triturar la sopa:</h3><br>
- Una vez que las verduras estén cocidas, puedes dejar la sopa tal cual o triturarla parcial o completamente con una licuadora de mano o un procesador de alimentos, según la textura que prefieras.<br><br>

<h3>4. Ajustar la sazón:</h3><br>
- Prueba la sopa y ajusta la sazón con sal y pimienta según sea necesario.<br><br>

<h3>5. Servir:</h3><br>
- Sirve la sopa de verduras caliente, decorada con perejil fresco picado si lo deseas. Acompáñala con pan crujiente o tostadas. ¡Disfruta de esta reconfortante y saludable sopa de verduras! <br><br>
""".trimIndent()
            ),
            Receta(
                "Sopa de tomate",
                arrayListOf("Tomate", "Cebolla"),
                """
<h1>Receta de Sopa de Tomate</h1><br>

<h2>Ingredientes:</h2><br>
- 1 kg de tomates maduros, cortados en cuartos<br>
- 1 cebolla grande, picada<br>
- 2 dientes de ajo, picados<br>
- 2 zanahorias, peladas y picadas<br>
- 2 tallos de apio, picados<br>
- 1 litro de caldo de verduras o pollo<br>
- 2 cucharadas de aceite de oliva<br>
- 1 cucharadita de azúcar (opcional, para reducir la acidez de los tomates)<br>
- Sal y pimienta al gusto<br>
- Albahaca fresca o seca para decorar (opcional)<br>
- Crema fresca o yogur natural para servir (opcional)<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Sofreír las verduras:</h3><br>
- En una olla grande, calienta el aceite de oliva a fuego medio. Agrega la cebolla y el ajo picados y cocina hasta que estén transparentes y fragantes.<br>
- Añade las zanahorias y el apio a la olla y cocina por unos minutos más, hasta que estén ligeramente tiernos.<br><br>

<h3>2. Cocinar los tomates:</h3><br>
- Agrega los tomates cortados a la olla y cocina por unos 5-10 minutos, hasta que comiencen a ablandarse y liberar sus jugos.<br><br>

<h3>3. Preparar la sopa:</h3><br>
- Vierte el caldo de verduras o pollo sobre los tomates y las verduras en la olla. Añade el azúcar si estás usando y sazona con sal y pimienta al gusto. Deja que la sopa hierva, luego reduce el fuego y cocina a fuego lento durante unos 20-25 minutos, para permitir que los sabores se mezclen y los ingredientes se ablanden completamente.<br><br>

<h3>4. Triturar la sopa:</h3><br>
- Una vez que los ingredientes estén cocidos, puedes usar una licuadora de mano o transferir la sopa a una licuadora convencional (trabajando en lotes si es necesario) para triturarla hasta obtener una consistencia suave y cremosa. Si prefieres una textura más rústica, puedes dejar la sopa tal cual.<br><br>

<h3>5. Servir:</h3><br>
- Sirve la sopa de tomate caliente, decorada con hojas de albahaca fresca o seca si lo deseas. Puedes agregar una cucharada de crema fresca o yogur natural en cada plato antes de servir para darle un toque cremoso adicional. Acompaña con pan crujiente o grissinis. ¡Disfruta de esta reconfortante sopa de tomate! <br><br>
""".trimIndent()
            ),
            Receta(
                "Tortilla de tomate y cebolla",
                arrayListOf("Tomate", "Cebolla", "Huevo"),
                """
<h1>Receta de Tortilla de Tomate y Cebolla</h1><br>

<h2>Ingredientes:</h2><br>
- 4 huevos grandes<br>
- 2 tomates medianos, cortados en rodajas finas<br>
- 1 cebolla mediana, cortada en rodajas finas<br>
- 2 cucharadas de aceite de oliva<br>
- Sal y pimienta al gusto<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Preparar los ingredientes:</h3><br>
- Corta los tomates y la cebolla en rodajas finas. Bate los huevos en un tazón grande y sazona con sal y pimienta al gusto.<br><br>

<h3>2. Sofreír las verduras:</h3><br>
- Calienta el aceite de oliva en una sartén grande a fuego medio. Agrega las rodajas de cebolla y cocina, revolviendo ocasionalmente, hasta que estén suaves y translúcidas, aproximadamente 5 minutos.<br>
- Agrega las rodajas de tomate a la sartén y cocina por otros 2-3 minutos, hasta que estén ligeramente tiernas pero aún mantengan su forma. Retira las verduras de la sartén y déjalas enfriar un poco.<br><br>

<h3>3. Hacer la tortilla:</h3><br>
- Vierte los huevos batidos en la sartén caliente y distribúyelos uniformemente. Luego, coloca las rodajas de cebolla y tomate sobre los huevos de manera uniforme.<br><br>

<h3>4. Cocinar la tortilla:</h3><br>
- Cocina la tortilla a fuego medio-bajo durante unos 5-7 minutos, o hasta que los bordes estén firmes y ligeramente dorados, y el centro esté casi listo.<br><br>

<h3>5. Darle la vuelta a la tortilla:</h3><br>
- Coloca un plato grande sobre la sartén y, con un movimiento rápido, da vuelta la tortilla para que se cocine del otro lado. Puedes agregar un poco más de aceite en la sartén antes de devolver la tortilla si es necesario.<br><br>

<h3>6. Cocinar el otro lado:</h3><br>
- Cocina la tortilla por el otro lado durante otros 5-7 minutos, o hasta que esté dorada y cocida por completo en el centro.<br><br>

<h3>7. Servir:</h3><br>
- Una vez que la tortilla esté lista, retírala del fuego y déjala reposar durante unos minutos antes de cortarla en porciones. Sirve caliente o a temperatura ambiente, acompañada de una ensalada fresca o simplemente con un poco de pan crujiente. ¡Disfruta de esta deliciosa tortilla de tomate y cebolla! <br><br>
""".trimIndent()
            ),
            Receta(
                "Arroz Chaufa",
                arrayListOf("Arroz", "Carne", "Huevo", "Cebolla"),
                """
<h1>Receta de Arroz Chaufa con Carne, Huevo y Cebolla</h1><br>

<h2>Ingredientes:</h2><br>
- 2 tazas de arroz cocido y refrigerado (preferiblemente arroz de grano largo)<br>
- 200 g de carne de pollo, cerdo o res, cortada en trozos pequeños<br>
- 2 huevos<br>
- 1 cebolla grande, picada<br>
- 2 dientes de ajo, picados finamente<br>
- 4 cucharadas de salsa de soja<br>
- 2 cucharadas de aceite vegetal<br>
- Sal y pimienta al gusto<br>
- Cebollín fresco picado para decorar (opcional)<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Preparar los ingredientes:</h3><br>
- Cocina el arroz con anticipación y refrigéralo durante al menos una hora antes de usarlo para que esté frío y firme.<br>
- Corta la carne en trozos pequeños, pica la cebolla y el ajo y tenlos listos para usar.<br><br>

<h3>2. Saltear la carne:</h3><br>
- En una sartén grande o wok, calienta una cucharada de aceite vegetal a fuego medio-alto. Agrega la carne y saltea hasta que esté cocida y dorada. Retira de la sartén y reserva.<br><br>

<h3>3. Saltear la cebolla y el ajo:</h3><br>
- En la misma sartén, agrega otra cucharada de aceite vegetal si es necesario. Agrega la cebolla y el ajo picados y saltea hasta que estén dorados y fragantes.<br><br>

<h3>4. Cocinar los huevos:</h3><br>
- En un lado de la sartén, agrega los huevos batidos y revuelve hasta que estén cocidos. Luego, mézclalos con la cebolla y el ajo.<br><br>

<h3>5. Preparar el arroz:</h3><br>
- Agrega el arroz cocido a la sartén con la cebolla, el ajo y los huevos, y revuelve bien para combinar.<br>
- Vierte la salsa de soja sobre el arroz y sigue revolviendo hasta que esté bien mezclado.<br><br>

<h3>6. Agregar la carne y servir:</h3><br>
- Agrega la carne salteada de vuelta a la sartén con el arroz y mezcla todo junto.<br>
- Una vez que todo esté bien caliente y bien mezclado, retira la sartén del fuego.<br><br>

<h3>7. Servir:</h3><br>
- Sirve el Arroz Chaufa caliente, decorado con cebollín fresco picado si lo deseas. Disfruta de este delicioso plato peruano-chino como plato principal o acompañamiento. ¡Buen provecho! <br><br>
""".trimIndent()
            ),
            Receta(
                "Lomo saltado",
                arrayListOf("Carne", "Cebolla", "Tomate", "Papa"),
                """
<h1>Receta de Lomo Saltado</h1><br>

<h2>Ingredientes:</h2><br>
- 500 g de filete de res, cortado en tiras<br>
- 2 cebollas rojas grandes, cortadas en tiras gruesas<br>
- 2 tomates grandes, cortados en tiras gruesas<br>
- 1 pimiento amarillo grande, cortado en tiras gruesas<br>
- 2 dientes de ajo, picados finamente<br>
- 2 cucharadas de salsa de soja<br>
- 2 cucharadas de vinagre de vino tinto<br>
- 2 cucharadas de aceite vegetal<br>
- 1 cucharadita de comino molido<br>
- 1 cucharadita de pimienta negra molida<br>
- 1/2 taza de cilantro fresco picado<br>
- Sal al gusto<br>
- Papas fritas caseras o arroz blanco cocido para acompañar<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Preparar los ingredientes:</h3><br>
- Corta la carne en tiras y sazónala con sal, comino y pimienta negra.<br>
- Corta las cebollas, los tomates y el pimiento en tiras gruesas.<br><br>

<h3>2. Saltear la carne:</h3><br>
- En una sartén grande o wok, calienta una cucharada de aceite vegetal a fuego alto. Agrega la carne y saltea rápidamente hasta que esté dorada por fuera pero aún jugosa por dentro. Retira la carne de la sartén y reserva.<br><br>

<h3>3. Saltear las verduras:</h3><br>
- En la misma sartén, agrega otra cucharada de aceite vegetal si es necesario. Agrega los ajos picados y saltea por unos segundos hasta que estén fragantes.<br>
- Agrega las cebollas y saltea hasta que estén tiernas y ligeramente caramelizadas.<br>
- Añade los tomates y el pimiento y cocina por unos minutos más, manteniendo las verduras crujientes.<br><br>

<h3>4. Combinar los ingredientes:</h3><br>
- Agrega la carne dorada de vuelta a la sartén con las verduras. Mezcla todo junto.<br>
- Vierte la salsa de soja y el vinagre de vino tinto sobre la mezcla y revuelve bien para combinar.<br>
- Cocina por unos minutos más, revolviendo constantemente, para que todos los sabores se mezclen y los ingredientes estén bien calientes.<br><br>

<h3>5. Terminar y servir:</h3><br>
- Retira la sartén del fuego y espolvorea el cilantro fresco picado sobre el Lomo Saltado.<br>
- Sirve caliente, acompañado de papas fritas caseras o arroz blanco cocido. ¡Disfruta de este delicioso plato peruano-chino! <br><br>
""".trimIndent()
            ),
            Receta(
                   "Ensalada César",
                     arrayListOf("Lechuga", "Pollo", "Queso"),
                     """
<h1>Receta de Ensalada César con Pollo y Queso</h1><br>

<h2>Ingredientes para la Ensalada:</h2><br>
- 1 lechuga romana, lavada y picada<br>
- 2 pechugas de pollo, cocidas y cortadas en tiras o dados<br>
- 1 taza de crutones (puedes comprarlos o hacerlos caseros)<br>
- 1/2 taza de queso parmesano rallado<br><br>

<h2>Ingredientes para el Aderezo César:</h2><br>
- 1/2 taza de mayonesa<br>
- 2 cucharadas de queso parmesano rallado<br>
- 2 cucharaditas de mostaza Dijon<br>
- 2 cucharaditas de salsa Worcestershire<br>
- 1 diente de ajo, picado finamente<br>
- 2 cucharadas de jugo de limón<br>
- Sal y pimienta negra molida al gusto<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Preparar los ingredientes:</h3><br>
- Cocina las pechugas de pollo hasta que estén bien cocidas, luego córtalas en tiras o dados.<br>
- Corta pan en cubos pequeños y mézclalos con un poco de aceite de oliva, ajo en polvo y sal. Tuesta en el horno precalentado a 180°C (350°F) durante 10-15 minutos o hasta que estén dorados y crujientes. Déjalos enfriar.<br><br>

<h3>2. Preparar el aderezo César:</h3><br>
- En un tazón pequeño, mezcla la mayonesa, el queso parmesano rallado, la mostaza Dijon, la salsa Worcestershire, el ajo picado, el jugo de limón, la sal y la pimienta. Mezcla bien hasta que todos los ingredientes estén combinados. Prueba y ajusta el condimento si es necesario.<br><br>

<h3>3. Montar la ensalada:</h3><br>
- En un tazón grande, mezcla la lechuga picada con los crutones, el pollo cocido y las tiras de queso parmesano.<br><br>

<h3>4. Aderezar la ensalada:</h3><br>
- Vierte el aderezo César sobre la ensalada y mezcla bien para asegurarte de que todas las hojas de lechuga estén cubiertas uniformemente.<br><br>

<h3>5. Servir:</h3><br>
- Espolvorea la ensalada con queso parmesano rallado adicional si lo deseas.<br>
- Sirve la Ensalada César con Pollo y Queso como plato principal para una comida ligera y deliciosa. ¡Disfruta de esta variación sabrosa de la clásica ensalada César! <br><br>
""".trimIndent()
            ),
            Receta(
                "Arroz con leche",
                arrayListOf("Arroz", "Leche"),
                """
<h1>Receta de Arroz con Leche</h1><br>

<h2>Ingredientes:</h2><br>
- 1 taza de arroz de grano corto o mediano<br>
- 4 tazas de leche entera<br>
- 1 rama de canela<br>
- 1 cáscara de limón<br>
- 1/2 taza de azúcar (o al gusto)<br>
- 1 cucharadita de esencia de vainilla (opcional)<br>
- Canela en polvo para espolvorear (opcional)<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Cocinar el arroz:</h3><br>
- Enjuaga el arroz en agua fría para eliminar el exceso de almidón.<br>
- En una olla grande, lleva a ebullición 2 tazas de agua. Agrega el arroz y cocina a fuego medio hasta que esté tierno, pero aún un poco firme, alrededor de 15 minutos. Escurre cualquier exceso de agua.<br><br>

<h3>2. Cocinar con la leche:</h3><br>
- En la misma olla, agrega la leche, la rama de canela y la cáscara de limón. Lleva la mezcla a ebullición a fuego medio-alto, luego reduce el fuego a medio-bajo y cocina a fuego lento durante unos 20-25 minutos, revolviendo ocasionalmente para evitar que el arroz se pegue al fondo de la olla.<br><br>

<h3>3. Añadir el azúcar y la vainilla:</h3><br>
- Una vez que el arroz esté suave y la mezcla tenga una consistencia cremosa, agrega el azúcar y la esencia de vainilla (si estás usando). Revuelve bien para combinar y cocina por otros 5 minutos.<br><br>

<h3>4. Enfriar y servir:</h3><br>
- Retira la rama de canela y la cáscara de limón de la olla. Transfiere el Arroz con Leche a cuencos individuales o un tazón grande.<br>
- Deja enfriar a temperatura ambiente o enfría en el refrigerador si prefieres servirlo frío.<br>
- Antes de servir, espolvorea con canela en polvo si lo deseas. ¡Disfruta de este delicioso postre tradicional! <br><br>
""".trimIndent()
            ),
            Receta(
                "Pollo frito con papas",
                arrayListOf("Pollo", "Papa", "Leche", "Huevo","Harina"),
                """
<h1>Receta de Pollo Frito con Papas</h1><br>

<h2>Ingredientes para el Pollo Frito:</h2><br>
- 1 pollo entero, cortado en piezas o muslos y pechugas<br>
- 1 taza de suero de leche (buttermilk) o leche<br>
- 2 tazas de harina de trigo<br>
- 1 cucharadita de sal<br>
- 1 cucharadita de pimienta negra molida<br>
- 1 cucharadita de ajo en polvo<br>
- 1 cucharadita de paprika (pimentón dulce)<br>
- Aceite vegetal para freír<br><br>

<h2>Ingredientes para las Papas Fritas:</h2><br>
- 4 papas grandes, peladas y cortadas en bastones<br>
- 2 cucharadas de aceite de oliva<br>
- Sal y pimienta al gusto<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Marinado del Pollo:</h3><br>
- Remoja las piezas de pollo en suero de leche o leche durante al menos 30 minutos. Esto ayudará a ablandar el pollo y agregar sabor.<br><br>

<h3>2. Preparar las Papas Fritas:</h3><br>
- Precalienta el horno a 220°C (425°F). En un tazón grande, mezcla las papas cortadas con aceite de oliva, sal y pimienta.<br>
- Extiende las papas en una bandeja para hornear en una sola capa y hornea en el horno precalentado durante 30-35 minutos, o hasta que estén doradas y crujientes, volteándolas ocasionalmente para que se cocinen de manera uniforme.<br>
- Una vez listas, retira las papas del horno y mantenlas calientes.<br><br>

<h3>3. Preparar el Pollo:</h3><br>
- En un plato grande, mezcla la harina de trigo con la sal, la pimienta negra, el ajo en polvo y la paprika.<br>
- Retira las piezas de pollo del suero de leche y escúrrelas ligeramente.<br>
- Pasa cada pieza de pollo por la mezcla de harina, asegurándote de cubrirlas completamente.<br><br>

<h3>4. Freír el Pollo:</h3><br>
- En una sartén grande o freidora, calienta suficiente aceite vegetal a fuego medio-alto para sumergir las piezas de pollo.<br>
- Cuando el aceite esté caliente, agrega las piezas de pollo, asegurándote de no sobrecargar la sartén. Fríe por ambos lados hasta que estén doradas y cocidas por completo, aproximadamente 12-15 minutos por lado, dependiendo del tamaño de las piezas.<br>
- Retira el pollo frito del aceite y colócalo sobre papel absorbente para eliminar el exceso de grasa.<br><br>

<h3>5. Servir:</h3><br>
- Sirve el Pollo Frito con Papas calientes, acompañado de una ensalada fresca o tus salsas favoritas para mojar. ¡Disfruta de este clásico plato casero! <br><br>
""".trimIndent()
            ),
            Receta(
                "Tacos de carne",
                arrayListOf("Carne", "Cebolla", "Tomate"),
                """
<h1>Receta de Tacos de Carne</h1><br>

<h2>Ingredientes:</h2><br>
- 500 g de carne de res molida (puedes usar también carne de pollo, cerdo o pavo)<br>
- 1 cebolla grande, picada<br>
- 2 dientes de ajo, picados finamente<br>
- 1 pimiento verde, cortado en tiras delgadas (opcional)<br>
- 1 tomate grande, picado<br>
- 2 cucharadas de aceite de oliva<br>
- 1 cucharadita de comino molido<br>
- 1 cucharadita de chile en polvo (ajuste según tu preferencia de picante)<br>
- 1 cucharadita de pimentón dulce<br>
- Sal y pimienta al gusto<br>
- 12 tortillas de maíz o harina<br>
- Ingredientes opcionales para servir: queso rallado, lechuga picada, tomate en cubitos, crema agria, salsa de tomate, salsa picante, cilantro fresco picado, rodajas de limón<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Preparar el relleno de carne:</h3><br>
- En una sartén grande, calienta el aceite de oliva a fuego medio-alto. Agrega la cebolla picada y el ajo, y cocina hasta que estén transparentes y fragantes.<br>
- Agrega la carne molida y cocina hasta que esté bien dorada y cocida por completo.<br>
- Agrega el pimiento verde (si estás usando), el tomate picado, el comino, el chile en polvo, el pimentón dulce, la sal y la pimienta. Cocina por unos minutos más hasta que los vegetales estén tiernos y los sabores se mezclen.<br><br>

<h3>2. Calentar las tortillas:</h3><br>
- Calienta las tortillas de maíz o harina en una sartén caliente o en el microondas hasta que estén calientes y flexibles.<br><br>

<h3>3. Armar los tacos:</h3><br>
- Coloca una porción de la mezcla de carne en el centro de cada tortilla caliente.<br>
- Agrega tus ingredientes opcionales favoritos, como queso rallado, lechuga picada, tomate en cubitos, crema agria, salsa de tomate, salsa picante y cilantro fresco.<br>
- Exprime un poco de jugo de limón por encima si lo deseas.<br><br>

<h3>4. Servir:</h3><br>
- Sirve los tacos calientes y listos para comer. ¡Disfruta de estos deliciosos tacos de carne con tus acompañamientos favoritos! <br><br>
""".trimIndent()
            ),
            Receta(
                "Pollo coreano con arroz",
                arrayListOf("Pollo", "Arroz", "Cebolla"),
                """
<h1>Receta de Pollo Coreano con Arroz (Dak Bulgogi)</h1><br>

<h2>Ingredientes para el Pollo Bulgogi:</h2><br>
- 500 g de pechugas de pollo, cortadas en tiras delgadas<br>
- 4 cucharadas de salsa de soja<br>
- 2 cucharadas de miel o azúcar<br>
- 2 cucharadas de aceite de sésamo<br>
- 2 dientes de ajo, picados<br>
- 1 cucharada de jengibre fresco, rallado<br>
- 2 cucharadas de semillas de sésamo tostado<br>
- 2 cebollas verdes, cortadas en rodajas finas (parte blanca y verde por separado)<br>
- 1 cucharada de aceite vegetal<br>
- Sal y pimienta al gusto<br><br>

<h2>Ingredientes para el Arroz:</h2><br>
- 1 taza de arroz blanco<br>
- 2 tazas de agua<br>
- Una pizca de sal<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Preparar el Pollo Bulgogi:</h3><br>
- En un tazón grande, mezcla la salsa de soja, la miel (o azúcar), el aceite de sésamo, el ajo picado, el jengibre rallado y las semillas de sésamo tostado.<br>
- Agrega las tiras de pollo al tazón y mezcla bien para asegurarte de que estén completamente cubiertas con la marinada. Deja marinar en el refrigerador durante al menos 30 minutos, o idealmente durante unas horas para que absorba bien los sabores.<br><br>

<h3>2. Cocinar el Arroz:</h3><br>
- Enjuaga el arroz bajo agua fría hasta que el agua salga clara, luego escúrrelo bien.<br>
- En una olla, agrega el arroz, el agua y una pizca de sal. Lleva a ebullición a fuego alto.<br>
- Reduce el fuego a bajo, tapa la olla y cocina durante unos 15-20 minutos, o hasta que el arroz esté tierno y el agua se haya absorbido por completo. Retira del fuego y deja reposar durante 5 minutos antes de destapar.<br><br>

<h3>3. Cocinar el Pollo Bulgogi:</h3><br>
- Calienta una sartén grande o wok a fuego medio-alto. Agrega una cucharada de aceite vegetal.<br>
- Agrega las cebollas verdes (parte blanca) a la sartén y saltea durante unos minutos hasta que estén tiernas.<br>
- Agrega las tiras de pollo marinadas (junto con la marinada) a la sartén y cocina hasta que estén doradas y cocidas por completo, aproximadamente 5-7 minutos.<br><br>

<h3>4. Servir:</h3><br>
- Sirve el Pollo Bulgogi caliente sobre arroz blanco, espolvorea las cebollas verdes (parte verde) por encima como adorno.<br>
- Puedes acompañar con kimchi u otros platos coreanos tradicionales si lo deseas.<br><br>

¡Disfruta de este delicioso y sabroso Pollo Coreano con Arroz (Dak Bulgogi)!<br><br>
""".trimIndent()
            ),
            Receta(
                "Sándwich de Queso",
                arrayListOf("Queso"),
                """
<h1>Receta de Sándwich de Queso</h1><br>

<h2>Ingredientes:</h2><br>
- 4 rebanadas de pan de tu elección (pan de molde, pan de sándwich, baguette, etc.)<br>
- 100 g de queso cheddar, suizo, mozzarella o tu queso favorito, en lonchas<br>
- 2 cucharadas de mantequilla, a temperatura ambiente<br>
- Opcional: rodajas de tomate, hojas de lechuga, jamón, tocino, aguacate, mostaza, mayonesa, etc.<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Untar el pan con mantequilla:</h3><br>
- Extiende una fina capa de mantequilla en un lado de cada rebanada de pan. Esto ayudará a que el pan se dore y tenga un sabor delicioso al tostarlo.<br><br>

<h3>2. Armar el sándwich:</h3><br>
- Coloca las lonchas de queso sobre la mitad de las rebanadas de pan (el lado sin mantequilla). Si estás agregando otros ingredientes como rodajas de tomate, hojas de lechuga, jamón, tocino o aguacate, añádelos encima del queso.<br>
- Cubre con las otras rebanadas de pan, con el lado untado de mantequilla hacia afuera.<br><br>

<h3>3. Cocinar el sándwich:</h3><br>
- Calienta una sartén a fuego medio. Coloca los sándwiches en la sartén caliente y cocina durante unos 2-3 minutos por cada lado, o hasta que estén dorados y crujientes, y el queso esté derretido en el interior.<br>
- También puedes usar una sandwichera o una parrilla eléctrica para cocinar los sándwiches.<br><br>

<h3>4. Servir:</h3><br>
- Retira los sándwiches de la sartén y sírvelos calientes.<br>
- Corta los sándwiches en diagonal si lo deseas y disfrútalos como un almuerzo rápido, merienda o cena ligera.<br><br>

¡Disfruta de este sencillo y delicioso Sándwich de Queso, y siéntete libre de personalizarlo con tus ingredientes favoritos! <br><br>
""".trimIndent()
            ),
            Receta(
                   "Majadito de carne"
                     , arrayListOf("Carne", "Arroz", "Cebolla", "Tomate"),
                        """
<h1>Receta de Majadito de Carne</h1><br>

<h2>Ingredientes:</h2><br>
- 1 taza de arroz<br>
- 250 g de carne de res (puede ser carne molida o cortada en trozos pequeños)<br>
- 1 cebolla grande, picada<br>
- 2 tomates medianos, picados<br>
- 2 dientes de ajo, picados finamente<br>
- 1 pimiento verde, picado<br>
- 2 cucharadas de aceite vegetal<br>
- 1 cucharadita de comino molido<br>
- 1 cucharadita de páprika (pimentón dulce)<br>
- 1/2 taza de arvejas (guisantes) cocidos (opcional)<br>
- 1/2 taza de zanahoria rallada (opcional)<br>
- Sal y pimienta al gusto<br>
- Perejil fresco picado para decorar (opcional)<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Cocinar el arroz:</h3><br>
- En una olla grande, cocina el arroz siguiendo las instrucciones del paquete. Reserva caliente.<br><br>

<h3>2. Preparar la carne:</h3><br>
- En una sartén grande o una olla, calienta el aceite vegetal a fuego medio.<br>
- Agrega la cebolla picada y cocina hasta que esté transparente.<br>
- Añade el ajo picado y cocina por un minuto más.<br>
- Agrega la carne de res y cocina hasta que esté dorada y cocida por completo.<br>
- Incorpora los tomates picados, el pimiento verde, el comino molido, la páprika, las arvejas cocidas y la zanahoria rallada (si estás usando). Cocina por unos minutos más, hasta que los vegetales estén tiernos y los sabores se mezclen.<br>
- Sazona con sal y pimienta al gusto.<br><br>

<h3>3. Mezclar el arroz y la carne:</h3><br>
- Agrega el arroz cocido a la mezcla de carne en la sartén u olla. Mezcla bien para combinar todos los ingredientes.<br>
- Cocina por unos minutos más, revolviendo ocasionalmente, para que los sabores se integren y el arroz se caliente completamente.<br><br>

<h3>4. Servir:</h3><br>
- Sirve el Majadito de Carne caliente, decorado con perejil fresco picado si lo deseas.<br>
- Disfruta este plato tradicional boliviano como plato principal o como parte de una comida abundante. ¡Buen provecho!<br><br>
""".trimIndent()
            ),
            Receta(
                "Galletas"
                , arrayListOf("Harina", "Manteca", "Huevo"),
                """
<h1>Receta de Galletas</h1><br>

<h2>Ingredientes:</h2><br>
- 2 tazas de harina de trigo<br>
- 1/2 cucharadita de bicarbonato de sodio<br>
- 1/2 cucharadita de sal<br>
- 1 taza de manteca (a temperatura ambiente)<br>
- 1 taza de azúcar<br>
- 1 huevo grande<br>
- 1 cucharadita de extracto de vainilla<br>
- Opcional: chispas de chocolate, nueces picadas, pasas, etc.<br><br>

<h2>Instrucciones:</h2><br>

<h3>1. Precalentar el horno:</h3><br>
- Precalienta tu horno a 180°C (350°F). Prepara una bandeja para hornear engrasándola ligeramente o forrándola con papel pergamino.<br><br>

<h3>2. Mezclar los ingredientes secos:</h3><br>
- En un tazón mediano, tamiza la harina de trigo, el bicarbonato de sodio y la sal. Mezcla bien y reserva.<br><br>

<h3>3. Batir la manteca y el azúcar:</h3><br>
- En otro tazón grande, bate la manteca y el azúcar hasta que estén suaves y cremosos.<br><br>

<h3>4. Incorporar el huevo y la vainilla:</h3><br>
- Agrega el huevo y la vainilla al tazón de la manteca y el azúcar. Continúa batiendo hasta que estén bien combinados.<br><br>

<h3>5. Mezclar los ingredientes secos y formar la masa:</h3><br>
- Agrega gradualmente los ingredientes secos al tazón de la mezcla de manteca, azúcar, huevo y vainilla. Mezcla hasta que se forme una masa suave y homogénea.<br>
- Si estás agregando ingredientes adicionales como chispas de chocolate o nueces, incorpóralos en este punto y mezcla hasta que estén distribuidos de manera uniforme en la masa.<br><br>

<h3>6. Formar las galletas:</h3><br>
- Con las manos limpias, forma pequeñas bolitas de masa del tamaño de una nuez y colócalas en la bandeja para hornear preparada, dejando espacio entre cada galleta para que se expandan durante la cocción.<br><br>

<h3>7. Hornear las galletas:</h3><br>
- Hornea las galletas en el horno precalentado durante 10-12 minutos, o hasta que estén ligeramente doradas en los bordes.<br>
- Retira del horno y deja que las galletas se enfríen en la bandeja durante unos minutos antes de transferirlas a una rej
""".trimIndent()
            )
        )
    }
}