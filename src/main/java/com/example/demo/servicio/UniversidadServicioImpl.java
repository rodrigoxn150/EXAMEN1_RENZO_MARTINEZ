package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.modelo.Universidad;
import com.example.demo.repository.ProfesorRepositorio;
import com.example.demo.repository.UniversidadRepositorio;

public class UniversidadServicioImpl implements UniversidadServicio {
	@Autowired
	public UniversidadRepositorio repositorio;
	@Override
	public void guardarUniversidad(Universidad universodad) {
		repositorio.save(universodad);
		
	}

	@Override
	public void editarUniversidad(Universidad universidad) {
		repositorio.saveAndFlush(universidad);
		
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<Universidad> listarUniversidad() {
		return repositorio.findAll();
	}

	@Override
	public Universidad obtenerUniversidadId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
