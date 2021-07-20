-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: egph_juegos
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.18-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `id_administrador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `email` varchar(30) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `cantidad_intentos` int(11) DEFAULT 0,
  PRIMARY KEY (`id_administrador`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'elDogor','jairfm01@gmail.com','0fde98c2451d096167c7cc772467826f',0),(2,'Jair','elgordotonypty@gmail.com','6a6c76e22fcfa7ea0a5f1b4613872e5b',3);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` varchar(10) NOT NULL,
  `fecha_N` date NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Jose Perez','Arraijan, Vacamonte','66889751','1999-12-01'),(2,'Daniel Flores','La Chorrera, Lomas de Mastranto','64879751','1989-06-21'),(3,'Javier Aparicio','Concepcion, Bugaba','679364891','1999-01-10'),(4,'Maryorie Channis','Boquete, Los Naranjos','68759632','2005-10-25'),(5,'Ariel Vergara','Arraijan, El Tecal','668897512','1999-12-01'),(6,'Dilan de la Cruz','Arraijan, El Chumical','69586413','1991-05-27'),(7,'Ariel Batista','Chitre, Vilas del Golf','69741359','2008-09-29'),(8,'Justein Valdez','Cuarare, El macano, Vacamonte','63616467','2003-07-15'),(9,'Sebatian Garcia','Las Tablas, Linda Vista','69987418','1970-03-06'),(10,'Ana Muñoz','Pocri, Iglessia de Pocri','63160248','2015-12-15'),(11,'Anyelys Murgas','Colon, Sabanitas','69784515','1988-11-11'),(12,'Nazarith Yanquez','San Miguelito, Los Andes','690315478','2001-04-08'),(13,'Hillary Pinzon','Via Argentina','65984723','2010-05-01'),(14,'Michell Anaya','Chorrillo','63015701','2005-08-09');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_factura`
--

DROP TABLE IF EXISTS `detalle_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_factura` (
  `id_detalle_factura` int(11) NOT NULL AUTO_INCREMENT,
  `id_factura` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `precio_unitario` double NOT NULL,
  PRIMARY KEY (`id_detalle_factura`),
  KEY `id_factura` (`id_factura`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `detalle_factura_ibfk_1` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`),
  CONSTRAINT `detalle_factura_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_factura`
--

LOCK TABLES `detalle_factura` WRITE;
/*!40000 ALTER TABLE `detalle_factura` DISABLE KEYS */;
INSERT INTO `detalle_factura` VALUES (1,1,2,3,62.97),(2,1,4,1,15.99),(3,1,8,1,25.99),(4,2,3,10,409.90000000000003),(5,2,1,10,609.9),(6,3,5,1,7.99),(7,3,4,2,31.98);
/*!40000 ALTER TABLE `detalle_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `id_factura` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `precio_total` double NOT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `fk_cliente` (`id_cliente`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,1,'2021-07-20',104.94999999999999),(2,10,'2021-07-20',2039.6),(3,2,'2021-07-20',79.94);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `cantidad_disponible` int(11) NOT NULL,
  `precio_unitario` double NOT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Call of Duty Black Ops 2',110,60.99),(2,'Minecraft',997,20.99),(3,'Call of Duty Modern Warfare 3',70,40.99),(4,'She will punish them',47,15.99),(5,'Dead by DeadLight',39,7.99),(6,'She will punish them',50,15.99),(7,'Rsident Evil 5',50,35.99),(8,'Ark',49,25.99),(9,'Grand Theft Auto V',100,20.99),(10,'Doki Doki Literatura Club',10,10.99),(11,'Red Dead Redemption II',120,50.99),(12,'DAY Z',50,10.99),(13,'League of Legends',100,20.99),(14,'Final Fantasy IX',60,35.99),(15,'Hitman II',30,45.99),(16,'The Legend Zelda Majoras Mask',40,25.99),(17,'The Legend Zelda Ocarina Of Time',30,15.99),(18,'God of War',30,20.99),(19,'Metal Gear',50,40.99),(20,'Metal Slug',200,1.99),(21,'Need For Speed Underground 2',200,1.99);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-20 17:19:56
