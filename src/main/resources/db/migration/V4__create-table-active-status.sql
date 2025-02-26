alter table medico add column active_status varchar(10) not null;
update medico set active_status = 1;