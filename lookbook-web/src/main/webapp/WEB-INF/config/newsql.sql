CREATE DATABASE  IF NOT EXISTS `lookbook` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `lookbook`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: lookbook
-- ------------------------------------------------------
-- Server version	5.5.25a

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
-- Table structure for table `texture_class`
--

DROP TABLE IF EXISTS `texture_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `texture_class` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `min_colors` int(10) unsigned DEFAULT NULL,
  `info` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_TEXTURE_CLASS_TITLE` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `texture_class`
--

LOCK TABLES `texture_class` WRITE;
/*!40000 ALTER TABLE `texture_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `texture_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enable_data`
--

DROP TABLE IF EXISTS `enable_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enable_data` (
  `main_data_key` varchar(45) NOT NULL,
  `sub_data_key` varchar(45) NOT NULL,
  PRIMARY KEY (`main_data_key`,`sub_data_key`),
  KEY `FK_enable_parts_classkey` (`sub_data_key`) USING BTREE,
  KEY `FK_enable_parts_1` (`main_data_key`) USING BTREE,
  CONSTRAINT `FK_enable_parts_partkey` FOREIGN KEY (`main_data_key`) REFERENCES `dictionary_data` (`data_key`),
  CONSTRAINT `FK_enable_parts_classkey` FOREIGN KEY (`sub_data_key`) REFERENCES `dictionary_data` (`data_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enable_data`
--

LOCK TABLES `enable_data` WRITE;
/*!40000 ALTER TABLE `enable_data` DISABLE KEYS */;
INSERT INTO `enable_data` VALUES ('thingClass_1','thingPart_1'),('thingClass_1','thingPart_2');
/*!40000 ALTER TABLE `enable_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `option`
--

DROP TABLE IF EXISTS `option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `option` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `option_class` varchar(45) NOT NULL,
  `info` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_OPTION_TITLE` (`title`) USING BTREE,
  KEY `FK_option_optclasskey` (`option_class`),
  CONSTRAINT `FK_option_optclasskey` FOREIGN KEY (`option_class`) REFERENCES `dictionary_data` (`data_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `option`
--

LOCK TABLES `option` WRITE;
/*!40000 ALTER TABLE `option` DISABLE KEYS */;
/*!40000 ALTER TABLE `option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `color` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `color_value` int(10) unsigned NOT NULL,
  `info` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_COLOR_VALUE` (`color_value`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `full_design`
--

DROP TABLE IF EXISTS `full_design`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `full_design` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `thing_part` varchar(45) NOT NULL,
  `info` varchar(4000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fulldesign_part` (`thing_part`) USING BTREE,
  CONSTRAINT `FK_fulldesign_part` FOREIGN KEY (`thing_part`) REFERENCES `dictionary_data` (`data_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `full_design`
--

LOCK TABLES `full_design` WRITE;
/*!40000 ALTER TABLE `full_design` DISABLE KEYS */;
/*!40000 ALTER TABLE `full_design` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_group_roles`
--

DROP TABLE IF EXISTS `web_group_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `web_group_roles` (
  `web_group_id` int(11) NOT NULL,
  `web_role_id` int(11) NOT NULL,
  PRIMARY KEY (`web_group_id`,`web_role_id`),
  KEY `FK_web_group_roles_1` (`web_role_id`),
  KEY `FK_web_group_roles_2` (`web_group_id`),
  CONSTRAINT `FK_web_group_roles_1` FOREIGN KEY (`web_role_id`) REFERENCES `web_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_web_group_roles_2` FOREIGN KEY (`web_group_id`) REFERENCES `web_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_group_roles`
--

LOCK TABLES `web_group_roles` WRITE;
/*!40000 ALTER TABLE `web_group_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `web_group_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `look_photo`
--

DROP TABLE IF EXISTS `look_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `look_photo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `photo` longblob NOT NULL,
  `look_id` int(10) unsigned NOT NULL,
  `info` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_look_photo_1` (`look_id`),
  CONSTRAINT `FK_look_photo_1` FOREIGN KEY (`look_id`) REFERENCES `look` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `look_photo`
--

LOCK TABLES `look_photo` WRITE;
/*!40000 ALTER TABLE `look_photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `look_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thing_option`
--

DROP TABLE IF EXISTS `thing_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thing_option` (
  `thing_id` int(10) unsigned NOT NULL,
  `option_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`thing_id`,`option_id`),
  KEY `FK_thing_option_2` (`option_id`),
  CONSTRAINT `FK_thing_option_1` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`),
  CONSTRAINT `FK_thing_option_2` FOREIGN KEY (`option_id`) REFERENCES `option` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thing_option`
--

LOCK TABLES `thing_option` WRITE;
/*!40000 ALTER TABLE `thing_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `thing_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictionary_class`
--

DROP TABLE IF EXISTS `dictionary_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dictionary_class` (
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `title_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary_class`
--

LOCK TABLES `dictionary_class` WRITE;
/*!40000 ALTER TABLE `dictionary_class` DISABLE KEYS */;
INSERT INTO `dictionary_class` VALUES ('thing_class'),('thing_part');
/*!40000 ALTER TABLE `dictionary_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coloration`
--

DROP TABLE IF EXISTS `coloration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coloration` (
  `design_id` int(10) unsigned NOT NULL,
  `color_id` int(10) unsigned NOT NULL,
  `priority` int(10) unsigned NOT NULL DEFAULT '1',
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_coloration_1` (`design_id`),
  KEY `FK_coloration_2` (`color_id`),
  CONSTRAINT `FK_coloration_1` FOREIGN KEY (`design_id`) REFERENCES `design` (`id`),
  CONSTRAINT `FK_coloration_2` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coloration`
--

LOCK TABLES `coloration` WRITE;
/*!40000 ALTER TABLE `coloration` DISABLE KEYS */;
/*!40000 ALTER TABLE `coloration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_user`
--

DROP TABLE IF EXISTS `web_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `web_user` (
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `salt` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `web_group_id` int(11) NOT NULL,
  PRIMARY KEY (`login`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `FK_web_user_1` (`web_group_id`),
  CONSTRAINT `FK_web_user_1` FOREIGN KEY (`web_group_id`) REFERENCES `web_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_user`
--

LOCK TABLES `web_user` WRITE;
/*!40000 ALTER TABLE `web_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `web_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictionary_data`
--

DROP TABLE IF EXISTS `dictionary_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dictionary_data` (
  `dic_name` varchar(45) NOT NULL,
  `data_key` varchar(45) NOT NULL,
  `value_ru` varchar(100) DEFAULT NULL,
  `value_en` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`data_key`),
  KEY `dic_data_class` (`dic_name`),
  CONSTRAINT `FK_dic_data_class` FOREIGN KEY (`dic_name`) REFERENCES `dictionary_class` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary_data`
--

LOCK TABLES `dictionary_data` WRITE;
/*!40000 ALTER TABLE `dictionary_data` DISABLE KEYS */;
INSERT INTO `dictionary_data` VALUES ('thing_class','thingClass_1','Куртка',NULL),('thing_part','thingPart_1','Карман',''),('thing_part','thingPart_2','Рукав',''),('thing_part','thingPart_3','Ворот',''),('thing_part','thingPart_4','Каблук',''),('thing_part','thingPart_5','Отворот','124'),('thing_part','thingPart_6','Нос4','444'),('thing_part','thingPart_7','6','124124');
/*!40000 ALTER TABLE `dictionary_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `look`
--

DROP TABLE IF EXISTS `look`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `look` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sex` varchar(1) CHARACTER SET latin1 NOT NULL,
  `add_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_date` date DEFAULT NULL,
  `hear_color` varchar(45) DEFAULT NULL,
  `hear_style` varchar(45) DEFAULT NULL,
  `info` varchar(4000) CHARACTER SET latin1 DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `place` varchar(45) NOT NULL,
  `complete` int(10) unsigned NOT NULL DEFAULT '0',
  `link` varchar(1000) CHARACTER SET latin1 DEFAULT NULL,
  `title` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `appearance` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_look_2` (`hear_style`) USING BTREE,
  KEY `FK_look_3` (`place`),
  KEY `FK_look_1` (`hear_color`),
  KEY `FK_look_hear_style` (`hear_style`),
  KEY `FK_look_hear_color` (`hear_color`),
  KEY `FK_look_place` (`place`),
  KEY `FK_look_country` (`country`),
  CONSTRAINT `FK_look_country` FOREIGN KEY (`country`) REFERENCES `dictionary_data` (`data_key`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_look_hear_color` FOREIGN KEY (`hear_color`) REFERENCES `dictionary_data` (`data_key`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_look_hear_style` FOREIGN KEY (`hear_style`) REFERENCES `dictionary_data` (`data_key`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_look_place` FOREIGN KEY (`place`) REFERENCES `dictionary_data` (`data_key`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `look`
--

LOCK TABLES `look` WRITE;
/*!40000 ALTER TABLE `look` DISABLE KEYS */;
/*!40000 ALTER TABLE `look` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part_option`
--

DROP TABLE IF EXISTS `part_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part_option` (
  `option_id` int(10) unsigned NOT NULL,
  `full_design_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`option_id`,`full_design_id`),
  KEY `FK_part_option_2` (`full_design_id`),
  KEY `FK_part_option_1` (`option_id`),
  CONSTRAINT `FK_part_option_1` FOREIGN KEY (`option_id`) REFERENCES `option` (`id`),
  CONSTRAINT `FK_part_option_2` FOREIGN KEY (`full_design_id`) REFERENCES `full_design` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_option`
--

LOCK TABLES `part_option` WRITE;
/*!40000 ALTER TABLE `part_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `part_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thing_parameter`
--

DROP TABLE IF EXISTS `thing_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thing_parameter` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `thing_id` int(10) unsigned NOT NULL,
  `parameter` varchar(45) NOT NULL,
  `param_value` varchar(45) CHARACTER SET latin1 NOT NULL,
  `info` varchar(4000) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_thingparam_param` (`parameter`),
  KEY `FK_thingparam_thing` (`thing_id`),
  CONSTRAINT `FK_thingparam_param` FOREIGN KEY (`parameter`) REFERENCES `dictionary_data` (`data_key`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_thingparam_thing` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thing_parameter`
--

LOCK TABLES `thing_parameter` WRITE;
/*!40000 ALTER TABLE `thing_parameter` DISABLE KEYS */;
/*!40000 ALTER TABLE `thing_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_role`
--

DROP TABLE IF EXISTS `web_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `web_role` (
  `id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title_UNIQUE` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_role`
--

LOCK TABLES `web_role` WRITE;
/*!40000 ALTER TABLE `web_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `web_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `texture`
--

DROP TABLE IF EXISTS `texture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `texture` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `texture_class_id` int(10) unsigned NOT NULL,
  `info` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_TEXTURE_TITLE` (`title`),
  KEY `FK_texture_1` (`texture_class_id`),
  CONSTRAINT `FK_texture_1` FOREIGN KEY (`texture_class_id`) REFERENCES `texture_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `texture`
--

LOCK TABLES `texture` WRITE;
/*!40000 ALTER TABLE `texture` DISABLE KEYS */;
/*!40000 ALTER TABLE `texture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_group`
--

DROP TABLE IF EXISTS `web_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `web_group` (
  `id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_group`
--

LOCK TABLES `web_group` WRITE;
/*!40000 ALTER TABLE `web_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `web_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thing`
--

DROP TABLE IF EXISTS `thing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thing` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `thing_class_key` varchar(45) NOT NULL,
  `look_id` int(10) unsigned DEFAULT NULL,
  `brand_key` varchar(45) NOT NULL,
  `info` varchar(4000) CHARACTER SET latin1 DEFAULT NULL,
  `add_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creat_date` date DEFAULT NULL,
  `complete` int(1) unsigned NOT NULL,
  `thing_class` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `brand` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_thing_2` (`look_id`),
  KEY `FK_thing_look` (`look_id`),
  KEY `FK_thing_brand_key` (`brand_key`),
  KEY `FK_thing_class_key` (`thing_class_key`),
  CONSTRAINT `FK_thing_brand_key` FOREIGN KEY (`brand_key`) REFERENCES `dictionary_data` (`data_key`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_thing_class_key` FOREIGN KEY (`thing_class_key`) REFERENCES `dictionary_data` (`data_key`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_thing_look` FOREIGN KEY (`look_id`) REFERENCES `look` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thing`
--

LOCK TABLES `thing` WRITE;
/*!40000 ALTER TABLE `thing` DISABLE KEYS */;
/*!40000 ALTER TABLE `thing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thing_photo`
--

DROP TABLE IF EXISTS `thing_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thing_photo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `photo` blob NOT NULL,
  `thing_id` int(10) unsigned NOT NULL,
  `info` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_thing_photo_1` (`thing_id`),
  CONSTRAINT `FK_thing_photo_1` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thing_photo`
--

LOCK TABLES `thing_photo` WRITE;
/*!40000 ALTER TABLE `thing_photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `thing_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `design`
--

DROP TABLE IF EXISTS `design`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `design` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `texture_id` int(10) unsigned NOT NULL,
  `thing_id` int(10) unsigned NOT NULL,
  `priority` int(10) unsigned NOT NULL DEFAULT '1',
  `info` varchar(4000) DEFAULT NULL,
  `full_design_id` int(10) unsigned DEFAULT NULL,
  `texture_size` int(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_design_1` (`texture_id`),
  KEY `FK_design_2` (`thing_id`),
  KEY `FK_design_3` (`full_design_id`),
  CONSTRAINT `FK_design_1` FOREIGN KEY (`texture_id`) REFERENCES `texture` (`id`),
  CONSTRAINT `FK_design_2` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`),
  CONSTRAINT `FK_design_3` FOREIGN KEY (`full_design_id`) REFERENCES `full_design` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `design`
--

LOCK TABLES `design` WRITE;
/*!40000 ALTER TABLE `design` DISABLE KEYS */;
/*!40000 ALTER TABLE `design` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-09-10 20:48:19
