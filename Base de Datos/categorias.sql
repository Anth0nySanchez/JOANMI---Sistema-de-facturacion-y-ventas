-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-01-2016 a las 03:40:42
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `categorias`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lacteos`
--

CREATE TABLE IF NOT EXISTS `lacteos` (
  `Codigo` varchar(25) NOT NULL,
  `Nombre` varchar(20) DEFAULT NULL,
  `Cantidad` int(10) DEFAULT NULL,
  `Proveedor` varchar(20) DEFAULT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `Precio_Unit` float DEFAULT NULL,
  `Dia_Llegada` varchar(10) DEFAULT NULL,
  `Hora_Llegada` varchar(10) DEFAULT NULL,
  `Categoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lacteos`
--

INSERT INTO `lacteos` (`Codigo`, `Nombre`, `Cantidad`, `Proveedor`, `Descripcion`, `Precio_Unit`, `Dia_Llegada`, `Hora_Llegada`, `Categoria`) VALUES
('JAM_MERC0001', 'Yogurt', 33, 'Toni', '', 5.35, '02/11/2015', '23:46:53', 'lacteos'),
('JAM_MERC0004', 'Leche Tony', 19, 'Toni', '', 1.35, '03/11/2015', '12:8:14', 'lacteos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nueva`
--

CREATE TABLE IF NOT EXISTS `nueva` (
  `Codigo` varchar(25) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Cantidad` int(10) NOT NULL,
  `Proveedor` varchar(20) NOT NULL,
  `Precio_Unit` float NOT NULL,
  `Dia_Llegada` varchar(10) NOT NULL,
  `Hora_Llegada` varchar(10) NOT NULL,
  `Categoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefonos`
--

CREATE TABLE IF NOT EXISTS `telefonos` (
  `Codigo` varchar(25) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Cantidad` int(10) NOT NULL,
  `Proveedor` varchar(20) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `Precio_Unit` float NOT NULL,
  `Dia_Llegada` varchar(10) NOT NULL,
  `Hora_Llegada` varchar(10) NOT NULL,
  `Categoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `telefonos`
--

INSERT INTO `telefonos` (`Codigo`, `Nombre`, `Cantidad`, `Proveedor`, `Descripcion`, `Precio_Unit`, `Dia_Llegada`, `Hora_Llegada`, `Categoria`) VALUES
('JAM_MERC0005', 'Sony Xperia z5', 70, 'Toni', 'telefono con buenas caracteristicas', 530, '10/11/2015', '8:31:24', 'telefonos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vestidos`
--

CREATE TABLE IF NOT EXISTS `vestidos` (
  `Codigo` varchar(25) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Cantidad` int(10) NOT NULL,
  `Proveedor` varchar(20) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `Precio_Unit` float NOT NULL,
  `Dia_Llegada` varchar(10) NOT NULL,
  `Hora_Llegada` varchar(10) NOT NULL,
  `Categoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zapato`
--

CREATE TABLE IF NOT EXISTS `zapato` (
  `Codigo` varchar(25) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Cantidad` int(10) NOT NULL,
  `Proveedor` varchar(20) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `Precio_Unit` float NOT NULL,
  `Dia_Llegada` varchar(10) NOT NULL,
  `Hora_Llegada` varchar(10) NOT NULL,
  `Categoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `zapato`
--

INSERT INTO `zapato` (`Codigo`, `Nombre`, `Cantidad`, `Proveedor`, `Descripcion`, `Precio_Unit`, `Dia_Llegada`, `Hora_Llegada`, `Categoria`) VALUES
('JAM_MERC0002', 'Zapato taco Alto', 36, 'Don Colon', '', 10, '02/11/2015', '23:48:15', 'zapato');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `lacteos`
--
ALTER TABLE `lacteos`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `nueva`
--
ALTER TABLE `nueva`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `telefonos`
--
ALTER TABLE `telefonos`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `vestidos`
--
ALTER TABLE `vestidos`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `zapato`
--
ALTER TABLE `zapato`
  ADD PRIMARY KEY (`Codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
