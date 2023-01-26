package com.example.memeapi.entidades

import com.google.gson.annotations.SerializedName

data class MemeResponse(
    @SerializedName("idMeme") var idMeme: Int,
    @SerializedName("nombre") var nombreMeme: String,
    @SerializedName("titInf") var txtInf: String,
    @SerializedName("titSup") var txtSup: String,
    @SerializedName("url") var url: String
)