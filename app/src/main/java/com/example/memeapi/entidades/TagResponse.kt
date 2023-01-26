package com.example.memeapi.entidades

import com.google.gson.annotations.SerializedName

data class TagResponse(
    @SerializedName("idTag") var idTag: Int,
    @SerializedName("texto") var texto: String
)