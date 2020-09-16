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