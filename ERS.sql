-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 28, 2013 at 08:02 PM
-- Server version: 5.5.29
-- PHP Version: 5.4.6-1ubuntu1.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ERS`
--

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE IF NOT EXISTS `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `middle_initial` varchar(5) DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  `street_address_1` varchar(255) DEFAULT NULL,
  `street_address_2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(5) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `primary_phone` varchar(45) DEFAULT NULL,
  `work_phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`id`, `first_name`, `last_name`, `middle_initial`, `email_address`, `street_address_1`, `street_address_2`, `city`, `state`, `zip`, `primary_phone`, `work_phone`) VALUES
(1, 'Greg', 'Adams', 'J', 'gadams@gmail.com', '123 Main St.', NULL, 'Zelienople', 'PA', '16063', '5558974625', '5551234567'),
(2, 'Bob', 'Johnson', 'F', 'bjohnson@gmail.com', '34 Shady Ln.', NULL, 'Cranberry Twp.', 'PA', '16066', '5557894561', '5551234556'),
(3, 'Sue', 'Niece', 'M', 'sniece@gmail.com', '1020 N. Market St.', 'Apt. 3G', 'Evans City', 'MN', '16007', '5559874563', '5551234568'),
(4, 'Mike', 'Eliott', 'S', 'melliot@gmail.com', '188 Kiester Rd.', NULL, 'Butler', 'OH', '16001', '5558213467', '5554567891'),
(5, 'Sam', 'Michaels', 'J', 'smichaels@gmail.com', '2030 Ardmore Blvd.', NULL, 'Butler', 'NY', '90210', '5551346792', '5554567898'),
(6, 'Anthony', 'Tretter', 'J', 'atretter@gmail.com', '2060 Braddock Ave.', NULL, 'Slippery Rock', 'PA', '15219', '5554678125', '5551472583'),
(7, 'Mary', 'McDonald', 'R', 'marymcdonald@gmail.com', 'P.O. Box 23', NULL, 'Harmony', 'PA', '45182', '5556784792', '5557894561'),
(8, 'John', 'Greer', 'J', 'jgreer@gmail.com', '1010 Hollywood Blvd.', NULL, 'Beverly Hills', 'CA', '90123', '5558375929', '4448229834'),
(9, 'Jimmy', 'Barns', 'M', 'jbarns@gmail.com', '471 Market St.', NULL, 'Topeka', 'KS', '54678', '1245678489', '5456843128'),
(10, 'Anna', 'Farrell', 'D', 'afarrell@gmail.com', '849 Rodi Rd.', NULL, 'Atlanta', 'GA', '45678', '5468421388', '7894518534'),
(11, 'Amy', 'Davis', 'E', 'adavis@gmail.com', '738 Beaver Rd.', NULL, 'Harrisburg', 'PA', '15467', '5213658974', '3569852123'),
(12, 'Larry', 'Magness', 'R', 'lmagness@gmail.com', '55 Chestnut St.', NULL, 'Newark', 'NJ', '23658', '8745682658', '3524698575'),
(13, 'Jen', 'Waller', 'P', 'jwaller@gmail.com', '', NULL, '', 'KS', '65487', '4759681235', '4759681235'),
(14, 'Joe', 'Reed', 'F', 'jreed@gmail.com', '', NULL, '', 'ME', '12345', '2653854152', '2653854152'),
(15, 'Shane', 'Wolfe', 'J', 'swolfe@gmail.com', '', NULL, '', 'OR', '89768', '2658749586', '2658749586'),
(16, 'Linda', 'Rimes', 'H', 'lrimes@gmail.com', '', NULL, '', 'ME', '12358', '2314568951', '2314568951'),
(17, 'Deborah', 'Wise', 'N', 'dwise@gmail.com', '', NULL, '', 'TN', '29846', '6985476589', '6985476589'),
(18, 'David', 'Troyer', 'L', 'dtroyer@gmail.com', '', NULL, '', 'CT', '12587', '2356263545', '2356263545'),
(19, 'Russell', 'Parton', 'R', 'rparton@gmail.com', '', NULL, '', 'NV', '59898', '2325685489', '2325685489'),
(20, 'Jerry', 'Fox', 'E', 'jfox@gmail.com', '', NULL, '', 'GA', '36325', '4532587659', '4532587659'),
(21, 'Sara', 'Young', 'W', 'syoung@gmail.com', '', NULL, '', 'LA', '45155', '5578964256', '5578964256'),
(22, 'Hannah', 'Brown', 'Z', 'hbrown@gmail.com', '', NULL, '', 'TX', '64787', '8546789582', '8546789582'),
(23, 'Brad', 'Donahue', 'A', 'bdonahue@gmail.com', '', NULL, '', 'OH', '18184', '2354621235', '2354621235'),
(24, 'Lindsey', 'Adams', 'U', 'ladams@gmail.com', '', NULL, '', 'TX', '69678', '1214546585', '1214546585'),
(25, 'Megan', 'Chase', 'I', 'mchase@gmail.com', '', NULL, '', 'IA', '45487', '5614235845', '5614235845'),
(26, 'Mike', 'Gregory', 'K', 'mgregory@gmail.com', '', NULL, '', 'IN', '21451', '5645788912', '5645788912'),
(27, 'Bill', 'Stewart', 'H', 'bstewart@gmail.com', '', NULL, '', 'WA', '85874', '2351466588', '2351466588');

-- --------------------------------------------------------

--
-- Table structure for table `USERS`
--

CREATE TABLE IF NOT EXISTS `USERS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `USERS`
--

INSERT INTO `USERS` (`id`, `username`, `password`, `admin`) VALUES
(1, 'Kelly', '1234', 0),
(2, 'Kelly', 'smithy', 0),
(3, 'asdfasd', 'adf', 0),
(4, 'adsfasd', 'asdfasdasd', 0),
(5, 'adsfasddsfd', 'asdfasdfasd', 0),
(6, 'asdfasdfdsa', 'adsfad', 0),
(7, 'asdafsdfads', 'asdf', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
