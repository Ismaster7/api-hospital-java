create table pacientes(
 id bigint not null auto_increment primary key,
 nome varchar(20) not null,
cpf varchar(11) not null,
 telefone varchar(9),
logradouro varchar(100) not null,
 numero int not null,
 bairro varchar(100) not null,
 cidade varchar(100) not null,
 estado varchar(100) not null
)