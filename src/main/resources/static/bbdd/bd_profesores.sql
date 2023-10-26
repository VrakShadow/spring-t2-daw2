/*-	Nombre
-	Codigo de Identificacion interno(puede ser DNI o uno que ustedes mismos creen)
-	Especialidad
-	Estado(Activo o Inactivo)
*/
drop database if exists bd_profesores;
create database if not exists bd_profesores;
use bd_profesores;

create table Profesor (
	id_profesor int primary key auto_increment,
	nombre_profesor varchar(255) not null,
    dni_profesor varchar(8) not null,
    especialidad_profesor varchar(100) not null,
    estado_profesor varchar(100) not null
);

insert into Profesor values (null, "Jose Roberto Robles Hernandez", "41526378", "Matematicas", "ACTIVO");
insert into Profesor values (null, "Maria Fresia Gomez Valencia", "65632894", "Comunicacion", "INACTIVO");
insert into Profesor values (null, "Juan Alberto Valencia Gimenez", "61859632", "Ciencias Politicas", "ACTIVO");
insert into Profesor values (null, "Oscar Rodrigo Quispe Lopez", "48965236", "Fisica Cuantica", "INACTIVO");
insert into Profesor values (null, "Melinda Francesca Oviedo Paz", "78569321", "Biotecnologia", "ACTIVO");

/*
SELECT * FROM PROFESOR
*/