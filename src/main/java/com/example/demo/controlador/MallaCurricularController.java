package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.MallaCurricular;
import com.example.demo.servicio.MallaCurricularServicio;

@RestController
@RequestMapping("/mallacurricular/v1")
public class MallaCurricularController {
	@Autowired
	private MallaCurricularServicio servicio;
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<MallaCurricular>> listarMalla(){
		return new ResponseEntity<List<MallaCurricular>>(servicio.listarMallaCurricular(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaCurricular malla){
		servicio.guardarMallaCurricular(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<MallaCurricular> listarPorId(@PathVariable Integer id){
		MallaCurricular p = servicio.obtenerMallaCurricularId(id);
		if(p != null)
			return new ResponseEntity<MallaCurricular>(p, HttpStatus.OK);
		return new ResponseEntity<MallaCurricular>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody MallaCurricular malla){
		MallaCurricular p = servicio.obtenerMallaCurricularId(malla.getIdMalla());
		if(p != null) {
			servicio.editarMallaCurricular(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		MallaCurricular p = servicio.obtenerMallaCurricularId(id);
		if(p != null) {
			servicio.eliminarMallaCurricular(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
}
