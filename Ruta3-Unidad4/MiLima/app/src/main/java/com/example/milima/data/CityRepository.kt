package com.example.milima.data

import com.example.milima.R
import com.example.milima.model.Place

object CityRepository {

    val places = listOf(

        // =========================
        // ☕ CAFETERÍAS
        // =========================

        Place(
            id = 1,
            name = "Café de Lima",
            category = "Cafeterías",
            description = "Un lugar para disfrutar de café y postres.",
            imageRes = R.drawable.cafe_de_lima
        ),

        Place(
            id = 2,
            name = "Puku Puku",
            category = "Cafeterías",
            description = "Cafetería peruana con café de especialidad.",
            imageRes = R.drawable.puku_puku
        ),

        Place(
            id = 3,
            name = "Café Verde",
            category = "Cafeterías",
            description = "Un espacio tranquilo para disfrutar de bebidas y postres.",
            imageRes = R.drawable.cafe_verde
        ),

        Place(
            id = 4,
            name = "Starbucks Lima",
            category = "Cafeterías",
            description = "Una opción conocida para disfrutar de café y bebidas en diferentes puntos de Lima.",
            imageRes = R.drawable.starbucks_lima
        ),


        // =========================
        // 🍽️ RESTAURANTES
        // =========================

        Place(
            id = 5,
            name = "Central",
            category = "Restaurantes",
            description = "Restaurante de cocina peruana contemporánea.",
            imageRes = R.drawable.central
        ),

        Place(
            id = 6,
            name = "Isolina",
            category = "Restaurantes",
            description = "Restaurante conocido por sus platos tradicionales peruanos.",
            imageRes = R.drawable.isolina
        ),

        Place(
            id = 7,
            name = "Panchita",
            category = "Restaurantes",
            description = "Restaurante especializado en comida tradicional peruana.",
            imageRes = R.drawable.panchita
        ),

        Place(
            id = 8,
            name = "Maido",
            category = "Restaurantes",
            description = "Restaurante que combina técnicas japonesas con ingredientes peruanos.",
            imageRes = R.drawable.maido
        ),


        // =========================
        // 🌳 PARQUES
        // =========================

        Place(
            id = 9,
            name = "Parque de la Reserva",
            category = "Parques",
            description = "Un parque conocido por el Circuito Mágico del Agua.",
            imageRes = R.drawable.parque_reserva
        ),

        Place(
            id = 10,
            name = "Parque Kennedy",
            category = "Parques",
            description = "Uno de los espacios públicos más conocidos de Miraflores.",
            imageRes = R.drawable.parque_kennedy
        ),

        Place(
            id = 11,
            name = "Parque El Olivar",
            category = "Parques",
            description = "Un histórico parque rodeado de antiguos olivos.",
            imageRes = R.drawable.parque_olivar
        ),

        Place(
            id = 12,
            name = "Parque Mariscal Castilla",
            category = "Parques",
            description = "Un amplio espacio verde para caminar, descansar y disfrutar del aire libre.",
            imageRes = R.drawable.parque_mariscal_castilla
        ),


        // =========================
        // 🛍️ CENTROS COMERCIALES
        // =========================

        Place(
            id = 13,
            name = "Larcomar",
            category = "Centros comerciales",
            description = "Centro comercial ubicado frente al océano Pacífico.",
            imageRes = R.drawable.larcomar
        ),

        Place(
            id = 14,
            name = "Jockey Plaza",
            category = "Centros comerciales",
            description = "Uno de los centros comerciales más grandes de Lima.",
            imageRes = R.drawable.jockey_plaza
        ),

        Place(
            id = 15,
            name = "Real Plaza Salaverry",
            category = "Centros comerciales",
            description = "Centro comercial con tiendas, restaurantes y entretenimiento.",
            imageRes = R.drawable.real_plaza_salaverry
        ),

        Place(
            id = 16,
            name = "Plaza San Miguel",
            category = "Centros comerciales",
            description = "Centro comercial con tiendas, restaurantes, entretenimiento y servicios.",
            imageRes = R.drawable.plaza_san_miguel
        ),


        // =========================
        // 🏛️ CULTURA
        // =========================

        Place(
            id = 17,
            name = "Museo Larco",
            category = "Cultura",
            description = "Museo dedicado al arte y la historia del antiguo Perú.",
            imageRes = R.drawable.museo_larco
        ),

        Place(
            id = 18,
            name = "Museo de Arte de Lima",
            category = "Cultura",
            description = "Museo que conserva importantes colecciones de arte peruano.",
            imageRes = R.drawable.mali
        ),

        Place(
            id = 19,
            name = "Circuito Mágico del Agua",
            category = "Cultura",
            description = "Espacio turístico con fuentes de agua y espectáculos de luces.",
            imageRes = R.drawable.circuito_agua
        ),

        Place(
            id = 20,
            name = "Huaca Pucllana",
            category = "Cultura",
            description = "Complejo arqueológico prehispánico ubicado en el distrito de Miraflores.",
            imageRes = R.drawable.huaca_pucllana
        )
    )
}