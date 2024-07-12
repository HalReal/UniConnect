package com.example.appointmentsappuam.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Citas(
    @PrimaryKey
    val id: String ,
    val docente: String,
    val fecha: String,
    val motivo: String,
    val hora: String
)
{
    constructor() : this("","","","","")
}