drop database libreriacoder;
create database libreriacoder;
use libreriacoder;

CREATE TABLE libro(
	id_libro INT PRIMARY KEY  AUTO_INCREMENT,
    autor VARCHAR(50) NOT NULL,
    numero_ejemplares INT NULL,
    titulo VARCHAR(50)
);


CREATE TABLE socio(
	id_socio INT PRIMARY KEY AUTO_INCREMENT,
    dni int NOT NULL,
    nombre_apellido VARCHAR(150) NOT NULL,
    telefono long 
    );
    
    CREATE TABLE prestamo(
		id_prestamo INT PRIMARY KEY AUTO_INCREMENT,
        estado_prestamo boolean default 0,
        fecha_prestamo DATE, 
        fecha_devolucion DATE ,
        libro_id int,
        socio_id int,
        constraint fk_libro_id foreign key(libro_id) references libro(id_libro),
        constraint fk_socio_id foreign key(socio_id) references socio(id_socio)
        
    );
    
    SELECT * FROM libreriacoder.libro;
      SELECT * FROM libreriacoder.socio;
SELECT * FROM libreriacoder.prestamo;
