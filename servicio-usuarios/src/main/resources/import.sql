INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');
INSERT INTO roles(nombre) VALUES('ROLE_USER');

INSERT INTO usuarios(username,password,enabled,email) VALUES('user', '$2a$10$KvIJ0zKt1KdzN3OR6Y693O0yUz7sCYIGjfkl50dkNUucZcoG7xXte',1,'usuario@gmail.com');
INSERT INTO usuarios(username,password,enabled,email) VALUES('admin', '$2a$10$GTo9h9XysLBiaqaaBtzKT.0DVqb1hCXgOCeTs59b0.VXGS68/Hj4a',1,'admin@gmail.com');
#INSERT INTO usuarios(username,password,enabled,email) VALUES('user', '$2a$10$KvIJ0zKt1KdzN3OR6Y693O0yUz7sCYIGjfkl50dkNUucZcoG7xXte',1,'usuario@gmail.com');

INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(1,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(2,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(2,1);


