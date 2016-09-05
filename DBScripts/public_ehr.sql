-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2016 at 12:46 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `public_ehr`
--

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `session_token` varchar(5000) NOT NULL,
  `id` int(11) UNSIGNED NOT NULL,
  `name` longblob NOT NULL,
  `country` longblob,
  `fatherName` longblob,
  `motherName` longblob,
  `gender` longblob,
  `bloodType` longblob,
  `dob` longblob,
  `disease` longblob,
  `symptoms` longblob,
  `diagnosis` longblob,
  `isUndergoneSurgery` longblob,
  `tempAddress` longblob,
  `permanentAddress` longblob,
  `isEyeSightProblem` longblob,
  `leftEyePower` longblob,
  `rightEyePower` longblob,
  `isHandicapped` longblob,
  `hasPolio` longblob,
  `hasCancer` longblob,
  `cancerType` longblob,
  `hasDiabetis` longblob,
  `hasBloodPressure` longblob,
  `hasSTD` longblob,
  `physician` longblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`session_token`, `id`, `name`, `country`, `fatherName`, `motherName`, `gender`, `bloodType`, `dob`, `disease`, `symptoms`, `diagnosis`, `isUndergoneSurgery`, `tempAddress`, `permanentAddress`, `isEyeSightProblem`, `leftEyePower`, `rightEyePower`, `isHandicapped`, `hasPolio`, `hasCancer`, `cancerType`, `hasDiabetis`, `hasBloodPressure`, `hasSTD`, `physician`) VALUES
('824905-ZBCL2', 2, 0xe393e11a0bb0d9a0d96ee48f91f554e1, 0x4270a2b60394d23cbcab11821e110a3c, 0x1d5b09c5a7ae568ca5a0693158f46c52, 0xce10574e0e8e662947ac742f71d81aea, 0xde1cdad4c9b19aecff23e18cb51ddab2, 0x4f3e2d54bcb72e6d02a1f18890298a65, 0xd1da26d37e81a6359cd782b4c7295515, 0x8ee4f960a32cb485c018541ab0c99c2469698ddf1329e755320493e718e3a5c5, 0x9dd7ecced07726fb3f09a1f29f6df032, 0xef9a7e3c7ff4a8908ed43c75706ab293, 0xd792f225792c1ac887f89f0bc599c9f1, 0xfbb454a7f440e73b60d3d419ffaf9bb7, 0xfbb454a7f440e73b60d3d419ffaf9bb7, 0xd792f225792c1ac887f89f0bc599c9f1, 0xa7298164ce280cdcf6caf3f9865ef35a, 0xa7298164ce280cdcf6caf3f9865ef35a, 0xd792f225792c1ac887f89f0bc599c9f1, 0xd792f225792c1ac887f89f0bc599c9f1, 0xd792f225792c1ac887f89f0bc599c9f1, 0x6dd21a44a7e4509e564ec988437bf080, 0xd792f225792c1ac887f89f0bc599c9f1, 0xd792f225792c1ac887f89f0bc599c9f1, 0xd792f225792c1ac887f89f0bc599c9f1, 0x8f97e21db09fc1428c876377b6403cb7),
('824905-ZBCL2', 3, 0xe393e11a0bb0d9a0d96ee48f91f554e1, 0x4270a2b60394d23cbcab11821e110a3c, 0x1d5b09c5a7ae568ca5a0693158f46c52, 0xce10574e0e8e662947ac742f71d81aea, 0xde1cdad4c9b19aecff23e18cb51ddab2, 0x4f3e2d54bcb72e6d02a1f18890298a65, 0xd1da26d37e81a6359cd782b4c7295515, 0x8ee4f960a32cb485c018541ab0c99c2469698ddf1329e755320493e718e3a5c5, 0x9dd7ecced07726fb3f09a1f29f6df032, 0xef9a7e3c7ff4a8908ed43c75706ab293, 0xd792f225792c1ac887f89f0bc599c9f1, 0xfbb454a7f440e73b60d3d419ffaf9bb7, 0xfbb454a7f440e73b60d3d419ffaf9bb7, 0xd792f225792c1ac887f89f0bc599c9f1, 0xa7298164ce280cdcf6caf3f9865ef35a, 0xa7298164ce280cdcf6caf3f9865ef35a, 0xd792f225792c1ac887f89f0bc599c9f1, 0xd792f225792c1ac887f89f0bc599c9f1, 0xd792f225792c1ac887f89f0bc599c9f1, 0x6dd21a44a7e4509e564ec988437bf080, 0xd792f225792c1ac887f89f0bc599c9f1, 0xd792f225792c1ac887f89f0bc599c9f1, 0xd792f225792c1ac887f89f0bc599c9f1, 0x8f97e21db09fc1428c876377b6403cb7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
