#localhost:8090/api/personal/personas
#localhost:8090/api/personal/nurses
#localhost:8090/api/personal/doctors
#Doctors
INSERT INTO persons(cedula, tarjeta_profesional, nombre, apellido, fecha_creacion ) VALUES('1000', '3001', 'Albert', 'Cortes', NOW());

INSERT INTO doctors (especialidad, id) VALUES ('Intensivista', '1');

#Nurses
INSERT INTO persons(cedula, tarjeta_profesional, nombre, apellido, fecha_creacion) VALUES('2000', '1001', 'Erica', 'Novoa', NOW() );
INSERT INTO persons(cedula, tarjeta_profesional, nombre, apellido, fecha_creacion ) VALUES('3000', '2001', 'Laura', 'Guzman', NOW());
INSERT INTO persons(cedula, tarjeta_profesional, nombre, apellido, fecha_creacion) VALUES('4000', '3001', 'Fernanda', 'Zapata', NOW());

INSERT INTO nurses (tipo, id) VALUES ('Jefe', '2');
INSERT INTO nurses (tipo, id) VALUES ('Aux', '3');
INSERT INTO nurses (tipo, id) VALUES ('Aux', '4');


