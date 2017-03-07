-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 07 Mars 2017 à 08:57
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `bdd_sdzee`
--

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(60) NOT NULL,
  `mot_de_passe` char(56) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `date_inscription` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `mot_de_passe`, `nom`, `date_inscription`) VALUES
(1, 'coyote@mail.acme', '7629ae53dbd1743ebbec21bc6bccbf45', 'Coyote', '2017-02-26 17:49:07'),
(2, 'jadorejquery@unefois.be', '0094bcab75591116f732cc180949c16d', 'Thunderseb', '2017-02-26 17:49:07'),
(3, 'jmarc@mail.fr', 'fe9bdba3a8df1a2397a5132b3276457a', 'Jean-Marc', '2017-02-26 22:37:47'),
(5, 'jmarc999@mail.fr', 'fe9bdba3a8df1a2397a5132b3276457a', 'Jean-Marc', '2017-02-26 23:01:18'),
(6, 'jmarc777@mail.fr', 'fe9bdba3a8df1a2397a5132b3276457a', 'Jean-Marc', '2017-02-26 23:10:18'),
(7, 'null', '37a6259cc0c1dae299a7866489dff0bd', 'null', '2017-03-01 00:27:29'),
(8, 'marcel@mail.fr', '98951f4898ab8da14b2c8ff93a953b98', 'Marcel', '2017-03-01 00:28:53');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
