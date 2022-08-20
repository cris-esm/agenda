\c agenda;

CREATE TABLE IF NOT EXISTS Pais(
    id bigint,
    nombre varchar
);

CREATE TABLE IF NOT EXISTS Provincia(
    id bigint,
    nombre varchar,
    idPais bigint
);

CREATE TABLE IF NOT EXISTS Localidad(
    id bigint,
    nombre varchar,
    idProvincia bigint
);

CREATE TABLE IF NOT EXISTS Domicilio(
    id bigint,
    calle varchar,
    altura integer,
    piso varchar,
    departamento varchar,
    idLocalidad bigint
);

CREATE TABLE IF NOT EXISTS Persona(
    id bigint,
    nombre varchar,
    telefono varchar,
    email varchar,
    fechaNac date,
    idDomicilio bigint,
    idtipocontacto bigint
);

CREATE TABLE IF NOT EXISTS TipoContacto(
	id bigint,
	nombre varchar
);

ALTER TABLE Pais ADD CONSTRAINT id_pais PRIMARY KEY (id);
ALTER TABLE Provincia ADD CONSTRAINT id_provincia PRIMARY KEY (id);
ALTER TABLE Localidad ADD CONSTRAINT id_localidad PRIMARY KEY (id);
ALTER TABLE Domicilio ADD CONSTRAINT id_domicilio PRIMARY KEY (id);
ALTER TABLE TipoContacto ADD CONSTRAINT id_tipoContacto PRIMARY KEY (id);
ALTER TABLE Persona ADD CONSTRAINT id_persona PRIMARY KEY (id);
ALTER TABLE TipoContacto ADD CONSTRAINT id_TipoContacto PRIMARY KEY (id);

ALTER TABLE Provincia ADD CONSTRAINT fk_pais FOREIGN KEY (idPais) REFERENCES Pais(id);
ALTER TABLE Localidad ADD CONSTRAINT fk_provincia FOREIGN KEY (idProvincia) REFERENCES Provincia(id);
ALTER TABLE Domicilio ADD CONSTRAINT fk_localidad FOREIGN KEY (idLocalidad) REFERENCES Localidad(id);
ALTER TABLE Persona ADD CONSTRAINT fk_domicilio FOREIGN KEY (idDomicilio) REFERENCES Domicilio(id);
ALTER TABLE Persona ADD CONSTRAINT fk_tipocontacto FOREIGN KEY (idtipocontacto) REFERENCES TipoContacto(id);

insert into pais values(1, 'Argentina')

insert into provincia values(1, 'Buenos Aires', 1);
insert into provincia values(2, 'Catamarca', 1);
insert into provincia values(3, 'Chaco', 1);
insert into provincia values(4, 'Chubut', 1);


insert into Localidad values(1, 'Acasusso',1);
insert into Localidad values(2, 'Bancalari',1);
insert into Localidad values(3, 'Barrio Uno',1);
insert into Localidad values(4, 'Beccar',1);
insert into Localidad values(5, 'Bella Vista',1);
insert into Localidad values(6, 'Benavidez',1);
insert into Localidad values(7, 'Berazategui',1);
insert into Localidad values(8, 'Boulogne Sur Mer',1);
insert into Localidad values(9, 'Caseros',1);
insert into Localidad values(10, 'Castelar',1);
insert into Localidad values(11, 'Del Viso',1);
insert into Localidad values(12, 'Don Torcuato',1);
insert into Localidad values(13, 'El Libertador',1);
insert into Localidad values(14, 'El Talar',1);
insert into Localidad values(15, 'Ezeiza',1);
insert into Localidad values(16, 'General Rodriguez',1);
insert into Localidad values(17, 'Grand Bourg',1);
insert into Localidad values(18, 'Haedo',1);
insert into Localidad values(19, 'Ingeniero Adolfo Sourdeaux',1);
insert into Localidad values(20, 'Ingeniero Pablo Nogués',1);
insert into Localidad values(21, 'Ituzaingo',1);
insert into Localidad values(22, 'Jose C. Paz',1);
insert into Localidad values(23, 'Jose Leon Suárez',1);
insert into Localidad values(24, 'Lanus',1);
insert into Localidad values(25, 'Loma Hermosa',1);
insert into Localidad values(26, 'Los Polvorines',1);
insert into Localidad values(27, 'Malvinas Argentinas',1);
insert into Localidad values(28, 'Manuel Alberti',1);
insert into Localidad values(29, 'Martinez',1);
insert into Localidad values(30, 'Merlo',1);
insert into Localidad values(31, 'Muñiz',1);
insert into Localidad values(32, 'Pilar',1);

insert into tipocontacto values(1, 'Trabajo');
insert into tipocontacto values(2, 'Familia');
insert into tipocontacto values(3, 'Amigo');

insert into domicilio values(1, 'calle falsa', 123, '4', '4b', 4);
insert into domicilio values(2, 'calle falsa', 456, '1', '1a', 4);

insert into persona values(1, 'Cristian Egas', '1122334455', 'cris@gmail.com', '1998-03-13', 1, 1);
insert into persona values(2, 'Mariano Franzetti', '1166778899', 'mariano@gmail.com', '1998-01-01', 2, 1);