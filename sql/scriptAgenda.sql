DROP DATABASE IF EXISTS `grupo7`;
CREATE DATABASE `grupo7`;
USE grupo7;

DROP TABLE IF EXISTS `personas`;
DROP TABLE IF EXISTS `direccion`;
DROP TABLE IF EXISTS `tipo_contacto`;

CREATE TABLE `direccion` (
  `iddireccion` int NOT NULL AUTO_INCREMENT,
  `pais` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `calle` varchar(45) DEFAULT NULL,
  `altura` varchar(45) DEFAULT NULL,
  `piso` varchar(45) DEFAULT NULL,
  `departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddireccion`)
);

CREATE TABLE `tipo_contacto` (
  `idtipo` int NOT NULL AUTO_INCREMENT,
  `Nombre_tipo` varchar(45) DEFAULT NULL,
  `Activa` int DEFAULT NULL,
  PRIMARY KEY (`idtipo`)
);

CREATE TABLE `personas` (
  `idPersona` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Fecha_nacimiento` date DEFAULT NULL,
  `IdDireccion` int DEFAULT NULL,
  `IdTipo` int DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `IdDireccion_idx` (`IdDireccion`),
  KEY `IdTipo_idx` (`IdTipo`),
  CONSTRAINT `IdDireccion` FOREIGN KEY (`IdDireccion`) REFERENCES `direccion` (`iddireccion`),
  CONSTRAINT `IdTipo` FOREIGN KEY (`IdTipo`) REFERENCES `tipo_contacto` (`idtipo`)
);

INSERT INTO direccion(pais) VALUES ('Argentina');
INSERT INTO direccion(pais) VALUES ('Brasil');
INSERT INTO direccion(pais) VALUES ('Chile');
INSERT INTO direccion(pais) VALUES ('Colombia');
INSERT INTO direccion(pais) VALUES ('Ecuador');
INSERT INTO direccion(pais) VALUES ('Francia');
INSERT INTO direccion(pais) VALUES ('Hungria');
INSERT INTO direccion(pais) VALUES ('Japon');
INSERT INTO direccion(pais) VALUES ('Peru');
INSERT INTO direccion(pais) VALUES ('Rusia');
INSERT INTO direccion(pais) VALUES ('Uruguay');
INSERT INTO direccion(pais) VALUES ('Venezuela');

INSERT INTO direccion(provincia) VALUES ('Buenos Aires');
INSERT INTO direccion(provincia) VALUES ('Catamarca');
INSERT INTO direccion(provincia) VALUES ('Chubut');
INSERT INTO direccion(provincia) VALUES ('Formosa');
INSERT INTO direccion(provincia) VALUES ('La Pampa');
INSERT INTO direccion(provincia) VALUES ('Misiones');
INSERT INTO direccion(provincia) VALUES ('San Juan');
INSERT INTO direccion(provincia) VALUES ('Santiago del Estero');
INSERT INTO direccion(provincia) VALUES ('Tierra del Fuego');

INSERT INTO direccion(localidad) VALUES ('Almirante Brown');
INSERT INTO direccion(localidad) VALUES ('Bahia Blanca');
INSERT INTO direccion(localidad) VALUES ('Don Torcuato');
INSERT INTO direccion(localidad) VALUES ('Hurlingham');
INSERT INTO direccion(localidad) VALUES ('Jose C. Paz');
INSERT INTO direccion(localidad) VALUES ('Malvinas Argentinas');
INSERT INTO direccion(localidad) VALUES ('Mar del Plata');
INSERT INTO direccion(localidad) VALUES ('Olivos');
INSERT INTO direccion(localidad) VALUES ('San Fernando');
INSERT INTO direccion(localidad) VALUES ('San Isidro');
INSERT INTO direccion(localidad) VALUES ('San Miguel');
INSERT INTO direccion(localidad) VALUES ('Tres de Febrero');

INSERT INTO tipo_contacto(Nombre_tipo) VALUES ('Amigo');
INSERT INTO tipo_contacto(Nombre_tipo) VALUES ('Familia');
INSERT INTO tipo_contacto(Nombre_tipo) VALUES ('Trabajo');


