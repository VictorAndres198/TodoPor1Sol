CREATE DATABASE  IF NOT EXISTS `bdbotica`;
USE `bdbotica`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdbotica
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `ajuste_comprobantes`
--

DROP TABLE IF EXISTS `ajuste_comprobantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ajuste_comprobantes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Fecha_Hora` datetime DEFAULT NULL,
  `motivo` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `monto` decimal(10,2) DEFAULT NULL,
  `ID_tipoComprobante` int NOT NULL,
  `ID_comprobante` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_AjusteComprobante_Comprobante1` (`ID_comprobante`),
  KEY `fk_AjusteComprobante_tipoComprobante1` (`ID_tipoComprobante`),
  CONSTRAINT `fk_AjusteComprobante_Comprobante1` FOREIGN KEY (`ID_comprobante`) REFERENCES `comprobantes` (`ID`),
  CONSTRAINT `fk_AjusteComprobante_tipoComprobante1` FOREIGN KEY (`ID_tipoComprobante`) REFERENCES `tipo_comprobantes` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ajuste_comprobantes`
--

LOCK TABLES `ajuste_comprobantes` WRITE;
/*!40000 ALTER TABLE `ajuste_comprobantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `ajuste_comprobantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `ID_categoria` int NOT NULL,
  `Nombre` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Medicamentos'),(2,'Suplementos'),(3,'Cuidado general');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_empresas`
--

DROP TABLE IF EXISTS `cliente_empresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_empresas` (
  `RUC` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `RazonSocial` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `Direccion` varchar(70) COLLATE utf8mb4_general_ci NOT NULL,
  `Telefono` varchar(9) COLLATE utf8mb4_general_ci NOT NULL,
  `Correo` varchar(60) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`RUC`),
  CONSTRAINT `fk_cliente_empresas_clientes1` FOREIGN KEY (`RUC`) REFERENCES `clientes` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_empresas`
--

LOCK TABLES `cliente_empresas` WRITE;
/*!40000 ALTER TABLE `cliente_empresas` DISABLE KEYS */;
INSERT INTO `cliente_empresas` VALUES ('20100012345','Comercial ABC S.A.','Av. Principal 123','987654321','contacto@comercialabc.com'),('20100023456','Inversiones XYZ S.R.L.','Calle Secundaria 456','987654322','info@inversionesxyz.com'),('20100034567','Servicios Integrales E.I.R.L.','Jr. Tercero 789','987654323','ventas@serviciosintegrales.com'),('20100045678','Distribuidora Central S.A.C.','Av. Cuarta 101','987654324','contacto@distribuidoracentral.com'),('20100056789','Logística & Transporte S.A.','Calle Quinta 202','987654325','logistica@logitrans.com'),('20100067890','Tecnología y Soluciones E.I.R.L.','Av. Sexta 303','987654326','soporte@tecnologiasoluciones.com'),('20100078901','Construcciones del Norte S.A.C.','Jr. Séptimo 404','987654327','proyectos@construnorte.com');
/*!40000 ALTER TABLE `cliente_empresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_personas`
--

DROP TABLE IF EXISTS `cliente_personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_personas` (
  `DNI` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `Nombres` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `Apellidos` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `Telefono` varchar(9) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Correo` varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  CONSTRAINT `fk_cliente_personas_clientes1` FOREIGN KEY (`DNI`) REFERENCES `clientes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_personas`
--

LOCK TABLES `cliente_personas` WRITE;
/*!40000 ALTER TABLE `cliente_personas` DISABLE KEYS */;
INSERT INTO `cliente_personas` VALUES ('01234567','Sofía','Díaz','987654330','sofia.diaz@example.com'),('11234567','Miguel','Torres','987654331','miguel.torres@example.com'),('12345678','Juan','Pérez','987654321','juan.perez@example.com'),('21234567','Valeria','Ruiz','987654332','valeria.ruiz@example.com'),('23456789','María','González','987654322','maria.gonzalez@example.com'),('31234567','Ricardo','Vásquez','987654333','ricardo.vasquez@example.com'),('34567890','Carlos','Ramírez','987654323','carlos.ramirez@example.com'),('41234567','Isabel','Morales','987654334','isabel.morales@example.com'),('45678901','Ana','Fernández','987654324','ana.fernandez@example.com'),('51234567','Fernando','Ortiz','987654335','fernando.ortiz@example.com'),('56789012','Luis','Martínez','987654325','luis.martinez@example.com'),('67890123','Laura','García','987654326','laura.garcia@example.com'),('78901234','José','Rodríguez','987654327','jose.rodriguez@example.com'),('89012345','Elena','López','987654328','elena.lopez@example.com'),('90123456','Pedro','Hernández','987654329','pedro.hernandez@example.com'),('990112','ramiro','cordoba',NULL,NULL);
/*!40000 ALTER TABLE `cliente_personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `ID` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('01234567'),('11234567'),('12345678'),('20100012345'),('20100023456'),('20100034567'),('20100045678'),('20100056789'),('20100067890'),('20100078901'),('21234567'),('23456789'),('31234567'),('34567890'),('41234567'),('45678901'),('51234567'),('56789012'),('67890123'),('78901234'),('89012345'),('90123456'),('990112');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobantes`
--

DROP TABLE IF EXISTS `comprobantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprobantes` (
  `ID` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `Fecha_Hora` datetime DEFAULT NULL,
  `ID_pedido` int NOT NULL,
  `ID_cliente` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `DNI_empleado` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  `ID_tipoComprobante` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Comprobante_tipoComprobante1_idx` (`ID_tipoComprobante`),
  KEY `fk_comprobantes_pedidos1_idx` (`ID_pedido`),
  KEY `fk_comprobantes_empleados1_idx` (`DNI_empleado`),
  KEY `fk_comprobantes_cliente1_idx` (`ID_cliente`),
  CONSTRAINT `fk_Comprobante_tipoComprobante1` FOREIGN KEY (`ID_tipoComprobante`) REFERENCES `tipo_comprobantes` (`ID`),
  CONSTRAINT `fk_comprobantes_cliente1` FOREIGN KEY (`ID_cliente`) REFERENCES `clientes` (`ID`),
  CONSTRAINT `fk_comprobantes_empleados1` FOREIGN KEY (`DNI_empleado`) REFERENCES `empleados` (`DNI`),
  CONSTRAINT `fk_comprobantes_pedidos1` FOREIGN KEY (`ID_pedido`) REFERENCES `pedidos` (`ID_Pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobantes`
--

LOCK TABLES `comprobantes` WRITE;
/*!40000 ALTER TABLE `comprobantes` DISABLE KEYS */;
INSERT INTO `comprobantes` VALUES ('003-0000001','2024-07-18 08:45:00',1,'12345678','11111111',1),('003-0000002','2024-07-18 09:30:00',2,'23456789','12345678',2),('003-0000003','2024-07-18 10:15:00',3,'34567890','33333333',1),('003-0000004','2024-07-18 11:00:00',4,'45678901','44444444',2),('003-0000005','2024-07-18 11:45:00',5,'56789012','7159938',1),('003-0000006','2024-07-23 03:17:41',10,'89012345','11111112',1),('003-0000007','2024-07-23 03:22:28',11,'21234567','11111112',1),('003-0000008','2024-07-23 03:25:33',12,'90123456','75392842',1),('003-0000009','2024-07-23 03:33:43',13,'45678901','11111112',1),('003-0000010','2024-07-23 04:08:45',14,'01234567','11111112',1);
/*!40000 ALTER TABLE `comprobantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_pedidos`
--

DROP TABLE IF EXISTS `detalle_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_pedidos` (
  `ID_DetallePedido` int NOT NULL AUTO_INCREMENT,
  `ID_Pedido` int DEFAULT NULL,
  `ID_Producto` int DEFAULT NULL,
  `Cantidad` int DEFAULT NULL,
  `SubTotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID_DetallePedido`),
  KEY `ID_PedCl` (`ID_Pedido`),
  KEY `ID_Prod` (`ID_Producto`),
  CONSTRAINT `detallepedido_ibfk_1` FOREIGN KEY (`ID_Pedido`) REFERENCES `pedidos` (`ID_Pedido`),
  CONSTRAINT `detallepedido_ibfk_2` FOREIGN KEY (`ID_Producto`) REFERENCES `productos` (`ID_Prod`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pedidos`
--

LOCK TABLES `detalle_pedidos` WRITE;
/*!40000 ALTER TABLE `detalle_pedidos` DISABLE KEYS */;
INSERT INTO `detalle_pedidos` VALUES (1,1,7,2,13.00),(2,1,10,1,25.00),(3,2,8,1,18.75),(4,2,9,2,29.60),(5,3,5,3,23.70),(6,3,12,1,30.50),(7,4,6,2,18.50),(8,4,13,1,9.90),(9,5,11,1,12.50),(10,5,15,2,11.50),(11,6,13,2,10.00),(12,9,6,3,16.50),(13,9,1,2,21.00),(14,9,11,1,6.20),(15,10,3,2,30.40),(16,10,2,5,43.75),(17,10,14,3,97.50),(18,11,10,3,42.90),(19,11,6,2,11.00),(20,11,9,1,9.75),(21,12,17,2,30.00),(22,12,13,1,8.90),(23,12,15,2,29.50),(24,13,7,3,23.70),(25,13,5,3,38.40),(26,13,3,2,30.40),(27,14,15,2,29.50),(28,14,12,1,22.00),(29,14,13,3,26.70);
/*!40000 ALTER TABLE `detalle_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `DNI` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  `Nombre` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Apellidos` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Correo` varchar(250) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Telefono` varchar(9) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Sueldo` decimal(10,2) DEFAULT NULL,
  `ID_farm` int NOT NULL,
  `horarioE` time NOT NULL,
  `horarioS` time DEFAULT NULL,
  `Estado` varchar(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  KEY `fk_empleados_farma1_idx` (`ID_farm`),
  CONSTRAINT `fk_empleados_farma1` FOREIGN KEY (`ID_farm`) REFERENCES `farmacias` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES ('11111111','my','me','mye','912345678',1888.00,1,'07:23:00','10:23:00','I'),('11111112','Ramón','Cóstini','rmcostin@gmail.com','928291111',1600.00,1,'08:00:00','16:00:00','A'),('11111113','Ramiro','Montesinos','ram.mon@gmail.com','99102927',1500.00,1,'07:00:00','15:00:00','A'),('11111114','Marta','Sánchez','martita@gmail.com','987009177',1500.00,1,'06:30:00','15:00:00','A'),('12345678','ya','na','yai@gmail.com','987654321',1630.00,1,'06:19:00','22:19:00','I'),('33333333','vá','véí','vae@gmail.com','912348764',1700.00,1,'07:41:00','00:41:00','I'),('44444444','viviana','yitreski','vivi.yit@gmail.com','984732657',1234.00,1,'09:00:00','23:00:00','A'),('7159938','Orlando','Salazar','steven@gmail.com','972363452',1.00,1,'08:00:00','20:00:00','A'),('72758660','Jakelyne','Rafael','jakeli@gmail.com','941766589',138.00,1,'08:00:00','20:00:00','A'),('72758680','Eric','Rafael','eric@gmail.com','998766589',138.00,1,'08:00:00','20:00:00','A'),('73468973','awedrfty','qwer','sdf@asd','936826842',1800.00,1,'19:34:00','23:34:00','A'),('75172230','hehe','hehe','ho@gmail','987651510',1395.00,1,'07:07:00','23:08:00','A'),('75392234','Bc','bc','bc@gmail','987651527',1380.00,1,'07:25:00','10:25:00','I'),('75392281','aby','ab','ab@gmail','987651512',1385.00,1,'16:35:00','20:39:00','A'),('75392830','mia','Mali','mia@gmail.com','937538652',1600.00,1,'07:30:00','23:00:00','A'),('75392842','mia','Mali','mia@gmail.com','937538652',1600.00,1,'07:30:00','23:00:00','A'),('75392845','a','b','a@gmail','987651216',1350.00,1,'08:22:00','16:23:00','A'),('75392854','Lola','Mani','lola@gmail.com','937538652',1600.00,1,'08:00:00','21:00:00','A'),('75392882','Fabi','Martinez','fabi@gmail.com','937538890',1800.00,1,'04:45:00','04:45:00','A'),('75392884','Lola','Mani','lola@gmail.com','937538652',1600.00,1,'08:00:00','21:00:00','A'),('75392891','mia','Mali','mia@gmail.com','937538652',1600.00,1,'09:55:00','20:09:00','A');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmacias`
--

DROP TABLE IF EXISTS `farmacias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farmacias` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ubicacion` varchar(250) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `direccion` varchar(250) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `NTelefono` varchar(9) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmacias`
--

LOCK TABLES `farmacias` WRITE;
/*!40000 ALTER TABLE `farmacias` DISABLE KEYS */;
INSERT INTO `farmacias` VALUES (1,'Ubicación de ejemplo','Dirección de ejemplo','123456789');
/*!40000 ALTER TABLE `farmacias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horarios` (
  `ID_HoraEmp` int NOT NULL AUTO_INCREMENT,
  `Fecha` date DEFAULT NULL,
  `Hentrada` time DEFAULT NULL,
  `Hsalida` time DEFAULT NULL,
  `DNI_empleado` varchar(8) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_HoraEmp`),
  KEY `fk_horarios_empleado1_idx_idx` (`DNI_empleado`),
  CONSTRAINT `fk_horarios_empleado1_idx` FOREIGN KEY (`DNI_empleado`) REFERENCES `empleados` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,'2024-07-18','22:51:46','22:53:01','11111112'),(2,'2024-07-18','23:31:38','23:31:46','11111113'),(3,'2024-07-18','23:45:42','23:46:01','11111114');
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `ID_Pedido` int NOT NULL AUTO_INCREMENT,
  `Fecha_Hora` datetime DEFAULT NULL,
  `PrecioTotal` decimal(10,2) DEFAULT NULL,
  `IGV` decimal(10,2) DEFAULT NULL,
  `Precio_Final` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID_Pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'2024-07-18 08:30:00',150.00,18.00,168.00),(2,'2024-07-18 10:15:00',250.00,30.00,280.00),(3,'2024-07-18 12:00:00',180.00,21.60,201.60),(4,'2024-07-18 14:45:00',320.00,38.40,358.40),(5,'2024-07-18 16:30:00',200.00,24.00,224.00),(6,'2024-07-22 17:00:06',22.20,2.09,33.00),(7,'2024-07-22 17:48:55',20.66,20.66,20.66),(8,'2024-07-22 17:54:42',29.77,29.77,29.77),(9,'2024-07-23 02:47:55',35.83,7.87,43.70),(10,'2024-07-23 03:17:41',140.75,30.90,171.65),(11,'2024-07-23 03:22:28',52.19,11.46,63.65),(12,'2024-07-23 03:25:33',56.09,12.31,68.40),(13,'2024-07-23 03:33:43',75.85,16.65,92.50),(14,'2024-07-23 04:08:45',64.12,14.08,78.20);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `ID_Prod` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(150) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `descripcion` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `FechaVencimiento` date DEFAULT NULL,
  `Precio` decimal(10,2) DEFAULT NULL,
  `Stock` int DEFAULT NULL,
  `ID_categoria` int NOT NULL,
  `RUC_Prov` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ID_Prod`),
  KEY `fk_productos_proveedor1_idx` (`RUC_Prov`),
  KEY `fk_productos_categorias1_idx` (`ID_categoria`),
  CONSTRAINT `fk_productos_categorias1` FOREIGN KEY (`ID_categoria`) REFERENCES `categorias` (`ID_categoria`),
  CONSTRAINT `fk_productos_proveedor1` FOREIGN KEY (`RUC_Prov`) REFERENCES `proveedores` (`RUC`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Paracetamol','Analgesic and antipyretic','2024-12-31',10.50,100,1,'12345678901'),(2,'Ibuprofeno','Anti-inflammatory drug','2023-09-15',8.75,80,1,'23456789012'),(3,'Vitamina C','Immune system support','2023-11-30',15.20,50,2,'34567890123'),(4,'Proteína en polvo','Supplement for muscle growth','2024-06-28',45.00,30,2,'45678901234'),(5,'Crema humectante','Moisturizing cream for skin','2023-10-31',12.80,70,3,'56789012345'),(6,'Jabón antibacterial','Antibacterial soap','2023-12-15',5.50,120,3,'67890123456'),(7,'Omeprazol','Antacid and antiulcer agent','2024-04-30',7.90,90,1,'78901234567'),(8,'Calcio + Vitamina D','Bone health supplement','2023-11-20',18.50,60,2,'89012345678'),(9,'Shampoo revitalizante','Revitalizing shampoo','2023-09-10',9.75,100,3,'90123456789'),(10,'Antihistamínico','Allergy relief medication','2024-03-15',14.30,40,1,'01234567890'),(11,'Ácido fólico','Folic acid supplement','2023-08-25',6.20,110,2,'11234567890'),(12,'Gel para el dolor muscular','Muscle pain relief gel','2024-05-12',22.00,25,3,'21234567890'),(13,'Pastillas para la tos','Cough relief tablets','2023-10-05',8.90,80,1,'31234567890'),(14,'Colágeno en polvo','Collagen powder supplement','2024-01-31',32.50,35,2,'41234567890'),(15,'Protector solar SPF 50','Sunscreen SPF 50','2023-12-31',14.75,60,3,'51234567890'),(16,'Quetorolaco','supresor de inflamacion dental','2024-07-26',20.00,-1,2,'78901234567'),(17,'Paracetamol','forte cant 50ml ñ','2024-08-10',15.00,-1,1,'34567890123');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `RUC` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `Nombre` varchar(150) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Pais` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Telefono` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Correo` varchar(55) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`RUC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES ('01234567890','FarmaSalud','Venezuela','+58 212 1234567','servicio@farmasalud.ve'),('11234567890','Vida y Salud','Brasil','+55 11 91234-5678','contacto@vidaysalud.com.br'),('12345678901','FarmaDistribuciones','Perú','+51 987654321','contacto@farmadist.com'),('21234567890','Distribuciones Medicas','Perú','+51 987654322','ventas@distribucionesmedicas.pe'),('23456789012','Medicamentos Globales','México','+52 5555555555','ventas@medglobal.com'),('31234567890','MediHealth','Chile','+56 2 23456789','info@medihealth.cl'),('34567890123','Salud y Vida','Colombia','+57 3100000000','info@saludyvida.co'),('41234567890','Salud Integral','México','+52 1 5555555556','contacto@saludintegral.mx'),('45678901234','Farma Internacional','Argentina','+54 11 4444444','comercial@farmaint.com.ar'),('51234567890','Farmacéutica del Norte','Argentina','+54 341 4444445','ventas@farmaceuticanorte.com.ar'),('56789012345','PharmaPlus','Chile','+56 9 87654321','servicio@pharmaplus.cl'),('61234567890','Medicasa','Colombia','+57 1 3456789','servicio@medicasa.co'),('67890123456','Distribuidora Médica','Ecuador','+593 99 1234567','distribuidora@medica.ec'),('78901234567','Salud Total','Uruguay','+598 98 765432','ventas@saludtotal.uy'),('89012345678','Meditech','Bolivia','+591 70123456','info@meditech.bo'),('90123456789','Farmacias Unidas','Paraguay','+595 21 123456','contacto@farmaciasunidas.py');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_comprobantes`
--

DROP TABLE IF EXISTS `tipo_comprobantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_comprobantes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `tipoComprobante` varchar(16) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_comprobantes`
--

LOCK TABLES `tipo_comprobantes` WRITE;
/*!40000 ALTER TABLE `tipo_comprobantes` DISABLE KEYS */;
INSERT INTO `tipo_comprobantes` VALUES (1,'boleta'),(2,'factura');
/*!40000 ALTER TABLE `tipo_comprobantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `dniEmpleado` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `clave` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Estado` varchar(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`dniEmpleado`),
  CONSTRAINT `fk_usuarios_empleados1` FOREIGN KEY (`dniEmpleado`) REFERENCES `empleados` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('11111112','lalito','lalito123','A'),('11111113','Ramiro','ramiro1234','A'),('11111114','Martasan','marta1234','A'),('7159938','Miri','mikri1234','A'),('72758680','Jakeli','7275','A'),('73468973','jt','jt1234','I'),('75392830','Pepe','pepe1234','A'),('75392842','Richi','richi1234','A'),('75392882','Are','are1234','A');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-23  4:11:46
