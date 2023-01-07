SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `covid-db`
--

-- --------------------------------------------------------

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `login`, `password`) VALUES
(1, 'user', '$2a$12$ZPeXqNjHJpSq2Roh3M6ViOxd9kBW1kqKKVMfzlQKJqePZ9SpABpYy');

--
-- Contenu de la table `vaccination_center`
--

INSERT INTO `vaccination_center` (`id_center`, `address`, `city`, `name`, `postal_code`) VALUES
(1, 'Place Stan', 'Nancy', 'Oui', '54000'),
(2, 'Place Carnot', 'Nancy', 'NancyV2', '54000'),
(3, 'Vélodrome', 'Vandoeuvre', 'Autre', '54500'),
(4, 'Gare de Metz', 'Metz', 'Centre de la Gare', '57000');