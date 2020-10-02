DROP DATABASE IF EXISTS `grupo7`;
CREATE DATABASE `grupo7`;
USE grupo7;

DROP TABLE IF EXISTS `personas`;
DROP TABLE IF EXISTS `direccion`;
DROP TABLE IF EXISTS `tipo_contacto`;
DROP TABLE IF EXISTS `pais`;
DROP TABLE IF EXISTS `provincia`;
DROP TABLE IF EXISTS `localidad`;

CREATE TABLE `pais` (
  `idpais` int NOT NULL AUTO_INCREMENT,
  `nombre_pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpais`)
);

CREATE TABLE `provincia` (
  `idprovincia` int NOT NULL AUTO_INCREMENT,
  `nombre_provincia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idprovincia`)
);

CREATE TABLE `localidad` (
  `idlocalidad` int NOT NULL AUTO_INCREMENT,
  `nombre_localidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idlocalidad`)
);

CREATE TABLE `direccion` (
  `iddireccion` int NOT NULL AUTO_INCREMENT,
  `pais` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `codigoPostal` varchar(6) DEFAULT NULL,
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
  `userLinkedin` varchar(40) DEFAULT NULL,
  `Fecha_nacimiento` date DEFAULT NULL,
  `IdDireccion` int DEFAULT NULL,
  `IdTipo` int DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `IdDireccion_idx` (`IdDireccion`),
  KEY `IdTipo_idx` (`IdTipo`),
  CONSTRAINT `IdDireccion` FOREIGN KEY (`IdDireccion`) REFERENCES `direccion` (`iddireccion`),
  CONSTRAINT `IdTipo` FOREIGN KEY (`IdTipo`) REFERENCES `tipo_contacto` (`idtipo`)
);

INSERT INTO pais(Nombre_pais) VALUES ('Argentina');
INSERT INTO pais(Nombre_pais) VALUES ('Brasil');
INSERT INTO pais(Nombre_pais) VALUES ('Bolivia');

INSERT INTO provincia(Nombre_provincia) VALUES ('Buenos Aires');
INSERT INTO provincia(Nombre_provincia) VALUES ('Corboba');
INSERT INTO provincia(Nombre_provincia) VALUES ('La Paz');

INSERT INTO localidad(Nombre_localidad) VALUES ('Moreno');
INSERT INTO localidad(Nombre_localidad) VALUES ('Ciudad de Dios');
INSERT INTO localidad(Nombre_localidad) VALUES ('Pachamama');


INSERT INTO tipo_contacto(Nombre_tipo) VALUES ('Amigo',1);
INSERT INTO tipo_contacto(Nombre_tipo) VALUES ('Familia',1);
INSERT INTO tipo_contacto(Nombre_tipo) VALUES ('Trabajo',1);


