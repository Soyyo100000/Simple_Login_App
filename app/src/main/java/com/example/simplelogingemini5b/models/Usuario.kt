package com.example.simplelogingemini5b.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(
    val nombre: String,
    val login: String,
    val pass: String,
    val email: String
) : Parcelable