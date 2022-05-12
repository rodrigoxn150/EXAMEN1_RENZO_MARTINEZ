package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Profesor;


public interface ProfesorServicio {
	public void guardarProfesor(Profesor profesor);
	public void editarProfesor(Profesor profesor);
	public void eliminarProfesor(Integer id);
	public List<Profesor> listarProfesor();
	public Profesor obtenerProfesorId(Integer id);
}
