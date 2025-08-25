package com.example.myday.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.example.myday.databinding.ActivityMainBinding
import com.example.myday.viewmodel.MainViewModel
import com.example.myday.R


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.estado.observe(this) {
            binding.tvEstado.text = it
        }
        viewModel.actualizarEstado("onCreate")
        // Eventos UI
        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Este es un Toast", Toast.LENGTH_SHORT).show()
        }
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Este es un Snackbar",
                Snackbar.LENGTH_LONG).show()
        }
        binding.btnDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Confirmación")
                .setMessage("¿Quieres continuar con este recordatorio?")
                .setPositiveButton("Sí") { _, _ ->
                    Toast.makeText(this, "Confirmado", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No", null)
                .show()
            true
        }
        // Navegación con BottomNavigation
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Snackbar.make(binding.root, "Estás en Inicio",
                        Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_recordatorios -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
    override fun onStart() {
        super.onStart()
        viewModel.actualizarEstado("onStart")
    }
    override fun onResume() {
        super.onResume()
        viewModel.actualizarEstado("onResume")
    }
    override fun onPause() {
        super.onPause()
        viewModel.actualizarEstado("onPause")
    }
    override fun onStop() {
        super.onStop()
        viewModel.actualizarEstado("onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        viewModel.actualizarEstado("onDestroy")
    }
}