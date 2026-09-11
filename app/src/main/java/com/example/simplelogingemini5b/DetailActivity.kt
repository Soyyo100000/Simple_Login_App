package com.example.simplelogingemini5b

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplelogingemini5b.databinding.ActivityDetailBinding
import com.example.simplelogingemini5b.models.Curso
import com.example.simplelogingemini5b.models.Usuario

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val curso = intent.getParcelableExtra<Curso>("EXTRA_CURSO")
        val usuario = intent.getParcelableExtra<Usuario>("EXTRA_USER")

        curso?.let {
            binding.tvDetailTitulo.text = it.titulo
            binding.tvDetailCategoria.text = it.categoria
            binding.tvDetailInfo.text = "${it.nivel} • ${it.duracion}"
            binding.tvDetailDescripcion.text = it.descripcion
            binding.ivDetailIcon.setImageResource(it.imagenResId)
        }

        binding.btnRegresar.setOnClickListener {
            finish()
        }
    }
}