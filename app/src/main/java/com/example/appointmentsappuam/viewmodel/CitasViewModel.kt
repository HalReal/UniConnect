package com.example.appointmentsappuam.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appointmentsappuam.db.toCitasDB
import com.example.appointmentsappuam.model.ListCitas
import com.example.appointmentsappuam.repository.RepositoryCitas
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CitasViewModel(context : Context, idUsuario : String) : ViewModel() {

    private val mstate = MutableStateFlow<_state>(_state())
    val _mstate : StateFlow<_state> = mstate

    val repository = RepositoryCitas(context)


    data class _state (
        val loading : Boolean = false,
        val listData : ListCitas = ListCitas()
    )

    init {
        viewModelScope.launch {
            mstate.update { it.copy(loading = true) }
            val response = repository.getAll(idUsuario)
            if (response.isSuccess) {
                mstate.update { it.copy(listData = response.getOrNull()!!) }
                repository.updateAgenda(response.getOrNull()!!.map { it.toCitasDB() })
            }
            mstate.update { it.copy(loading = false) }
        }
    }
}

class CitasViewModelFactory(private val context: Context, private val idUsuario : String) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CitasViewModel(context,idUsuario) as T
    }
}
