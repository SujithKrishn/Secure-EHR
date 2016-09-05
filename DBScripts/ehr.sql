-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2016 at 12:45 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ehr`
--

-- --------------------------------------------------------

--
-- Table structure for table `fga`
--

CREATE TABLE `fga` (
  `id` int(11) NOT NULL,
  `groupId` int(11) NOT NULL,
  `columnNames` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fga`
--

INSERT INTO `fga` (`id`, `groupId`, `columnNames`) VALUES
(20, 6, 'fatherName'),
(22, 6, 'gender'),
(19, 6, 'country'),
(21, 6, 'motherName'),
(17, 6, 'id'),
(18, 6, 'name'),
(23, 6, 'bloodType'),
(24, 8, 'id'),
(25, 8, 'name'),
(26, 8, 'isEyeSightProblem'),
(27, 8, 'leftEyePower'),
(28, 8, 'rightEyePower'),
(29, 9, 'hasCancer'),
(30, 9, 'id'),
(31, 9, 'name'),
(32, 9, 'cancerType');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `loginId` int(10) UNSIGNED NOT NULL,
  `loginName` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `groupId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`loginId`, `loginName`, `password`, `groupId`) VALUES
(1, 'suji', 'suji', 1),
(5, 'Vipin', 'vipin', 7),
(6, 'Shiyas', 'shiyas', 6),
(7, 'Harsha', 'Harsha', 8);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  `fatherName` varchar(500) DEFAULT NULL,
  `motherName` varchar(500) DEFAULT NULL,
  `gender` varchar(500) DEFAULT NULL,
  `bloodType` varchar(500) DEFAULT NULL,
  `dob` varchar(500) DEFAULT NULL,
  `disease` varchar(500) DEFAULT NULL,
  `symptoms` varchar(500) DEFAULT NULL,
  `diagnosis` varchar(500) DEFAULT NULL,
  `isUndergoneSurgery` varchar(500) DEFAULT NULL,
  `tempAddress` varchar(500) DEFAULT NULL,
  `permanentAddress` varchar(500) DEFAULT NULL,
  `isEyeSightProblem` varchar(500) DEFAULT NULL,
  `leftEyePower` varchar(500) DEFAULT NULL,
  `rightEyePower` varchar(500) DEFAULT NULL,
  `isHandicapped` varchar(500) DEFAULT NULL,
  `hasPolio` varchar(500) DEFAULT NULL,
  `hasCancer` varchar(500) DEFAULT NULL,
  `cancerType` varchar(500) DEFAULT NULL,
  `hasDiabetis` varchar(500) DEFAULT NULL,
  `hasBloodPressure` varchar(500) DEFAULT NULL,
  `hasSTD` varchar(500) DEFAULT NULL,
  `physician` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `name`, `country`, `fatherName`, `motherName`, `gender`, `bloodType`, `dob`, `disease`, `symptoms`, `diagnosis`, `isUndergoneSurgery`, `tempAddress`, `permanentAddress`, `isEyeSightProblem`, `leftEyePower`, `rightEyePower`, `isHandicapped`, `hasPolio`, `hasCancer`, `cancerType`, `hasDiabetis`, `hasBloodPressure`, `hasSTD`, `physician`) VALUES
(11, 'Maharajan', 'India', '', '', 'Male', 'A+', '', 'Airborne disease', 'chest pain', '', 'Yes', '', '', 'No', '', '', 'No', 'No', 'No', 'NA', 'No', 'No', 'No', 'suji'),
(14, 'Sabari', 'France', 'Survesh', 'Savithiri', 'Female', 'O+', '1987-12-08', 'Lifestyle disease', 'fever', 'NO', 'No', '34,kamanhalli', '34,kamanhalli', 'No', '', '', 'No', 'No', 'No', 'NA', 'No', 'No', 'No', 'vikas'),
(15, 'Ramu', 'India', 'Raghav', 'veena', 'Male', 'A+', '', 'Rare disease', 'nausea', 'NO', 'No', '56,veerah st', '56,veerah st', 'No', '', '', 'Yes', 'Yes', 'Yes', 'Bladder cancer ', 'Yes', 'Yes', 'Yes', 'suji'),
(16, 'Maharajan', 'India', 'Rajan', 'Rani', 'Male', 'A+', '1989-12-04', 'Contagious disease', 'chest pain', 'NO', 'Yes', '345,reen st,Chennai', '345,reen st,Chennai', 'Yes', '0.5', '0.7', 'No', 'No', 'No', 'NA', 'Yes', 'Yes', 'No', 'Vipin');

-- --------------------------------------------------------

--
-- Table structure for table `user_group`
--

CREATE TABLE `user_group` (
  `groupId` int(11) NOT NULL,
  `groupName` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_group`
--

INSERT INTO `user_group` (`groupId`, `groupName`) VALUES
(1, 'Admin'),
(5, 'Doctor'),
(6, 'Nurse'),
(7, 'General Physician'),
(8, 'Eye Doctor'),
(9, 'Specialist');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fga`
--
ALTER TABLE `fga`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`loginId`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_group`
--
ALTER TABLE `user_group`
  ADD PRIMARY KEY (`groupId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fga`
--
ALTER TABLE `fga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `loginId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `user_group`
--
ALTER TABLE `user_group`
  MODIFY `groupId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
