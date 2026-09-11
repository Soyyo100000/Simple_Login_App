package com.example.simplelogingemini5b

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplelogingemini5b.databinding.ActivityLoginBinding
import com.example.simplelogingemini5b.models.Usuario

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // Lista de usuarios simulada para el examen
    private val usuarios = listOf(
        Usuario("Juan Perez", "admin", "1234", "admin@example.com"),
        Usuario("Maria Lopez", "user", "pass", "user@example.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty()) {
                binding.etUsername.error = getString(R.string.empty_fields)
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.etPassword.error = getString(R.string.empty_fields)
                return@setOnClickListener
            }

            val usuario = usuarios.find { it.login == username && it.pass == password }

            if (usuario != null) {
                Toast.makeText(this, getString(R.string.correct_credentials), Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("EXTRA_USER", usuario)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, getString(R.string.invalid_credentials), Toast.LENGTH_SHORT).show()
            }
        }

        binding.ivFacebook.setOnClickListener {
            Toast.makeText(this, "Facebook Login", Toast.LENGTH_SHORT).show()
        }

        binding.ivLinkedIn.setOnClickListener {
            Toast.makeText(this, "LinkedIn Login", Toast.LENGTH_SHORT).show()
        }
    }
}