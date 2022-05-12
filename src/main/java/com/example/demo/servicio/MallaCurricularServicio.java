package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.MallaCurricular;



public interface MallaCurricularServicio {
	public void guardarMallaCurricular(MallaCurricular malla);
	public void editarMallaCurricular(MallaCurricular malla );
	public void eliminarMallaCurricular(Integer id);
	public List<MallaCurricular> listarMallaCurricular();
	public MallaCurricular obtenerMallaCurricularId(Integer id);
}
