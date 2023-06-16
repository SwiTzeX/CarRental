-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: db-eu-02.sparkedhost.us:3306
-- Generation Time: Jun 16, 2023 at 12:37 PM
-- Server version: 10.6.13-MariaDB-1:10.6.13+maria~ubu1804-log
-- PHP Version: 8.1.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `s91924_carRentDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `Notifications`
--

CREATE TABLE `Notifications` (
  `idN` int(11) NOT NULL,
  `idU` int(11) DEFAULT NULL,
  `title` varchar(254) DEFAULT NULL,
  `content` varchar(254) DEFAULT NULL,
  `read` tinyint(1) DEFAULT NULL,
  `date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Notifications`
--

INSERT INTO `Notifications` (`idN`, `idU`, `title`, `content`, `read`, `date`) VALUES
(51, 48, 'Reservation', 'Your reservation has been approved', 1, '2023-06-07 16:23:26'),
(52, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \n', 1, '2023-06-07 16:46:47'),
(53, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nTextArea@3b5c09e9[styleClass=text-input text-area]', 1, '2023-06-07 16:59:16'),
(54, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nThis is bullshit', 1, '2023-06-07 17:01:20'),
(55, 48, 'Reservation', 'Your reservation has been approved', 1, '2023-06-07 17:03:15'),
(56, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \ndfghksjdbvlksdnvpiwks', 1, '2023-06-07 17:04:03'),
(57, 48, 'Reservation', 'Your reservation has been approved', 1, '2023-06-07 17:28:09'),
(58, 50, 'Reservation', 'Your reservation for Ferrari F430 has been refused for thr following reason : \nkdfjhskjfbskdjfvnskjdvnksj', 1, '2023-06-07 17:28:38'),
(59, 48, 'Reservation', 'Your reservation has been approved', 1, '2023-06-07 17:30:48'),
(60, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \n.kdjfnvbksdjfvbnlsdkjfbvsdlkhfjvb', 1, '2023-06-07 17:31:16'),
(61, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nheheh', 1, '2023-06-07 17:37:49'),
(62, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nmhg', 1, '2023-06-07 17:38:36'),
(63, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \njhgkhgc', 1, '2023-06-07 17:44:07'),
(64, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nhhhhhhh', 1, '2023-06-07 17:46:50'),
(65, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nkmhjbghgvghjvjhvjhhigliuh', 1, '2023-06-07 17:48:19'),
(66, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nhahaha ana mklkha', 1, '2023-06-07 17:50:01'),
(67, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nasdfghjkl;', 1, '2023-06-07 17:50:30'),
(68, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nqwertyuiop', 1, '2023-06-07 17:52:16'),
(69, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nhksdfvdfjkh', 1, '2023-06-07 17:53:35'),
(70, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nhgf', 1, '2023-06-07 17:55:35'),
(71, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nkughfyhg', 1, '2023-06-07 17:56:08'),
(72, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nsdfghjk', 1, '2023-06-07 17:56:43'),
(73, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nqwertyuiop', 1, '2023-06-07 18:00:25'),
(74, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \ndtytghjds', 1, '2023-06-07 18:04:03'),
(75, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nldjfbjhb', 1, '2023-06-07 18:05:07'),
(76, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nhgfghfghjghjghk', 1, '2023-06-07 18:07:09'),
(77, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nb3d mni', 1, '2023-06-07 18:14:16'),
(78, 50, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nuyyghjvgyujhyghujyghuj', 1, '2023-06-07 18:14:57'),
(79, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nkhgfhjcg', 1, '2023-06-07 18:18:02'),
(80, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nnvskl', 1, '2023-06-07 18:18:52'),
(81, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nkjhfghfgj', 1, '2023-06-07 18:20:35'),
(82, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nffgjkluhk', 1, '2023-06-07 18:22:01'),
(83, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nsadas', 1, '2023-06-07 18:29:28'),
(84, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nasdsa', 1, '2023-06-07 18:30:35'),
(85, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nasdsa', 1, '2023-06-07 18:32:03'),
(86, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nsddss', 1, '2023-06-07 18:42:47'),
(87, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \njkhsdfilwehfjh', 1, '2023-06-07 18:46:57'),
(88, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nksjhdfhkj', 1, '2023-06-07 18:47:09'),
(89, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nkjsdhvc', 1, '2023-06-07 18:52:48'),
(90, 48, 'Reservation', 'Your reservation has been approved', 1, '2023-06-07 18:53:41'),
(91, 48, 'Reservation', 'Your reservation has been approved', 1, '2023-06-07 19:03:24'),
(92, 48, 'Reservation', 'Your reservation for Volkswagen Touareghas been approved', 1, '2023-06-07 19:08:33'),
(93, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for thr following reason : \nThis is bullshit', 1, '2023-06-07 19:09:20'),
(94, 50, 'Reservation', 'Your reservation for Ferrari F430has been approved', 1, '2023-06-07 21:16:13'),
(95, 50, 'Reservation', 'Your reservation for Ferrari F430has been approved', 1, '2023-06-07 22:37:56'),
(96, 48, 'Reservation', 'Your reservation for Volkswagen Touareghas been approved', 1, '2023-06-08 13:56:07'),
(97, 50, 'Reservation', 'Your reservation for Ferrari F430has been approved', 1, '2023-06-08 13:56:35'),
(98, 48, 'Reservation', 'Your reservation for Volkswagen Touareghas been approved', 1, '2023-06-09 22:02:43'),
(99, 48, 'Reservation', 'Your reservation for Ferrari F430has been approved', 1, '2023-06-10 01:36:25'),
(100, 48, 'Reservation', 'Your reservation for Volkswagen Touareg has been refused for the following reason : \ntiming', 1, '2023-06-10 20:00:46'),
(101, 48, 'Reservation', 'Your reservation for Ferrari F430has been approved', 1, '2023-06-11 16:21:29'),
(102, 48, 'Reservation', 'Your reservation for Volkswagen Golf will be pending until it is approved.', 1, '2023-06-11 20:23:37'),
(103, 48, 'Reservation', 'Your reservation for Volkswagen Golfhas been approved', 1, '2023-06-11 20:34:49'),
(104, 48, 'Reservation', 'Your reservation for Ferrari F430 has been approved.', 1, '2023-06-12 02:24:12'),
(105, 48, 'Reservation', 'Your reservation for Ferrari F430 has finished for the following reason : \n', 1, '2023-06-12 02:43:37'),
(106, 48, 'Reservation', 'Your reservation for Ferrari 458 has been approved.', 1, '2023-06-12 02:58:30'),
(107, 48, 'Reservation', 'Your reservation for Ferrari 458 has finished for the following reason : \n', 1, '2023-06-12 02:58:34'),
(108, 48, 'Reservation', 'Your reservation for Volkswagen Golf has been Denied for the following reason : \nhh', 1, '2023-06-12 12:35:36'),
(109, 48, 'Reservation', 'Your reservation for Bentley Continental GT will be pending until it is approved.', 1, '2023-06-12 12:46:45'),
(110, 48, 'Reservation', 'Your reservation for Volkswagen Touareg will be pending until it is approved.', 1, '2023-06-12 11:38:49'),
(111, 48, 'Reservation', 'Your reservation for Audi S6 Avant will be pending until it is approved.', 1, '2023-06-12 20:33:52'),
(112, 76, 'Reservation', 'Your reservation for Ferrari 458 will be pending until it is approved.', 0, '2023-06-12 22:58:04'),
(113, 76, 'Reservation', 'Your reservation for Ferrari 458 has been approved.', 0, '2023-06-12 23:13:44'),
(114, 77, 'Reservation', 'Your reservation for Volkswagen Golf will be pending until it is approved.', 1, '2023-06-12 23:35:11'),
(115, 77, 'Reservation', 'Your reservation for Volkswagen Golf has been approved.', 1, '2023-06-12 23:37:48'),
(116, 48, 'Reservation', 'Your reservation for BMW M5 will be pending until it is approved.', 1, '2023-06-13 00:51:32'),
(117, 48, 'Reservation', 'Your reservation for Volkswagen Touareg will be pending until it is approved.', 1, '2023-06-13 02:39:17'),
(118, 48, 'Reservation', 'Your reservation for Audi S6 Avant has been approved.', 1, '2023-06-13 02:51:42'),
(119, 48, 'Reservation', 'Your reservation for BMW M5 has been approved.', 1, '2023-06-13 02:55:19'),
(120, 48, 'Reservation', 'Your reservation for Ferrari 458 will be pending until it is approved.', 1, '2023-06-13 10:54:04'),
(121, 80, 'Reservation', 'Your reservation for Bentley Continental GT will be pending until it is approved.', 1, '2023-06-13 13:25:52'),
(122, 48, 'Reservation', 'Your reservation for Ferrari 458 has finished for the following reason : \n', 1, '2023-06-13 13:35:30'),
(123, 48, 'Reservation', 'Your reservation for Ferrari 458 has been approved.', 1, '2023-06-13 13:35:36'),
(124, 84, 'Reservation', 'Your reservation for BMW M5 will be pending until it is approved.', 1, '2023-06-15 00:08:14'),
(125, 84, 'Reservation', 'Your reservation for BMW M5 has been approved.', 1, '2023-06-15 00:10:27');

-- --------------------------------------------------------

--
-- Table structure for table `Reservations`
--

CREATE TABLE `Reservations` (
  `idU` int(11) NOT NULL,
  `idV` int(11) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Reservations`
