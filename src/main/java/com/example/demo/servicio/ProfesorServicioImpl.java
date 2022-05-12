package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.modelo.Profesor;

import com.example.demo.repository.ProfesorRepositorio;

public class ProfesorServicioImpl implements ProfesorServicio{
	@Autowired
	public ProfesorRepositorio repositorio;
	@Override
	public void guardarProfesor(Profesor profesor) {
		repositorio.save(profesor);
		
	}

	@Override
	public void editarProfesor(Profesor profesor) {
		repositorio.saveAndFlush(profesor);
		
	}

	@Override
	public void eliminarProfesor(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<Profesor> listarProfesor() {
		return repositorio.findAll();
	}

	@Override
	public Profesor obtenerProfesorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
