package com.example.coctaildb.network

import com.google.gson.annotations.SerializedName

data class CocktailsList(
    @SerializedName("drinks")
    val list: List<Cocktail>
)

data class Cocktail (
    @SerializedName("idDrink")
    val id: String,
    @SerializedName("strDrinkThumb")
    val drinkImg: String,
    @SerializedName("strDrink")
    val drinkTitle: String
)
