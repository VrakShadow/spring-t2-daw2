package com.cibertec.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.model.Profesor;
import com.cibertec.edu.repository.ProfesorDao;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorDao profesorRepo;
	
	@Override
	public List<Profesor> getAllProfesores() {
		// TODO Auto-generated method stub
		return this.profesorRepo.findAll();
	}

	@Override
	public Profesor getOneStudent(int id) {
		// TODO Auto-generated method stub
		Optional<Profesor> profesor = this.profesorRepo.findById(id);
		if(profesor.isPresent()) {
			return profesor.get();
		}
		return null;
	}

}
