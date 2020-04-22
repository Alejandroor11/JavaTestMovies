-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para testjavadb
CREATE DATABASE IF NOT EXISTS `testjavadb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `testjavadb`;

-- Volcando estructura para tabla testjavadb.pelicula
CREATE TABLE IF NOT EXISTS `pelicula` (
  `IdPelicula` int(11) NOT NULL AUTO_INCREMENT,
  `Categoria` varchar(50) DEFAULT NULL,
  `Descripcion` text DEFAULT NULL,
  `Estado` int(11) DEFAULT 1,
  `Fecha_registro` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`IdPelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla testjavadb.pelicula: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT IGNORE INTO `pelicula` (`IdPelicula`, `Categoria`, `Descripcion`, `Estado`, `Fecha_registro`) VALUES
	(5, 'Terror', '<strong style="color: #42ff33">Nombre/Descripcion</strong>\r\n<div>\r\nEl guason parte 5\r\n</div>\r\n<div>\r\n&nbsp;\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Imagen</strong>\r\n<div>\r\n<p>\r\n&nbsp;<img src="..//" alt=" " />\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Url Trailer</strong>\r\n<div>\r\n<p>\r\n&nbsp;<a href="https://www.youtube.com/watch?v=lIvpFqNpQx4">https://www.youtube.com/watch?v=lIvpFqNpQx4</a>\r\n</p>\r\n</div>\r\n', 1, '2019-03-18 16:12:57'),
	(6, 'Terror', '<strong style="color: #42ff33">Nombre/Descripcion</strong>\r\n<div>\r\nEl guason parte 1<span style="white-space: pre">	</span>\r\n</div>\r\n<div>\r\n&nbsp;\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Imagen</strong>\r\n<div>\r\n<p>\r\n&nbsp;<img src="/" alt=" " />\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Url Trailer</strong>\r\n<div>\r\n<p>\r\n&nbsp;<a href="https://www.youtube.com/watch?v=lIvpFqNpQx4">https://www.youtube.com/watch?v=lIvpFqNpQx4</a>\r\n</p>\r\n</div>\r\n', 1, '2020-04-18 16:12:57'),
	(7, 'Comedia', '<strong style="color: #42ff33">Nombre/Descripcion</strong>\r\n<div>\r\n<p>\r\n&nbsp;Fast and furious\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Imagen</strong>\r\n<div>\r\n<p>\r\n&nbsp;<img src="/" alt=" " />\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Url Trailer</strong>\r\n<div>\r\n<p>\r\n&nbsp;<a href="https://www.youtube.com/watch?v=lIvpFqNpQx4">https://www.youtube.com/watch?v=lIvpFqNpQx4</a>\r\n</p>\r\n</div>\r\n', 1, '2020-04-18 16:12:58'),
	(15, 'Drama', '<strong style="color: #42ff33">Nombre/Descripcion</strong>\r\n<div>\r\n<p>\r\n&nbsp;El guason Original\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Imagen</strong>\r\n<div>\r\n<p>\r\n&nbsp;<img src="/" alt=" " />\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Url Trailer</strong>\r\n<div>\r\n<p>\r\n&nbsp;<a href="https://www.youtube.com/watch?v=IfB65qjLbwc">https://www.youtube.com/watch?v=IfB65qjLbwc</a>\r\n</p>\r\n</div>\r\n', 1, '2020-04-18 19:07:47'),
	(16, 'Accion', '<strong style="color: #42ff33">Nombre/Descripcion</strong>\r\n<div>\r\n<p>\r\n&nbsp;Batman inicia\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Imagen</strong>\r\n<div>\r\n<p>\r\n&nbsp;<img src="/" alt=" " />\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Url Trailer</strong>\r\n<div>\r\n<p>\r\n&nbsp;<a href="https://www.youtube.com/watch?v=IfB65qjLbwc">https://www.youtube.com/watch?v=IfB65qjLbwc</a>\r\n</p>\r\n</div>\r\n', 1, '2020-04-18 19:57:26'),
	(17, 'Comedia', '<strong style="color: #42ff33">Nombre/Descripcion</strong>\r\n<div>\r\n<p>\r\nParasite\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Imagen</strong>\r\n<div>\r\n<p>\r\n&nbsp;<img src="..//" alt=" " />\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Url Trailer</strong>\r\n<div>\r\n<p>\r\n&nbsp;<a href="https://www.youtube.com/watch?v=IfB65qjLbwc">https://www.youtube.com/watch?v=IfB65qjLbwc</a>\r\n</p>\r\n</div>\r\n', 1, '2020-04-18 22:37:15'),
	(19, 'Accion', '<strong style="color: #42ff33">Nombre/Descripcion</strong>\r\n<div>\r\n<p>\r\n&nbsp;One Upon time In hollywood\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Imagen</strong>\r\n<div>\r\n<p>\r\n&nbsp;<img src="..//" alt=" " />\r\n</p>\r\n</div>\r\n<hr />\r\n<strong style="color: #42ff33">Url Trailer</strong>\r\n<div>\r\n<p>\r\n&nbsp;<a href="https://www.youtube.com/watch?v=IfB65qjLbwc">https://www.youtube.com/watch?v=IfB65qjLbwc</a>\r\n</p>\r\n</div>\r\n', 1, '2020-04-18 23:46:49');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;

