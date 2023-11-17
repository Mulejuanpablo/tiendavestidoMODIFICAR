create database chloedb;
use chloedb;

create table vestido (
id BIGINT AUTO_INCREMENT primary key,
codigo varchar(250) not null,
nombre varchar(250),
color varchar(250),
talle varchar(250),
unidades varchar(250),
fechacompra varchar(250),
descripcion varchar(250),
foto varchar(250),
precio_id bigint,
foreign key (precio_id) references precio(id)

);


create table precio (
id BIGINT AUTO_INCREMENT primary key,
preciocolor varchar(250)
);

create table cliente (
id BIGINT auto_increment primary key ,
apellido varchar(250),
nombre varchar(250),
dni BIGINT,
celular BIGINT ,
mail varchar(250),
direccion varchar(250),
ciudad varchar(250)
);

create table evento (
id BIGINT auto_increment primary key ,
evento varchar(250),
fecha varchar(250),
entrega varchar(250),
devolucion varchar(250)
);

create table alquiler (
id BIGINT auto_increment primary key ,
cliente_id BIGINT,
vestido_id BIGINT,
evento_id BIGINT(250),
fechaentrega BIGINT,
fechadevolucion BIGINT,
precio BIGINT,
seña BIGINT,
resto BIGINT,
foreign key (cliente_id) references cliente(id),
foreign key (vestido_id) references vestido(id),
foreign key (evento_id) references evento(id)
);
