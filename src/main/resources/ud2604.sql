DROP TABLE IF EXISTS `facultad`;
SET character_set_client = utf8mb4 ;

CREATE TABLE `facultad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `facultad` WRITE;
/*!40000 ALTER TABLE `facultad` DISABLE KEYS */;
INSERT INTO `facultad` VALUES (1,'facultad 1'),(2,'facultad 2'),(3,'facultad 3'),(4,'facultad 4');
/*!40000 ALTER TABLE `facultad` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `investigadores`;
SET character_set_client = utf8mb4 ;

CREATE TABLE `investigadores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom_apels` varchar(255) DEFAULT NULL,
  `facultad` int,
  PRIMARY KEY (`id`),
  CONSTRAINT facultad_inv_fk FOREIGN KEY (facultad) REFERENCES facultad (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `investigadores` WRITE;
/*!40000 ALTER TABLE `investigadores` DISABLE KEYS */;
INSERT INTO `investigadores` VALUES (1,'investigador 1',1),(2,'investigador 2',2),(3,'investigador 3',3),(4,'investigador 4',4);
/*!40000 ALTER TABLE `investigadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `equipos` (
	`id` int NOT NULL AUTO_INCREMENT,
	nombre nvarchar(100),
    `facultad` int,
    primary key(id),
    CONSTRAINT facultad_equ_fk FOREIGN KEY (facultad) REFERENCES facultad (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` VALUES (1,'SD4D',1),(2,'FWE1',2),(3,'4CFE',3),(4,'WDQS',4);
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reserva` (
	id int not null auto_increment,
	investigador int,
    equipo int,
    comienzo datetime,
    fin datetime,
    primary key(id),
	CONSTRAINT investigador_fk FOREIGN KEY (investigador) REFERENCES investigadores (id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT equipos_fk FOREIGN KEY (equipo) REFERENCES equipos (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--
LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva`(investigador, equipo, comienzo, fin) VALUES (1,2,'2022-08-16','2022-08-20'),(3,1,'2022-07-16','2022-07-20');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;