-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 08 mars 2022 à 14:39
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `mahdi`
--

-- --------------------------------------------------------

--
-- Structure de la table `capsule`
--

CREATE TABLE `capsule` (
  `id` int(255) NOT NULL,
  `nomcapsule` varchar(255) NOT NULL,
  `typecapsule` varchar(255) NOT NULL,
  `longcapsule` varchar(255) NOT NULL,
  `programmecapsule` varchar(255) NOT NULL,
  `chemincapsule` varchar(255) NOT NULL,
  `cible` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `capsule`
--

INSERT INTO `capsule` (`id`, `nomcapsule`, `typecapsule`, `longcapsule`, `programmecapsule`, `chemincapsule`, `cible`, `image`) VALUES
(1, 'X203YYq', '2', '12', 'cps', 'cps', 'red', 'C:\\Users\\DELL\\Downloads\\spring\\web_project\\SpringBoot4DS2\\mahdi\\src\\resources\\b.jpg'),
(2, 'X203YYq', '2', '12', 'cps', 'cps', 'red', 'C:\\Users\\DELL\\Downloads\\spring\\web_project\\SpringBoot4DS2\\mahdi\\src\\resources\\IBM.jpg'),
(3, 'titre ', 'https:://www.lien1.com', 'enfant ', 'type', 'long', 'programme', 'C:\\Users\\DELL\\Downloads\\spring\\web_project\\SpringBoot4DS2\\mahdi\\src\\resources\\Linkdin.jpg'),
(4, 'titre ', 'https:://www.lien1.com', 'enfant ', 'type', 'long', 'programme', 'C:\\Users\\DELL\\Downloads\\spring\\web_project\\SpringBoot4DS2\\mahdi\\src\\resources\\b.jpg'),
(5, 'titre ', 'https:://www.lien1.com', 'enfant ', 'type', 'long', 'programme', 'C:\\Users\\DELL\\Downloads\\spring\\web_project\\SpringBoot4DS2\\mahdi\\src\\resources\\b.jpg'),
(6, 'titre ', 'https:://www.lien1.com', 'enfant ', 'type', 'long', 'programme', 'C:\\Users\\DELL\\Downloads\\spring\\web_project\\SpringBoot4DS2\\mahdi\\src\\resources\\b.jpg'),
(7, 'X203YYq', '2', '12', 'cps', 'cps', 'red', 'C:\\Users\\DELL\\Downloads\\spring\\web_project\\SpringBoot4DS2\\mahdi\\src\\resources\\IBM.jpg'),
(9, 'X203YYq', '2', '12', 'cps', 'cps', 'nb', 'C:\\Users\\DELL\\Downloads\\spring\\web_project\\SpringBoot4DS2\\mahdi\\src\\resources\\images.jpg'),
(10, 'X203YYq', '2', '12', 'cps', 'cps', 'nb', 'C:\\Users\\DELL\\Downloads\\spring\\web_project\\SpringBoot4DS2\\mahdi\\src\\resources\\IBM.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `coach`
--

CREATE TABLE `coach` (
  `idcoach` int(255) NOT NULL,
  `nomprenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `coach`
--

INSERT INTO `coach` (`idcoach`, `nomprenom`, `email`, `dob`, `image`) VALUES
(1, 'coach', 'coach', '2022-03-17', 'C:\\\\Users\\\\DELL\\\\Downloads\\\\spring\\\\web_project\\\\SpringBoot4DS2\\\\mahdi\\\\src\\\\resources\\\\ben-affleck.png'),
(2, 'coach', 'email', '2022-03-02', 'C:\\\\Users\\\\DELL\\\\Downloads\\\\spring\\\\web_project\\\\SpringBoot4DS2\\\\mahdi\\\\src\\\\resources\\\\ben-affleck.png'),
(3, 'coach', 'mail', '2022-03-09', 'C:\\\\Users\\\\DELL\\\\Downloads\\\\spring\\\\web_project\\\\SpringBoot4DS2\\\\mahdi\\\\src\\\\resources\\\\ben-affleck.png'),
(4, 'print', 'emil', '2022-03-07', 'C:\\\\Users\\\\DELL\\\\Downloads\\\\spring\\\\web_project\\\\SpringBoot4DS2\\\\mahdi\\\\src\\\\resources\\\\ben-affleck.png'),
(5, 'test', 'test', '2022-03-10', 'C:\\\\Users\\\\DELL\\\\Downloads\\\\spring\\\\web_project\\\\SpringBoot4DS2\\\\mahdi\\\\src\\\\resources\\\\ben-affleck.png');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `capsule`
--
ALTER TABLE `capsule`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `coach`
--
ALTER TABLE `coach`
  ADD PRIMARY KEY (`idcoach`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `capsule`
--
ALTER TABLE `capsule`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `coach`
--
ALTER TABLE `coach`
  MODIFY `idcoach` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
