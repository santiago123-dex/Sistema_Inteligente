# Sistema_Inteligente
<!-- 
create database cursos_online;

use cursos_online;

drop table categoria;

drop table cursos;

drop table estudiante;

create table categoria(
	id_categoria int primary key auto_increment,
	nombre_categoria varchar(100) not null
);

create table cursos(
	id_curso int PRIMARY KEY AUTO_INCREMENT,
	titulo_curso varchar(100) not null,
	descripcion varchar(150) not null,
	id_categoria int not null,
	foreign key (id_categoria) references categoria (id_categoria)
);

create table estudiante(
	id_estudiante int PRIMARY key auto_increment,
	nombre varchar(100) not null,
	email varchar(150) not null
);

CREATE TABLE estudiante_cursos(
    id_estudiante INT NOT NULL,
    id_curso INT NOT NULL,
    FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante),
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso),
    PRIMARY KEY(id_estudiante, id_curso)
);


 -->

