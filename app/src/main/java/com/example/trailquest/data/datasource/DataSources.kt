package com.example.trailquest.data.datasource

import com.example.trailquest.R

object DataSources {
    val types = listOf(
        "Restaurants",
        "Historical Sites",
        "Art Galleries",
        "Shopping",
        "Landmarks",
        "Cultural Centers",
        "Beaches",
        "Zoos",
        "Nature Landmarks",
        "Amusement Parks",
        "Religious Sites",
        "Castles",
        "Breweries",
        "Hiking Trails",
        "Events",
        "Cruises",
        "Nightlife"
    )

    val typesIcons = hashMapOf(
        "Restaurants" to R.drawable.rounded_restaurant_24,
        "Historical Sites" to R.drawable.historical_site_icon,
        "Art Galleries" to R.drawable.rounded_palette_24,
        "Shopping" to R.drawable.rounded_shopping_cart_24,
        "Landmarks" to R.drawable.rounded_flag_2_24,
        "Cultural Centers" to R.drawable.rounded_theater_comedy_24,
        "Beaches" to R.drawable.rounded_beach_access_24,
        "Zoos" to R.drawable.zoos_icon,
        "Nature Landmarks" to R.drawable.rounded_nature_24,
        "Amusement Parks" to R.drawable.amusement_park_icon,
        "Religious Sites" to R.drawable.religious_sites_icon,
        "Castles" to R.drawable.rounded_castle_24,
        "Breweries" to R.drawable.breweries_icon,
        "Hiking Trails" to R.drawable.rounded_hiking_24,
        "Events" to R.drawable.rounded_event_24,
        "Cruises" to R.drawable.rounded_directions_boat_24,
        "Nightlife" to R.drawable.rounded_nightlife_24
    )

    val countries = listOf(
        "Albania",
        "Andorra",
        "Armenia",
        "Austria",
        "Azerbaijan",
        "Belarus",
        "Belgium",
        "Bosnia and Herzegovina",
        "Bulgaria",
        "Croatia",
        "Cyprus",
        "Czechia",
        "Denmark",
        "Estonia",
        "Finland",
        "France",
        "Georgia",
        "Germany",
        "Greece",
        "Hungary",
        "Iceland",
        "Ireland",
        "Italy",
        "Kazakhstan",
        "Kosovo",
        "Latvia",
        "Liechtenstein",
        "Lithuania",
        "Luxembourg",
        "Malta",
        "Moldova",
        "Monaco",
        "Montenegro",
        "Netherlands",
        "North Macedonia",
        "Norway",
        "Poland",
        "Portugal",
        "Romania",
        "Russia",
        "San Marino",
        "Serbia",
        "Slovakia",
        "Slovenia",
        "Spain",
        "Sweden",
        "Switzerland",
        "Turkey",
        "Ukraine",
        "United Kingdom",
        "Vatican City"
    )

    val navigationRailItems = hashMapOf(
        "Back" to R.drawable.rounded_arrow_back_24,
        "Home" to R.drawable.rounded_home_24,
    )


    val levelTitles = hashMapOf(
        1 to "Newbie",
        2 to "Rookie",
        3 to "Explorer",
        4 to "Journeyman",
        5 to "Traveler",
        6 to "Adventurer",
        7 to "Seasoned Adventurer",
    )
}