--

INSERT INTO `Reservations` (`idU`, `idV`, `startDate`, `endDate`, `status`) VALUES
(48, 4, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 2),
(48, 4, '2023-06-13 00:00:00', '2023-06-22 00:00:00', 1),
(48, 57, '2023-04-12 00:00:00', '2023-04-22 00:00:00', 2),
(48, 58, '2023-01-12 00:00:00', '2023-02-04 00:00:00', 1),
(48, 58, '2023-05-17 00:00:00', '2023-05-27 00:00:00', 2),
(48, 59, '2023-06-10 00:00:00', '2023-06-10 00:00:00', 1),
(48, 60, '2023-06-01 00:00:00', '2023-06-05 00:00:00', 0),
(48, 60, '2023-06-12 00:00:00', '2023-06-18 00:00:00', -2),
(56, 4, '2022-10-06 19:58:04', '2022-11-06 19:58:09', 2),
(76, 4, '2022-06-12 00:00:00', '2022-06-15 00:00:00', 2),
(77, 8, '2023-07-12 00:00:00', '2023-07-22 00:00:00', 0),
(80, 57, '2023-06-13 00:00:00', '2023-09-01 00:00:00', 0),
(84, 59, '2023-06-15 00:00:00', '2023-06-15 00:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Reviews`
--

CREATE TABLE `Reviews` (
  `idR` int(11) NOT NULL,
  `idU` int(11) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  `comment` varchar(254) DEFAULT NULL,
  `creationDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Reviews`
--

INSERT INTO `Reviews` (`idR`, `idU`, `stars`, `comment`, `creationDate`) VALUES
(14, 68, 3, 'Best Madame Majdoulyne', '2023-06-12 17:36:44'),
(15, 50, 4, 'Best Madame Bassma', '2023-06-12 17:37:00'),
(17, 75, 5, 'madame majdoulyne pls max cc o cf ', '2023-06-12 19:06:39'),
(18, 48, 5, 'i love it', '2023-06-13 00:06:01'),
(19, 77, 5, 'i appreciate the service !', '2023-06-13 00:44:28');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `idU` int(11) NOT NULL,
  `nid` varchar(254) DEFAULT NULL,
  `email` varchar(254) DEFAULT NULL,
  `phoneNumber` varchar(254) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `fullname` varchar(254) DEFAULT NULL,
  `password` varchar(254) DEFAULT NULL,
  `creationDate` datetime NOT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`idU`, `nid`, `email`, `phoneNumber`, `status`, `age`, `fullname`, `password`, `creationDate`, `isAdmin`) VALUES
(48, 'XA1366', 'ABDELFATTAHHANAFI@gmail.com', '661293728', 0, 25, 'abdelfattah hanafi', 'gtkkog/TtVrZfFQdm5vsfw==', '2023-06-06 00:00:00', 1),
(50, 'SADSA1', 'sadsa@gmail.com', '610523355', 1, 25, 'Souhail Elkhayati', 'NBkFWqtOPIgCKWyFwLJ4MQ==', '2023-06-06 00:00:00', 0),
(53, 'DJZO', 'haha@hehe.com', '504020505', 0, 76, 'abdelfattah hanafi', 'hjvyZ21netCJg+xkcsQH2A==', '2023-06-07 00:00:00', 0),
(56, 'xa8888888', '8888@gmail.com', '661293728', 0, NULL, 'abdelfattah hanafi', 'ZZXFIpytdu4TPT8wD+oJQg==', '2023-06-07 00:00:00', 0),
(61, 'wqeqwe', 'sadsa@gmail.com', '661293728', 0, NULL, 'sadasd', 'IUN51eQnHowZ7pmfEXapzw==', '2023-06-10 16:31:27', 0),
(64, 'sddsc', 'ssssqa@gmail.com', '661293728', 1, NULL, 'sdsadsad', '+M79dP4208D61g6S+0Ofjg==', '2023-06-10 16:42:27', 0),
(68, 'test', 'test@gmail.com', '661293728', 0, 25, 'Malak Fatara', '+2++sDPoG9mDv3YVMMstEw==', '2023-06-10 17:49:42', 0),
(71, 'azerty12', 'anas@gmail.com', '62323232', 0, 20, 'anas chigiri', '9s5akKUyvzgwId2ujBjKLg==', '2023-06-12 13:12:41', 0),
(72, 'ou987', 'anas@uir.com', '9877654', 1, 20, 'test test', 'JKCY2pQBCHxv6lT1qgFAUg==', '2023-06-12 13:14:17', 0),
(73, '45878', 'katokari@gmai.com', '15155', 2, 19, 'anas chj', 'WEMaHgnwyQwadSptfOe+bw==', '2023-06-12 13:24:16', 0),
(74, '119', 'nnhh@gmail.com', '19', 1, 19, 'nn hh', 'WEMaHgnwyQwadSptfOe+bw==', '2023-06-12 13:27:19', 0),
(75, '100', 'abdelilah@zebestinzewest.com', '0616171819', 2, 93, 'abdelilah hanafi', 'ThebeztinzewestHHsha+++=====', '2023-06-12 21:05:52', 0),
(76, 't5zg5f', 'neima.hlou@uir.ac.ma', '0101201201', 0, 22, 'Neima Hlou', 'swzGVF/z95weAAZnnTI3pQ==', '2023-06-12 22:48:08', 0),
(77, 'AZERTY02', 'assou.ibenjellal@gmail.com', '0623232323', 0, 21, 'assou samir', 'cz4+JGs6zRONynBAH/Y1cQ==', '2023-06-12 23:33:56', 0),
(78, 'NJ63GDF', 'malakfatara@gmail.com', '0867543625', 0, 18, 'Malak Fatara', '5IcMAbPanQyLOhf7NgjHlw==', '2023-06-13 00:07:55', 0),
(79, 'NKGD56', 'malak.fatara@uir.ac.ma', '0678765465', 2, 21, 'Malak Fatara', 'pKlOsFkHVuyVwXkJjf7CUA==', '2023-06-13 00:59:04', 0),
(80, 'EQW1234', 'elkhayatisouhail@gmail.com', '0610622143', 2, 21, 'Mehdi Elouadi', 'QOPfvoXfKoDoWHgX4hts/w==', '2023-06-13 13:21:18', 0),
(81, 'LLL5', 'bassma.guermah@uir.ac.ma', '07777', 0, 30, 'bassma guermah', 'Xc1i4k9uEFvdZgsRSvErEA==', '2023-06-13 12:21:43', 0),
(82, 'gdt56', 'hanifimaj@yahoo.fr', '0967545676', 0, 21, 'malak fatara', '5IcMAbPanQyLOhf7NgjHlw==', '2023-06-13 12:23:14', 0),
(83, '123456', 'anas.chj12@gmail.com', '0767120894', 0, 20, 'anas chj', 'WEMaHgnwyQwadSptfOe+bw==', '2023-06-14 21:11:40', 0),
(84, '06', 'mouadmess6@gmail.com', '06', 0, 21, 'mouad hh', 'WEMaHgnwyQwadSptfOe+bw==', '2023-06-14 23:51:14', 0),
(85, '45', 'anas.chajadine@uir.ac.ma', '15', 0, 19, 'anas hhh', 'WEMaHgnwyQwadSptfOe+bw==', '2023-06-15 00:15:18', 0),
(86, 'XA1656', 'sadasd@gmail.com', '0661293728', 0, 18, 'karim hanafi', 'zqjf37x3G7blhrpz5PvzW2cexE7qq8EVnr0YE3SUTj8=', '2023-06-16 13:44:02', 0);

-- --------------------------------------------------------

--
-- Table structure for table `Vehicles`
--

CREATE TABLE `Vehicles` (
  `idV` int(11) NOT NULL,
  `modelName` varchar(254) DEFAULT NULL,
  `color` varchar(254) DEFAULT NULL,
  `disponibility` tinyint(1) DEFAULT NULL,
  `brandName` varchar(254) DEFAULT NULL,
  `vehicleState` tinyint(1) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `type` varchar(254) DEFAULT NULL,
  `passengers` int(11) DEFAULT NULL,
  `fuelType` varchar(254) DEFAULT NULL,
  `gearType` varchar(254) DEFAULT NULL,
  `deposit` float DEFAULT NULL,
  `trunkCapacity` int(11) DEFAULT NULL,
  `maxSpeed` int(11) DEFAULT NULL,
  `horsePower` int(11) DEFAULT NULL,
  `plate` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Vehicles`
--

INSERT INTO `Vehicles` (`idV`, `modelName`, `color`, `disponibility`, `brandName`, `vehicleState`, `price`, `type`, `passengers`, `fuelType`, `gearType`, `deposit`, `trunkCapacity`, `maxSpeed`, `horsePower`, `plate`) VALUES
(4, '458', 'red', 0, 'Ferrari', NULL, 20500, 'Sport', 2, 'Petrol', 'Automatic', 50, 230, 325, 562, 'DSAFD_48'),
(8, 'Golf', 'white', 1, 'Volkswagen', NULL, 450, 'Hatchback', 5, 'Diesel', 'Manual', 15, 380, 190, 240, 'DSAFD_46'),
(57, 'Continental GT', 'blue', 1, 'Bentley', NULL, 16000, 'Coupe', 4, 'Petrol', 'Automatic', 50, 358, 333, 626, 'DSAFD_48'),
(58, 'S6 Avant', 'Metallic Grey', 1, 'Audi', NULL, 5000, 'Wagon', 5, 'Petrol', 'Automatic', 30, 389, 250, 444, 'DSAFD_49'),
(59, 'M5', 'Dark Blue', 0, 'BMW', NULL, 7500, 'Sedan', 5, 'Petrol', 'Automatic', 30, 530, 305, 600, 'DSAFD_56'),
(60, 'Touareg', 'brown', 1, 'Volkswagen', NULL, 900, 'SUV', 5, 'Diesel', 'Automatic', 20, 810, 220, 282, 'DSAFD_51'),
(63, 'Touareg', 'brown', 1, 'Volkswagen', NULL, 900, 'SUV', 5, 'Petrol', 'Manual', 20, 810, 220, 282, 'DSAFD_51'),
(64, 'Continental GT', 'blue', 1, 'Bentley', NULL, 16000, 'Coupe', 4, 'Diesel', 'Automatic', 50, 530, 400, 626, 'DSAFD_48'),
(65, '458', 'red', 1, 'Ferrari', NULL, 20500, 'Sport', 2, 'Petrol', 'Manual', 50, 350, 450, 700, 'DSAFD_48'),
(66, 'M5', 'Dark Blue', 1, 'BMW', NULL, 7500, 'Sedan', 5, 'Diesel', 'Automatic', 30, 530, 305, 600, 'DSAFD_56');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Notifications`
--
ALTER TABLE `Notifications`
  ADD PRIMARY KEY (`idN`),
  ADD KEY `AK_Identifier_1` (`idN`),
  ADD KEY `FK_NOTIFICA_ASSOCIATI_USER` (`idU`);

--
-- Indexes for table `Reservations`
--
ALTER TABLE `Reservations`
  ADD PRIMARY KEY (`idU`,`idV`,`startDate`),
  ADD KEY `FK_RESERVAT_ASSOCIATI_VEHICLE` (`idV`);

--
-- Indexes for table `Reviews`
--
ALTER TABLE `Reviews`
  ADD PRIMARY KEY (`idR`),
  ADD KEY `AK_Identifier_1` (`idR`),
  ADD KEY `FK_REVIEW_ASSOCIATI_USER` (`idU`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`idU`),
  ADD KEY `AK_Identifier_1` (`idU`);

--
-- Indexes for table `Vehicles`
--
ALTER TABLE `Vehicles`
  ADD PRIMARY KEY (`idV`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Notifications`
--
ALTER TABLE `Notifications`
  MODIFY `idN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=126;

--
-- AUTO_INCREMENT for table `Reviews`
--
ALTER TABLE `Reviews`
  MODIFY `idR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `idU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;

--
-- AUTO_INCREMENT for table `Vehicles`
--
ALTER TABLE `Vehicles`
  MODIFY `idV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Notifications`
--
ALTER TABLE `Notifications`
  ADD CONSTRAINT `FK_NOTIFICA_ASSOCIATI_USER` FOREIGN KEY (`idU`) REFERENCES `Users` (`idU`);

--
-- Constraints for table `Reservations`
--
ALTER TABLE `Reservations`
  ADD CONSTRAINT `FK_RESERVAT_ASSOCIATI_USER` FOREIGN KEY (`idU`) REFERENCES `Users` (`idU`),
  ADD CONSTRAINT `FK_RESERVAT_ASSOCIATI_VEHICLE` FOREIGN KEY (`idV`) REFERENCES `Vehicles` (`idV`);

--
-- Constraints for table `Reviews`
--
ALTER TABLE `Reviews`
  ADD CONSTRAINT `FK_REVIEW_ASSOCIATI_USER` FOREIGN KEY (`idU`) REFERENCES `Users` (`idU`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
