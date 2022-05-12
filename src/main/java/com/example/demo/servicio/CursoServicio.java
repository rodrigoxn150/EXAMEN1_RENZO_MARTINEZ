package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Curso;


public interface CursoServicio {
	public void guardarCurso(Curso curso);
	public void editarCurso(Curso curso );
	public void eliminarCurso(Integer id);
	public List<Curso> listarCurso();
	public Curso obtenerCursoId(Integer id);
}
