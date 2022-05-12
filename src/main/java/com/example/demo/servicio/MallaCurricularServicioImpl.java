package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.modelo.MallaCurricular;

import com.example.demo.repository.MallaCurricularRepositorio;

public class MallaCurricularServicioImpl implements MallaCurricularServicio{
	@Autowired
	public MallaCurricularRepositorio repositorio;
	@Override
	public void guardarMallaCurricular(MallaCurricular malla) {
		repositorio.save(malla);	
		
	}

	@Override
	public void editarMallaCurricular(MallaCurricular malla) {
		repositorio.saveAndFlush(malla);
		
	}

	@Override
	public void eliminarMallaCurricular(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<MallaCurricular> listarMallaCurricular() {
		return repositorio.findAll();
	
	}

	@Override
	public MallaCurricular obtenerMallaCurricularId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
