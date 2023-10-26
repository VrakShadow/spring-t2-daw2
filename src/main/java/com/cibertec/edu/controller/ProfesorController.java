package com.cibertec.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.edu.model.Profesor;
import com.cibertec.edu.service.ProfesorServiceImpl;

@Controller
@RequestMapping("/home")
public class ProfesorController {
	
	@Autowired
	private ProfesorServiceImpl profesorService;
	
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		return "index";
	}
	
	@ModelAttribute("profesores")
	public List<Profesor> obtenerProfesores() {
		List<Profesor> profesores = profesorService.getAllProfesores();
		
		return profesores;
	}
	
	@GetMapping({"/profesor/{id_profesor}"})
	public String index(Model model, @PathVariable(name = "id_profesor") int id_profesor) {
		model.addAttribute("titulo", "Profesor # " + id_profesor);
		Profesor profesor = this.profesorService.getOneStudent(id_profesor);
		if(profesor == null)
			profesor = new Profesor();
		model.addAttribute("profesor", profesor);
		return "profesor";
	}

}