-- Volcando estructura para tabla testjavadb.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `IdRol` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla testjavadb.rol: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT IGNORE INTO `rol` (`IdRol`, `Nombre`) VALUES
	(1, 'Administrador'),
	(2, 'Customer'),
	(3, 'Consulta');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para procedimiento testjavadb.sp_pelicula_con_año
DELIMITER //
CREATE PROCEDURE `sp_pelicula_con_año`()
SELECT p.IdPelicula, p.Categoria, p.Descripcion, p.Estado, p.Fecha_registro
FROM pelicula p
WHERE p.Fecha_registro = (SELECT MAX(p.Fecha_registro) FROM pelicula)//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_pelicula_con_año2
DELIMITER //
CREATE PROCEDURE `sp_pelicula_con_año2`()
SELECT *
FROM pelicula p
WHERE p.Fecha_registro = DATE_SUB(YEAR(CURDATE()), INTERVAL 365 DAY)//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_pelicula_con_id
DELIMITER //
CREATE PROCEDURE `sp_pelicula_con_id`(
	IN `idp` INT
)
SELECT p.IdPelicula, p.Categoria, p.Descripcion, p.Estado, p.Fecha_registro
FROM pelicula p
WHERE p.IdPelicula = idp ORDER BY p.Fecha_registro desc//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_pelicula_delete
DELIMITER //
CREATE PROCEDURE `sp_pelicula_delete`(
	IN `idp` INT
)
DELETE FROM pelicula
WHERE IdPelicula = idp//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_pelicula_register
DELIMITER //
CREATE PROCEDURE `sp_pelicula_register`(
	IN `dsc` TEXT,
	IN `cat` VARCHAR(50)
)
INSERT INTO pelicula (Descripcion, Categoria, Estado)
VALUES (dsc,cat, 1)//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_pelicula_update
DELIMITER //
CREATE PROCEDURE `sp_pelicula_update`(
	IN `dsc` TEXT,
	IN `cat` VARCHAR(50),
	IN `idp` INT
)
UPDATE pelicula p
SET p.Descripcion = dsc, p.Categoria = cat, p.Estado= 1
WHERE p.IdPelicula = idp//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_trailer_delete
DELIMITER //
CREATE PROCEDURE `sp_trailer_delete`(
	IN `idt` INT
)
DELETE FROM trailer
WHERE IdTrailer = 'idt'//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_trailer_register
DELIMITER //
CREATE PROCEDURE `sp_trailer_register`(
	IN `url` TEXT
)
INSERT INTO trailer(URL)
VALUES (url)//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_trailer_update
DELIMITER //
CREATE PROCEDURE `sp_trailer_update`(
	IN `url` TEXT
)
UPDATE trailer
SET URL = 'url'//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_usuario_c_id
DELIMITER //
CREATE PROCEDURE `sp_usuario_c_id`(
	IN `idu` INT
)
SELECT u.IdUsuario, u.Documento, u.Usuario, u.Estado
FROM usuario u
WHERE u.IdUsuario = idu//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_usuario_delete
DELIMITER //
CREATE PROCEDURE `sp_usuario_delete`(
	IN `idu` INT
)
DELETE FROM usuario
WHERE IdUsuario='idu'//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_usuario_register
DELIMITER //
CREATE PROCEDURE `sp_usuario_register`(
	IN `nom` VARCHAR(50),
	IN `doc` INT,
	IN `user` VARCHAR(50),
	IN `pass` VARCHAR(50),
	IN `rol` INT
)
INSERT INTO usuario(Nombre, Documento, usuario, Contrasena, Estado, Fecha_registro, idRol)
VALUES (nom, doc, USER, pass, 1, NOW(), rol)//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_usuario_rest_pass
DELIMITER //
CREATE PROCEDURE `sp_usuario_rest_pass`(
	IN `idu` INT
)
update usuario u
SET u.Contrasena=YEAR(CURDATE())
WHERE u.IdUsuario=idu//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_usuario_t_sesion
DELIMITER //
CREATE PROCEDURE `sp_usuario_t_sesion`(
	IN `usa` CHAR(50),
	IN `ctn` CHAR(50)
)
SELECT u.IdUsuario, u.Nombre, u.Documento, u.Usuario, u.Contrasena, r.Nombre, u.Estado,
IF(u.Contrasena = YEAR(curdate()) or CHAR_LENGTH(u.Contrasena) < 30, 'Si', 'No' ) as Cifrar, u.idRol
from usuario u INNER JOIN rol r on r.IdRol = u.idRol
where u.usuario = usa AND u.Contrasena = ctn//
DELIMITER ;

