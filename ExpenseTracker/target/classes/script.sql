-- MySQL dump 10.13  Distrib 5.7.1-m11, for Win64 (x86_64)
--
-- Host: localhost    Database: expence_tracer
-- ------------------------------------------------------
-- Server version	5.7.1-m11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `userId` varchar(6) NOT NULL,
  `accountNo` varchar(16) NOT NULL,
  `name` varchar(24) NOT NULL,
  `accType` varchar(8) NOT NULL,
  `IFSC` varchar(11) NOT NULL,
  `currencyType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`accountNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('123456','1','dfghj','Saving','1111','INR'),('123456','123456789','alphha','Saving','123','INR'),('123456','2','2','Saving','2','INR');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expence`
--

DROP TABLE IF EXISTS `expence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expence` (
  `userId` varchar(6) NOT NULL,
  `pType` varchar(10) NOT NULL,
  `price` int(11) NOT NULL,
  `product` varchar(15) NOT NULL,
  `date` date NOT NULL,
  `expenseId` int(11) NOT NULL,
  PRIMARY KEY (`expenseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expence`
--

LOCK TABLES `expence` WRITE;
/*!40000 ALTER TABLE `expence` DISABLE KEYS */;
INSERT INTO `expence` VALUES ('123456','Stationary',123,'mango','2020-03-01',2),('123456','Stationary',111,'pen','2020-03-01',3);
/*!40000 ALTER TABLE `expence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `userId` varchar(6) NOT NULL,
  `feedback` varchar(120) NOT NULL,
  `feedbackId` int(11) NOT NULL,
  `questionId` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedbackquestion`
--

DROP TABLE IF EXISTS `feedbackquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedbackquestion` (
  `id` int(11) NOT NULL,
  `question` varchar(120) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedbackquestion`
--

LOCK TABLES `feedbackquestion` WRITE;
/*!40000 ALTER TABLE `feedbackquestion` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedbackquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` varchar(6) NOT NULL,
  `firstName` varchar(10) NOT NULL,
  `lastName` varchar(10) NOT NULL,
  `password` varchar(40) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `gender` varchar(6) NOT NULL,
  `contactNo` varchar(10) NOT NULL,
  `sQuestion` varchar(45) NOT NULL,
  `sAnswer` varchar(20) NOT NULL,
  `userType` varchar(10) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `sQuestion_UNIQUE` (`sQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('123123','yashika','Yadav','123','2020-01-01','Female','9001444138','Teacher','t','admin'),('123456','prayas','vijay','abc','2020-03-06','Male','9001444138','name','t','user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-12 12:13:24
