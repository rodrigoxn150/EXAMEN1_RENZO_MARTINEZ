package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Universidad;


public interface UniversidadServicio {

	public void guardarUniversidad(Universidad universodad);
	public void editarUniversidad(Universidad universidad);
	public void eliminarUniversidad(Integer id);
	public List<Universidad> listarUniversidad();
	public Universidad obtenerUniversidadId(Integer id);
}
