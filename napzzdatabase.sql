-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: host.docker.internal:4000
-- Generation Time: May 30, 2021 at 04:27 PM
-- Server version: 8.0.21
-- PHP Version: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `napzzdatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `Apartment`
--

CREATE TABLE `Apartment` (
  `apartmentId` int NOT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `apartmentOwner_apartmentOwnerId` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Apartment`
--

INSERT INTO `Apartment` (`apartmentId`, `description`, `city`, `detail`, `province`, `name`, `apartmentOwner_apartmentOwnerId`) VALUES
(1, 'ห้องสตูดิโอ ค่าเช่าเริ่มต้น 6,000บาท ขนาด 25-35 ตรม. มีระเบียงทุกห้อง ภายในห้อง มีเตียงพร้อมที่นอนขนาด6ฟุต, ตู้เสื้อผ้าแบบ Built-in, โต๊ะเครื่องแป้ง, แอร์, เครื่องทำน้ำอุ่น, อ่างอาบน้ำ, บริการเคเบิ้ลทีวี, wi-fi,', 'คลองเตย', '199 ถ. รัชดาภิเษก แขวง คลองเตย ', 'กรุงเทพ', 'หอธวัชล้ำฟ้า Phuket', 6),
(2, 'อพาร์ทเมนท์ใกล้สถานีรถไฟฟ้าใต้ดินเพียง 200เมตรถึงMRTลาดพร้าว ตกแต่งสวยเฟอร์นิเจอร์บิ้วอิน พร้อมทีวีLCD32\" เดินทางสะดวก ความปลอดภัยเข้าออกด้วยระบบคีย์การ์ด รปภ.24ชั่วโมง กล้องวงจรปิด อินเตอร์เน็ตไร้สาย', 'อารีย์', ' 388 ถ. พหลโยธิน แขวง สามเสนใน', 'กรุงเทพ', 'เจริญทรัพย์', 6),
(7, 'อพาร์ทเมนท์ใกล้สถานีรถไฟฟ้าใต้ดินเพียง 200เมตรถึงMRTลาดพร้าว ตกแต่งสวยเฟอร์นิเจอร์บิ้วอิน พร้อมทีวีLCD32\" เดินทางสะดวก ความปลอดภัยเข้าออกด้วยระบบคีย์การ์ด รปภ.24ชั่วโมง กล้องวงจรปิด อินเตอร์เน็ตไร้สาย', 'อารีย์', ' 388 ถ. พหลโยธิน แขวง สามเสนใน', 'กรุงเทพ', 'เจริญทรัพย์ 3333', 6),
(8, 'อพาร์ทเมนท์ใกล้สถานีรถไฟฟ้าใต้ดินเพียง 200เมตรถึงMRTลาดพร้าว ตกแต่งสวยเฟอร์นิเจอร์บิ้วอิน พร้อมทีวีLCD32\" เดินทางสะดวก ความปลอดภัยเข้าออกด้วยระบบคีย์การ์ด รปภ.24ชั่วโมง กล้องวงจรปิด อินเตอร์เน็ตไร้สาย', 'อารีย์', ' 388 ถ. พหลโยธิน แขวง สามเสนใน', 'กรุงเทพ', 'เอ เดอะก๊อด 666', 8);

-- --------------------------------------------------------

--
-- Table structure for table `ApartmentOwner`
--

