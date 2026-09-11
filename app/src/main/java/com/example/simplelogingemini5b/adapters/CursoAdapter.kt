package com.example.simplelogingemini5b.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplelogingemini5b.databinding.ItemCursoBinding
import com.example.simplelogingemini5b.models.Curso

class CursoAdapter(
    private val cursos: List<Curso>,
    private val onItemClick: (Curso) -> Unit
) : RecyclerView.Adapter<CursoAdapter.CursoViewHolder>() {

    inner class CursoViewHolder(val binding: ItemCursoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val binding = ItemCursoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CursoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = cursos[position]
        with(holder.binding) {
            tvCursoTitulo.text = curso.titulo
            tvCursoInfo.text = "${curso.nivel} • ${curso.duracion}"
            ivCursoImagen.setImageResource(curso.imagenResId)
            
            btnVerDetalles.setOnClickListener { onItemClick(curso) }
            root.setOnClickListener { onItemClick(curso) }
        }
    }

    override fun getItemCount(): Int = cursos.size
}