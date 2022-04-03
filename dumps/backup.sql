-- MySQL dump 10.19  Distrib 10.3.31-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: dbscuoladmps
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
  KEY `fkpv_idx` (`pv`),
  CONSTRAINT `fk_anagpv` FOREIGN KEY (`pv`) REFERENCES `t_province` (`pv`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_anagrafiche`
--

LOCK TABLES `t_anagrafiche` WRITE;
/*!40000 ALTER TABLE `t_anagrafiche` DISABLE KEYS */;
INSERT INTO `t_anagrafiche` VALUES (1,'rossi','mario','to'),(2,'bianchi','maria','cn'),(7,'torri','Alessandro','cn'),(8,'garda','Paolo','al'),(9,'redi','filippo','to'),(10,'magni','alex','to'),(11,'newton','isaac','to'),(12,'keplero','gio','to'),(13,'ainstain','newton','to');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_corsi`
--

LOCK TABLES `t_corsi` WRITE;
/*!40000 ALTER TABLE `t_corsi` DISABLE KEYS */;
INSERT INTO `t_corsi` VALUES (1,'java db',NULL,'2022-02-02',100,100.00,'2022-03-03 13:01:13'),(2,'html5','css js html','2022-02-03',50,50.00,'2022-03-03 13:01:13'),(3,'inglese','talk and pick','2022-03-03',12,100.00,'2022-03-03 13:04:01'),(4,'jakarta EE','applicazioni web con jakarta EE','2022-03-07',200,0.00,'2022-03-07 12:28:39'),(6,'IOT wio seed','IOT develop red node','2022-05-05',80,500.00,NULL);
/*!40000 ALTER TABLE `t_corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_docenti`
--

DROP TABLE IF EXISTS `t_docenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_docenti` (
  `id_docente` int(11) NOT NULL AUTO_INCREMENT,
  `id_anagrafica` int(11) NOT NULL,
  `id_corso` int(11) NOT NULL,
  `costoorario` decimal(5,2) DEFAULT NULL,
  `oredocenza` smallint(5) unsigned DEFAULT 0,
  PRIMARY KEY (`id_docente`),
  UNIQUE KEY `idunique` (`id_corso`,`id_anagrafica`),
  KEY `idxdocente` (`id_anagrafica`),
  KEY `idxdocc` (`id_corso`),
  CONSTRAINT `fkdoca` FOREIGN KEY (`id_anagrafica`) REFERENCES `t_anagrafiche` (`id_anagrafica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkdocc` FOREIGN KEY (`id_corso`) REFERENCES `t_corsi` (`id_corso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_docenti`
--

LOCK TABLES `t_docenti` WRITE;
/*!40000 ALTER TABLE `t_docenti` DISABLE KEYS */;
INSERT INTO `t_docenti` VALUES (1,11,1,100.00,50),(2,12,1,80.00,50),(3,13,2,200.00,45),(4,12,2,80.00,5),(5,11,3,100.00,10);
/*!40000 ALTER TABLE `t_docenti` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_iscrizioni`
--

LOCK TABLES `t_iscrizioni` WRITE;
/*!40000 ALTER TABLE `t_iscrizioni` DISABLE KEYS */;
INSERT INTO `t_iscrizioni` VALUES (1,1,1,'2022-03-08 08:54:37'),(2,2,1,'2022-03-08 08:54:37'),(3,1,2,'2022-03-08 08:54:37');
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
  `sogliacorto` smallint(4) unsigned DEFAULT NULL,
  `sogliamedio` smallint(4) unsigned DEFAULT NULL,
  `soglialungo` smallint(4) unsigned DEFAULT NULL,
  PRIMARY KEY (`idt_opzioni`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_opzioni`
--

LOCK TABLES `t_opzioni` WRITE;
/*!40000 ALTER TABLE `t_opzioni` DISABLE KEYS */;
INSERT INTO `t_opzioni` VALUES (1,22.00,25.00,50,100,120);
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
-- Table structure for table `tmpdel`
--

DROP TABLE IF EXISTS `tmpdel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmpdel` (
  `id_anagrafica` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmpdel`
--

LOCK TABLES `tmpdel` WRITE;
/*!40000 ALTER TABLE `tmpdel` DISABLE KEYS */;
INSERT INTO `tmpdel` VALUES (5),(6);
/*!40000 ALTER TABLE `tmpdel` ENABLE KEYS */;
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
-- Temporary table structure for view `v_andamento_corsi`
--

DROP TABLE IF EXISTS `v_andamento_corsi`;
/*!50001 DROP VIEW IF EXISTS `v_andamento_corsi`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_andamento_corsi` (
  `id_corso` tinyint NOT NULL,
  `titolocorso` tinyint NOT NULL,
  `costodocenza` tinyint NOT NULL,
  `totoredocenza` tinyint NOT NULL,
  `totaleoredocenza` tinyint NOT NULL,
  `numdocenti` tinyint NOT NULL,
  `oremancanti` tinyint NOT NULL,
  `costocorso` tinyint NOT NULL,
  `numiscrittiminimo` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_corsi_fasce`
--

DROP TABLE IF EXISTS `v_corsi_fasce`;
/*!50001 DROP VIEW IF EXISTS `v_corsi_fasce`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_corsi_fasce` (
  `id_corso` tinyint NOT NULL,
  `fasciacorso` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_corsi_ok`
--

DROP TABLE IF EXISTS `v_corsi_ok`;
/*!50001 DROP VIEW IF EXISTS `v_corsi_ok`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_corsi_ok` (
  `titolocorso` tinyint NOT NULL,
  `id_corso` tinyint NOT NULL,
  `duratacorso` tinyint NOT NULL,
  `descrizionecorso` tinyint NOT NULL,
  `datainizio` tinyint NOT NULL,
  `costocorso` tinyint NOT NULL,
  `datacreazione` tinyint NOT NULL,
  `costo_noiva` tinyint NOT NULL
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
  `profitto` tinyint NOT NULL,
  `id_anagrafica` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `pv` tinyint NOT NULL
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
  `duratacorso` tinyint NOT NULL,
  `costocorso` tinyint NOT NULL,
  `cognome` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `pv` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_profitto_corsi`
--

DROP TABLE IF EXISTS `v_profitto_corsi`;
/*!50001 DROP VIEW IF EXISTS `v_profitto_corsi`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_profitto_corsi` (
  `id_corso` tinyint NOT NULL,
  `titolocorso` tinyint NOT NULL,
  `tot_iscritti` tinyint NOT NULL,
  `profitto` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'dbscuoladmps'
--
/*!50003 DROP PROCEDURE IF EXISTS `corsiprofitto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`tss`@`localhost` PROCEDURE `corsiprofitto`(minprofitto int)
BEGIN
  SELECT 
        `c`.`id_corso` AS `id_corso`,
        `c`.`titolocorso` AS `titolocorso`,
        COUNT(`i`.`id_iscrizione`) AS `tot_iscritti`,
        ROUND(`c`.`costo_noiva` * COUNT(`i`.`id_iscrizione`),
                2) AS `profitto`
 FROM
        (`v_corsi_ok` `c`
        LEFT JOIN `t_iscrizioni` `i` ON (`c`.`id_corso` = `i`.`id_corso`))
        
	GROUP BY `c`.`id_corso`
    
      HAVING profitto >minprofitto
    
       ORDER BY ROUND(`c`.`costo_noiva` * COUNT(`i`.`id_iscrizione`),
            2) DESC , `c`.`titolocorso`;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `del_anagrafiche_unused` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`tss`@`localhost` PROCEDURE `del_anagrafiche_unused`(quanti int )
BEGIN

drop table if exists tmpdel;
create table tmpdel as 
SELECT a.id_anagrafica FROM 

  t_anagrafiche a 
  left join t_iscrizioni i on a.id_anagrafica= i.id_anagrafica
  left join  t_docenti d on a.id_anagrafica = d.id_anagrafica
  
where i.id_iscrizione is null and d.id_docente is null

order by a.id_anagrafica

limit quanti;

delete from t_anagrafiche 
where id_anagrafica in(select id_anagrafica from tmpdel);




END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
-- Final view structure for view `v_andamento_corsi`
--

/*!50001 DROP TABLE IF EXISTS `v_andamento_corsi`*/;
/*!50001 DROP VIEW IF EXISTS `v_andamento_corsi`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_andamento_corsi` AS select `c`.`id_corso` AS `id_corso`,`c`.`titolocorso` AS `titolocorso`,sum(`d`.`costoorario` * `d`.`oredocenza`) AS `costodocenza`,sum(`d`.`oredocenza`) AS `totoredocenza`,sum(`d`.`oredocenza`) AS `totaleoredocenza`,count(0) AS `numdocenti`,`c`.`duratacorso` - sum(`d`.`oredocenza`) AS `oremancanti`,`c`.`costocorso` AS `costocorso`,sum(`d`.`costoorario` * `d`.`oredocenza`) / `c`.`costocorso` AS `numiscrittiminimo` from (`t_corsi` `c` join `t_docenti` `d` on(`c`.`id_corso` = `d`.`id_corso`)) group by `c`.`id_corso` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_corsi_fasce`
--

/*!50001 DROP TABLE IF EXISTS `v_corsi_fasce`*/;
/*!50001 DROP VIEW IF EXISTS `v_corsi_fasce`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_corsi_fasce` AS select `t_corsi`.`id_corso` AS `id_corso`,case when `t_corsi`.`duratacorso` < `t_opzioni`.`sogliacorto` then 'corto' when `t_corsi`.`duratacorso` < `t_opzioni`.`sogliamedio` then 'medio' when `t_corsi`.`duratacorso` < `t_opzioni`.`soglialungo` then 'lungo' else 'extra' end AS `fasciacorso` from (`t_corsi` join `t_opzioni`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_corsi_ok`
--

/*!50001 DROP TABLE IF EXISTS `v_corsi_ok`*/;
/*!50001 DROP VIEW IF EXISTS `v_corsi_ok`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_corsi_ok` AS select ucase(`c`.`titolocorso`) AS `titolocorso`,`c`.`id_corso` AS `id_corso`,`c`.`duratacorso` AS `duratacorso`,`c`.`descrizionecorso` AS `descrizionecorso`,`c`.`datainizio` AS `datainizio`,`c`.`costocorso` AS `costocorso`,`c`.`datacreazione` AS `datacreazione`,`c`.`costocorso` * (1 / (1 + `o`.`ivastd` / 100)) AS `costo_noiva` from (`t_corsi` `c` join `t_opzioni` `o`) */;
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
/*!50001 VIEW `v_corso_best` AS select `v_profitto_corsi`.`id_corso` AS `id_corso`,`v_profitto_corsi`.`titolocorso` AS `titolocorso`,`v_profitto_corsi`.`tot_iscritti` AS `tot_iscritti`,`v_profitto_corsi`.`profitto` AS `profitto` from `v_profitto_corsi` limit 1 */;
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
/*!50001 VIEW `v_corso_best_alunni` AS select `c`.`id_corso` AS `id_corso`,`c`.`titolocorso` AS `titolocorso`,`c`.`tot_iscritti` AS `tot_iscritti`,`c`.`profitto` AS `profitto`,`a`.`id_anagrafica` AS `id_anagrafica`,`a`.`cognome` AS `cognome`,`a`.`nome` AS `nome`,`a`.`pv` AS `pv` from ((`v_corso_best` `c` join `t_iscrizioni` `i` on(`c`.`id_corso` = `i`.`id_corso`)) join `t_anagrafiche` `a` on(`i`.`id_anagrafica` = `a`.`id_anagrafica`)) */;
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
/*!50001 VIEW `v_iscrizioni_full` AS select `i`.`id_iscrizione` AS `id_iscrizione`,`i`.`id_anagrafica` AS `id_anagrafica`,`i`.`id_corso` AS `id_corso`,`i`.`dataiscrizione` AS `dataiscrizione`,`c`.`titolocorso` AS `titolocorso`,`c`.`duratacorso` AS `duratacorso`,`c`.`costocorso` AS `costocorso`,`a`.`cognome` AS `cognome`,`a`.`nome` AS `nome`,`a`.`pv` AS `pv` from ((`t_iscrizioni` `i` join `t_corsi` `c`) join `t_anagrafiche` `a`) where `i`.`id_corso` = `c`.`id_corso` and `i`.`id_anagrafica` = `a`.`id_anagrafica` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_profitto_corsi`
--

/*!50001 DROP TABLE IF EXISTS `v_profitto_corsi`*/;
/*!50001 DROP VIEW IF EXISTS `v_profitto_corsi`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`tss`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_profitto_corsi` AS select `c`.`id_corso` AS `id_corso`,`c`.`titolocorso` AS `titolocorso`,count(`i`.`id_iscrizione`) AS `tot_iscritti`,round(`c`.`costo_noiva` * count(`i`.`id_iscrizione`),2) AS `profitto` from (`v_corsi_ok` `c` left join `t_iscrizioni` `i` on(`c`.`id_corso` = `i`.`id_corso`)) group by `c`.`id_corso` order by round(`c`.`costo_noiva` * count(`i`.`id_iscrizione`),2) desc,`c`.`titolocorso` */;
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

-- Dump completed on 2022-03-17  9:06:59
