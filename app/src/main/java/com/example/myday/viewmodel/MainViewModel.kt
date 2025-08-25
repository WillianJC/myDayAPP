package  com.example.myday.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myday.model.EstadoRepository

class MainViewModel : ViewModel() {
    private val repository = EstadoRepository()
    val estado: LiveData<String> = repository.estado
    fun actualizarEstado(etapa: String) {
        repository.actualizarEstado(etapa)
    }
}