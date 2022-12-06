CREATE TABLE preco{
	id serial not null primary key,
	valor_fimde_semana DOUBLE not null,
	valor_uteis DOUBLE not null
};

CREATE TABLE vaga{
	numero serial not null,
	veiculo_id serial not null
};

CREATE TABLE veiculo{
	id serial not null primary key,
	cor varchar(100) not null,
	placa varchar(100) not null,
	vaga_numero int not null
};
INSERT INTO vaga(numero) VALUES(1);