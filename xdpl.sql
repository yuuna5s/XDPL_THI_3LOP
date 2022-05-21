-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2022 at 10:27 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `xdpl`
--

-- --------------------------------------------------------

--
-- Table structure for table `cathi`
--

CREATE TABLE `cathi` (
  `idcathi` varchar(12) NOT NULL,
  `giothi` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cathi`
--

INSERT INTO `cathi` (`idcathi`, `giothi`) VALUES
('CA1', '09:00:00'),
('CA2', '14:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `diem`
--

CREATE TABLE `diem` (
  `idthisinh` varchar(12) NOT NULL,
  `idkhoathi` varchar(12) NOT NULL,
  `nghe` double DEFAULT NULL,
  `noi` double DEFAULT NULL,
  `doc` double DEFAULT NULL,
  `viet` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diem`
--

INSERT INTO `diem` (`idthisinh`, `idkhoathi`, `nghe`, `noi`, `doc`, `viet`) VALUES
('TS00001', 'KT001', 10, 2, 0, 0),
('TS00002', 'KT001', 10, 0, 0, 0),
('TS00005', 'KT001', NULL, NULL, NULL, NULL),
('TS00009', 'KT001', NULL, NULL, NULL, NULL),
('TS00012', 'KT001', NULL, NULL, NULL, NULL),
('TS00016', 'KT001', NULL, NULL, NULL, NULL),
('TS00019', 'KT001', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `khoathi`
--

CREATE TABLE `khoathi` (
  `idkhoathi` varchar(12) NOT NULL,
  `tenkhoathi` text CHARACTER SET utf8 DEFAULT NULL,
  `ngaythi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khoathi`
--

INSERT INTO `khoathi` (`idkhoathi`, `tenkhoathi`, `ngaythi`) VALUES
('KT001', 'Khóa thi 01', '2022-02-01'),
('KT002', 'Khóa thi 02', '2022-02-09'),
('KT003', 'Khóa thi 03', '2022-03-01');

-- --------------------------------------------------------

--
-- Table structure for table `phongthi`
--

CREATE TABLE `phongthi` (
  `idphongthi` varchar(12) NOT NULL,
  `tenphongthi` text CHARACTER SET utf8 DEFAULT NULL,
  `idtrinhdo` varchar(12) DEFAULT NULL,
  `idkhoathi` varchar(12) DEFAULT NULL,
  `idcathi` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phongthi`
--

INSERT INTO `phongthi` (`idphongthi`, `tenphongthi`, `idtrinhdo`, `idkhoathi`, `idcathi`) VALUES
('P001', 'A2P001', 'A2', 'KT001', 'CA1');

-- --------------------------------------------------------

--
-- Table structure for table `sobaodanh`
--

CREATE TABLE `sobaodanh` (
  `sbd` varchar(12) NOT NULL,
  `idthisinh` varchar(12) NOT NULL,
  `idphongthi` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sobaodanh`
--

INSERT INTO `sobaodanh` (`sbd`, `idthisinh`, `idphongthi`) VALUES
('A2001', 'TS00001', 'P001'),
('A2002', 'TS00002', 'P001'),
('A2003', 'TS00005', 'P001'),
('A2004', 'TS00009', 'P001'),
('A2005', 'TS00012', 'P001'),
('A2006', 'TS00016', 'P001'),
('A2007', 'TS00019', 'P001');

-- --------------------------------------------------------

--
-- Table structure for table `thisinh`
--

CREATE TABLE `thisinh` (
  `idthisinh` varchar(12) NOT NULL,
  `hoten` text CHARACTER SET utf8 DEFAULT NULL,
  `gioitinh` text DEFAULT '0',
  `diachi` text CHARACTER SET utf8 DEFAULT NULL,
  `sdt` tinytext DEFAULT NULL,
  `idtrinhdo` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thisinh`
--

INSERT INTO `thisinh` (`idthisinh`, `hoten`, `gioitinh`, `diachi`, `sdt`, `idtrinhdo`) VALUES
('TS00001', 'Nguyễn Văn A', '1', '123 abc', '0355460710', 'A2'),
('TS00002', 'Nguyễn Văn L', '1', '123 abcd', '0355460710', 'A2'),
('TS00003', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1'),
('TS00004', 'Lê Văn D', '1', '123 ABC', '0355460710', 'B1'),
('TS00005', 'Lê Văn C', '1', '123 ABC', '0355460710', 'A2'),
('TS00006', 'Lê Văn H', '0', '123 ABC', '0355460710', 'B1'),
('TS00007', 'Lê Văn L', '1', '123 ABC', '0355460710', 'B1'),
('TS00008', 'Lê Văn C', '0', '123 ABC', '0355460710', 'B1'),
('TS00009', 'Lê Văn B', '1', '123 ABC', '0355460710', 'A2'),
('TS00010', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1'),
('TS00011', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1'),
('TS00012', 'Lê Văn B', '1', '123 ABC', '0355460710', 'A2'),
('TS00013', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1'),
('TS00014', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1'),
('TS00015', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1'),
('TS00016', 'Lê Văn B', '1', '123 ABC', '0355460710', 'A2'),
('TS00017', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1'),
('TS00018', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1'),
('TS00019', 'Lê Văn B', '1', '123 ABC', '0355460710', 'A2'),
('TS00020', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1'),
('TS00021', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1'),
('TS00022', 'Lê Văn B', '1', '123 ABC', '0355460710', 'B1');

-- --------------------------------------------------------

--
-- Table structure for table `trinhdo`
--

CREATE TABLE `trinhdo` (
  `idtrinhdo` varchar(12) NOT NULL,
  `tentrinhdo` text CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trinhdo`
--

INSERT INTO `trinhdo` (`idtrinhdo`, `tentrinhdo`) VALUES
('A2', 'Chứng chỉ trình độ A2'),
('B1', 'Chứng chỉ trình độ B1'),
('B2', 'Chứng chỉ trình độ B2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cathi`
--
ALTER TABLE `cathi`
  ADD PRIMARY KEY (`idcathi`);

--
-- Indexes for table `diem`
--
ALTER TABLE `diem`
  ADD PRIMARY KEY (`idthisinh`,`idkhoathi`),
  ADD KEY `FK_DIEM_KT` (`idkhoathi`);

--
-- Indexes for table `khoathi`
--
ALTER TABLE `khoathi`
  ADD PRIMARY KEY (`idkhoathi`);

--
-- Indexes for table `phongthi`
--
ALTER TABLE `phongthi`
  ADD PRIMARY KEY (`idphongthi`),
  ADD KEY `FK_PT_TD` (`idtrinhdo`),
  ADD KEY `FK_PT_KT` (`idkhoathi`),
  ADD KEY `FK_PT_CT` (`idcathi`);

--
-- Indexes for table `sobaodanh`
--
ALTER TABLE `sobaodanh`
  ADD PRIMARY KEY (`sbd`,`idthisinh`,`idphongthi`),
  ADD KEY `FK_SBD_TS` (`idthisinh`),
  ADD KEY `FK_SBD_PT` (`idphongthi`);

--
-- Indexes for table `thisinh`
--
ALTER TABLE `thisinh`
  ADD PRIMARY KEY (`idthisinh`),
  ADD KEY `FK_TS_TD` (`idtrinhdo`);

--
-- Indexes for table `trinhdo`
--
ALTER TABLE `trinhdo`
  ADD PRIMARY KEY (`idtrinhdo`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `diem`
--
ALTER TABLE `diem`
  ADD CONSTRAINT `FK_DIEM_KT` FOREIGN KEY (`idkhoathi`) REFERENCES `khoathi` (`idkhoathi`),
  ADD CONSTRAINT `FK_DIEM_TS` FOREIGN KEY (`idthisinh`) REFERENCES `thisinh` (`idthisinh`);

--
-- Constraints for table `phongthi`
--
ALTER TABLE `phongthi`
  ADD CONSTRAINT `FK_PT_CT` FOREIGN KEY (`idcathi`) REFERENCES `cathi` (`idcathi`),
  ADD CONSTRAINT `FK_PT_KT` FOREIGN KEY (`idkhoathi`) REFERENCES `khoathi` (`idkhoathi`),
  ADD CONSTRAINT `FK_PT_TD` FOREIGN KEY (`idtrinhdo`) REFERENCES `trinhdo` (`idtrinhdo`);

--
-- Constraints for table `sobaodanh`
--
ALTER TABLE `sobaodanh`
  ADD CONSTRAINT `FK_SBD_PT` FOREIGN KEY (`idphongthi`) REFERENCES `phongthi` (`idphongthi`),
  ADD CONSTRAINT `FK_SBD_TS` FOREIGN KEY (`idthisinh`) REFERENCES `thisinh` (`idthisinh`);

--
-- Constraints for table `thisinh`
--
ALTER TABLE `thisinh`
  ADD CONSTRAINT `FK_TS_TD` FOREIGN KEY (`idtrinhdo`) REFERENCES `trinhdo` (`idtrinhdo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
