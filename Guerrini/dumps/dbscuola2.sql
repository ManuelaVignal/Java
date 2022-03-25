-- MySQL dump 10.19  Distrib 10.3.31-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: DBScuola
-- ------------------------------------------------------
-- Server version	10.3.31-MariaDB-0+deb10u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_anagrafiche`
--

DROP TABLE IF EXISTS `t_anagrafiche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_anagrafiche` (
  `id_anagrafica` int(11) NOT NULL AUTO_INCREMENT,
  `cognome` varchar(45) NOT NULL,
  `nome` varchar(65) NOT NULL,
  `pv` varchar(4) NOT NULL,
  PRIMARY KEY (`id_anagrafica`),
  KEY `idxcog` (`cognome`,`nome`),
  KEY `fk_pv_idx` (`pv`),
  CONSTRAINT `fk_anagpv` FOREIGN KEY (`pv`) REFERENCES `t_province` (`pv`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_anagrafiche`
--

LOCK TABLES `t_anagrafiche` WRITE;
/*!40000 ALTER TABLE `t_anagrafiche` DISABLE KEYS */;
INSERT INTO `t_anagrafiche` VALUES (1,'vignal','manuela','to'),(2,'rossi','mario','vc'),(3,'bianchi','maria','at'),(4,'pippo','pluto','cn'),(5,'vignal','manuela','to'),(6,'vignal','sandra','no'),(7,'sebastiani','serena','to'),(8,'rossetto','pluto','cn'),(9,'vignal','carlo','to'),(10,'mancuso ','bettina','vb');
/*!40000 ALTER TABLE `t_anagrafiche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_corsi`
--

DROP TABLE IF EXISTS `t_corsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_corsi` (
  `id_corso` int(11) NOT NULL AUTO_INCREMENT,
  `titolocorso` varchar(250) NOT NULL,
  `descrizionecorso` varchar(1000) DEFAULT NULL,
  `datainizio` date DEFAULT NULL,
  `duratacorso` smallint(6) DEFAULT NULL,
  `costocorso` decimal(6,2) DEFAULT NULL,
  `datacreazione` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_corso`),
  UNIQUE KEY `udx_tc` (`titolocorso`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_corsi`
--

LOCK TABLES `t_corsi` WRITE;
/*!40000 ALTER TABLE `t_corsi` DISABLE KEYS */;
INSERT INTO `t_corsi` VALUES (1,'java db',NULL,'2022-02-02',100,100.00,'2022-03-03 14:02:14'),(2,'html5','css js html','2022-02-03',50,50.00,'2022-03-03 14:02:14'),(3,'inglese','talk and pick','2022-02-01',12,100.00,'2022-03-03 14:06:14'),(8,'jakarta EE edizione 3','applicazioni web con jakarta EE','2022-03-09',120,0.00,'2022-03-08 23:00:00'),(9,'sql','sql data base','2002-03-09',100,100.00,'2022-03-10 07:55:41');
/*!40000 ALTER TABLE `t_corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_iscrizioni`
--

DROP TABLE IF EXISTS `t_iscrizioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_iscrizioni` (
  `id_iscrizione` int(11) NOT NULL AUTO_INCREMENT,
  `id_anagrafica` int(11) NOT NULL,
  `id_corso` int(11) NOT NULL,
  `dataiscrizione` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id_iscrizione`),
  UNIQUE KEY `udx_anc` (`id_anagrafica`,`id_corso`),
  KEY `idxiscran` (`id_anagrafica`),
  KEY `idxiscrc` (`id_corso`),
  CONSTRAINT `fk_iscran` FOREIGN KEY (`id_anagrafica`) REFERENCES `t_anagrafiche` (`id_anagrafica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iscrc` FOREIGN KEY (`id_corso`) REFERENCES `t_corsi` (`id_corso`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_iscrizioni`
--

LOCK TABLES `t_iscrizioni` WRITE;
/*!40000 ALTER TABLE `t_iscrizioni` DISABLE KEYS */;
INSERT INTO `t_iscrizioni` VALUES (1,1,1,'2022-03-08 09:54:35'),(2,2,2,'2022-03-08 09:54:35'),(3,3,3,'2022-03-08 09:54:35'),(5,4,1,'2022-03-08 14:36:58');
/*!40000 ALTER TABLE `t_iscrizioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_opzioni`
--

DROP TABLE IF EXISTS `t_opzioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_opzioni` (
  `idt_opzioni` int(11) NOT NULL AUTO_INCREMENT,
  `ivastd` decimal(4,2) DEFAULT NULL,
  `scontostd` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`idt_opzioni`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_opzioni`
--

LOCK TABLES `t_opzioni` WRITE;
/*!40000 ALTER TABLE `t_opzioni` DISABLE KEYS */;
INSERT INTO `t_opzioni` VALUES (1,22.00,25.00);
/*!40000 ALTER TABLE `t_opzioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_province`
--

DROP TABLE IF EXISTS `t_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_province` (
  `pv` varchar(4) NOT NULL,
  PRIMARY KEY (`pv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_province`
--

LOCK TABLES `t_province` WRITE;
/*!40000 ALTER TABLE `t_province` DISABLE KEYS */;
INSERT INTO `t_province` VALUES ('al'),('at'),('bi'),('cn'),('no'),('to'),('vb'),('vc');
/*!40000 ALTER TABLE `t_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_anagrafica_no_iscrizione`
--

DROP TABLE IF EXISTS `v_anagrafica_no_iscrizione`;
/*!50001 DROP VIEW IF EXISTS `v_anagrafica_no_iscrizione`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_anagrafica_no_iscrizione` (
  `id_anagrafica` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `pv` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_corso_best`
--

DROP TABLE IF EXISTS `v_corso_best`;
/*!50001 DROP VIEW IF EXISTS `v_corso_best`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_corso_best` (
  `id_corso` tinyint NOT NULL,
  `titolocorso` tinyint NOT NULL,
  `tot_iscritti` tinyint NOT NULL,
  `costocorso` tinyint NOT NULL,
  `costo_noiva` tinyint NOT NULL,
  `profitto` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_corso_best_alunni`
--

DROP TABLE IF EXISTS `v_corso_best_alunni`;
/*!50001 DROP VIEW IF EXISTS `v_corso_best_alunni`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_corso_best_alunni` (
  `id_corso` tinyint NOT NULL,
  `titolocorso` tinyint NOT NULL,
  `tot_iscritti` tinyint NOT NULL,
  `costocorso` tinyint NOT NULL,
  `costo_noiva` tinyint NOT NULL,
  `profitto` tinyint NOT NULL,
  `id_anagrafica` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `pv` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_corsook`
--

DROP TABLE IF EXISTS `v_corsook`;
/*!50001 DROP VIEW IF EXISTS `v_corsook`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_corsook` (
  `id_corso` tinyint NOT NULL,
  `descrizionecorso` tinyint NOT NULL,
  `datainizio` tinyint NOT NULL,
  `duratacorso` tinyint NOT NULL,
  `titolocorso` tinyint NOT NULL,
  `costocorso` tinyint NOT NULL,
  `costo_noiva` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_iscrizioni_full`
--

DROP TABLE IF EXISTS `v_iscrizioni_full`;
/*!50001 DROP VIEW IF EXISTS `v_iscrizioni_full`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_iscrizioni_full` (
  `id_iscrizione` tinyint NOT NULL,
  `id_anagrafica` tinyint NOT NULL,
  `id_corso` tinyint NOT NULL,
  `dataiscrizione` tinyint NOT NULL,
  `titolocorso` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `costocorso` tinyint NOT NULL,
  `duratacorso` tinyint NOT NULL,
  `pv` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_profitti_corsi`
--

DROP TABLE IF EXISTS `v_profitti_corsi`;
/*!50001 DROP VIEW IF EXISTS `v_profitti_corsi`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_profitti_corsi` (
  `id_corso` tinyint NOT NULL,
  `titolocorso` tinyint NOT NULL,
  `tot_iscritti` tinyint NOT NULL,
  `costocorso` tinyint NOT NULL,
  `costo_noiva` tinyint NOT NULL,
  `profitto` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_anagrafica_no_iscrizione`
--

/*!50001 DROP TABLE IF EXISTS `v_anagrafica_no_iscrizione`*/;
/*!50001 DROP VIEW IF EXISTS `v_anagrafica_no_iscrizione`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_anagrafica_no_iscrizione` AS select `a`.`id_anagrafica` AS `id_anagrafica`,`a`.`cognome` AS `cognome`,`a`.`nome` AS `nome`,`a`.`pv` AS `pv` from (`t_anagrafiche` `a` left join `t_iscrizioni` `i` on(`a`.`id_anagrafica` = `i`.`id_anagrafica`)) where `i`.`id_iscrizione` is null order by `a`.`cognome`,`a`.`nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_corso_best`
--

/*!50001 DROP TABLE IF EXISTS `v_corso_best`*/;
/*!50001 DROP VIEW IF EXISTS `v_corso_best`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_corso_best` AS select `v_profitti_corsi`.`id_corso` AS `id_corso`,`v_profitti_corsi`.`titolocorso` AS `titolocorso`,`v_profitti_corsi`.`tot_iscritti` AS `tot_iscritti`,`v_profitti_corsi`.`costocorso` AS `costocorso`,`v_profitti_corsi`.`costo_noiva` AS `costo_noiva`,`v_profitti_corsi`.`profitto` AS `profitto` from `v_profitti_corsi` limit 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_corso_best_alunni`
--

/*!50001 DROP TABLE IF EXISTS `v_corso_best_alunni`*/;
/*!50001 DROP VIEW IF EXISTS `v_corso_best_alunni`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_corso_best_alunni` AS select `c`.`id_corso` AS `id_corso`,`c`.`titolocorso` AS `titolocorso`,`c`.`tot_iscritti` AS `tot_iscritti`,`c`.`costocorso` AS `costocorso`,`c`.`costo_noiva` AS `costo_noiva`,`c`.`profitto` AS `profitto`,`a`.`id_anagrafica` AS `id_anagrafica`,`a`.`cognome` AS `cognome`,`a`.`nome` AS `nome`,`a`.`pv` AS `pv` from ((`v_corso_best` `c` join `t_iscrizioni` `i` on(`c`.`id_corso` = `i`.`id_corso`)) join `t_anagrafiche` `a` on(`a`.`id_anagrafica` = `i`.`id_anagrafica`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_corsook`
--

/*!50001 DROP TABLE IF EXISTS `v_corsook`*/;
/*!50001 DROP VIEW IF EXISTS `v_corsook`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_corsook` AS select `t_corsi`.`id_corso` AS `id_corso`,`t_corsi`.`descrizionecorso` AS `descrizionecorso`,`t_corsi`.`datainizio` AS `datainizio`,`t_corsi`.`duratacorso` AS `duratacorso`,ucase(`t_corsi`.`titolocorso`) AS `titolocorso`,`t_corsi`.`costocorso` AS `costocorso`,`t_corsi`.`costocorso` * (1 / (1 + `o`.`ivastd` / 100)) AS `costo_noiva` from (`t_corsi` join `t_opzioni` `o`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_iscrizioni_full`
--

/*!50001 DROP TABLE IF EXISTS `v_iscrizioni_full`*/;
/*!50001 DROP VIEW IF EXISTS `v_iscrizioni_full`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_iscrizioni_full` AS select `i`.`id_iscrizione` AS `id_iscrizione`,`i`.`id_anagrafica` AS `id_anagrafica`,`i`.`id_corso` AS `id_corso`,`i`.`dataiscrizione` AS `dataiscrizione`,`c`.`titolocorso` AS `titolocorso`,`a`.`cognome` AS `cognome`,`a`.`nome` AS `nome`,`c`.`costocorso` AS `costocorso`,`c`.`duratacorso` AS `duratacorso`,`a`.`pv` AS `pv` from ((`t_iscrizioni` `i` join `t_corsi` `c`) join `t_anagrafiche` `a`) where `i`.`id_corso` = `c`.`id_corso` and `i`.`id_anagrafica` = `a`.`id_anagrafica` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_profitti_corsi`
--

/*!50001 DROP TABLE IF EXISTS `v_profitti_corsi`*/;
/*!50001 DROP VIEW IF EXISTS `v_profitti_corsi`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_profitti_corsi` AS select `c`.`id_corso` AS `id_corso`,`c`.`titolocorso` AS `titolocorso`,count(`i`.`id_iscrizione`) AS `tot_iscritti`,`c`.`costocorso` AS `costocorso`,`c`.`costo_noiva` AS `costo_noiva`,`c`.`costo_noiva` * count(`i`.`id_iscrizione`) AS `profitto` from (`v_corsook` `c` left join `t_iscrizioni` `i` on(`c`.`id_corso` = `i`.`id_corso`)) group by `c`.`id_corso` order by `c`.`costo_noiva` * count(`i`.`id_iscrizione`) desc,`c`.`titolocorso` */;
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

-- Dump completed on 2022-03-14  9:06:35
