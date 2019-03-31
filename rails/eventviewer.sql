-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 08, 2018 at 08:06 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventviewer`
--

-- --------------------------------------------------------

--
-- Table structure for table `CONTA_USUARIO`
--

CREATE TABLE `CONTA_USUARIO` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(40) DEFAULT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `tipoacesso` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `CONTA_USUARIO`
--

INSERT INTO `CONTA_USUARIO` (`matricula`, `nome`, `login`, `senha`, `tipoacesso`) VALUES
(987, NULL, 'user3', 'testepw', '4'),
(12345, NULL, 'newzko', 'svenska7', '3'),
(12346, NULL, 'user2', 'unip1010', '3'),
(12350, 'Tomcat', 'srv', 'srv001', '1'),
(111111, NULL, 'junior', 'unip1010', '2');

-- --------------------------------------------------------

--
-- Table structure for table `ESPACO`
--

CREATE TABLE `ESPACO` (
  `id` int(6) NOT NULL,
  `nome` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ESPACO`
--

INSERT INTO `ESPACO` (`id`, `nome`) VALUES
(11110, 'Rio Jacare-Pepira'),
(11111, 'Alto Caparao'),
(11112, 'Cambara do Sul '),
(1456, 'teste2');

-- --------------------------------------------------------

--
-- Table structure for table `EVENTO`
--

CREATE TABLE `EVENTO` (
  `id` int(6) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `descricao` varchar(280) DEFAULT NULL,
  `palestrante` int(11) NOT NULL,
  `local` int(6) NOT NULL,
  `data` datetime DEFAULT '1900-01-01 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `EVENTO`
--

INSERT INTO `EVENTO` (`id`, `nome`, `descricao`, `palestrante`, `local`, `data`) VALUES
(123456, 'Design Thinking', 'A mesma de sempre', 111111, 11111, '2018-11-01 20:45:00'),
(123457, 'rafting', 'ir ali testar o cardiaco', 12350, 11112, '2018-10-31 19:10:00'),
(123458, 'Emprendedorismo Virtual', 'Do maluco que se acha', 111111, 11112, '2018-11-01 20:45:00'),
(17460476, 'Teste', 'qq coiss', 12346, 11111, '2019-11-19 21:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `PARTICIPANTES`
--

CREATE TABLE `PARTICIPANTES` (
  `id_evento` int(6) NOT NULL,
  `id_pessoa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `PARTICIPANTES`
--

INSERT INTO `PARTICIPANTES` (`id_evento`, `id_pessoa`) VALUES
(123457, 12345),
(123458, 12345),
(123456, 12345);

-- --------------------------------------------------------

--
-- Table structure for table `PESSOA`
--

CREATE TABLE `PESSOA` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `rg` varchar(12) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `cnpj` varchar(15) DEFAULT NULL,
  `status` char(1) NOT NULL,
  `tipo` char(1) NOT NULL,
  `tipo_acesso` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `PESSOA`
--

INSERT INTO `PESSOA` (`matricula`, `nome`, `endereco`, `telefone`, `email`, `rg`, `cpf`, `cnpj`, `status`, `tipo`, `tipo_acesso`) VALUES
(987, 'user3', 'Aquele', '+551134343434', 'jsdhsd@hsms.com', '1342323', NULL, NULL, '1', '1', '4'),
(988, 'user4', 'Rua', '+5511243445', 'qqcoisa@dominio.com', '234565', NULL, NULL, '1', '1', '1'),
(12345, 'Gabriel Tavares ', 'Avenida Paulista, 900', '+55119876432', 'tavares.gabri@gmail.com', '355034402', NULL, NULL, '1', '1', '1'),
(12346, 'User 2', 'Avenida Paulista, 900', '+55119876432', 'user@java.sun.com', '450601936', NULL, NULL, '1', '1', '1'),
(12350, 'Tomcat', 'Avenida Paulista, 900', '+55119876432', 'tom@apache.com', '275466401', NULL, NULL, '1', '1', '1'),
(111111, 'Airton Junior', 'Avenida Paulista, 540', '+55119876433434', 'aquele@dominio.com', '1246792872', NULL, NULL, '4', '2', '3');

-- --------------------------------------------------------

--
-- Table structure for table `STATUS`
--

CREATE TABLE `STATUS` (
  `id` char(1) NOT NULL,
  `descricao` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `STATUS`
--

INSERT INTO `STATUS` (`id`, `descricao`) VALUES
('1', 'Ativo'),
('2', 'Inativo'),
('3', 'Desligado'),
('4', 'Ferias'),
('5', 'Licenca');

-- --------------------------------------------------------

--
-- Table structure for table `TIPO_ACESSO`
--

CREATE TABLE `TIPO_ACESSO` (
  `id` varchar(1) NOT NULL,
  `tipo_emp` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `TIPO_ACESSO`
--

INSERT INTO `TIPO_ACESSO` (`id`, `tipo_emp`) VALUES
('1', 'Admin'),
('2', 'Membro'),
('3', 'Guia'),
('4', 'Visitante');

-- --------------------------------------------------------

--
-- Table structure for table `TIPO_PESSOA`
--

CREATE TABLE `TIPO_PESSOA` (
  `id` char(1) NOT NULL,
  `tipo_pessoa` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `TIPO_PESSOA`
--

INSERT INTO `TIPO_PESSOA` (`id`, `tipo_pessoa`) VALUES
('1', 'PF'),
('2', 'PJ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CONTA_USUARIO`
--
ALTER TABLE `CONTA_USUARIO`
  ADD PRIMARY KEY (`matricula`);

--
-- Indexes for table `EVENTO`
--
ALTER TABLE `EVENTO`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_evento_pessoa_palestrante` (`palestrante`);

--
-- Indexes for table `PESSOA`
--
ALTER TABLE `PESSOA`
  ADD PRIMARY KEY (`matricula`),
  ADD UNIQUE KEY `matricula` (`matricula`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `CONTA_USUARIO`
--
ALTER TABLE `CONTA_USUARIO`
  ADD CONSTRAINT `fk_conta_usuario_pessoa` FOREIGN KEY (`matricula`) REFERENCES `PESSOA` (`matricula`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
