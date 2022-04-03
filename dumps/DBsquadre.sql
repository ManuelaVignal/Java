-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: localhost    Database: DBsquadre
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `t_giocatori`
--

DROP TABLE IF EXISTS `t_giocatori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_giocatori` (
  `id_giocatore` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `pv` varchar(10) NOT NULL,
  `id_squadra` int unsigned NOT NULL,
  PRIMARY KEY (`id_giocatore`),
  KEY `fk_giocatore_idx` (`id_squadra`),
  KEY `idx_giocatore` (`nome`,`cognome`),
  KEY `fk_gpv_idx` (`pv`),
  CONSTRAINT `fk_giocatore` FOREIGN KEY (`id_squadra`) REFERENCES `t_squadre` (`id_squadra`),
  CONSTRAINT `fk_gpv` FOREIGN KEY (`pv`) REFERENCES `t_province` (`pv`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_giocatori`
--

LOCK TABLES `t_giocatori` WRITE;
/*!40000 ALTER TABLE `t_giocatori` DISABLE KEYS */;
INSERT INTO `t_giocatori` VALUES (1,'mario','rossi','to',1),(2,'luca','verdi','cn',4),(3,'gianni','viola','al',6),(4,'alessio','blu','cs',3),(5,'raffaello','giallo','mi',2),(6,'manuele','bianchi','va',4);
/*!40000 ALTER TABLE `t_giocatori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_province`
--

DROP TABLE IF EXISTS `t_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_province` (
  `pv` varchar(4) NOT NULL,
  PRIMARY KEY (`pv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_province`
--

LOCK TABLES `t_province` WRITE;
/*!40000 ALTER TABLE `t_province` DISABLE KEYS */;
INSERT INTO `t_province` VALUES ('al'),('cn'),('cs'),('mi'),('to'),('va');
/*!40000 ALTER TABLE `t_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_squadre`
--

DROP TABLE IF EXISTS `t_squadre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_squadre` (
  `id_squadra` int unsigned NOT NULL AUTO_INCREMENT,
  `nomesquadra` varchar(45) NOT NULL,
  `provincia` varchar(4) NOT NULL,
  `allenatore` varchar(45) DEFAULT NULL,
  `punti` int unsigned DEFAULT '0',
  PRIMARY KEY (`id_squadra`),
  KEY `fk_sqpv_idx` (`provincia`),
  CONSTRAINT `fk_sqpv` FOREIGN KEY (`provincia`) REFERENCES `t_province` (`pv`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_squadre`
--

LOCK TABLES `t_squadre` WRITE;
/*!40000 ALTER TABLE `t_squadre` DISABLE KEYS */;
INSERT INTO `t_squadre` VALUES (1,'milan','mi','',5),(2,'inter','mi',NULL,7),(3,'juve','to',NULL,2),(4,'torino','to',NULL,3),(5,'cosenza','cs',NULL,4),(6,'alessandria','al',NULL,0);
/*!40000 ALTER TABLE `t_squadre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_squadra_giocatore`
--

DROP TABLE IF EXISTS `v_squadra_giocatore`;
/*!50001 DROP VIEW IF EXISTS `v_squadra_giocatore`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_squadra_giocatore` AS SELECT 
 1 AS `id_squadra`,
 1 AS `nomesquadra`,
 1 AS `provincia`,
 1 AS `punti`,
 1 AS `id_giocatore`,
 1 AS `nome`,
 1 AS `cognome`,
 1 AS `pv`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_squadra_giocatore`
--

/*!50001 DROP VIEW IF EXISTS `v_squadra_giocatore`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_squadra_giocatore` AS select `s`.`id_squadra` AS `id_squadra`,`s`.`nomesquadra` AS `nomesquadra`,`s`.`provincia` AS `provincia`,`s`.`punti` AS `punti`,`g`.`id_giocatore` AS `id_giocatore`,`g`.`nome` AS `nome`,`g`.`cognome` AS `cognome`,`g`.`pv` AS `pv` from (`t_squadre` `s` join `t_giocatori` `g` on((`s`.`id_squadra` = `g`.`id_squadra`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-03 17:14:44
