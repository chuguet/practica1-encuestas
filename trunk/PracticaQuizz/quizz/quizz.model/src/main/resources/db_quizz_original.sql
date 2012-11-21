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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Almacena todas las encuestas del sistema';

--
-- Dumping data for table `encuesta`
--

/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Las distintas preguntas que conforman una encuesta';

--
-- Dumping data for table `pregunta`
--

/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Las posibles respuestas asociadas a cada pregunta';

--
-- Dumping data for table `respuesta`
--

/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Almacena los usuarios del sistema';

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
