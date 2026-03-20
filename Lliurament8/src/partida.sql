-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 10-04-2025 a las 11:54:08
-- Versión del servidor: 8.0.41-0ubuntu0.20.04.1
-- Versión de PHP: 7.4.3-4ubuntu2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ptd2_miguelAngel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `Partida_id` smallint NOT NULL,
  `Partida_jug_id` smallint NOT NULL,
  `Partida_ganadorjugador` tinyint(1) NOT NULL,
  `Fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `partida`
--

INSERT INTO `partida` (`Partida_id`, `Partida_jug_id`, `Partida_ganadorjugador`, `Fecha`) VALUES
(1, 4, 0, '2025-04-10'),
(2, 4, 0, '2025-04-10'),
(3, 3, 1, '2025-04-08'),
(4, 5, 0, '2025-04-10'),
(5, 6, 0, '2025-04-10'),
(6, 1, 0, '2025-04-10');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`Partida_id`),
  ADD KEY `Partida_jug_id` (`Partida_jug_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `Partida_id` smallint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `partida`
--
ALTER TABLE `partida`
  ADD CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`Partida_jug_id`) REFERENCES `jugadores` (`Jug_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
