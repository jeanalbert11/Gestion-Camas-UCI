#Pacientes
INSERT INTO patients(cedula, nombre, apellido, correo, fecha_creacion ) VALUES('100', 'Andres', 'Perez', 'aperez@gmail.com', NOW());
INSERT INTO patients(cedula, nombre, apellido, correo, fecha_creacion ) VALUES('200', 'Rocio', 'Angel', 'rangel@gmail.com', NOW());
INSERT INTO patients(cedula, nombre, apellido, correo, fecha_creacion ) VALUES('300', 'Jorge', 'Quintero', 'jquintero@gmail.com', NOW());
INSERT INTO patients(cedula, nombre, apellido, correo, fecha_creacion ) VALUES('400', 'Ana', 'Lozano', 'alozano@gmail.com', NOW());
INSERT INTO patients(cedula, nombre, apellido, correo, fecha_creacion ) VALUES('500', 'Pedro', 'Contreras', 'pcontreras@gmail.com', NOW());


#Enfermeras
INSERT INTO nurses(cedula, tarjeta_profesional, nombre, apellido, correo, fecha_creacion) VALUES('1000', '1001', 'Erica', 'Novoa', 'e.novoa@gmail.com', NOW());
INSERT INTO nurses(cedula, tarjeta_profesional, nombre, apellido, correo, fecha_creacion ) VALUES('2000', '2001', 'Laura', 'Guzman', 'l.guzman@gmail.com', NOW());
INSERT INTO nurses(cedula, tarjeta_profesional, nombre, apellido, correo, fecha_creacion ) VALUES('3000', '3001', 'Fernanda', 'Zapata', 'f.zapata@gmail.com', NOW());

#Camas
INSERT INTO beds(codigo, nurse_id) VALUES ( '101', '1');
INSERT INTO beds(codigo, nurse_id) VALUES ( '102', '1');
INSERT INTO beds(codigo, nurse_id) VALUES ( '103', '2');
INSERT INTO beds(codigo, nurse_id) VALUES ( '104', '3');
