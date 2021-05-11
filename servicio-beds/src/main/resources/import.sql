#Pacientes
INSERT INTO patients(cedula, nombre, apellido, correo, fecha_creacion ) VALUES('100', 'Andres', 'Perez', 'aperez@gmail.com', NOW());
INSERT INTO patients(cedula, nombre, apellido, correo, fecha_creacion ) VALUES('200', 'Rocio', 'Angel', 'rangel@gmail.com', NOW());
INSERT INTO patients(cedula, nombre, apellido, correo, fecha_creacion ) VALUES('300', 'Jorge', 'Quintero', 'jquintero@gmail.com', NOW());
INSERT INTO patients(cedula, nombre, apellido, correo, fecha_creacion ) VALUES('400', 'Ana', 'Lozano', 'alozano@gmail.com', NOW());
INSERT INTO patients(cedula, nombre, apellido, correo, fecha_creacion ) VALUES('500', 'Pedro', 'Contreras', 'pcontreras@gmail.com', NOW());

#Enfermeras
INSERT INTO nurses(cedula, tarjeta_profesional, nombre, apellido, fecha_creacion) VALUES('1000', '1001', 'Erica', 'Novoa', NOW());
INSERT INTO nurses(cedula, tarjeta_profesional, nombre, apellido, fecha_creacion ) VALUES('2000', '2001', 'Laura', 'Guzman', NOW());
INSERT INTO nurses(cedula, tarjeta_profesional, nombre, apellido, fecha_creacion ) VALUES('3000', '3001', 'Fernanda', 'Zapata', NOW());

#Camas
INSERT INTO beds(codigo, estado, nurse_id, paciente_id) VALUES ( '101', True, '1', '1');
INSERT INTO beds(codigo, estado, nurse_id, paciente_id) VALUES ( '102', False, '1', '2');
INSERT INTO beds(codigo, estado, nurse_id) VALUES ( '103', True, '2');
INSERT INTO beds(codigo, estado, nurse_id) VALUES ( '104', True, '3');

#Unidades de cuidados intensivos
INSERT INTO units(acronimo,tipo) VALUES ( 'UCIC', 'Unidad de cuidados intensivos coronarios');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCI', 'Unidad de cuidados intensivos');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCIM', 'Unidad de cuidados intermedios');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCIP', 'Unidad de cuidado pediatrico');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCICovid', 'Unidad de cuidado covid-19');

#Hospitales
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('1', 'Clínica del Occidente', 'S.A.', '4254620', 'Calle 29 17-65', 'privada');
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('2', 'Centro Policlínico del Olaya', 'S.A.', '3725060', 'Carrera 20 # 23 - 23 sur','publica');
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('3', 'Virrey Solís IPS', 'S.A.', '4473533', 'Avenida Las Americas 1', 'privada');
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('4', 'Centro Dermatológico Federico Lleras Acosta', 'S.A.', '3077072', 'Avenida 1a N 13a 61', 'publica');

#Hospitales_Unidades
#INSERT INTO `uci`.`hospitals_units` (`hospital_id`, `units_id`) VALUES ('1', '1');
#INSERT INTO `uci`.`hospitals_units` (`hospital_id`, `units_id`) VALUES ('1', '2');
#INSERT INTO `uci`.`hospitals_units` (`hospital_id`, `units_id`) VALUES ('1', '3');



