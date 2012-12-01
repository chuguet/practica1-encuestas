-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.21


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_quizz
--

CREATE DATABASE IF NOT EXISTS db_quizz;
USE db_quizz;

--
-- Definition of table `encuesta`
--

DROP TABLE IF EXISTS `encuesta`;
CREATE TABLE `encuesta` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COMMENT='Almacena todas las encuestas del sistema';

--
-- Dumping data for table `encuesta`
--

/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
INSERT INTO `encuesta` (`id`,`nombre`,`fecha_inicio`,`fecha_fin`) VALUES 
 (1,'sdfasdf','2012-11-29','2012-11-29'),
 (2,'asdf','2012-11-29','2012-11-29'),
 (3,'asdf','2012-11-29','2012-11-29'),
 (4,'sdafd','2012-11-29','2012-11-29'),
 (5,'asd','2012-11-29','2012-11-29'),
 (6,'cd','2012-11-29','2012-11-29'),
 (7,'a','2012-11-29','2012-11-29'),
 (8,'asdf','2012-11-29','2012-11-29'),
 (9,'fasdf','2012-11-29','2012-11-29'),
 (10,'asdf','2012-11-29','2012-11-29'),
 (11,'asdf','2012-11-29','2012-11-29'),
 (12,'dd','2012-11-29','2012-11-29'),
 (13,'sadf','2012-11-29','2012-11-29'),
 (14,'¿Cúal es el coche que más te gusta?','2012-12-01','2012-12-01'),
 (15,'Prueba correcta','2012-12-01','2012-12-01');
/*!40000 ALTER TABLE `encuesta` ENABLE KEYS */;


--
-- Definition of table `encuesta_usuario`
--

DROP TABLE IF EXISTS `encuesta_usuario`;
CREATE TABLE `encuesta_usuario` (
  `id_encuesta` int(10) unsigned NOT NULL,
  `id_usuario` int(10) unsigned DEFAULT NULL,
  `ip_dispositivo` varchar(20) DEFAULT NULL,
  KEY `FK_encuesta_usuario_1` (`id_encuesta`),
  KEY `FK_encuesta_usuario_2` (`id_usuario`),
  CONSTRAINT `FK_encuesta_usuario_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`id`),
  CONSTRAINT `FK_encuesta_usuario_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `encuesta_usuario`
--

/*!40000 ALTER TABLE `encuesta_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `encuesta_usuario` ENABLE KEYS */;


--
-- Definition of table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
CREATE TABLE `pregunta` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pregunta` varchar(100) NOT NULL,
  `id_encuesta` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pregunta_1` (`id_encuesta`),
  CONSTRAINT `FK_pregunta_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='Las distintas preguntas que conforman una encuesta';

--
-- Dumping data for table `pregunta`
--

/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` (`id`,`pregunta`,`id_encuesta`) VALUES 
 (1,'¿Qué es lo que valoras más en un coche?',14),
 (2,'Pregunta 1',15),
 (3,'Pregunta 2',15),
 (4,'Pregunta3',15);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;


--
-- Definition of table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
CREATE TABLE `respuesta` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `respuesta` varchar(100) NOT NULL,
  `id_pregunta` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_respuesta_1` (`id_pregunta`),
  CONSTRAINT `FK_respuesta_1` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1 COMMENT='Las posibles respuestas asociadas a cada pregunta';

--
-- Dumping data for table `respuesta`
--

/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` (`id`,`respuesta`,`id_pregunta`) VALUES 
 (4,'Respuesta 11',2),
 (5,'Respuesta 12',2),
 (6,'Respuesta 13',2),
 (7,'Respuesta 21',3),
 (8,'Respuesta 22',3),
 (9,'asdfasdfa',4),
 (10,'Respuesta 2',4),
 (11,'Respuesta 14',2),
 (12,'Respuesta 23',3),
 (13,'Respuesta 24',3),
 (14,'La seguridad',1),
 (15,'El diseño',1),
 (16,'El precio',1),
 (17,'Las prestaciones',1);
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;


--
-- Definition of table `respuesta_usuario`
--

DROP TABLE IF EXISTS `respuesta_usuario`;
CREATE TABLE `respuesta_usuario` (
  `id_respuesta` int(10) unsigned NOT NULL,
  `id_usuario` int(10) unsigned DEFAULT NULL,
  KEY `FK_respuesta_usuario_1` (`id_respuesta`),
  KEY `FK_respuesta_usuario_2` (`id_usuario`),
  CONSTRAINT `FK_respuesta_usuario_1` FOREIGN KEY (`id_respuesta`) REFERENCES `respuesta` (`id`),
  CONSTRAINT `FK_respuesta_usuario_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `respuesta_usuario`
--

/*!40000 ALTER TABLE `respuesta_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuesta_usuario` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `usuario` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `admin` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Almacena los usuarios del sistema';

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`,`nombre`,`apellidos`,`email`,`usuario`,`pwd`,`admin`) VALUES 
 (1,'David','Llamazares Juárez','dllamazares@atsistemas.com','admin','admin',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
