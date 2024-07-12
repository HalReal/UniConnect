package com.example.appointmentsappuam.db

import com.example.appointmentsappuam.entity.Citas as CitasDb
import com.example.appointmentsappuam.model.CitasItem as CitasDomain

fun CitasDb.toCitasDomain() : CitasDomain = CitasDomain(
    fecha,id,motivo,docente,hora
)

fun CitasDomain.toCitasDB() : CitasDb = CitasDb(
    id,hora,fecha,motivo,docente
)