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
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1 COMMENT='Almacena todas las encuestas del sistema';

--
-- Dumping data for table `encuesta`
--

/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
INSERT INTO `encuesta` (`id`,`nombre`,`fecha_inicio`,`fecha_fin`) VALUES 
 (23,'Peliculas del siglo XX','2012-12-01 05:30:00','2013-01-20 06:30:00'),
 (24,'Utilidad de la Thermo-Mix','2012-12-10 00:00:00','2013-01-31 00:00:00'),
 (25,'Selección de coche','2012-12-18 00:00:00','2012-12-31 00:00:00');
/*!40000 ALTER TABLE `encuesta` ENABLE KEYS */;


--
-- Definition of table `encuesta_contestada`
--

DROP TABLE IF EXISTS `encuesta_contestada`;
CREATE TABLE `encuesta_contestada` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_encuesta` int(10) unsigned NOT NULL,
  `id_usuario` int(10) unsigned DEFAULT NULL,
  `ip_usuario` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_encuesta_contestada_1` (`id_encuesta`),
  CONSTRAINT `FK_encuesta_contestada_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `encuesta_contestada`
--

/*!40000 ALTER TABLE `encuesta_contestada` DISABLE KEYS */;
INSERT INTO `encuesta_contestada` (`id`,`id_encuesta`,`id_usuario`,`ip_usuario`) VALUES 
 (17,24,4,NULL),
 (18,24,4,NULL),
 (19,24,NULL,NULL),
 (20,24,NULL,'da3e0446-66df-4364-bc7c-f987b92672ab'),
 (21,24,NULL,'f0745def-26ef-415b-893d-1225a8619a1c'),
 (22,24,NULL,'6f638e91-c790-4aae-ace8-85dcb7bf5f72'),
 (23,24,NULL,'6f638e91-c790-4aae-ace8-85dcb7bf5f72'),
 (24,24,NULL,'9f9ef15b-7622-4a90-8be2-b04e5a79e219');
/*!40000 ALTER TABLE `encuesta_contestada` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1 COMMENT='Las distintas preguntas que conforman una encuesta';

--
-- Dumping data for table `pregunta`
--

/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` (`id`,`pregunta`,`id_encuesta`) VALUES 
 (19,'¿Cúal es la mejor película del S.XX?',23),
 (20,'¿Cuál es la mejor Banda sonora?',23),
 (21,'¿Quien es el mejor actor?',23),
 (22,'¿Cuánto utilizas la Thermo-Mix?',24),
 (23,'¿Cuál es la receta que más te gusta?',24),
 (24,'¿Se la aconsejarías a un amigo?',24),
 (25,'¿Qué valoras en un coche?',25),
 (26,'¿Cuál es la velocidad máxima a la que sueles conducir?',25),
 (27,'¿Qué coche elegirías?',25);
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
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1 COMMENT='Las posibles respuestas asociadas a cada pregunta';

--
-- Dumping data for table `respuesta`
--

/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` (`id`,`respuesta`,`id_pregunta`) VALUES 
 (40,'Gladiator',19),
 (41,'Lo que el viento se llevo',19),
 (42,'Casablanca',19),
 (43,'Titanic',19),
 (44,'Alien',20),
 (45,'Pulp Fiction',20),
 (46,'El Señor de los Anillos',20),
 (47,'Wodie Allen',21),
 (48,'Santiago Segura',21),
 (49,'Rafaela Carra',21),
 (50,'A diario',22),
 (51,'5 veces por semana',22),
 (52,'3 veces por semana',22),
 (53,'1 vez por semana',22),
 (54,'1 vez al mes',22),
 (55,'Arroz con bogavante',23),
 (56,'Arroz con leche',23),
 (57,'Pollo en pepitoria',23),
 (58,'Cocido',23),
 (59,'Siempre',24),
 (60,'Casi seguro',24),
 (61,'Probablemente',24),
 (62,'Casi que no',24),
 (63,'Nunca',24),
 (64,'El diseño',25),
 (65,'El acabado',25),
 (66,'La fiabilidad',25),
 (67,'Las prestaciones',25),
 (68,'80 km/h',26),
 (69,'90 km/h',26),
 (70,'100 km/h',26),
 (71,'130 km/h',26),
 (72,'Ford Focus',27),
 (73,'volkswagen Golf',27),
 (74,'Seat Leon',27),
 (75,'Renault Megane',27);
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;


--
-- Definition of table `respuesta_contestada`
--

DROP TABLE IF EXISTS `respuesta_contestada`;
CREATE TABLE `respuesta_contestada` (
  `id_respuesta` int(10) unsigned NOT NULL,
  `id_encuesta_contestada` int(10) unsigned NOT NULL,
  KEY `FK_respuesta_usuario_1` (`id_respuesta`),
  KEY `FK_respuesta_contestada_2` (`id_encuesta_contestada`),
  CONSTRAINT `FK_respuesta_contestada_1` FOREIGN KEY (`id_respuesta`) REFERENCES `respuesta` (`id`),
  CONSTRAINT `FK_respuesta_contestada_2` FOREIGN KEY (`id_encuesta_contestada`) REFERENCES `encuesta_contestada` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `respuesta_contestada`
--

/*!40000 ALTER TABLE `respuesta_contestada` DISABLE KEYS */;
INSERT INTO `respuesta_contestada` (`id_respuesta`,`id_encuesta_contestada`) VALUES 
 (50,17),
 (56,17),
 (60,17),
 (50,18),
 (56,18),
 (60,18),
 (53,19),
 (55,19),
 (59,19),
 (53,20),
 (55,20),
 (59,20),
 (54,21),
 (58,21),
 (59,21),
 (53,22),
 (57,22),
 (59,22),
 (53,23),
 (57,23),
 (59,23),
 (52,24),
 (56,24),
 (60,24);
/*!40000 ALTER TABLE `respuesta_contestada` ENABLE KEYS */;


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
  `pwd` varchar(40) NOT NULL,
  `admin` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='Almacena los usuarios del sistema';

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`,`nombre`,`apellidos`,`email`,`usuario`,`pwd`,`admin`) VALUES 
 (1,'David','Llamazares Juárez','dllamazares@atsistemas.com','d','c4ca4238a0b923820dcc509a6f75849b',1),
 (2,'Carlos','Huguet','huguet@gmail.com','c','c4ca4238a0b923820dcc509a6f75849b',1),
 (3,'Sergio','Rios','sergio.rios@upsam.es','s','c4ca4238a0b923820dcc509a6f75849b',0),
 (4,'Pedro','Alonso','palonso@gmail.com','p','c4ca4238a0b923820dcc509a6f75849b',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
