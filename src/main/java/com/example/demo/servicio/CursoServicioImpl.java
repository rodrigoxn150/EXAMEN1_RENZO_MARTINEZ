package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.modelo.Curso;
import com.example.demo.repository.CursoRepositorio;

public class CursoServicioImpl implements CursoServicio{
	@Autowired
	public CursoRepositorio repositorio;
	@Override
	public void guardarCurso(Curso curso) {
		repositorio.save(curso);		
		
	}

	@Override
	public void editarCurso(Curso curso) {
		repositorio.saveAndFlush(curso);	
		
	}

	@Override
	public void eliminarCurso(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<Curso> listarCurso() {
		return repositorio.findAll();
	
	}

	@Override
	public Curso obtenerCursoId(Integer id) {
		
		return repositorio.findById(id).orElse(null);
	}

}
