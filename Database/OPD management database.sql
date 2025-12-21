-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: opd_management
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `concession` varchar(255) DEFAULT NULL,
  `consultation_fee` decimal(38,2) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `paid_amount` decimal(38,2) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `pending_amount` decimal(38,2) DEFAULT NULL,
  `total_amount` decimal(38,2) DEFAULT NULL,
  `visit_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaraxwmte10xirv8dsexgwrpoy` (`visit_id`),
  CONSTRAINT `FKaraxwmte10xirv8dsexgwrpoy` FOREIGN KEY (`visit_id`) REFERENCES `visits` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (1,'10%',500.00,'2025-11-25',300.00,'UPI','Partially Paid',200.00,500.00,1);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnostics`
--

DROP TABLE IF EXISTS `diagnostics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnostics` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `visit_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2vbacb9cdm8ttcdd5wj1f6s9n` (`doctor_id`),
  KEY `FKikekh5nqakxo73c4ukx3rjtkv` (`visit_id`),
  CONSTRAINT `FK2vbacb9cdm8ttcdd5wj1f6s9n` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `FKikekh5nqakxo73c4ukx3rjtkv` FOREIGN KEY (`visit_id`) REFERENCES `visits` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostics`
--

LOCK TABLES `diagnostics` WRITE;
/*!40000 ALTER TABLE `diagnostics` DISABLE KEYS */;
INSERT INTO `diagnostics` VALUES (2,'2025-11-22','CBC (Complete Blood Count)',1,1);
/*!40000 ALTER TABLE `diagnostics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `clinic_name` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobileno` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'tarale khurd ,Radhanagari','patil clinic','1970-01-01','patilraj@gmail.com','7653274343','Dr.Rajvardhan patil','raj123','Stomac indose','live','dvscythgvbaiu','1970-01-01'),(3,'Nashik, Maharashtra','HealthCare Clinic','2025-11-22','amit.deshmukh@example.com','9876543210','Dr. Amit Deshmukh','doctor123','General Physician','active','abcd1234xyz890','2025-11-22'),(6,'At-Tarale Khurd , Post- Kasaba Tarale,','Shree clinic','2025-12-06','samu16@gmail.com','9239736833','Dr.Samiksha','sam123','Dentist','Active','','2025-12-06'),(7,'At-Tarale Khurd , Post- Kasaba Tarale','Patil Clinic','2025-12-06','pratiraj19@gmail.com','8638700792','Dr.Pratiraj','admin123','ENT','Active','','2025-12-06'),(8,'At-Post-save','City Clinic','2025-12-10','vaibhav12@gmail.com','9879868752','Dr.Vaibhav Patil','vaibhav123','Cardiologist','Active','','2025-12-10');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicines`
--

DROP TABLE IF EXISTS `medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicines` (
  `id` int NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8j7rpd3srtdnyanj17yjosga9` (`doctor_id`),
  CONSTRAINT `FK8j7rpd3srtdnyanj17yjosga9` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicines`
--

LOCK TABLES `medicines` WRITE;
/*!40000 ALTER TABLE `medicines` DISABLE KEYS */;
INSERT INTO `medicines` VALUES (1,'Paracetamol','Fever Tablet ',1);
/*!40000 ALTER TABLE `medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pathologytest`
--

DROP TABLE IF EXISTS `pathologytest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pathologytest` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `report_file` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `test_id` int DEFAULT NULL,
  `visit_id` int DEFAULT NULL,
  `testmaster_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKktm0lmqvg2d19tq12itvnow7a` (`test_id`),
  KEY `FKrk1ajxvn8tnx18dc2pr7uywco` (`visit_id`),
  KEY `FK5ierdbqlgar6jxbpqvvvom0c9` (`testmaster_id`),
  CONSTRAINT `FK5ierdbqlgar6jxbpqvvvom0c9` FOREIGN KEY (`testmaster_id`) REFERENCES `testmasters` (`id`),
  CONSTRAINT `FKktm0lmqvg2d19tq12itvnow7a` FOREIGN KEY (`test_id`) REFERENCES `visits` (`id`),
  CONSTRAINT `FKrk1ajxvn8tnx18dc2pr7uywco` FOREIGN KEY (`visit_id`) REFERENCES `visits` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pathologytest`
--

LOCK TABLES `pathologytest` WRITE;
/*!40000 ALTER TABLE `pathologytest` DISABLE KEYS */;
INSERT INTO `pathologytest` VALUES (2,'2025-11-27','No abnormalities detected','https://clinic-storage.com/reports/visit18/xray_scan.jpg','Normal Pathology',NULL,1,2);
/*!40000 ALTER TABLE `pathologytest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int NOT NULL,
  `alcohol` varchar(255) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `mobileno` varchar(255) DEFAULT NULL,
  `patient_name` varchar(255) DEFAULT NULL,
  `smoking` varchar(255) DEFAULT NULL,
  `tobacco` varchar(255) DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKperqpk72jxd90l8yq7qf5fsx0` (`doctor_id`),
  CONSTRAINT `FKperqpk72jxd90l8yq7qf5fsx0` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,'Pune, Maharashtra',32,'No','B+','2025-11-22','Male','172','9876543210','Rahul Sharma','No','No',1),(3,'At-Tarale Khurd Patil Galli  , Post- Kasaba Tarale,, Tal - Radhanagari , Dist- kolhapur, Pincode - 416211',22,'no','o+','2025-12-07','Male','178','9322965161','Rajvardhan','no','no',1),(4,'At-Tarale Khurd Patil Galli  , Post- Kasaba Tarale,, Tal - Radhanagari , Dist- kolhapur, Pincode - 416211',22,'no','o+','2025-12-07','Male','178','9322965161','Rajvardhan','no','no',NULL),(5,'At-Tarale Khurd Patil Galli  , Post- Kasaba Tarale,, Tal - Radhanagari , Dist- kolhapur, Pincode - 416211',22,'no','o+','2025-12-07','Male','178','9322965161','Rajvardhan','no','no',7),(6,'At-Shirgao,Tal - Radhanagari , Dist- kolhapur, Pincode - 416211',32,'no','o+','2025-12-07','Male','178','3874923244','Sangram','no','no',6),(7,'At-Arjunwada Tal - Radhanagari , Dist- kolhapur, Pincode - 416213',25,'no','o+','2025-12-07','Male','175','9364243434','Ashu','no','no',6),(8,'At-Post Save,Kolhapur',23,'Yes','AB+','2025-12-10','Male','175','9876764232','Pankaj','Yes','No',8),(9,'At -Pune ',35,'No','O+','2025-12-14','Female','172 cm','9876764232','Priyanka Patil','No','No',7),(10,'At - Kolhapur',26,'No','O+','2025-12-14','Female','175 cm','9767352643','Mansi Patil','No','No',7),(11,'At-Arjunwada Tal - Radhanagari , Dist- kolhapur, Pincode - 416213',27,'No','AB+','2025-12-17','Male','175 cm','9372485327','Omkar Patil','No','No',7);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receptions`
--

DROP TABLE IF EXISTS `receptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receptions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `shift` varchar(255) DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKoscf01c8ms1vwr1t6cry8ikoh` (`email`),
  KEY `FK7s8nlibk753wiyy6054sxjism` (`doctor_id`),
  CONSTRAINT `FK7s8nlibk753wiyy6054sxjism` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receptions`
--

LOCK TABLES `receptions` WRITE;
/*!40000 ALTER TABLE `receptions` DISABLE KEYS */;
INSERT INTO `receptions` VALUES (2,'rohan.kulkarni@example.com','Rohan Kulkarni','rohan@456','8765432109','Morning',7),(3,'anita@gmail.com','Anita','anita123','9876543210','Morning',1),(4,'thestranger328@gmail.com','Rajvardhan Uttam Patil ','admin1234','9322965161','Morning',6),(5,'aksh23@gmail.com','Akash','admin12345','9604620657','Evening',7);
/*!40000 ALTER TABLE `receptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referralcenters`
--

DROP TABLE IF EXISTS `referralcenters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referralcenters` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `contact_info` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl3g2sy458b6mjmssrfkimp3ae` (`doctor_id`),
  CONSTRAINT `FKl3g2sy458b6mjmssrfkimp3ae` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referralcenters`
--

LOCK TABLES `referralcenters` WRITE;
/*!40000 ALTER TABLE `referralcenters` DISABLE KEYS */;
INSERT INTO `referralcenters` VALUES (1,'Tarale Khurd, Maharashtra','9876543210','2025-01-10','Patil Medical Store','Pharmacy',1);
/*!40000 ALTER TABLE `referralcenters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referrals`
--

DROP TABLE IF EXISTS `referrals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referrals` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `deatils` varchar(255) DEFAULT NULL,
  `note_type` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `referral_center_id` int DEFAULT NULL,
  `visit_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhnrg7ughup096yvcmdj6ywh7v` (`doctor_id`),
  KEY `FKi9fhtcdfc8xpcq08p26w83haj` (`patient_id`),
  KEY `FKpqek4vj8wgh22794yds2ur388` (`referral_center_id`),
  KEY `FKaee5q8sbac0i1sygluohea224` (`visit_id`),
  CONSTRAINT `FKaee5q8sbac0i1sygluohea224` FOREIGN KEY (`visit_id`) REFERENCES `visits` (`id`),
  CONSTRAINT `FKhnrg7ughup096yvcmdj6ywh7v` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `FKi9fhtcdfc8xpcq08p26w83haj` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKpqek4vj8wgh22794yds2ur388` FOREIGN KEY (`referral_center_id`) REFERENCES `referralcenters` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referrals`
--

LOCK TABLES `referrals` WRITE;
/*!40000 ALTER TABLE `referrals` DISABLE KEYS */;
INSERT INTO `referrals` VALUES (2,'2025-11-25','Referred to cardiology department for further cardiac assessment due to chest discomfort and abnormal ECG patterns.','Referral Note','Patient requires specialist evaluation',3,1,1,1);
/*!40000 ALTER TABLE `referrals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testmasters`
--

DROP TABLE IF EXISTS `testmasters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testmasters` (
  `id` int NOT NULL AUTO_INCREMENT,
  `normal_range` varchar(255) DEFAULT NULL,
  `test_name` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKow8pyepc6lhhuxqjtmkbgnq5b` (`doctor_id`),
  CONSTRAINT `FKow8pyepc6lhhuxqjtmkbgnq5b` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testmasters`
--

LOCK TABLES `testmasters` WRITE;
/*!40000 ALTER TABLE `testmasters` DISABLE KEYS */;
INSERT INTO `testmasters` VALUES (2,'80 - 100','Blood Glucose (Fasting)','mg/dL',1);
/*!40000 ALTER TABLE `testmasters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitreports`
--

DROP TABLE IF EXISTS `visitreports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitreports` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creared_at` date DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `visit_id` int DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5s45yeear87eiqdyeq7geonnt` (`visit_id`),
  CONSTRAINT `FK5s45yeear87eiqdyeq7geonnt` FOREIGN KEY (`visit_id`) REFERENCES `visits` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitreports`
--

LOCK TABLES `visitreports` WRITE;
/*!40000 ALTER TABLE `visitreports` DISABLE KEYS */;
INSERT INTO `visitreports` VALUES (1,NULL,'Chest_Xray_Report.pdf','PDF','https://hospital-storage.com/uploads/visit15/chest_xray_report.pdf',1,NULL),(2,NULL,'Scan_Report.pdf','PDF','https://clinic-storage.com/visit20/scan_report.pdf',1,NULL);
/*!40000 ALTER TABLE `visitreports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visits`
--

DROP TABLE IF EXISTS `visits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `additional_notes` varchar(255) DEFAULT NULL,
  `advice` varchar(255) DEFAULT NULL,
  `bp` varchar(255) DEFAULT NULL,
  `cns` varchar(255) DEFAULT NULL,
  `complaints` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `current_medication` varchar(255) DEFAULT NULL,
  `cvs` varchar(255) DEFAULT NULL,
  `diagnosis` varchar(255) DEFAULT NULL,
  `ecg` varchar(255) DEFAULT NULL,
  `edema` varchar(255) DEFAULT NULL,
  `fasting_sugar` varchar(255) DEFAULT NULL,
  `followup_date` date DEFAULT NULL,
  `hb` varchar(255) DEFAULT NULL,
  `jaundice` varchar(255) DEFAULT NULL,
  `pa` varchar(255) DEFAULT NULL,
  `pallor` varchar(255) DEFAULT NULL,
  `past_history` varchar(255) DEFAULT NULL,
  `pp_sugar` varchar(255) DEFAULT NULL,
  `pulse` varchar(255) DEFAULT NULL,
  `random_sugar` varchar(255) DEFAULT NULL,
  `respiration_rate` varchar(255) DEFAULT NULL,
  `rs` varchar(255) DEFAULT NULL,
  `saturation` varchar(255) DEFAULT NULL,
  `sugar` varchar(255) DEFAULT NULL,
  `temperature` varchar(255) DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `urea_creatine` varchar(255) DEFAULT NULL,
  `visit_date` date DEFAULT NULL,
  `weight` int NOT NULL,
  `doctor_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKth95fndjk3y3nepjfu3f66r63` (`doctor_id`),
  KEY `FKra5p2e0tp6djolm46kdr42cyt` (`patient_id`),
  CONSTRAINT `FKra5p2e0tp6djolm46kdr42cyt` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKth95fndjk3y3nepjfu3f66r63` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visits`
--

LOCK TABLES `visits` WRITE;
/*!40000 ALTER TABLE `visits` DISABLE KEYS */;
INSERT INTO `visits` VALUES (1,'Patient stable, advised rest','Rest, increased fluid intake, paracetamol 500mg','120/80','Grossly normal','Headache, mild fever, weakness since 2 days','2025-11-22','None','Normal S1, S2','Viral Fever','Normal sinus rhythm','No','95 mg/dL','2025-12-02','13.5 g/dL','No','Soft, non-tender','No','No major past illness','130 mg/dL','78','115 mg/dL','18/min','Clear','98%','110 mg/dL','99.5°F','2025-11-22','Normal','2025-11-22',68,1,1);
/*!40000 ALTER TABLE `visits` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-18 15:38:33
