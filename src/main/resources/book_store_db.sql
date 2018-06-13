-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2018 at 02:18 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_store_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `authors`
--

CREATE TABLE `authors` (
  `ID` int(11) NOT NULL,
  `FirstName` varchar(100) NOT NULL,
  `LastName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `authors`
--

INSERT INTO `authors` (`ID`, `FirstName`, `LastName`) VALUES
(1, 'Erich Maria', 'Remarque'),
(2, 'Jerome David', 'Salinger'),
(3, 'Agatha', 'Christie'),
(24, 'Tudor', 'Vianu'),
(25, 'Tudor', 'Vianu'),
(26, 'Feodor', 'Dostoievski');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `ID` int(11) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `AuthorID` int(11) NOT NULL,
  `Year` varchar(4) NOT NULL,
  `Genre` enum('war_novel','detective','realistic_fiction') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`ID`, `Title`, `AuthorID`, `Year`, `Genre`) VALUES
(5, 'All Quiet on the Western Front', 1, '1929', 'war_novel'),
(6, 'Arch of Triumph', 1, '1945', 'war_novel'),
(7, 'The Catcher in the Rye', 2, '1951', 'realistic_fiction'),
(8, 'Murder on the Orient Express', 3, '1934', 'detective'),
(31, 'Three Comrades', 1, '1936', 'war_novel'),
(32, 'Three Comrades', 1, '1936', 'war_novel');

-- --------------------------------------------------------

--
-- Table structure for table `book_lang`
--

CREATE TABLE `book_lang` (
  `ID` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `lang_code` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book_lang`
--

INSERT INTO `book_lang` (`ID`, `book_id`, `lang_code`) VALUES
(1, 5, 'ro'),
(2, 5, 'en'),
(3, 6, 'en'),
(5, 8, 'en'),
(51, 7, 'ro');

-- --------------------------------------------------------

--
-- Table structure for table `languages`
--

CREATE TABLE `languages` (
  `Code` varchar(2) NOT NULL,
  `Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `languages`
--

INSERT INTO `languages` (`Code`, `Name`) VALUES
('en', 'English'),
('ro', 'Romanian');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authors`
--
ALTER TABLE `authors`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `AuthorID` (`AuthorID`),
  ADD KEY `GenreID` (`Genre`);

--
-- Indexes for table `book_lang`
--
ALTER TABLE `book_lang`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `book_id` (`book_id`),
  ADD KEY `lang_code` (`lang_code`);

--
-- Indexes for table `languages`
--
ALTER TABLE `languages`
  ADD PRIMARY KEY (`Code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `authors`
--
ALTER TABLE `authors`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `book_lang`
--
ALTER TABLE `book_lang`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `books_ibfk_1` FOREIGN KEY (`AuthorID`) REFERENCES `authors` (`ID`);

--
-- Constraints for table `book_lang`
--
ALTER TABLE `book_lang`
  ADD CONSTRAINT `book_lang_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`ID`),
  ADD CONSTRAINT `book_lang_ibfk_2` FOREIGN KEY (`lang_code`) REFERENCES `languages` (`Code`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
