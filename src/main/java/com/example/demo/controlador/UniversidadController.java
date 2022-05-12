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

import com.example.demo.modelo.Profesor;
import com.example.demo.modelo.Universidad;
import com.example.demo.servicio.ProfesorServicio;
import com.example.demo.servicio.UniversidadServicio;

@RestController
@RequestMapping("/universidad/v1")
public class UniversidadController {
	@Autowired
	private UniversidadServicio servicio;
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Universidad>> listarMalla(){
		return new ResponseEntity<List<Universidad>>(servicio.listarUniversidad(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Universidad universidad){
		servicio.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<Universidad> listarPorId(@PathVariable Integer id){
		Universidad p = servicio.obtenerUniversidadId(id);
		if(p != null)
			return new ResponseEntity<Universidad>(p, HttpStatus.OK);
		return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody Universidad universidad){
		Universidad p = servicio.obtenerUniversidadId(universidad.getIdUniversidad());
		if(p != null) {
			servicio.editarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Universidad p = servicio.obtenerUniversidadId(id);
		if(p != null) {
			servicio.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
}
