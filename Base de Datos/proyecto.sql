-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-12-2015 a las 18:08:29
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `Codigo` varchar(15) NOT NULL,
  `Cedula` int(11) NOT NULL,
  `Nombres` varchar(40) NOT NULL,
  `Apellidos` varchar(40) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `Sexo` varchar(2) NOT NULL,
  `Celular` int(15) NOT NULL,
  `Telefono` int(15) NOT NULL,
  `Fecha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`Codigo`, `Cedula`, `Nombres`, `Apellidos`, `Direccion`, `Correo`, `Sexo`, `Celular`, `Telefono`, `Fecha`) VALUES
('JAM_CL0001', 906954573, 'Vicente Abel', 'Sanchez Pluas', 'Cdla. Alegria Mz. 205 V. 10', 'sanchezvicente81@yahoo.com', 'M', 984297645, 2120656, '07/11/2015'),
('JAM_CL0002', 949875655, 'Carla Liliana', 'Marquez Cabrera', 'Las Acacias ', 'carla.liliana@gmail.com', 'F', 956856456, 2165498, '07/11/2015'),
('JAM_CL0003', 1311686172, 'Yadira Monserrate', 'Montes Borrero', 'Calle Eloy ALfaro', 'yadirita83@gmail.com', 'F', 956452321, 2156457, '07/12/2015'),
('JAM_CL0004', 982657877, 'Benito Manuel', 'Cazal Pluas', 'Las Acacias', 'Benito@yahoo.com', 'M', 986574578, 2154678, '22/12/2015');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_factura`
--

CREATE TABLE IF NOT EXISTS `detalle_factura` (
  `Num_Factura` varchar(30) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `Nom_Pro` varchar(50) NOT NULL,
  `cantidad` int(15) NOT NULL,
  `Precio_Unit` float NOT NULL,
  `Total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE IF NOT EXISTS `facturas` (
  `Num_Fac` varchar(30) NOT NULL,
  `CI` int(11) NOT NULL,
  `Fecha` varchar(15) NOT NULL,
  `Hora` varchar(15) NOT NULL,
  `Subtotal` float NOT NULL,
  `Iva` float NOT NULL,
  `Total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formulario`
--

CREATE TABLE IF NOT EXISTS `formulario` (
  `Nombres` text NOT NULL,
  `Apellidos` text NOT NULL,
  `Fecha_nac` date NOT NULL,
  `Cedula` int(11) NOT NULL,
  `Telefono` int(10) NOT NULL,
  `Celular` int(10) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `Usuario` varchar(10) NOT NULL,
  `Contraseña` varchar(15) NOT NULL,
  `Sexo` text NOT NULL,
  `Tipo_Usuario` text NOT NULL,
  `Correo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `formulario`
--

INSERT INTO `formulario` (`Nombres`, `Apellidos`, `Fecha_nac`, `Cedula`, `Telefono`, `Celular`, `Direccion`, `Usuario`, `Contraseña`, `Sexo`, `Tipo_Usuario`, `Correo`) VALUES
('Carlos Alberto', 'Zambrano Arias', '1998-12-04', 543453453, 2152445, 98565854, 'Cdla.Urdesa', 'CarlosAza', 'Carlitos', 'M', 'Empleado', 'Carlosalbert@hotmail.com'),
('Anthony JosuE', 'Sanchez Borrero', '1998-10-07', 923643399, 2120656, 969643430, 'Km 8 1/2 via a Daule', 'Anthony98', 'micontraseña', 'M', 'Administrador', 'anthonyjosue3@gmail.com'),
('Michael Jhonatan', 'Perez Pin', '1998-07-13', 956236562, 21565557, 98685654, 'La prosperina', 'Dexxtronex', '261004', 'M', 'Administrador', 'michaelperezpin@hotmail.com'),
('Adrian Jesus', 'Davila', '1994-12-08', 965658265, 245454, 5435354, 'la alegria', 'adrianrk8', 'gordilin', 'M', 'Empleado', 'adrian@hotmail.com'),
('Cecilia Monserrate', 'Borrero Zamora', '1967-06-14', 1304584814, 2120656, 994343411, 'Cdla. Alegria Mz. 205 V. 10', 'cecilia67', 'cecilita', 'F', 'Empleado', 'cecilita.1967@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE IF NOT EXISTS `pedidos` (
  `Codigo` varchar(15) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Proveedor` varchar(45) NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  `Fecha_Ped` varchar(11) NOT NULL,
  `Fecha_Entrega` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`Codigo`, `Nombre`, `Cantidad`, `Proveedor`, `Descripcion`, `Fecha_Ped`, `Fecha_Entrega`) VALUES
('JAM_PED0001', 'galletas', 45, 'Isaac', 'oreo 50\nricas 25\nmuecas 59', '22/12/2015', '06/1/2016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE IF NOT EXISTS `proveedores` (
  `Codigo` varchar(25) NOT NULL,
  `Nombre` varchar(25) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Telefono` int(20) DEFAULT NULL,
  `Correo` varchar(50) DEFAULT NULL,
  `Productos` varchar(200) DEFAULT NULL,
  `Celular` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`Codigo`, `Nombre`, `Direccion`, `Telefono`, `Correo`, `Productos`, `Celular`) VALUES
('JAM_PROV0001', 'Don Lucho', 'Calle', 21256554, 'donlucho@gmail.com', 'zapatos', 212102),
('JAM_PROV0002', 'Toni', 'Guayaquil', 12125122, 'tony@toni.com', 'yogurth', 94643354),
('JAM_PROV0003', 'Don Colon', 'manta', 12241, 'doncolon@hotmail.com', 'tacos - plataforma', 12215415),
('JAM_PROV0004', 'Isaac', 'guayaquil', 212124212, 'isaaac@gmail.com', 'nada', 12061215);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ultimo_numero`
--

CREATE TABLE IF NOT EXISTS `ultimo_numero` (
  `Clientes` int(11) NOT NULL,
  `Formulario` int(11) NOT NULL,
  `Pedidos` int(11) NOT NULL,
  `Proveedores` int(11) NOT NULL,
  `Factura` int(11) NOT NULL,
  `Mercaderia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ultimo_numero`
--

INSERT INTO `ultimo_numero` (`Clientes`, `Formulario`, `Pedidos`, `Proveedores`, `Factura`, `Mercaderia`) VALUES
(5, 1, 2, 5, 1, 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `formulario`
--
ALTER TABLE `formulario`
  ADD PRIMARY KEY (`Cedula`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`Codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
