package com.cibertec.edu.service;

import java.util.List;

import com.cibertec.edu.model.Profesor;

public interface ProfesorService {
	
	public List<Profesor> getAllProfesores();
	
	public Profesor getOneStudent(int id);
}
