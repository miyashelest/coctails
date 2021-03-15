package com.example.coctaildb.network

import com.google.gson.annotations.SerializedName

data class FilterList(
    @SerializedName("drinks")
    val list: List<Filter>
)

data class Filter(
    @SerializedName("strCategory")
    val filter: String
)