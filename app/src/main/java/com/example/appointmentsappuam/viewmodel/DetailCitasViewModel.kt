package com.example.appointmentsappuam.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appointmentsappuam.db.toCitasDomain
import com.example.appointmentsappuam.entity.Citas
import com.example.appointmentsappuam.repository.RepositoryCitas
import com.example.appointmentsappuam.repository.RepositoryDetailCitas
import kotlinx.coroutines.launch

class DetailCitasViewModel(context: Context, idCita : String): ViewModel() {

    val repository = RepositoryDetailCitas(context)

    val repositoryCitas = RepositoryCitas(context)

    var citasMutable by mutableStateOf(Citas())
        private set

    var mstate by mutableStateOf(State())
        private set

    fun onDocente(docente : String) {
        citasMutable = citasMutable.copy(docente = docente)
    }

    fun onFecha(fecha : String) {
        citasMutable = citasMutable.copy(fecha = fecha)
    }

    fun onMotivo(motivo : String) {
        citasMutable = citasMutable.copy(motivo = motivo)
    }

    fun onHora(hora:String) {
        citasMutable = citasMutable.copy(hora = hora)
    }

    fun onSave(idCita : String) {
        //insert & update
        if (idCita.equals("-1")) {
            viewModelScope.launch {
                val response = repositoryCitas.createCita(citasMutable.toCitasDomain())
                if (response.isSuccess) {
                    mstate = mstate.copy(error = false,mensaje="Insercion con Exito")
                }
                else {
                    mstate = mstate.copy(error = true, mensaje = "Error al insertar " +
                            "${response.exceptionOrNull()?.message}")
                }

            }
        }
    }

    init {
        viewModelScope.launch {
            if (idCita == "-1") {
                citasMutable = Citas()
            }
            else {
                citasMutable = repository.getDetail(idCita)
            }
        }
    }

    data class State(
        val mensaje : String? = null,
        var error : Boolean = false
    )

    fun resetDato() {
        mstate = mstate.copy(error = false, mensaje = null)
    }


}

class DetailCitasViewModelFactory(private val context: Context,
                                   private val idCitas : String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailCitasViewModel(context,idCitas) as T
    }
}