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
-- Table structure for table `mark_history`
--

DROP TABLE IF EXISTS `mark_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mark_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mh_date` date NOT NULL,
  `mh_room` varchar(45) NOT NULL,
  `mh_value` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_room_idx` (`mh_room`),
  CONSTRAINT `fk_room` FOREIGN KEY (`mh_room`) REFERENCES `room` (`ro_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mark_history`
--

LOCK TABLES `mark_history` WRITE;
/*!40000 ALTER TABLE `mark_history` DISABLE KEYS */;
INSERT INTO `mark_history` VALUES (1,'2017-04-19','1011a',4),(2,'2017-04-19','712a',5),(3,'2017-04-19','516b',4),(4,'2017-04-19','142a',4),(5,'2017-04-19','253b',5),(6,'2017-04-19','147a',6),(7,'2017-04-19','222b',4),(8,'2017-04-20','1011a',4),(9,'2017-04-20','147a',3),(10,'2017-04-20','712a',5),(60,'2017-04-04','111a',5),(61,'2017-04-04','111a',5),(62,'2017-04-04','111a',5);
/*!40000 ALTER TABLE `mark_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rebuke_history`
--

DROP TABLE IF EXISTS `rebuke_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rebuke_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rebh_name` varchar(45) NOT NULL,
  `rebh_rank` int(11) NOT NULL,
  `rebh_start_date` date NOT NULL,
  `rebh_end_date` date NOT NULL,
  `rebh_student` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reb_student_idx` (`rebh_student`),
  CONSTRAINT `fk_reb_student` FOREIGN KEY (`rebh_student`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rebuke_history`
--

LOCK TABLES `rebuke_history` WRITE;
/*!40000 ALTER TABLE `rebuke_history` DISABLE KEYS */;
INSERT INTO `rebuke_history` VALUES (1,'university',1,'2017-10-10','2018-10-10',3),(2,'faculty',2,'2017-11-10','2018-11-10',4),(3,'hostel',3,'2017-09-05','2018-09-05',5),(4,'hostel',3,'2017-12-12','2018-12-12',3),(5,'faculty',2,'2017-12-15','2018-12-15',3),(6,'hostel',2,'2016-04-04','2016-05-05',7);
/*!40000 ALTER TABLE `rebuke_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residence_history`
--

DROP TABLE IF EXISTS `residence_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `residence_history` (
  `id` int(11) NOT NULL,
  `resh_set_date` date NOT NULL,
  `resh_eject_date` date NOT NULL,
  `resh_student` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_res_student_idx` (`resh_student`),
  CONSTRAINT `fk_res_student` FOREIGN KEY (`resh_student`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residence_history`
--

LOCK TABLES `residence_history` WRITE;
/*!40000 ALTER TABLE `residence_history` DISABLE KEYS */;
INSERT INTO `residence_history` VALUES (1,'2017-09-01','2018-06-01',10),(2,'2017-09-01','2018-06-01',9),(3,'2017-09-01','2018-06-01',8),(4,'2017-09-01','2018-06-01',7),(5,'2017-09-01','2018-06-01',6),(6,'2017-09-02','2018-06-02',5),(7,'2017-09-02','2018-06-02',4),(8,'2017-09-02','2018-06-02',3),(9,'2017-09-02','2018-06-02',2),(10,'2017-09-02','2018-06-02',1);
/*!40000 ALTER TABLE `residence_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_rank` int(11) NOT NULL,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'manager'),(2,'commandant'),(3,'guest');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `ro_number` varchar(45) NOT NULL,
  `ro_places` int(11) NOT NULL,
  `ro_free_places` int(11) NOT NULL,
  `ro_floor` int(11) NOT NULL,
  PRIMARY KEY (`ro_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES ('1011a',5,5,10),('111a',5,5,1),('142a',5,5,1),('147a',5,5,1),('222b',5,5,2),('253b',5,5,2),('516b',5,5,5),('712a',5,5,7);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `st_name` varchar(45) NOT NULL,
  `st_surname` varchar(45) NOT NULL,
  `st_university` varchar(45) NOT NULL,
  `st_faculty` varchar(45) NOT NULL,
  `st_group` varchar(45) NOT NULL,
  `st_room` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_room_idx` (`st_room`),
  CONSTRAINT `fk_st_room` FOREIGN KEY (`st_room`) REFERENCES `room` (`ro_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Alexander','Kosaray','BSU','MMF','11506','142a'),(2,'Vladimir','Bondar','BSU','MMF','11506','253b'),(3,'Alexey','Sedlietsky','BNTU','FITR','333','147a'),(4,'Olga','Kozhemyakina','BSUIR','CSN','250503','712a'),(5,'Vladzislau','Zavadski','BSUIR','CSN','350501','1011a'),(6,'Dzmitry','Brouka','BSUIR','CP','151002','1011a'),(7,'Alex','Stybook','BSEU','ET','zzz003','516b'),(8,'Margarita','Gitcheva','BSEU','IR','zzz003','712a'),(9,'Alex','Serbin','EGU','NN','k1k1k1','1011a'),(10,'Pavel','Belkevich','BSU','FPM','22508','222b'),(11,'Miron','Fedorov','Oxford','Literature','q1','111a');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `us_name` varchar(45) NOT NULL,
  `us_password` varchar(45) NOT NULL,
  `us_role` int(11) NOT NULL,
  PRIMARY KEY (`us_name`,`us_password`),
  KEY `ro_fk_idx` (`us_role`),
  CONSTRAINT `ro_fk` FOREIGN KEY (`us_role`) REFERENCES `role` (`role_rank`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Miron','miron',1),('Slava','slava',2),('Johnyboy','johnyboy',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_hours_history`
--

DROP TABLE IF EXISTS `work_hours_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_hours_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wh_date` date NOT NULL,
  `wh_number` int(11) NOT NULL,
  `wh_student` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_wh_student_idx` (`wh_student`),
  CONSTRAINT `fk_wh_student` FOREIGN KEY (`wh_student`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_hours_history`
--

LOCK TABLES `work_hours_history` WRITE;
/*!40000 ALTER TABLE `work_hours_history` DISABLE KEYS */;
INSERT INTO `work_hours_history` VALUES (1,'2017-12-12',333,2),(2,'2017-12-12',333,1),(3,'2017-12-12',333,3),(4,'2017-12-25',444,2),(5,'2018-02-20',555,2),(14,'2017-04-04',20,9),(15,'2017-04-04',20,9);
/*!40000 ALTER TABLE `work_hours_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-29 11:27:00
