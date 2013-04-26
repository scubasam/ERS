CREATE DATABASE  IF NOT EXISTS `ers` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ers`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: ers
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `middle_initial` varchar(5) DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  `street_address_1` varchar(255) DEFAULT NULL,
  `street_address_2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(5) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `primary_phone` varchar(45) DEFAULT NULL,
  `work_phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (1,'Greg2','Adams','J','gadams@gmail.com','123 Main St.','','Zelienople','PA','16063','(555) 555-5555','(555) 555-5555'),(2,'Bob','Johnson','F','bjohnson@gmail.com','34 Shady Ln.',NULL,'Cranberry Twp.','PA','16066','5557894561','5551234556'),(3,'Sue','Niece','M','sniece@gmail.com','1020 N. Market St.','Apt. 3G','Evans City','MN','16007','5559874563','5551234568'),(4,'Mike','Eliott','S','melliot@gmail.com','188 Kiester Rd.',NULL,'Butler','OH','16001','5558213467','5554567891'),(5,'Sam','Michaels','J','smichaels@gmail.com','2030 Ardmore Blvd.',NULL,'Butler','NY','90210','5551346792','5554567898'),(6,'Anthony','Tretter','J','atretter@gmail.com','2060 Braddock Ave.',NULL,'Slippery Rock','PA','15219','5554678125','5551472583'),(7,'Mary','McDonald','R','marymcdonald@gmail.com','P.O. Box 23',NULL,'Harmony','PA','45182','5556784792','5557894561'),(8,'John','Greer','J','jgreer@gmail.com','1010 Hollywood Blvd.',NULL,'Beverly Hills','CA','90123','5558375929','4448229834'),(9,'Jimmy','Barns','M','jbarns@gmail.com','471 Market St.',NULL,'Topeka','KS','54678','1245678489','5456843128'),(10,'Anna','Farrell','D','afarrell@gmail.com','849 Rodi Rd.',NULL,'Atlanta','GA','45678','5468421388','7894518534'),(11,'Amy','Davis','E','adavis@gmail.com','738 Beaver Rd.',NULL,'Harrisburg','PA','15467','5213658974','3569852123'),(12,'Larry','Magness','R','lmagness@gmail.com','55 Chestnut St.',NULL,'Newark','NJ','23658','8745682658','3524698575'),(13,'Jen','Waller','P','jwaller@gmail.com','',NULL,'','KS','65487','4759681235','4759681235'),(14,'Joe','Reed','F','jreed@gmail.com','',NULL,'','ME','12345','2653854152','2653854152'),(15,'Shane','Wolfe','J','swolfe@gmail.com','',NULL,'','OR','89768','2658749586','2658749586'),(16,'Linda','Rimes','H','lrimes@gmail.com','',NULL,'','ME','12358','2314568951','2314568951'),(17,'Deborah','Wise','N','dwise@gmail.com','',NULL,'','TN','29846','6985476589','6985476589'),(18,'David','Troyer','L','dtroyer@gmail.com','',NULL,'','CT','12587','2356263545','2356263545'),(19,'Russell','Parton','R','rparton@gmail.com','',NULL,'','NV','59898','2325685489','2325685489'),(20,'Jerry','Fox','E','jfox@gmail.com','',NULL,'','GA','36325','4532587659','4532587659'),(21,'Sara','Young','W','syoung@gmail.com','',NULL,'','LA','45155','5578964256','5578964256'),(22,'Hannah','Brown','Z','hbrown@gmail.com','',NULL,'','TX','64787','8546789582','8546789582'),(23,'Brad','Donahue','A','bdonahue@gmail.com','',NULL,'','OH','18184','2354621235','2354621235'),(24,'Lindsey','Adams','U','ladams@gmail.com','',NULL,'','TX','69678','1214546585','1214546585'),(25,'Megan','Chase','I','mchase@gmail.com','',NULL,'','IA','45487','5614235845','5614235845'),(26,'Mike','Gregory','K','mgregory@gmail.com','',NULL,'','IN','21451','5645788912','5645788912'),(27,'Bill','Stewart','H','bstewart@gmail.com','',NULL,'','WA','85874','2351466588','2351466588'),(28,'Alex','McC','J','alex@a.com','123 st','','grove city','pa','16124','7243722629','8147868937'),(29,'Kelly','Smith','','sovzx2@gmail.com','39 Ravenwood Ln','','Grove City','PA','16127','7243721425','7243721425'),(31,'Kelly2','Smith','','sovzx2@gmail.com','39 Ravenwood Ln','','Grove City','PA','16127','(724) 372-1425','(724) 372-1425'),(32,'Testing','Mc Test Test','','test@test.com','39 Ravenwood Ln','','Grove City','PA','16127','(724) 372-1425','(724) 372-1425'),(33,'Greg2','Adams','J','gadams@gmail.com','123 Main St.','','Zelienople','PA','16063','(724) 372-1425','(724) 372-1425'),(34,'Fred','Blair','','fblair@cement.com','123 Merry Way','','Grove City','PA','16127','5555555555','5555555555');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contractors`
