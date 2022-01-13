-- this is a sql file for initializing the crudeventos database

-- drop table if exists evento;

create table if not exists evento(
	id serial,
	nome varchar(50),
	local varchar(50),
	data varchar(50),
	horario varchar(50)
);
