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
#INSERT INTO beds(codigo, estado, nurse_id) VALUES ( '101', False, '1');
#INSERT INTO beds(codigo, estado, nurse_id) VALUES ( '102', False, '1');
#INSERT INTO beds(codigo, estado, nurse_id) VALUES ( '103', False, '2');
#INSERT INTO beds(codigo, estado, nurse_id) VALUES ( '104', False, '3');

INSERT INTO beds(codigo, nurse_id) VALUES ( '101', '1');
INSERT INTO beds(codigo, nurse_id) VALUES ( '102', '1');
INSERT INTO beds(codigo, nurse_id) VALUES ( '103', '2');
INSERT INTO beds(codigo, nurse_id) VALUES ( '104', '3');

#Unidades de cuidados intensivos
INSERT INTO units(acronimo,tipo) VALUES ( 'UCIC', 'Unidad de cuidados intensivos coronarios');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCI', 'Unidad de cuidados intensivos');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCIM', 'Unidad de cuidados intermedios');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCIP', 'Unidad de cuidado pediatrico');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCICovid', 'Unidad de cuidado covid-19');

#Hospitales
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('1', 'Cl??nica del Occidente', 'S.A.', '4254620', 'Calle 29 17-65', 'Privada');
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('2', 'Centro Policl??nico del Olaya', 'S.A.', '3725060', 'Carrera 20 # 23 - 23 sur','Publica');
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('3', 'Virrey Sol??s IPS', 'S.A.', '4473533', 'Avenida Las Americas 1', 'Privada');
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('4', 'Centro Dermatol??gico Federico Lleras Acosta', 'S.A.', '3077072', 'Avenida 1a N 13a 61', 'Publica');

#Hospitales_Unidades
#INSERT INTO `uci`.`hospitals_units` (`hospital_id`, `units_id`) VALUES ('1', '1');
#INSERT INTO `uci`.`hospitals_units` (`hospital_id`, `units_id`) VALUES ('1', '2');
#INSERT INTO `uci`.`hospitals_units` (`hospital_id`, `units_id`) VALUES ('1', '3');



