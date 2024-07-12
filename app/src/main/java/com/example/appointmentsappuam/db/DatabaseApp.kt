package com.example.appointmentsappuam.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appointmentsappuam.dao.CitasDAO
import com.example.appointmentsappuam.entity.Citas

@Database(
    entities = [Citas::class],
    version=1
)
abstract class DatabaseApp : RoomDatabase()  {

    abstract fun agendaDAO(): CitasDAO

    companion object {
        @Volatile
        private var INSTANCE : DatabaseApp?=null
        fun getDataBase(context : Context) : DatabaseApp {
            return INSTANCE ?: synchronized (this) {
                val instance = Room.databaseBuilder(
                    context,
                    DatabaseApp::class.java,
                    "CitasDb").build()
                INSTANCE= instance
                instance
            }
        }

    }

}