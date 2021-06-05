#Unidades de cuidados intensivos
INSERT INTO units(acronimo,tipo) VALUES ( 'UCIC', 'Unidad de cuidados intensivos coronarios');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCI', 'Unidad de cuidados intensivos');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCIM', 'Unidad de cuidados intermedios');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCIP', 'Unidad de cuidado pediatrico');
INSERT INTO units(acronimo,tipo) VALUES ( 'UCICovid', 'Unidad de cuidado covid-19');

#Hospitales
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('1', 'Clínica del Occidente', 'S.A.', '4254620', 'Calle 29 17-65', 'Privada');
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('2', 'Centro Policlínico del Olaya', 'S.A.', '3725060', 'Carrera 20 # 23 - 23 sur','Publica');
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('3', 'Virrey Solís IPS', 'S.A.', '4473533', 'Avenida Las Americas 1', 'Privada');
INSERT INTO hospitals (id, nombre, razon_social, telefono, direccion, tipo) VALUES ('4', 'Centro Dermatológico Federico Lleras Acosta', 'S.A.', '3077072', 'Avenida 1a N 13a 61', 'Publica');

#Hospitales_Unidades
#INSERT INTO `uci`.`hospitals_units` (`hospital_id`, `units_id`) VALUES ('1', '1');
#INSERT INTO `uci`.`hospitals_units` (`hospital_id`, `units_id`) VALUES ('1', '2');
#INSERT INTO `uci`.`hospitals_units` (`hospital_id`, `units_id`) VALUES ('1', '3');



