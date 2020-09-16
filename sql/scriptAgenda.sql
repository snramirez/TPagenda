DROP DATABASE IF EXISTS `grupo7`;
CREATE DATABASE `grupo7`;
USE grupo7;
CREATE TABLE `personas`
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Calle` varchar(50),
  `Altura` varchar(10),
  `Piso` varchar(10),
  `Departamento` varchar(10),
  `Localidad` varchar(30),
  `Email` varchar(50),
  `Fecha_Nacimiento` date,
  `Tipo` varchar(20),
  PRIMARY KEY (`idPersona`)
);