package com.example.myday.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
class EstadoRepository {
    private val _estado = MutableLiveData<String>()
    val estado: LiveData<String> get() = _estado
    fun actualizarEstado(etapa: String) {
        _estado.value = "Etapa actual: $etapa"
    }
}