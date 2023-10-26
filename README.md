<div align="center">
  <h2>T2 EXAMEN</h2>
  <p>Desarrollo de examen DAW2.</p>
</div>

## Requisitos previos
- [Java](https://adoptium.net/).
- [Maven](https://maven.apache.org/)
- [Spring Tool Suite 4](https://spring.io/tools).
- [MySQL](https://www.mysql.com/).

## Versiones
- Java: JDK 21.
- Maven: 3.9.5.
- MySQL: 8.0.34.
- Spring: 3.1.5.

## Instalación y Ejecución
1. Clonar o descarga el repositorio `https://github.com/VrakShadow/spring-t2-daw2.git`.
2. Importar el proyecto "spring-t2-daw2" en el IDE Spring Tool Suite 4.
3. Ajustar en el archivo `application.properties` la cadena de conexión `bd_profesores`.
```
server.port=8008
spring.jpa.database=MYSQL
spring.jpa.show-sql=true
spring.datasource.url=jdbc:mysql://localhost:3306/bd_profesores
spring.datasource.username=admin
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
4. Ejecutar la base de datos MySQL `bd_profesores`.
5. Ejecuta el proyecto de Spring.
6. Abre tu navegador y escribe `http://localhost:8008/home/index`.
7. Escribe el username -> `admin` y password -> `admin`.
8. Escribe `http://localhost:8008/api/profesores/all` para mostrar en JSON
9. Mostrar un profesor `http://localhost:8008/api/profesores/{id_profesor}`

## Observaciones
- La base de datos se encuenta en los archivos del proyecto (../resources/static/bbdd/bd_profesores).
- El RESTful funciona cuando esta logueado y en caso de no funcionar deshabilita el login.