--

DROP TABLE IF EXISTS `contractors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contractors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contractor_name` varchar(100) NOT NULL,
  `contact_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `contractor_contactFK` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contractors`
--

LOCK TABLES `contractors` WRITE;
/*!40000 ALTER TABLE `contractors` DISABLE KEYS */;
INSERT INTO `contractors` VALUES (1,'Bob\'s Warehouse',1),(2,'The Shipping Co.',8),(3,'Bob\'s Warehouse',5),(4,'Adams Trucking',4),(5,'FreightMaster',18),(6,'Adams Trucking',22),(7,'Samson Shipping',6),(8,'Fred\'s Cement and Foundry Services',34);
/*!40000 ALTER TABLE `contractors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drivers`
--

DROP TABLE IF EXISTS `drivers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drivers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_id` int(11) NOT NULL,
  `contractor_id` int(11) DEFAULT NULL,
  `license_number` varchar(10) DEFAULT NULL,
  `license_expiration` date DEFAULT NULL,
  `license_class` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `driver_contactFK` (`contact_id`),
  KEY `driver_contractorFK` (`contractor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivers`
--

LOCK TABLES `drivers` WRITE;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` VALUES (1,3,3,'384-374','2010-05-23','A'),(2,15,5,'768-911','2012-10-11','C'),(3,7,1,'829-490','2011-11-02','C'),(4,16,7,'456-465','2011-06-29','D'),(5,24,2,'897-285','2011-12-05','A'),(6,17,4,'251-231','2011-11-12','D'),(7,19,1,'101-231','2011-05-02','C'),(8,11,6,'256-589','2011-01-22','C'),(9,10,2,'763-998','2011-04-15','D'),(10,9,5,'585-115','2010-04-11','B');
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `street_address_1` varchar(255) NOT NULL,
  `street_address_2` varchar(255) DEFAULT NULL,
  `city` varchar(100) NOT NULL,
  `state` varchar(10) NOT NULL,
  `zip` varchar(10) NOT NULL,
  `road_name` varchar(100) DEFAULT NULL,
  `road_number` int(11) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `longitude` varchar(45) DEFAULT NULL,
  `contractor_id` int(11) DEFAULT NULL,
  `location_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `location_contractorFK` (`contractor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'East Depot','213 Navy Rd.',NULL,'Pittsburgh','PA','15232','Navy Rd.',457,'34','45',1,'depot'),(2,'West Depot','44 Martin Rd.',NULL,'Cleveland','OH','22357','Martin Rd.',651,'32','44',4,'depot'),(3,'South Depot','586 Liverpool Rd.',NULL,'Pittsburgh','PA','15232','Liverpool Rd.',258,'34','45',5,'depot'),(4,'Adams Depot','998 Adams Ln.',NULL,'Pittsburgh','PA','15232','Adams Ln.',201,'34','45',2,'depot'),(5,'Garage E3','1241 Able Rd.',NULL,'Cleveland','OH','22356','Able Rd.',413,'32','44',7,'depot'),(6,'Garage E6','67 Milly Dr.',NULL,'Pittsburgh','PA','15232','Milly Dr.',856,'34','45',3,'depot'),(7,'Garage F3','453 Main St.',NULL,'Columbus','OH','23568','Main St.',21,'33','46',3,'depot'),(8,'Garage A3','256 Fillmore Blvd.',NULL,'Columbus','OH','23568','Fillmore Blvd.',460,'33','46',4,'depot'),(9,'Garage J8','1456 Jones Dr.',NULL,'Pittsburgh','PA','15232','Jones Dr.',695,'34','45',6,'depot'),(10,'Garage L9','2586 Carnegie St.',NULL,'Pittsburgh','PA','15232','Carnegie St.',587,'34','45',6,'depot'),(11,'Garage B7','745 Fullson Dr.',NULL,'Harrisburg','PA','15232','Fullson Dr.',258,'36','46',2,'depot'),(12,'Garage B5','225 Navy Rd.',NULL,'Pittsburgh','PA','15232','Navy Rd.',146,'34','45',1,'depot'),(13,'Garage A2','563 Lincoln Rd.',NULL,'Pittsburgh','PA','15232','Lincoln Rd.',456,'34','45',4,'depot'),(14,'Silver Lake Depot','12 Wester Rd.',NULL,'Harrisburg','PA','15232','Wester Rd.',213,'34','45',1,'depot'),(15,'Garage F4','46 W. Arizona St.',NULL,'Nantucket','MA','12017','Arizona St.',232,'11','40',2,'depot'),(16,'East Warehouse','254 Kliner Rd.',NULL,'Johnstown','PA','14125','Kliner Rd.',256,'35','45',3,'warehouse'),(17,'Warehouse G4','411 Park Rd.',NULL,'Pittsburgh','PA','15222','Park Rd.',410,'37','44',2,'warehouse'),(18,'Warehouse 342','508 Sandy Rd.',NULL,'Johnstown','PA','14125','Sandy Rd.',194,'35','45',4,'warehouse'),(19,'South Warehouse','1024 Marketway St.',NULL,'Pittsburgh','PA','15222','Marketway St.',285,'37','44',6,'warehouse'),(20,'Warehouse 38','55 Tri-Boro Expy.',NULL,'Pittsburgh','PA','15223','Tri-Boro Expy.',466,'37','44',2,'warehouse'),(21,'Warehouse 55','118 Millerstown Rd.',NULL,'Johnstown','PA','14125','Millerstown Rd.',558,'35','45',1,'warehouse'),(22,'Warehouse A4','210 Route 8.',NULL,'Pittsburgh','PA','15221','Route 8',123,'37','44',1,'warehouse'),(23,'Warehouse B2','1238 N. Plugger St.',NULL,'Boston','MA','10124','Plugger St.',98,'28','42',7,'warehouse'),(24,'East Depot','213 Navy Rd.',NULL,'Pittsburgh','PA','15232','Navy Rd.',457,'34','45',1,'depot'),(25,'West Depot','44 Martin Rd.',NULL,'Cleveland','OH','22357','Martin Rd.',651,'32','44',4,'depot'),(26,'South Depot','586 Liverpool Rd.',NULL,'Pittsburgh','PA','15232','Liverpool Rd.',258,'34','45',5,'depot'),(27,'Adams Depot','998 Adams Ln.',NULL,'Pittsburgh','PA','15232','Adams Ln.',201,'34','45',2,'depot'),(28,'Garage E3','1241 Able Rd.',NULL,'Cleveland','OH','22356','Able Rd.',413,'32','44',7,'depot'),(29,'Garage E6','67 Milly Dr.',NULL,'Pittsburgh','PA','15232','Milly Dr.',856,'34','45',3,'depot'),(30,'Garage F3','453 Main St.',NULL,'Columbus','OH','23568','Main St.',21,'33','46',3,'depot'),(31,'Garage A3','256 Fillmore Blvd.',NULL,'Columbus','OH','23568','Fillmore Blvd.',460,'33','46',4,'depot'),(32,'Garage J8','1456 Jones Dr.',NULL,'Pittsburgh','PA','15232','Jones Dr.',695,'34','45',6,'depot'),(33,'Garage L9','2586 Carnegie St.',NULL,'Pittsburgh','PA','15232','Carnegie St.',587,'34','45',6,'depot'),(34,'Garage B7','745 Fullson Dr.',NULL,'Harrisburg','PA','15232','Fullson Dr.',258,'36','46',2,'depot'),(35,'Garage B5','225 Navy Rd.',NULL,'Pittsburgh','PA','15232','Navy Rd.',146,'34','45',1,'depot'),(36,'Garage A2','563 Lincoln Rd.',NULL,'Pittsburgh','PA','15232','Lincoln Rd.',456,'34','45',4,'depot'),(37,'Silver Lake Depot','12 Wester Rd.',NULL,'Harrisburg','PA','15232','Wester Rd.',213,'34','45',1,'depot'),(38,'Garage F4','46 W. Arizona St.',NULL,'Nantucket','MA','12017','Arizona St.',232,'11','40',2,'depot'),(39,'East Warehouse','254 Kliner Rd.',NULL,'Johnstown','PA','14125','Kliner Rd.',256,'35','45',3,'warehouse'),(40,'Warehouse G4','411 Park Rd.',NULL,'Pittsburgh','PA','15222','Park Rd.',410,'37','44',2,'warehouse'),(41,'Warehouse 342','508 Sandy Rd.',NULL,'Johnstown','PA','14125','Sandy Rd.',194,'35','45',4,'warehouse'),(42,'South Warehouse','1024 Marketway St.',NULL,'Pittsburgh','PA','15222','Marketway St.',285,'37','44',6,'warehouse'),(43,'Warehouse 38','55 Tri-Boro Expy.',NULL,'Pittsburgh','PA','15223','Tri-Boro Expy.',466,'37','44',2,'warehouse'),(44,'Warehouse 55','118 Millerstown Rd.',NULL,'Johnstown','PA','14125','Millerstown Rd.',558,'35','45',1,'warehouse'),(45,'Warehouse A4','210 Route 8.',NULL,'Pittsburgh','PA','15221','Route 8',123,'37','44',1,'warehouse'),(46,'Warehouse B2','1238 N. Plugger St.',NULL,'Boston','MA','10124','Plugger St.',98,'28','42',7,'warehouse'),(47,'Testing2','39 Ravenwood Ln8','','Grove City','PA','16128','Ravenwood Ln',39,'41','80',5,'warehouse'),(48,'Foundry','39 Ravenwood Ln','','Grove City','PA','16127','Ravenwood Ln',39,'34','34',8,'United States');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maintenance_orders`
--

DROP TABLE IF EXISTS `maintenance_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maintenance_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requester_id` int(11) DEFAULT NULL,
  `service_technician_id` int(11) DEFAULT NULL,
  `scheduled_date` datetime DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `service_type_key` varchar(45) DEFAULT NULL,
  `cost` varchar(45) DEFAULT NULL,
  `status_key` varchar(45) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL,
  `maintenance_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `maintenance_order_driverFK` (`requester_id`),
  KEY `maintenance_order_service_technicianFK` (`service_technician_id`),
  KEY `maintenance_order_vehicleFK` (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintenance_orders`
--

LOCK TABLES `maintenance_orders` WRITE;
/*!40000 ALTER TABLE `maintenance_orders` DISABLE KEYS */;
INSERT INTO `maintenance_orders` VALUES (1,3,1,'2010-03-28 00:00:00','Brake Replacement','REPAIR','$123.00','COMPLETED',1,'BRAKES'),(2,4,2,'2010-03-28 00:00:00','Tighten Suspension','MAINTENANCE','$586.00','COMPLETED',3,'SUSPENSION'),(3,6,1,'2010-03-28 00:00:00','Brake Replacement','REPAIR','$1024.00','COMPLETED',8,'BRAKES'),(4,7,2,'2010-03-28 00:00:00','Muffler Replacement','REPAIR','$699.00','COMPLETED',5,'EXHAUST'),(5,5,3,'2010-03-28 00:00:00','Oil Change','MAINTENANCE','$641.00','COMPLETED',8,'ENGINE'),(6,2,3,'2010-03-28 00:00:00','Brake Replacement','REPAIR','$35.00','PENDING',7,'SUSPENSION'),(7,2,1,'2010-03-28 00:00:00','Upholstery Refinish','REPAIR','$102.00','COMPLETED',9,'INTERIOR'),(8,1,5,'2010-03-28 00:00:00','Upholstery Refinish','MAINTENANCE','$256.00','COMPLETED',3,'INTERIOR'),(9,9,4,'2010-03-28 00:00:00','Brake Replacement','MAINTENANCE','$574.00','COMPLETED',2,'BRAKES'),(10,9,4,'2010-03-28 00:00:00','Radiator Repair','REPAIR','$664.00','COMPLETED',4,'ENGINE'),(11,7,5,'2010-03-28 00:00:00','Brake Replacement','REPAIR','$105.00','PENDING',4,'ENGINE'),(12,5,2,'2010-03-28 00:00:00','Tire Replacement','REPAIR','$586.00','PENDING',12,'TIRES'),(13,7,2,'2010-03-28 00:00:00','Air Pressure Check','MAINTENANCE','$669.00','COMPLETED',11,'TIRES'),(14,2,1,'2010-03-28 00:00:00','Muffler Check','MAINTENANCE','$87.00','PENDING',10,'EXHAUST'),(15,4,3,'2010-03-28 00:00:00','Brake Replacement','REPAIR','$23.00','COMPLETED',4,'BRAKES'),(16,5,4,'2010-04-12 00:00:00','Oil Change','MAINTENANCE','$15.00','PENDING',2,'ENGINE');
/*!40000 ALTER TABLE `maintenance_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissions` (
  `id` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` VALUES ('edu.thangiah.user.action.AddAction',2),('edu.thangiah.user.action.DeleteAction',2),('edu.thangiah.user.action.ManagementController',2),('edu.thangiah.user.action.UpdateAction',2);
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_UNIQUE` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (3,'contractorOwner'),(4,'driver'),(1,'globalAdmin'),(5,'user'),(2,'userAdmin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `routes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_id` int(11) DEFAULT NULL,
  `start_location_id` int(11) DEFAULT NULL,
  `end_location_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `route_vehicleFK` (`vehicle_id`),
  KEY `route_locationFK` (`start_location_id`,`end_location_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES (2,3,1,2),(3,5,3,4),(4,5,5,6),(5,8,6,7),(6,7,8,9),(7,3,8,3),(8,2,3,4),(9,4,2,4),(10,4,4,3),(11,8,5,3),(12,10,2,2),(13,11,4,4),(14,12,3,2),(15,6,4,4),(16,1,2,2),(17,11,18,4),(19,12,48,48);
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_technicians`
--

DROP TABLE IF EXISTS `service_technicians`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_technicians` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_id` int(11) NOT NULL,
  `skill_grade` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `service_technician_contactFK` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_technicians`
--

LOCK TABLES `service_technicians` WRITE;
/*!40000 ALTER TABLE `service_technicians` DISABLE KEYS */;
INSERT INTO `service_technicians` VALUES (1,12,'Junior'),(2,8,'Junior'),(3,13,'Apprentice'),(4,20,'Master'),(5,14,'Apprentice');
/*!40000 ALTER TABLE `service_technicians` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipments`
--

DROP TABLE IF EXISTS `shipments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time_entered` datetime DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `vehicle_type_id` int(11) DEFAULT NULL,
  `route_id` int(11) DEFAULT NULL,
  `route_order_value` int(11) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `available_date` date DEFAULT NULL,
  `available_time` time DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `release_time` time DEFAULT NULL,
  `earliest_delivery_date` date DEFAULT NULL,
  `earliest_delivery_time` time DEFAULT NULL,
  `latest_delivery_date` date DEFAULT NULL,
  `latest_delivery_time` time DEFAULT NULL,
  `service_time` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `cubic_weight` int(11) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `destination_id` int(11) DEFAULT NULL,
  `pooled_shipment` tinyint(1) NOT NULL,
  `pooled_destination_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shipment_routeFK` (`route_id`),
  KEY `shipment_vehicle_typeFK` (`vehicle_type_id`),
  KEY `shipment_locationFK` (`location_id`),
  KEY `shipment_destinationFK` (`destination_id`),
  KEY `shipment_pooled_destinationFK` (`pooled_destination_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipments`
--

LOCK TABLES `shipments` WRITE;
/*!40000 ALTER TABLE `shipments` DISABLE KEYS */;
INSERT INTO `shipments` VALUES (1,'2010-03-28 12:23:00',1875938,1,2,0,17,'2010-03-29','12:55:00','2010-12-09','17:00:00','2010-06-02','00:00:00','2010-07-02','23:59:59',3,25,20,'Derby Plumbing',23,0,NULL),(2,'2010-03-12 15:25:00',2839303,2,2,1,17,'2010-05-02','15:23:00','2010-12-19','17:00:00','2010-06-05','00:00:00','2010-07-05','23:59:59',5,20,22,'Derby Plumbing',23,0,NULL),(3,'2010-05-15 22:56:00',2568745,2,2,2,17,'2010-04-23','02:44:00','2010-02-18','17:00:00','2010-08-05','00:00:00','2010-08-05','23:59:59',4,13,10,'Miller Electrical',23,0,NULL),(4,'2010-04-02 22:35:00',2568945,3,NULL,NULL,19,'2010-03-11','05:07:00','2010-05-20','17:00:00','2010-08-30','00:00:00','2010-08-30','23:59:59',1,28,29,'Miller Electrical',16,0,NULL),(5,'2010-11-10 02:45:00',2568479,1,2,3,17,'2010-08-02','04:17:00','2010-12-21','17:00:00','2010-11-28','00:00:00','2010-12-28','23:59:59',1,15,14,'Derby Plumbing',23,0,NULL),(6,'2009-08-23 14:12:00',3695487,2,NULL,NULL,20,'2010-08-22','22:12:00','2010-01-05','17:00:00','2010-12-22','00:00:00','2010-12-31','23:59:59',2,20,15,'Miller Electrical',17,0,NULL),(7,'2010-08-15 12:44:00',1546841,1,NULL,NULL,16,'2010-10-23','20:23:00','2010-05-02','17:00:00','2010-03-06','00:00:00','2010-04-06','23:59:59',2,50,34,'Miller Electrical',18,0,NULL),(8,'2010-09-14 02:55:00',5798484,1,NULL,NULL,20,'2010-12-15','15:54:00','2010-08-14','17:00:00','2010-12-01','00:00:00','2010-12-31','23:59:59',5,20,23,'Sandusky Steel',19,0,NULL),(9,'2010-04-06 08:32:00',5896895,3,2,4,17,'2010-03-07','08:16:00','2010-08-23','17:00:00','2010-02-25','00:00:00','2010-03-25','23:59:59',4,25,15,'Derby Plumbing',23,0,NULL),(10,'2010-05-28 17:02:00',3256887,3,NULL,NULL,16,'2010-10-08','08:58:00','2010-06-17','17:00:00','2010-05-06','00:00:00','2010-06-06','23:59:59',5,18,18,'Sandusky Steel',20,0,NULL),(11,'2010-06-29 17:14:00',2543212,1,2,5,17,'2010-08-10','10:16:00','2010-11-17','17:00:00','2010-05-08','00:00:00','2010-06-08','23:59:59',3,20,15,'Miller Electrical',23,0,NULL),(12,'2010-06-30 23:46:00',1215412,1,NULL,NULL,20,'2010-11-29','23:24:00','2010-10-02','17:00:00','2010-08-12','00:00:00','2010-09-12','23:59:59',6,27,17,'Derby Plumbing',21,0,NULL),(13,'2010-06-12 00:35:00',1315465,2,2,6,17,'2010-09-30','22:22:00','2010-12-05','17:00:00','2010-04-15','00:00:00','2010-05-15','23:59:59',5,33,19,'Sandusky Steel',23,0,NULL),(14,'2010-05-08 21:26:00',2535652,3,2,7,17,'2010-05-14','20:05:00','2010-01-28','17:00:00','2010-09-30','00:00:00','2010-10-30','23:59:59',2,21,11,'Derby Plumbing',23,0,NULL),(15,'2010-03-15 16:02:00',2565414,2,NULL,NULL,18,'2010-03-08','01:10:00','2010-03-31','17:00:00','2010-11-30','00:00:00','2010-12-30','23:59:59',1,20,15,'Miller Electrical',22,0,NULL),(16,'2010-10-23 12:11:00',2536524,1,NULL,NULL,19,'2010-01-01','16:01:00','2010-06-23','17:00:00','2010-10-23','00:00:00','2010-11-23','23:59:59',1,30,20,'Sandusky Steel',16,0,NULL),(17,NULL,123,3,9,NULL,4,NULL,NULL,'2013-04-03',NULL,'2013-04-12',NULL,'2013-04-06',NULL,123,123,123,'123',18,0,NULL);
/*!40000 ALTER TABLE `shipments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `user_role_id` (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (24,1),(26,1),(24,2),(26,2),(29,2),(30,2),(29,3),(30,3),(24,5);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `salt` varchar(16) NOT NULL,
  `session_id` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `serializedVisibilityMap` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (25,'Jacky','4904e56f7c6f54e2f6fd897d3e24f108b02b3a05',0,'21ufq2sdycv2qz6j','',NULL,NULL),(24,'Kelly','09ec11d5f8bb00b6dbd053f1dd8cab5ba10d4735',1,'7m9hc8fivst1kdwr','nqahw2bxyqyw5w64ibauui07cxkp2m5gwtgwld14i5ox5nl5r8n4yy257wz206z9','admin@kelly-smith.me','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<java version=\"1.7.0_13\" class=\"java.beans.XMLDecoder\">\n <object class=\"java.util.HashMap\">\n  <void method=\"put\">\n   <string>contractor</string>\n   <object class=\"java.util.HashSet\">\n    <void method=\"add\">\n     <string>locations</string>\n    </void>\n    <void method=\"add\">\n     <string>contractorName</string>\n    </void>\n    <void method=\"add\">\n     <string>contact</string>\n    </void>\n   </object>\n  </void>\n  <void method=\"put\">\n   <string>location</string>\n   <object class=\"java.util.HashSet\">\n    <void method=\"add\">\n     <string>contractor</string>\n    </void>\n    <void method=\"add\">\n     <string>streetAddress1</string>\n    </void>\n    <void method=\"add\">\n     <string>name</string>\n    </void>\n    <void method=\"add\">\n     <string>locationType</string>\n    </void>\n    <void method=\"add\">\n     <string>longitude</string>\n    </void>\n    <void method=\"add\">\n     <string>vehicles</string>\n    </void>\n   </object>\n  </void>\n  <void method=\"put\">\n   <string>route</string>\n   <object class=\"java.util.HashSet\">\n    <void method=\"add\">\n     <string>endLocation</string>\n    </void>\n    <void method=\"add\">\n     <string>vehicle</string>\n    </void>\n    <void method=\"add\">\n     <string>shipments</string>\n    </void>\n    <void method=\"add\">\n     <string>startLocation</string>\n    </void>\n   </object>\n  </void>\n  <void method=\"put\">\n   <string>vehicleType</string>\n   <object class=\"java.util.HashSet\">\n    <void method=\"add\">\n     <string>model</string>\n    </void>\n    <void method=\"add\">\n     <string>restrictions</string>\n    </void>\n    <void method=\"add\">\n     <string>type</string>\n    </void>\n    <void method=\"add\">\n     <string>maximumCubicWeight</string>\n    </void>\n    <void method=\"add\">\n     <string>height</string>\n    </void>\n    <void method=\"add\">\n     <string>minimumCubicWeight</string>\n    </void>\n    <void method=\"add\">\n     <string>description</string>\n    </void>\n    <void method=\"add\">\n     <string>subType</string>\n    </void>\n    <void method=\"add\">\n     <string>length</string>\n    </void>\n    <void method=\"add\">\n     <string>maximumRange</string>\n    </void>\n    <void method=\"add\">\n     <string>capacity</string>\n    </void>\n    <void method=\"add\">\n     <string>emptyWeight</string>\n    </void>\n    <void method=\"add\">\n     <string>vehicles</string>\n    </void>\n    <void method=\"add\">\n     <string>make</string>\n    </void>\n   </object>\n  </void>\n  <void method=\"put\">\n   <string>user</string>\n   <object class=\"java.util.HashSet\">\n    <void method=\"add\">\n     <string>username</string>\n    </void>\n    <void method=\"add\">\n     <string>sessionId</string>\n    </void>\n   </object>\n  </void>\n  <void method=\"put\">\n   <string>contact</string>\n   <object class=\"java.util.HashSet\">\n    <void method=\"add\">\n     <string>lastName</string>\n    </void>\n    <void method=\"add\">\n     <string>streetAddress1</string>\n    </void>\n    <void method=\"add\">\n     <string>emailAddress</string>\n    </void>\n    <void method=\"add\">\n     <string>firstName</string>\n    </void>\n    <void method=\"add\">\n     <string>workPhone</string>\n    </void>\n    <void method=\"add\">\n     <string>city</string>\n    </void>\n   </object>\n  </void>\n </object>\n</java>\n'),(23,'Alex','5deab2558476e8209ea74da66d756de9a13098b2',1,'a3ads3u7flp20mqa','as7ks5feo1jme11d2yvvr6rwn0q9fnsf1uhbeh43ev8lrcru2u7ye9ha3smue6fr',NULL,NULL),(26,'Default','a1ba6591e17699d62d8c94cca46fa2677712f9f9',1,'dagvvk36bx4242z7','i8d1cozp1xir3hukc3vfj5o70v0hc8ngwzz8zxexkhx6nxoavch75tjxsbausq9w',NULL,NULL),(27,'TESTIN','Testing',1,'testing','tseting','',NULL),(28,'TestingTesting','f2e4a393d6e9b7343c908521bce2cc8be61378a5',1,'5gw7olh7f044bmet','',NULL,NULL),(29,'Testing2','12209f8497303c2ddd65dc7b2088db5c67c15d9a',0,'tkt4xfr1v95ogz0t','',NULL,NULL),(30,'Testing4','7f85d249ab5a9b7f4409fab76db4be513f2b98b6',0,'8v1m9c0kbwd34cty','',NULL,NULL),(35,'Test9','f31708b506ed8e53fead42557cb0b40a52e24e4e',0,'i53xvpzrzk9o6snn','','test2@yahoo.com',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_driver`
--

DROP TABLE IF EXISTS `vehicle_driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_driver` (
  `vehicle_id` int(11) NOT NULL,
  `driver_id` int(11) NOT NULL,
  PRIMARY KEY (`vehicle_id`,`driver_id`),
  KEY `vehicle_driver_driverFK` (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_driver`
--

LOCK TABLES `vehicle_driver` WRITE;
/*!40000 ALTER TABLE `vehicle_driver` DISABLE KEYS */;
INSERT INTO `vehicle_driver` VALUES (2,1),(1,2),(3,2),(1,3),(4,4),(5,5);
/*!40000 ALTER TABLE `vehicle_driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_types`
--

DROP TABLE IF EXISTS `vehicle_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `sub_type` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `make` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `minimum_weight` int(11) NOT NULL,
  `maximum_weight` int(11) NOT NULL,
  `capacity` varchar(45) DEFAULT NULL,
  `maximum_range` int(11) NOT NULL,
  `restrictions` varchar(255) DEFAULT NULL,
  `height` int(11) NOT NULL,
  `empty_weight` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `minimum_cubic_weight` int(11) DEFAULT NULL,
  `maximum_cubic_weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_types`
--

LOCK TABLES `vehicle_types` WRITE;
/*!40000 ALTER TABLE `vehicle_types` DISABLE KEYS */;
INSERT INTO `vehicle_types` VALUES (1,'Flatbed','Open','','FreightLiner','FL-20134',20000,40000,NULL,400,NULL,90,7000,95,NULL,NULL),(2,'Flatbed','Closed','','Mack','M-DJ48DC',20000,40000,NULL,400,NULL,95,8000,88,NULL,NULL),(3,'Flatbed','Refrigerated','','Mack','M-DK84VK',20000,40000,NULL,400,NULL,98,9000,88,NULL,NULL),(4,'Semi-Trailer','Open','','FreightLiner','FL-38409',60000,120000,NULL,500,NULL,105,23000,160,NULL,NULL),(5,'Heavy','Open','','Mack','M-EK38KJ',5000,10000,NULL,400,NULL,80,3000,70,NULL,NULL),(6,'Tanker','Open','','FreightLiner','FL-384DK',20000,40000,'3000',400,NULL,80,10000,85,NULL,NULL),(7,'Van','Panel','','Dodge','DOD-383D',2000,7000,NULL,400,NULL,65,3000,65,NULL,NULL),(8,'Van','Parcel','','GM','GM-FJKE3',2000,7000,NULL,400,NULL,60,3000,65,NULL,NULL),(9,'Flatbed','Open','','FreightLiner','FL-20134',20000,40000,NULL,400,NULL,90,7000,95,NULL,NULL),(10,'Flatbed','Closed','','Mack','M-DJ48DC',20000,40000,NULL,400,NULL,95,8000,88,NULL,NULL),(11,'Flatbed','Refrigerated','','Mack','M-DK84VK',20000,40000,NULL,400,NULL,98,9000,88,NULL,NULL),(12,'Semi-Trailer','Open','','FreightLiner','FL-38409',60000,120000,NULL,500,NULL,105,23000,160,NULL,NULL),(13,'Heavy','Open','','Mack','M-EK38KJ',5000,10000,NULL,400,NULL,80,3000,70,NULL,NULL),(14,'Tanker','Open','','FreightLiner','FL-384DK',20000,40000,'3000',400,NULL,80,10000,85,NULL,NULL),(15,'Van','Panel','','Dodge','DOD-383D',2000,7000,NULL,400,NULL,65,3000,65,NULL,NULL),(16,'Van','Parcel','','GM','GM-FJKE3',2000,7000,NULL,400,NULL,60,3000,65,NULL,NULL),(17,'Tanker','Panel','Kelly','GM','GM-FJKD4',5000,4555,'345',445,'543',45,4534,43,NULL,NULL);
/*!40000 ALTER TABLE `vehicle_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plate_number` varchar(20) DEFAULT NULL,
  `vin_number` varchar(45) NOT NULL,
  `manufactured_year` varchar(45) NOT NULL,
  `vehicle_type_id` int(11) NOT NULL,
  `location_id` int(11) DEFAULT NULL,
  `contractor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vehicle_locationFK` (`location_id`),
  KEY `vehicle_contractorFK` (`contractor_id`),
  KEY `vehicle_typeFK` (`vehicle_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES (1,'DEC-DFE1','4B7DH3LDJNEE945D','1982',2,2,1),(2,'KD8-2GX','56JFBNWUMNSJMWJ6','1995',1,8,5),(3,'HHG-JIN','JF58R6F82V8E2D68','2008',4,7,2),(4,'J7F-901','5F4E7D2G4R7W9S21','2005',2,8,4),(5,'KD9-5DS','J4GH56E8D4Q1A7D1','2007',5,2,3),(6,'MNK-GGT','5D6E27D11H5JK7RT','1999',7,9,6),(7,'5D6-D6D','JKD845JFU58FK2LH','1995',6,9,1),(8,'L04-K9H','KD856JFLWKFM945J','2005',4,1,7),(9,'RB3-5D8','6DJELOD0PCKJADDD','1983',2,4,4),(10,'DEE-V89','KDMC83JKCH30CL22','1994',5,5,5),(11,'EKE-83D','DJDKC378DALCX893','1979',4,2,3),(12,'FE3-EF3','KDHE83DHENCX83DD','1985',8,3,2);
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-25 22:46:07
