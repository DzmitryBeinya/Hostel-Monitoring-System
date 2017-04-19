-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hostel_schema
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `st_name` varchar(45) NOT NULL,
  `st_surname` varchar(45) NOT NULL,
  `st_university` varchar(45) NOT NULL,
  `st_faculty` varchar(45) NOT NULL,
  `st_group` varchar(45) NOT NULL,
  `st_room` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_room_idx` (`st_room`),
  CONSTRAINT `fk_st_room` FOREIGN KEY (`st_room`) REFERENCES `room` (`ro_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Alexander','Kosaray','BSU','MMF','11506','142a'),(2,'Vladimir','Bondar','BSU','MMF','11506','253b'),(3,'Alexey','Sedlietsky','BNTU','FITR','333','147a'),(4,'Olga','Kozhemyakina','BSUIR','CSN','250503','712a'),(5,'Vladzislau','Zavadski','BSUIR','CSN','350501','1011a'),(6,'Dzmitry','Brouka','BSUIR','CP','151002','1011a'),(7,'Alexey','Stybook','BSEU','ET','zzz003','516b'),(8,'Margarita','Gitcheva','BSEU','IR','zzz003','712a'),(9,'Alex','Serbin','EGU','NN','k1k1k1','1011a'),(10,'Pavel','Belkevich','BSU','FPM','22508','222b');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-19 18:36:02
