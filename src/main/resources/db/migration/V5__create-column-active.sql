alter table pacientes
add column active_status varchar(10) not null;

update pacientes
set active_status = 1;