package com.cibertec.edu.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.edu.model.Profesor;
import com.cibertec.edu.response.http.HttpResponseObject;
import com.cibertec.edu.service.ProfesorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {
	
	@Autowired
	private ProfesorServiceImpl profesorService;
	
	@GetMapping("/profesores/all")
	public HttpResponseObject obtenerProfesores() {
		List<Profesor> profesores = profesorService.getAllProfesores();
		if(profesores.size() == 0) {
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND, null);
		}
		return new HttpResponseObject("success", HttpStatus.OK, profesores);
	}
	
	@GetMapping("/profesores/{id}")
	public HttpResponseObject obtenerUnProfesor(@PathVariable(name = "id") int id) {
		Profesor profesor = this.profesorService.getOneStudent(id);
		if(profesor == null)
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND, null);
		return new HttpResponseObject("success", HttpStatus.OK, profesor);
	}
}


