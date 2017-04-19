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
-- Table structure for table `rebuke_history`
--

DROP TABLE IF EXISTS `rebuke_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rebuke_history` (
  `id` int(11) NOT NULL,
  `rebh_rebuke` int(11) NOT NULL,
  `rebh_start_date` date NOT NULL,
  `rebh_end_date` date NOT NULL,
  `rebh_student` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rebuke_idx` (`rebh_rebuke`),
  KEY `fk_student_idx` (`rebh_student`),
  CONSTRAINT `fk_reb_rebuke` FOREIGN KEY (`rebh_rebuke`) REFERENCES `rebuke` (`re_rank`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reb_student` FOREIGN KEY (`rebh_student`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rebuke_history`
--

LOCK TABLES `rebuke_history` WRITE;
/*!40000 ALTER TABLE `rebuke_history` DISABLE KEYS */;
INSERT INTO `rebuke_history` VALUES (1,1,'2017-10-10','2018-10-10',3),(2,3,'2017-11-10','2018-11-10',4),(3,2,'2017-09-05','2018-09-05',5),(4,2,'2017-12-12','2018-12-12',3),(5,3,'2017-12-15','2018-12-15',3);
/*!40000 ALTER TABLE `rebuke_history` ENABLE KEYS */;
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
