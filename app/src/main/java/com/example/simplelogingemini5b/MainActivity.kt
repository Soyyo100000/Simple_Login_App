package com.example.simplelogingemini5b

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplelogingemini5b.adapters.CursoAdapter
import com.example.simplelogingemini5b.databinding.ActivityMainBinding
import com.example.simplelogingemini5b.models.Curso
import com.example.simplelogingemini5b.models.Usuario

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var usuarioLogueado: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usuarioLogueado = intent.getParcelableExtra("EXTRA_USER")
        
        setupRecyclerView()
        setupListeners()
    }

    private fun setupRecyclerView() {
        val listaCursos = listOf(
            Curso(
                "Desarrollo Web Fullstack",
                "Domina el frontend y backend con las tecnologías más modernas como React y Node.js.",
                "Principiante",
                "12 hrs",
                "Web",
                R.drawable.ic_user_placeholder // Usando el placeholder por ahora
            ),
            Curso(
                "Mobile App con Kotlin",
                "Crea aplicaciones nativas para Android usando Kotlin y las mejores prácticas de Google.",
                "Intermedio",
                "20 hrs",
                "Mobile",
                R.drawable.ic_user_placeholder
            ),
            Curso(
                "Diseño UX/UI",
                "Aprende a diseñar interfaces intuitivas y experiencias de usuario memorables con Figma.",
                "Principiante",
                "10 hrs",
                "Diseño",
                R.drawable.ic_user_placeholder
            )
        )

        binding.rvCursos.layoutManager = LinearLayoutManager(this)
        binding.rvCursos.adapter = CursoAdapter(listaCursos) { curso ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("EXTRA_CURSO", curso)
                putExtra("EXTRA_USER", usuarioLogueado)
            }
            startActivity(intent)
        }
    }

    private fun setupListeners() {
        binding.ivClose.setOnClickListener {
            finish()
        }
    }
}