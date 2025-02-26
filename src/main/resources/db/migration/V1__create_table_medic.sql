create table medicos(
                        id bigint not null auto_increment,
                        nome varchar(100) not null,
                        email varchar(100),
                        crm varchar(6) not null unique,
                        especialidade varchar(100) not null,
                        logradouro varchar(100) not null,
                        numero int not null,
                        bairro varchar(100) not null,
                        cidade varchar(100) not null,
                        estado varchar(100) not null,
                        primary key(id)
);