-- Volcando estructura para procedimiento testjavadb.sp_usuario_update
DELIMITER //
CREATE PROCEDURE `sp_usuario_update`(
	IN `nom` VARCHAR(50),
	IN `est` INT,
	IN `con` VARCHAR(50),
	IN `idu` INT
)
UPDATE usuario u
SET u.Nombre = nom, u.Estado = est, u.Contrasena = con
WHERE u.IdUsuario = idu//
DELIMITER ;

-- Volcando estructura para tabla testjavadb.trailer
CREATE TABLE IF NOT EXISTS `trailer` (
  `IdTrailer` int(11) NOT NULL AUTO_INCREMENT,
  `URL` text DEFAULT NULL,
  `IdPelicula` int(11) DEFAULT 0,
  PRIMARY KEY (`IdTrailer`),
  KEY `FK__pelicula` (`IdPelicula`),
  CONSTRAINT `FK__pelicula` FOREIGN KEY (`IdPelicula`) REFERENCES `pelicula` (`IdPelicula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla testjavadb.trailer: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `trailer` DISABLE KEYS */;
/*!40000 ALTER TABLE `trailer` ENABLE KEYS */;

-- Volcando estructura para tabla testjavadb.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) DEFAULT NULL,
  `Documento` int(11) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Contrasena` varchar(50) DEFAULT NULL,
  `Estado` tinyint(4) DEFAULT 1,
  `Fecha_registro` timestamp NULL DEFAULT current_timestamp(),
  `idRol` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`),
  UNIQUE KEY `Documento` (`Documento`),
  UNIQUE KEY `Usuario` (`Usuario`),
  KEY `idRol` (`idRol`),
  CONSTRAINT `idRol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla testjavadb.usuario: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT IGNORE INTO `usuario` (`IdUsuario`, `Nombre`, `Documento`, `Usuario`, `Contrasena`, `Estado`, `Fecha_registro`, `idRol`) VALUES
	(1, 'PruebaUsuario', 1000243, 'Alejandroor', '2b6fec3af92db401aab7f8acefe805c6', 1, '2020-04-17 22:12:48', 1),
	(2, 'UsuarioRevision', 100000, 'judapagon1996@hotmail.es', '2020', 1, '2020-04-18 23:21:21', 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
