package com.cibertec.edu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.edu.model.Profesor;

@Repository
public interface ProfesorDao extends CrudRepository<Profesor, Integer> {
	
	public List<Profesor> findAll();
	public Optional<Profesor> findById(int id);
}
