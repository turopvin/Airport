-- MySQL dump 10.13  Distrib 5.7.19, for Linux (i686)
--
-- Host: localhost    Database: airport_DB
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

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
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flights` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `arrival_date` datetime DEFAULT NULL,
  `city_from` varchar(255) DEFAULT NULL,
  `city_to` varchar(255) DEFAULT NULL,
  `departure_date` datetime DEFAULT NULL,
  `free_places` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `plane_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlyulbbnnff5cs3lmiluryaors` (`plane_id`),
  CONSTRAINT `FKlyulbbnnff5cs3lmiluryaors` FOREIGN KEY (`plane_id`) REFERENCES `planes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (2,'2017-11-01 00:00:00','Grodno','Stockholm','2017-11-01 00:00:00',5,25,1),(3,'2017-11-01 00:00:00','Porto','Grodno','2017-11-01 00:00:00',8,120,2),(4,'2017-11-01 00:00:00','Moscow','Grodno','2017-11-01 00:00:00',8,20,2),(5,'2017-11-02 00:00:00','Grodno','Winterfell','2017-11-02 00:00:00',8,280,2),(6,'2017-11-02 00:00:00','Oslo','Grodno','2017-11-02 00:00:00',5,15,1),(7,'2017-11-03 00:00:00','Grodno','Rome','2017-11-03 00:00:00',4,60,1),(8,'2017-11-03 00:00:00','Grodno','London','2017-11-03 00:00:00',5,95,1),(9,'2017-11-03 00:00:00','Berlin','Grodno','2017-11-03 00:00:00',7,51,2),(10,'2017-11-04 00:00:00','Grodno','Madrid','2017-11-04 00:00:00',8,35,2),(11,'2017-11-04 00:00:00','Liverpool','Grodno','2017-11-04 00:00:00',5,130,1),(12,'2017-11-05 00:00:00','Grodno','Moscow','2017-11-05 00:00:00',8,20,2),(13,'2017-11-05 00:00:00','Barcelona','Grodno','2017-11-05 00:00:00',8,60,2),(14,'2017-11-05 00:00:00','Winterfell','Grodno','2017-11-05 00:00:00',5,240,1),(15,'2017-11-06 00:00:00','Grodno','Liverpool','2017-11-06 00:00:00',5,95,1),(16,'2017-11-06 00:00:00','Rome','Grodno','2017-11-06 00:00:00',7,47,2),(18,'2017-11-07 00:00:00','Grodno','Oslo','2017-11-07 00:00:00',5,24,1),(19,'2017-11-07 00:00:00','Grodno','Porto','2017-11-07 00:00:00',8,110,2),(21,'2017-11-08 00:00:00','Stockholm','Grodno','2017-11-08 00:00:00',5,15,1);
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passengers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `passport_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengers`
--

LOCK TABLES `passengers` WRITE;
/*!40000 ALTER TABLE `passengers` DISABLE KEYS */;
INSERT INTO `passengers` VALUES (1,'turopvin@mail.ru','Artsiom','Rudziak','KH789325'),(2,'olga@Mail.ru','Olga','Smirna','AO983274'),(3,'polina@mail.com','Polina','Petrovskaya','FT567485'),(4,'marina@mail.ru','Maria','Buben','KH231953');
/*!40000 ALTER TABLE `passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planes`
--

DROP TABLE IF EXISTS `planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(255) DEFAULT NULL,
  `number_of_places` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planes`
--

LOCK TABLES `planes` WRITE;
/*!40000 ALTER TABLE `planes` DISABLE KEYS */;
INSERT INTO `planes` VALUES (1,'Boeing 737-500',5),(2,'Boeing 737-800',8);
/*!40000 ALTER TABLE `planes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_id` int(11) DEFAULT NULL,
  `passenger_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtdayegtd891qq5xm0axfbckvy` (`flight_id`),
  KEY `FK1ds262xq345nkvs5o9ptnftwr` (`passenger_id`),
  CONSTRAINT `FK1ds262xq345nkvs5o9ptnftwr` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`id`),
  CONSTRAINT `FKtdayegtd891qq5xm0axfbckvy` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (4,7,2),(5,16,3),(6,9,4);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-27 15:15:01
