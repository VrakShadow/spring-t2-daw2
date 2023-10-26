package com.cibertec.edu.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Profesor")
public class Profesor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
    id_profesor int primary key auto_increment,
	nombre_profesor varchar(255) not null,
    dni_profesor varchar(8) not null,
    especialidad_profesor varchar(100) not null,
    estado_profesor varchar(100) not null 
 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_profesor")
	int id_profesor;
	
	@Column(name = "nombre_profesor")
	String nombre_profesor;
	
	@Column(name = "dni_profesor")
	String dni_profesor;
	
	@Column(name = "especialidad_profesor")
	String especialidad_profesor;
	
	@Column(name = "estado_profesor")
	String estado_profesor;
}
