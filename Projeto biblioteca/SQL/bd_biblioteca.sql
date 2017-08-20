-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 01-Jun-2017 às 16:17
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_biblioteca`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `obras`
--

CREATE TABLE `obras` (
  `Titulo` bigint(20) UNSIGNED NOT NULL,
  `codAssunto` int(11) NOT NULL,
  `codEditora` int(11) NOT NULL,
  `codAutor` int(11) NOT NULL,
  `anoPublicacao` varchar(4) NOT NULL,
  `ISBN` varchar(255) NOT NULL,
  `codGenero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `nome` varchar(100) NOT NULL,
  `codPessoa` int(11) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `codTipoPessoa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipoutilitario`
--

CREATE TABLE `tipoutilitario` (
  `codTipoUtilitario` int(20) UNSIGNED NOT NULL,
  `tipoUtilitario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipoutilitario`
--

INSERT INTO `tipoutilitario` (`codTipoUtilitario`, `tipoUtilitario`) VALUES
(1, 'Assunto'),
(2, 'Genero'),
(3, 'Autor'),
(4, 'Editora'),
(7, 'Tipo pessoa');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `codUsuario` bigint(20) UNSIGNED NOT NULL,
  `userNeme` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `utilitarios`
--

CREATE TABLE `utilitarios` (
  `codUtilitario` int(11) NOT NULL,
  `utilitario` varchar(255) NOT NULL,
  `codTipoUtilirario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `utilitarios`
--

INSERT INTO `utilitarios` (`codUtilitario`, `utilitario`, `codTipoUtilirario`) VALUES
(1, 'Direito Civil', 1),
(2, 'Direito Trabalho', 1),
(3, 'Filozofia', 1),
(4, 'Administração', 1),
(5, 'Direito penal', 1),
(6, 'Literatura', 2),
(7, 'Martim claret', 4),
(8, 'Abril', 4),
(9, 'Leya', 4),
(10, 'Ficção', 2),
(11, 'Terror', 2),
(12, 'Direito', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `obras`
--
ALTER TABLE `obras`
  ADD PRIMARY KEY (`Titulo`),
  ADD UNIQUE KEY `codObra` (`Titulo`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`codPessoa`);

--
-- Indexes for table `tipoutilitario`
--
ALTER TABLE `tipoutilitario`
  ADD PRIMARY KEY (`codTipoUtilitario`),
  ADD UNIQUE KEY `codTipoUtilitario_2` (`codTipoUtilitario`),
  ADD UNIQUE KEY `codTipoUtilitario` (`codTipoUtilitario`) USING BTREE;

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD UNIQUE KEY `codUsuario` (`codUsuario`),
  ADD UNIQUE KEY `codUsuario_2` (`codUsuario`);

--
-- Indexes for table `utilitarios`
--
ALTER TABLE `utilitarios`
  ADD PRIMARY KEY (`codUtilitario`),
  ADD UNIQUE KEY `codUtilitario` (`codUtilitario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `obras`
--
ALTER TABLE `obras`
  MODIFY `Titulo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tipoutilitario`
--
ALTER TABLE `tipoutilitario`
  MODIFY `codTipoUtilitario` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `codUsuario` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
