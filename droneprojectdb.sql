-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 28, 2022 at 02:27 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `droneprojectdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `drone`
--

CREATE TABLE IF NOT EXISTS `drone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `battery_capacity` int(11) DEFAULT NULL,
  `modelweight` varchar(255) DEFAULT NULL,
  `serialnumber` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `drone`
--

INSERT INTO `drone` (`id`, `name`, `battery_capacity`, `modelweight`, `serialnumber`, `state`, `weight`) VALUES
(1, 'FirstDrone', 100, 'Heavyweight', '123456', 'IDLE', 400),
(2, 'Second Drone', 100, 'Cruiserweight', 'fGE0BnLGqz', 'IDLE', 300);

-- --------------------------------------------------------

--
-- Table structure for table `droneadded`
--

CREATE TABLE IF NOT EXISTS `droneadded` (
  `drone_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `medication_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`drone_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `dron_added`
--

CREATE TABLE IF NOT EXISTS `dron_added` (
  `drone_id` bigint(20) NOT NULL,
  `medication_id` bigint(20) NOT NULL,
  PRIMARY KEY (`drone_id`,`medication_id`),
  KEY `FK10678ul89j4eg20vovu32l5ik` (`medication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dron_added`
--

INSERT INTO `dron_added` (`drone_id`, `medication_id`) VALUES
(1, 4),
(1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `medication`
--

CREATE TABLE IF NOT EXISTS `medication` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `medname` varchar(255) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `medication`
--

INSERT INTO `medication` (`id`, `code`, `medname`, `weight`) VALUES
(1, '434R', 'MegProfin', 200),
(2, '434T', 'Topinn', 200),
(4, 'TPb_', 'Taplin', 500),
(5, 'UI234', 'Cprotap', 200),
(7, 'TEH352', 'Patprofin', 700);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dron_added`
--
ALTER TABLE `dron_added`
  ADD CONSTRAINT `FK10678ul89j4eg20vovu32l5ik` FOREIGN KEY (`medication_id`) REFERENCES `medication` (`id`),
  ADD CONSTRAINT `FKlqi6nnkr6qmltitvf4kuihw9c` FOREIGN KEY (`drone_id`) REFERENCES `drone` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
