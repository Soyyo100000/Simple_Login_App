package com.example.simplelogingemini5b.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Curso(
    val titulo: String,
    val descripcion: String,
    val nivel: String,
    val duracion: String,
    val categoria: String,
    val imagenResId: Int
) : Parcelable