-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2018 at 11:53 PM
-- Server version: 5.5.57-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `SharedService`
--

-- --------------------------------------------------------

--
-- Table structure for table `Department`
--

CREATE TABLE IF NOT EXISTS `Department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE IF NOT EXISTS `Employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Ssn` varchar(10) NOT NULL,
  `first_name` varchar(15) NOT NULL,
  `middle_name` varchar(15) DEFAULT NULL,
  `last_name` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `address_line1` varchar(100) DEFAULT NULL,
  `address_line2` varchar(100) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `state` varchar(15) DEFAULT NULL,
  `zip_code` varchar(10) DEFAULT NULL,
  `email_address` varchar(50) NOT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `department_id` int(10) NOT NULL,
  `manager_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `department_id` (`department_id`),
  KEY `manager_id` (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Manager`
--

CREATE TABLE IF NOT EXISTS `Manager` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Timesheet`
--

CREATE TABLE IF NOT EXISTS `Timesheet` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `hours1` int(1) NOT NULL,
  `task1` varchar(20) NOT NULL,
  `hours2` int(1) NOT NULL,
  `task2` varchar(20) NOT NULL,
  `hours3` int(1) NOT NULL,
  `task3` varchar(20) NOT NULL,
  `hours4` int(1) NOT NULL,
  `task4` varchar(20) NOT NULL,
  `hours5` int(1) NOT NULL,
  `task5` varchar(20) NOT NULL,
  `hours6` int(1) NOT NULL,
  `task6` varchar(20) NOT NULL,
  `hours7` int(1) NOT NULL,
  `task7` varchar(20) NOT NULL,
  `hours8` int(1) NOT NULL,
  `task8` varchar(20) NOT NULL,
  `employee_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Travel`
--

CREATE TABLE IF NOT EXISTS `Travel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ToDate` date NOT NULL,
  `FromDate` date NOT NULL,
  `departure` varchar(20) NOT NULL,
  `arrival` varchar(20) NOT NULL,
  `employee_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Employee`
--
ALTER TABLE `Employee`
  ADD CONSTRAINT `Employee_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `Department` (`id`),
  ADD CONSTRAINT `Employee_ibfk_2` FOREIGN KEY (`manager_id`) REFERENCES `Manager` (`id`);

--
-- Constraints for table `Timesheet`
--
ALTER TABLE `Timesheet`
  ADD CONSTRAINT `Timesheet_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `Employee` (`id`);

--
-- Constraints for table `Travel`
--
ALTER TABLE `Travel`
  ADD CONSTRAINT `Travel_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `Employee` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