CREATE TABLE `ApartmentOwner` (
  `apartmentOwnerVerifyStatus` varchar(255) DEFAULT NULL,
  `apartmentOwnerId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ApartmentOwner`
--

INSERT INTO `ApartmentOwner` (`apartmentOwnerVerifyStatus`, `apartmentOwnerId`) VALUES
(NULL, 6),
(NULL, 8);

-- --------------------------------------------------------

--
-- Table structure for table `Apartment_Image`
--

CREATE TABLE `Apartment_Image` (
  `Apartment_apartmentId` int NOT NULL,
  `images_imageId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Apartment_Image`
--

INSERT INTO `Apartment_Image` (`Apartment_apartmentId`, `images_imageId`) VALUES
(1, 9),
(1, 10),
(2, 11),
(2, 12),
(7, 25),
(7, 26),
(8, 34),
(8, 35);

-- --------------------------------------------------------

--
-- Table structure for table `ContractType`
--

CREATE TABLE `ContractType` (
  `contractId` int NOT NULL,
  `contract` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ContractType`
--

INSERT INTO `ContractType` (`contractId`, `contract`) VALUES
(1, 'monthly'),
(2, 'yearly');

-- --------------------------------------------------------

--
-- Table structure for table `Customer`
--

CREATE TABLE `Customer` (
  `customerId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Customer`
--

INSERT INTO `Customer` (`customerId`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `FacilityFeature`
--

CREATE TABLE `FacilityFeature` (
  `facilityId` int NOT NULL,
  `facility` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `FacilityFeature`
--

INSERT INTO `FacilityFeature` (`facilityId`, `facility`) VALUES
(1, 'Two Bed'),
(2, 'Elagant Vantage'),
(3, 'No Smoking'),
(4, 'Air Conditioning');

-- --------------------------------------------------------

--
-- Table structure for table `FacilityFeature_Room`
--

CREATE TABLE `FacilityFeature_Room` (
  `FacilityFeature_facilityId` int NOT NULL,
  `roomList_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(25);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequences`
--

CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hibernate_sequences`
--

INSERT INTO `hibernate_sequences` (`sequence_name`, `next_val`) VALUES
('default', 0);

-- --------------------------------------------------------

--
-- Table structure for table `Image`
--

CREATE TABLE `Image` (
  `imageId` int NOT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Image`
--

INSERT INTO `Image` (`imageId`, `url`) VALUES
(1, 'https://pix6.agoda.net/hotelImages/6024613/-1/0443725487752c48ab6761a3d659d816.jpg?s=1024x768'),
(2, 'https://img.travel.rakuten.co.jp/share/image_up/172054/LARGE/7b1080a5373288e22c687ae72d033d899e18f4c8.47.1.26.2.jpg'),
(3, 'https://www.hotelscombined.dk/himg/ca/5c/81/ice-55077-62978153_3XL-863601.jpg'),
(4, 'https://dmn-dallas-news-prod.cdn.arcpublishing.com/resizer/dn9JmbyHvw0DTUWlpE8V9Z0K4lU=/1660x934/smart/filters:no_upscale()/cloudfront-us-east-1.images.arcpublishing.com/dmn/S4ZX2DV7BZDW5HW54OMMISE4Y4.jpg'),
(5, 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/white-bedroom-ideas-stregis-08-1573683802.jpg'),
(6, 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/white-bedroom-jeannette-fristoe-1559156532.jpg'),
(7, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(8, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(9, 'https://pix6.agoda.net/hotelImages/6024613/-1/0443725487752c48ab6761a3d659d816.jpg?s=1024x768'),
(10, 'https://img.travel.rakuten.co.jp/share/image_up/172054/LARGE/7b1080a5373288e22c687ae72d033d899e18f4c8.47.1.26.2.jpg'),
(11, 'https://www.hotelscombined.dk/himg/ca/5c/81/ice-55077-62978153_3XL-863601.jpg'),
(12, 'https://dmn-dallas-news-prod.cdn.arcpublishing.com/resizer/dn9JmbyHvw0DTUWlpE8V9Z0K4lU=/1660x934/smart/filters:no_upscale()/cloudfront-us-east-1.images.arcpublishing.com/dmn/S4ZX2DV7BZDW5HW54OMMISE4Y4.jpg'),
(13, 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/white-bedroom-ideas-stregis-08-1573683802.jpg'),
(14, 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/white-bedroom-jeannette-fristoe-1559156532.jpg'),
(15, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(16, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(25, 'https://www.hotelscombined.dk/himg/ca/5c/81/ice-55077-62978153_3XL-863601.jpg'),
(26, 'https://dmn-dallas-news-prod.cdn.arcpublishing.com/resizer/dn9JmbyHvw0DTUWlpE8V9Z0K4lU=/1660x934/smart/filters:no_upscale()/cloudfront-us-east-1.images.arcpublishing.com/dmn/S4ZX2DV7BZDW5HW54OMMISE4Y4.jpg'),
(28, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(29, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(30, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(31, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(32, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(33, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(34, 'https://www.hotelscombined.dk/himg/ca/5c/81/ice-55077-62978153_3XL-863601.jpg'),
(35, 'https://dmn-dallas-news-prod.cdn.arcpublishing.com/resizer/dn9JmbyHvw0DTUWlpE8V9Z0K4lU=/1660x934/smart/filters:no_upscale()/cloudfront-us-east-1.images.arcpublishing.com/dmn/S4ZX2DV7BZDW5HW54OMMISE4Y4.jpg'),
(36, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(37, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(38, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(39, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(40, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(41, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(46, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(47, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(56, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(57, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(58, 'https://i.ytimg.com/vi/Yt4yx9veLL4/maxresdefault.jpg'),
(59, 'https://q-xx.bstatic.com/images/hotel/max1024x768/280/280267550.jpg'),
(64, 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/room_starry-night-room12.jpg?alt=media&token=852368d4-3931-427e-9485-ff44381687f3');

-- --------------------------------------------------------

--
-- Table structure for table `LandmarkFeature`
--

CREATE TABLE `LandmarkFeature` (
  `landmarkId` int NOT NULL,
  `landmark` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Reservation`
--

CREATE TABLE `Reservation` (
  `reservationId` int NOT NULL,
  `citizenIdLink` varchar(255) DEFAULT NULL,
  `evidentLink` varchar(255) DEFAULT NULL,
  `signatureLink` varchar(255) DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  `user_userId` int DEFAULT NULL,
  `reservationStatus` varchar(255) DEFAULT NULL,
  `reservationStatus_reservationStatusId` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Reservation`
--

INSERT INTO `Reservation` (`reservationId`, `citizenIdLink`, `evidentLink`, `signatureLink`, `room_id`, `user_userId`, `reservationStatus`, `reservationStatus_reservationStatusId`) VALUES
(7, 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/card_card5.jpg?alt=media&token=b9f4670e-7e50-4581-9a5f-467c2cf18de4', 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/payment_qada4t1gpE3k5o9r15a-o.jpg?alt=media&token=82418fe9-4cfe-4505-a891-7b794b9b5526', NULL, 2, 6, '1', 1),
(12, 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/card_card5.jpg?alt=media&token=5cdc0042-5eda-48de-b094-4c161c7fa3b3', 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/payment_qada4t1gpE3k5o9r15a-o.jpg?alt=media&token=7b0ed0cb-9a5e-460d-ae71-78dee4143a48', NULL, 1, 6, '1', 1),
(13, NULL, NULL, NULL, 3, 6, NULL, 1),
(16, 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/card_Realize%20Diagram%20-%20System%20Architecture.png?alt=media&token=cbfff665-774e-4430-bd3f-2b5f05c039d3', 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/payment_Realize%20Diagram%20-%20System%20Architecture.png?alt=media&token=3f1d4421-91bd-4d94-b652-85412a11836a', 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/contact_Realize%20Diagram%20-%20System%20Architecture.png?alt=media&token=fb3a0d7e-a1a0-4ecf-9a66-ed7471682702', 3, 1, NULL, 1),
(17, 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/card_class-diagram-finalbackend.umlcd.png?alt=media&token=151b7876-6c4b-4d14-8c0e-eccece412880', 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/payment_ERDiagram.png?alt=media&token=979f7e71-687d-4ec5-9a2a-cb23cfe9f7cf', 'https://firebasestorage.googleapis.com/v0/b/napzz-room-reservation.appspot.com/o/contact_class-diagram-finalbackend.umlcd.png?alt=media&token=5f830076-961f-4f90-a052-3aa0926113be', 2, 1, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ReservationStatus`
--

CREATE TABLE `ReservationStatus` (
  `reservationStatusId` int NOT NULL,
  `reservationStatus` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ReservationStatus`
--

INSERT INTO `ReservationStatus` (`reservationStatusId`, `reservationStatus`) VALUES
(2, 'APPROVED'),
(1, 'IN_PROGRESS');

-- --------------------------------------------------------

--
-- Table structure for table `Review`
--

CREATE TABLE `Review` (
  `reviewId` int NOT NULL,
  `comment` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Room`
--

CREATE TABLE `Room` (
  `id` int NOT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `roomName` varchar(255) DEFAULT NULL,
  `apartment_apartmentId` int DEFAULT NULL,
  `contractType_contractId` int DEFAULT NULL,
  `roomStatus_roomStatusId` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Room`
--

INSERT INTO `Room` (`id`, `description`, `city`, `detail`, `province`, `price`, `roomName`, `apartment_apartmentId`, `contractType_contractId`, `roomStatus_roomStatusId`) VALUES
(1, 'ตกแต่งพร้อมเข้าอยู่ บิลอินตู้เสื้อผ้า เตียง โต็ะแต่งตัว แอร์ ทีวี ตู้เย็น เครื่องทำนํ้าอุ่น บริเวณเตรียมอาหารพร้อมซิงค์ล้างจาน จอดรถ1คันต่อห้องไม่คิดค่าบริการ มีรปภ 24 ชม. พร้อมลิฟท์โดยสาร', NULL, NULL, NULL, 2500, 'ห้องสตูดิโอ 45 ตรม.', 1, 1, 1),
(2, 'ห้องหรูขนาดใหญ่ ช่วยสร้าง Productivity ดีๆได้สูง', NULL, NULL, NULL, 4500, 'ห้องลอฟต์ loft กว้างพรีเมี่ยม', 2, 2, 1),
(3, 'Tech Programmer ที่ต้องการแรงบันดาลใจ ห้องหรูขนาดใหญ่ ช่วยสร้าง Productivity ดีๆได้สูง', NULL, NULL, NULL, 4500, 'ห้องผู้บริหารแนว Tech Programmer อัพเดทโดยซัน', 2, 2, 1),
(17, 'Tech Programmer ที่ต้องการแรงบันดาลใจ ห้องหรูขนาดใหญ่ ช่วยสร้าง Productivity ดีๆได้สูง', NULL, NULL, NULL, 4500, 'ห้องผู้บริหารแนว Tech Programmer Panuwat 6666', 8, 2, 1),
(18, 'Tech Programmer ที่ต้องการแรงบันดาลใจ ห้องหรูขนาดใหญ่ ช่วยสร้าง Productivity ดีๆได้สูง', NULL, NULL, NULL, 4500, 'ห้องผู้บริหารแนว Tech Programmer Panuwat 6666', 8, 2, 1),
(22, 'test ultimate', NULL, NULL, NULL, 500, 'super ultimate god room', 8, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `RoomStatus`
--

CREATE TABLE `RoomStatus` (
  `roomStatusId` int NOT NULL,
  `roomStatus` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `RoomStatus`
--

INSERT INTO `RoomStatus` (`roomStatusId`, `roomStatus`) VALUES
(1, 'AVAILABLE'),
(2, 'IN_PROGRESS'),
(3, 'RESERVED');

-- --------------------------------------------------------

--
-- Table structure for table `Room_FacilityFeature`
--

CREATE TABLE `Room_FacilityFeature` (
  `Room_id` int NOT NULL,
  `facilities_facilityId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Room_FacilityFeature`
--

INSERT INTO `Room_FacilityFeature` (`Room_id`, `facilities_facilityId`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 2),
(3, 2),
(17, 2),
(18, 2),
(18, 3),
(22, 1),
(22, 2),
(22, 3);

-- --------------------------------------------------------

--
-- Table structure for table `Room_Image`
--

CREATE TABLE `Room_Image` (
  `Room_id` int NOT NULL,
  `images_imageId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Room_Image`
--

INSERT INTO `Room_Image` (`Room_id`, `images_imageId`) VALUES
(1, 13),
(1, 14),
(2, 15),
(2, 16),
(3, 38),
(3, 39),
(17, 56),
(17, 57),
(18, 58),
(18, 59),
(22, 64);

-- --------------------------------------------------------

--
-- Table structure for table `Room_Review`
--

CREATE TABLE `Room_Review` (
  `Room_id` int NOT NULL,
  `reviews_reviewId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `userId` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `emailToken` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `usertype` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`userId`, `email`, `emailToken`, `firstname`, `lastname`, `password`, `username`, `usertype`) VALUES
(1, 'wdrdres3qew5ts21@gmail.com', NULL, 'Lin', 'Jingyun', 'UltimateGod999', 'wdrdres3qew5ts21@gmail.com', 'CUSTOMER'),
(6, 'nithirun1995@gmail.com', 'NJD0uV', 'Nithirun', 'Numnonda', 'UltimateGod999', 'nithirun1995@gmail.com', 'APARTMENT_OWNER'),
(8, 'panuwat33586@gmail.com', 'rnfyiK', 'Panuwat', 'Chiawchansilp', 'UltimateGod999', 'panuwat33586@gmail.com', 'APARTMENT_OWNER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Apartment`
--
ALTER TABLE `Apartment`
  ADD PRIMARY KEY (`apartmentId`),
  ADD KEY `FKmqyfqx1m0is4vy9ccpbdwn37b` (`apartmentOwner_apartmentOwnerId`);

--
-- Indexes for table `ApartmentOwner`
--
ALTER TABLE `ApartmentOwner`
  ADD PRIMARY KEY (`apartmentOwnerId`);

--
-- Indexes for table `Apartment_Image`
--
ALTER TABLE `Apartment_Image`
  ADD UNIQUE KEY `UK_qo57kqmnydf9gs49wha9mwpsp` (`images_imageId`),
  ADD KEY `FKfuqt5htmuhwcuupbqkpo4b2hr` (`Apartment_apartmentId`);

--
-- Indexes for table `ContractType`
--
ALTER TABLE `ContractType`
  ADD PRIMARY KEY (`contractId`);

--
-- Indexes for table `Customer`
--
ALTER TABLE `Customer`
  ADD PRIMARY KEY (`customerId`);

--
-- Indexes for table `FacilityFeature`
--
ALTER TABLE `FacilityFeature`
  ADD PRIMARY KEY (`facilityId`);

--
-- Indexes for table `FacilityFeature_Room`
--
ALTER TABLE `FacilityFeature_Room`
  ADD UNIQUE KEY `UK_gook96jcexl2c4edo3ed73rw4` (`roomList_id`),
  ADD KEY `FKb1jqxnayn6jkp5ets2h29vm6n` (`FacilityFeature_facilityId`);

--
-- Indexes for table `hibernate_sequences`
--
ALTER TABLE `hibernate_sequences`
  ADD PRIMARY KEY (`sequence_name`);

--
-- Indexes for table `Image`
--
ALTER TABLE `Image`
  ADD PRIMARY KEY (`imageId`);

--
-- Indexes for table `LandmarkFeature`
--
ALTER TABLE `LandmarkFeature`
  ADD PRIMARY KEY (`landmarkId`);

--
-- Indexes for table `Reservation`
--
ALTER TABLE `Reservation`
  ADD PRIMARY KEY (`reservationId`),
  ADD KEY `FKprp9xfstf1buic0e0mg1tndfu` (`room_id`),
  ADD KEY `FKjesl2cogtdbsmikk9hgf69hp9` (`user_userId`),
  ADD KEY `FK48dsqb9n97w3h80sl0dfkbkpi` (`reservationStatus_reservationStatusId`);

--
-- Indexes for table `ReservationStatus`
--
ALTER TABLE `ReservationStatus`
  ADD PRIMARY KEY (`reservationStatusId`),
  ADD UNIQUE KEY `UK_h3mtf2dtef3lwo05voyw5tg5k` (`reservationStatus`);

--
-- Indexes for table `Review`
--
ALTER TABLE `Review`
  ADD PRIMARY KEY (`reviewId`);

--
-- Indexes for table `Room`
--
ALTER TABLE `Room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6j7rbko3a42kx7pk7qqt99ix2` (`apartment_apartmentId`),
  ADD KEY `FKdky0f0ciq021in7kib0yd38cx` (`contractType_contractId`),
  ADD KEY `FKkfxl9eyrfu901g20cskpgvjjt` (`roomStatus_roomStatusId`);

--
-- Indexes for table `RoomStatus`
--
ALTER TABLE `RoomStatus`
  ADD PRIMARY KEY (`roomStatusId`),
  ADD UNIQUE KEY `UK_kiar3sxxyxl6eymwyyxquphy` (`roomStatus`);

--
-- Indexes for table `Room_FacilityFeature`
--
ALTER TABLE `Room_FacilityFeature`
  ADD KEY `FKr88fh859ofwe0ruqf5kxsmyum` (`facilities_facilityId`),
  ADD KEY `FK3q423jv0sgnsx29jspkh3bl82` (`Room_id`);

--
-- Indexes for table `Room_Image`
--
ALTER TABLE `Room_Image`
  ADD UNIQUE KEY `UK_j546vjhk4dv6rayh0jmqavew0` (`images_imageId`),
  ADD KEY `FKq3roecc72tdecv7gh0yy4nt51` (`Room_id`);

--
-- Indexes for table `Room_Review`
--
ALTER TABLE `Room_Review`
  ADD UNIQUE KEY `UK_go3w0vr82bd6y8uwm3ftd9ht9` (`reviews_reviewId`),
  ADD KEY `FKdtdyafy6d3f5uql4c18ujn4tf` (`Room_id`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`),
  ADD UNIQUE KEY `UK_jreodf78a7pl5qidfh43axdfb` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Apartment`
--
ALTER TABLE `Apartment`
  MODIFY `apartmentId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `ContractType`
--
ALTER TABLE `ContractType`
  MODIFY `contractId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `FacilityFeature`
--
ALTER TABLE `FacilityFeature`
  MODIFY `facilityId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Image`
--
ALTER TABLE `Image`
  MODIFY `imageId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `LandmarkFeature`
--
ALTER TABLE `LandmarkFeature`
  MODIFY `landmarkId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Reservation`
--
ALTER TABLE `Reservation`
  MODIFY `reservationId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `ReservationStatus`
--
ALTER TABLE `ReservationStatus`
  MODIFY `reservationStatusId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Review`
--
ALTER TABLE `Review`
  MODIFY `reviewId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `RoomStatus`
--
ALTER TABLE `RoomStatus`
  MODIFY `roomStatusId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `userId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Apartment`
--
ALTER TABLE `Apartment`
  ADD CONSTRAINT `FKmqyfqx1m0is4vy9ccpbdwn37b` FOREIGN KEY (`apartmentOwner_apartmentOwnerId`) REFERENCES `ApartmentOwner` (`apartmentOwnerId`);

--
-- Constraints for table `ApartmentOwner`
--
ALTER TABLE `ApartmentOwner`
  ADD CONSTRAINT `FK9e2oux7tmgrdrnpggqyvm2pjb` FOREIGN KEY (`apartmentOwnerId`) REFERENCES `User` (`userId`);

--
-- Constraints for table `Apartment_Image`
--
ALTER TABLE `Apartment_Image`
  ADD CONSTRAINT `FK6ffsuh7px46c05iiawcqdgbi6` FOREIGN KEY (`images_imageId`) REFERENCES `Image` (`imageId`),
  ADD CONSTRAINT `FKfuqt5htmuhwcuupbqkpo4b2hr` FOREIGN KEY (`Apartment_apartmentId`) REFERENCES `Apartment` (`apartmentId`);

--
-- Constraints for table `Customer`
--
ALTER TABLE `Customer`
  ADD CONSTRAINT `FKjtivvdqcd95l82tvhq9svqpyy` FOREIGN KEY (`customerId`) REFERENCES `User` (`userId`);

--
-- Constraints for table `FacilityFeature_Room`
--
ALTER TABLE `FacilityFeature_Room`
  ADD CONSTRAINT `FKb1jqxnayn6jkp5ets2h29vm6n` FOREIGN KEY (`FacilityFeature_facilityId`) REFERENCES `FacilityFeature` (`facilityId`),
  ADD CONSTRAINT `FKedn5amhitdd4gso37kbk5lf98` FOREIGN KEY (`roomList_id`) REFERENCES `Room` (`id`);

--
-- Constraints for table `Reservation`
--
ALTER TABLE `Reservation`
  ADD CONSTRAINT `FK48dsqb9n97w3h80sl0dfkbkpi` FOREIGN KEY (`reservationStatus_reservationStatusId`) REFERENCES `ReservationStatus` (`reservationStatusId`),
  ADD CONSTRAINT `FKjesl2cogtdbsmikk9hgf69hp9` FOREIGN KEY (`user_userId`) REFERENCES `User` (`userId`),
  ADD CONSTRAINT `FKprp9xfstf1buic0e0mg1tndfu` FOREIGN KEY (`room_id`) REFERENCES `Room` (`id`);

--
-- Constraints for table `Room`
--
ALTER TABLE `Room`
  ADD CONSTRAINT `FK6j7rbko3a42kx7pk7qqt99ix2` FOREIGN KEY (`apartment_apartmentId`) REFERENCES `Apartment` (`apartmentId`),
  ADD CONSTRAINT `FKdky0f0ciq021in7kib0yd38cx` FOREIGN KEY (`contractType_contractId`) REFERENCES `ContractType` (`contractId`),
  ADD CONSTRAINT `FKkfxl9eyrfu901g20cskpgvjjt` FOREIGN KEY (`roomStatus_roomStatusId`) REFERENCES `RoomStatus` (`roomStatusId`);

--
-- Constraints for table `Room_FacilityFeature`
--
ALTER TABLE `Room_FacilityFeature`
  ADD CONSTRAINT `FK3q423jv0sgnsx29jspkh3bl82` FOREIGN KEY (`Room_id`) REFERENCES `Room` (`id`),
  ADD CONSTRAINT `FKr88fh859ofwe0ruqf5kxsmyum` FOREIGN KEY (`facilities_facilityId`) REFERENCES `FacilityFeature` (`facilityId`);

--
-- Constraints for table `Room_Image`
--
ALTER TABLE `Room_Image`
  ADD CONSTRAINT `FKc0nbgimacuf7ogr63jmj3mgbg` FOREIGN KEY (`images_imageId`) REFERENCES `Image` (`imageId`),
  ADD CONSTRAINT `FKq3roecc72tdecv7gh0yy4nt51` FOREIGN KEY (`Room_id`) REFERENCES `Room` (`id`);

--
-- Constraints for table `Room_Review`
--
ALTER TABLE `Room_Review`
  ADD CONSTRAINT `FK4h2ae7xpiicei1q3h0rcnvc12` FOREIGN KEY (`reviews_reviewId`) REFERENCES `Review` (`reviewId`),
  ADD CONSTRAINT `FKdtdyafy6d3f5uql4c18ujn4tf` FOREIGN KEY (`Room_id`) REFERENCES `Room` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
