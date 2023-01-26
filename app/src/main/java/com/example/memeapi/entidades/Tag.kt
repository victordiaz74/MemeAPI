package com.example.memeapi.entidades

import com.google.gson.annotations.SerializedName

data class Tag (
    @SerializedName("tagNombre")var tagNombre: String
)