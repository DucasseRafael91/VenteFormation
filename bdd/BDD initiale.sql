-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 05 jan. 2026 à 12:16
-- Version du serveur : 8.4.7
-- Version de PHP : 8.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `vente_formation`
--

-- --------------------------------------------------------

--
-- Structure de la table `est_de_type`
--

DROP TABLE IF EXISTS `est_de_type`;
CREATE TABLE IF NOT EXISTS `est_de_type` (
                                             `e_fk_type_formation` int NOT NULL,
                                             `e_fk_formation` int NOT NULL,
                                             PRIMARY KEY (`e_fk_type_formation`,`e_fk_formation`),
    KEY `e_fk_type_formation` (`e_fk_type_formation`,`e_fk_formation`),
    KEY `e_fk_formation` (`e_fk_formation`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `est_de_type`
--

INSERT INTO `est_de_type` (`e_fk_type_formation`, `e_fk_formation`) VALUES
                                                                        (3, 1),
                                                                        (3, 2),
                                                                        (4, 3);

-- --------------------------------------------------------

--
-- Structure de la table `v_categorie`
--

DROP TABLE IF EXISTS `v_categorie`;
CREATE TABLE IF NOT EXISTS `v_categorie` (
                                             `c_id` int NOT NULL AUTO_INCREMENT,
                                             `c_nom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`c_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `v_categorie`
--

INSERT INTO `v_categorie` (`c_id`, `c_nom`) VALUES
                                                (5, 'Java'),
                                                (6, 'Python'),
                                                (7, 'Anglais'),
                                                (8, 'Maths');

-- --------------------------------------------------------

--
-- Structure de la table `v_client`
--

DROP TABLE IF EXISTS `v_client`;
CREATE TABLE IF NOT EXISTS `v_client` (
                                          `c_id` int NOT NULL AUTO_INCREMENT,
                                          `c_nom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    `c_prenom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    `c_email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    `c_adresse` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
    `c_telephone` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
    `c_fk_utilisateur` int NOT NULL,
    PRIMARY KEY (`c_id`),
    KEY `c_fk_utilisateur` (`c_fk_utilisateur`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `v_client`
--

INSERT INTO `v_client` (`c_id`, `c_nom`, `c_prenom`, `c_email`, `c_adresse`, `c_telephone`, `c_fk_utilisateur`) VALUES
                                                                                                                    (1, 'Dupont', 'Pierrre', 'pierre_dupont@gmail.com', '38 rue des coquelicots', '0612345623', 5),
                                                                                                                    (2, 'Dubois', 'Martin', 'martin_dubois@outlook.fr', '31 rue des jonquilles', '0723675423', 4),
                                                                                                                    (3, 'Dupré', 'Capucine', 'capucine_dupré@gmail.com', '45 rue des lilas', '0563468423', 5);

-- --------------------------------------------------------

--
-- Structure de la table `v_commande`
--

DROP TABLE IF EXISTS `v_commande`;
CREATE TABLE IF NOT EXISTS `v_commande` (
                                            `c_id` int NOT NULL AUTO_INCREMENT,
                                            `c_date` datetime NOT NULL,
                                            `c_fk_client` int NOT NULL,
                                            PRIMARY KEY (`c_id`),
    KEY `c_fk_client` (`c_fk_client`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `v_commande`
--

INSERT INTO `v_commande` (`c_id`, `c_date`, `c_fk_client`) VALUES
                                                               (2, '2026-01-05 12:12:37', 2),
                                                               (3, '2026-01-05 14:12:37', 3);

-- --------------------------------------------------------

--
-- Structure de la table `v_formation`
--

DROP TABLE IF EXISTS `v_formation`;
CREATE TABLE IF NOT EXISTS `v_formation` (
                                             `f_id` int NOT NULL AUTO_INCREMENT,
                                             `f_nom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    `f_description` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `duree_jours` int NOT NULL,
    `prix` double NOT NULL,
    `f_fk_categorie` int NOT NULL,
    PRIMARY KEY (`f_id`),
    KEY `f_fk_categorie` (`f_fk_categorie`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `v_formation`
--

INSERT INTO `v_formation` (`f_id`, `f_nom`, `f_description`, `duree_jours`, `prix`, `f_fk_categorie`) VALUES
                                                                                                          (1, 'Java avancé', 'Cours java avancé', 5, 23, 5),
                                                                                                          (2, 'Python Avancé', 'cours python', 3, 10, 6),
                                                                                                          (3, 'Anglais', 'Cours Anglais', 22, 10.65, 7);

-- --------------------------------------------------------

--
-- Structure de la table `v_ligne_commande`
--

DROP TABLE IF EXISTS `v_ligne_commande`;
CREATE TABLE IF NOT EXISTS `v_ligne_commande` (
                                                  `l_fk_formation` int NOT NULL,
                                                  `l_fk_commande` int NOT NULL,
                                                  PRIMARY KEY (`l_fk_formation`,`l_fk_commande`),
    KEY `l_fk_formation` (`l_fk_formation`,`l_fk_commande`),
    KEY `l_fk_commande` (`l_fk_commande`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `v_ligne_commande`
--

INSERT INTO `v_ligne_commande` (`l_fk_formation`, `l_fk_commande`) VALUES
                                                                       (2, 2),
                                                                       (3, 2),
                                                                       (2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `v_type_formation`
--

DROP TABLE IF EXISTS `v_type_formation`;
CREATE TABLE IF NOT EXISTS `v_type_formation` (
                                                  `t_id` int NOT NULL AUTO_INCREMENT,
                                                  `t_nom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`t_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `v_type_formation`
--

INSERT INTO `v_type_formation` (`t_id`, `t_nom`) VALUES
                                                     (3, 'présentiel'),
                                                     (4, 'distanciel');

-- --------------------------------------------------------

--
-- Structure de la table `v_utilisateur`
--

DROP TABLE IF EXISTS `v_utilisateur`;
CREATE TABLE IF NOT EXISTS `v_utilisateur` (
                                               `u_id` int NOT NULL AUTO_INCREMENT,
                                               `u_identifant` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
    `u_mot_de_passe` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`u_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `v_utilisateur`
--

INSERT INTO `v_utilisateur` (`u_id`, `u_identifant`, `u_mot_de_passe`) VALUES
                                                                           (4, 'pierre40', 'pierre'),
                                                                           (5, 'juju13', 'juliette');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `est_de_type`
--
ALTER TABLE `est_de_type`
    ADD CONSTRAINT `est_de_type_ibfk_1` FOREIGN KEY (`e_fk_formation`) REFERENCES `v_formation` (`f_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `est_de_type_ibfk_2` FOREIGN KEY (`e_fk_type_formation`) REFERENCES `v_type_formation` (`t_id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `v_client`
--
ALTER TABLE `v_client`
    ADD CONSTRAINT `v_client_ibfk_1` FOREIGN KEY (`c_fk_utilisateur`) REFERENCES `v_utilisateur` (`u_id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `v_commande`
--
ALTER TABLE `v_commande`
    ADD CONSTRAINT `v_commande_ibfk_2` FOREIGN KEY (`c_fk_client`) REFERENCES `v_client` (`c_id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `v_formation`
--
ALTER TABLE `v_formation`
    ADD CONSTRAINT `v_formation_ibfk_1` FOREIGN KEY (`f_fk_categorie`) REFERENCES `v_categorie` (`c_id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `v_ligne_commande`
--
ALTER TABLE `v_ligne_commande`
    ADD CONSTRAINT `v_ligne_commande_ibfk_1` FOREIGN KEY (`l_fk_formation`) REFERENCES `v_formation` (`f_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `v_ligne_commande_ibfk_2` FOREIGN KEY (`l_fk_commande`) REFERENCES `v_commande` (`c_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
