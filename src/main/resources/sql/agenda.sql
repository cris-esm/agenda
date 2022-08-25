\c agenda;

CREATE TABLE IF NOT EXISTS Pais(
    id serial,
    nombre varchar
);

CREATE TABLE IF NOT EXISTS Provincia(
    id serial,
    nombre varchar,
    idPais bigint
);

CREATE TABLE IF NOT EXISTS Localidad(
    id serial,
    nombre varchar,
    idProvincia bigint
);

CREATE TABLE IF NOT EXISTS Domicilio(
    id serial,
    calle varchar,
    altura integer,
    piso varchar,
    departamento varchar,
    idLocalidad bigint
);

CREATE TABLE IF NOT EXISTS TipoContacto(
	id serial,
	nombre varchar
);

CREATE TABLE IF NOT EXISTS Persona(
    id serial,
    nombre varchar,
    telefono varchar,
    email varchar,
    fechaNac date,
    idDomicilio bigint,
    idtipocontacto bigint
);

ALTER TABLE Pais ADD CONSTRAINT id_pais PRIMARY KEY (id);
ALTER TABLE Provincia ADD CONSTRAINT id_provincia PRIMARY KEY (id);
ALTER TABLE Localidad ADD CONSTRAINT id_localidad PRIMARY KEY (id);
ALTER TABLE Domicilio ADD CONSTRAINT id_domicilio PRIMARY KEY (id);
ALTER TABLE Persona ADD CONSTRAINT id_persona PRIMARY KEY (id);
ALTER TABLE TipoContacto ADD CONSTRAINT id_TipoContacto PRIMARY KEY (id);

ALTER TABLE Provincia ADD CONSTRAINT fk_pais FOREIGN KEY (idPais) REFERENCES Pais(id);
ALTER TABLE Localidad ADD CONSTRAINT fk_provincia FOREIGN KEY (idProvincia) REFERENCES Provincia(id);
ALTER TABLE Domicilio ADD CONSTRAINT fk_localidad FOREIGN KEY (idLocalidad) REFERENCES Localidad(id);
ALTER TABLE Persona ADD CONSTRAINT fk_domicilio FOREIGN KEY (idDomicilio) REFERENCES Domicilio(id);
ALTER TABLE Persona ADD CONSTRAINT fk_tipocontacto FOREIGN KEY (idtipocontacto) REFERENCES TipoContacto(id);

insert into pais values(default, 'Argentina');

insert into provincia values(default, 'Buenos Aires', 1);
insert into provincia values(default, 'Catamarca', 1);
insert into provincia values(default, 'Chaco', 1);
insert into provincia values(default, 'Chubut', 1);


insert into Localidad values(default, 'Acasusso',1);
insert into Localidad values(default, 'Bancalari',1);
insert into Localidad values(default, 'Barrio Uno',1);
insert into Localidad values(default, 'Beccar',1);
insert into Localidad values(default, 'Bella Vista',1);
insert into Localidad values(default, 'Benavidez',1);
insert into Localidad values(default, 'Berazategui',1);
insert into Localidad values(default, 'Boulogne Sur Mer',1);
insert into Localidad values(default, 'Caseros',1);
insert into Localidad values(default, 'Castelar',1);
insert into Localidad values(default, 'Del Viso',1);
insert into Localidad values(default, 'Don Torcuato',1);
insert into Localidad values(default, 'El Libertador',1);
insert into Localidad values(default, 'El Talar',1);
insert into Localidad values(default, 'Ezeiza',1);
insert into Localidad values(default, 'General Rodriguez',1);
insert into Localidad values(default, 'Grand Bourg',1);
insert into Localidad values(default, 'Haedo',1);
insert into Localidad values(default, 'Ingeniero Adolfo Sourdeaux',1);
insert into Localidad values(default, 'Ingeniero Pablo Nogués',1);
insert into Localidad values(default, 'Ituzaingo',1);
insert into Localidad values(default, 'Jose C. Paz',1);
insert into Localidad values(default, 'Jose Leon Suárez',1);
insert into Localidad values(default, 'Lanus',1);
insert into Localidad values(default, 'Loma Hermosa',1);
insert into Localidad values(default, 'Los Polvorines',1);
insert into Localidad values(default, 'Malvinas Argentinas',1);
insert into Localidad values(default, 'Manuel Alberti',1);
insert into Localidad values(default, 'Martinez',1);
insert into Localidad values(default, 'Merlo',1);
insert into Localidad values(default, 'Muñiz',1);
insert into Localidad values(default, 'Pilar',1);

insert into tipocontacto values(default, 'Trabajo');
insert into tipocontacto values(default, 'Familia');
insert into tipocontacto values(default, 'Amigo');

insert into domicilio values(default, 'calle falsa', 123, '4', '4b', 4);
insert into domicilio values(default, 'calle falsa', 456, '1', '1a', 4);

insert into persona values(default, 'Cristian Egas', '1122334455', 'cris@gmail.com', '1998-03-13', 1, 1);
insert into persona values(default, 'Mariano Franzetti', '1166778899', 'mariano@gmail.com', '1998-01-01', 2, 1);