-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 07-04-2024 a las 09:18:30
-- Versión del servidor: 5.7.28-0ubuntu0.19.04.2
-- Versión de PHP: 7.2.24-0ubuntu0.19.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `padel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `jug_id` int(11) NOT NULL,
  `jug_nom` varchar(50) NOT NULL,
  `jug_edat` tinyint(4) DEFAULT NULL,
  `jug_pai` varchar(3) DEFAULT NULL,
  `jug_nivell` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`jug_id`, `jug_nom`, `jug_edat`, `jug_pai`, `jug_nivell`) VALUES
(1, 'Raul Foguer', 3, 'ESP', 1),
(2, 'Guillem Salvà', 3, 'ESP', 2),
(3, 'Lluis Salvà', 3, 'ESP', 3),
(4, 'Cris Salvà', 3, 'ESP', 4),
(9, 'Pep Foguer', 3, 'ESP', 1),
(10, 'Pep Salvà', 3, 'ESP', 2),
(13, 'Tomás Foguer', 3, 'ESP', 1),
(14, 'Tomás Salvà', 3, 'ESP', 2),
(15, 'Flor Salvà', 3, 'ESP', 3),
(16, 'Regina Salvà', 3, 'ESP', 4),
(17, 'Bep Foguer', 52, 'ESP', 1),
(19, 'Flor Cantany', 4, 'ESP', 3),
(20, 'Regina Majoral', 52, 'ESP', 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`jug_id`),
  ADD UNIQUE KEY `jug_nom` (`jug_nom`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `jug_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
