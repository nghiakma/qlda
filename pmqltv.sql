-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pmqltv
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `docgia`
--

DROP TABLE IF EXISTS `docgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docgia` (
  `madocgia` int(10) NOT NULL AUTO_INCREMENT COMMENT 'mã id của độc giả',
  `tendocgia` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaysinh` date DEFAULT NULL,
  `gioitinh` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `diachi` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dienthoai` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `trangthai` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaylapthe` date DEFAULT NULL,
  PRIMARY KEY (`madocgia`),
  UNIQUE KEY `madocgia_UNIQUE` (`madocgia`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docgia`
--

LOCK TABLES `docgia` WRITE;
/*!40000 ALTER TABLE `docgia` DISABLE KEYS */;
INSERT INTO `docgia` VALUES (1,'Trần Văn Anh','1980-01-17','Nam','Thanh Trì','atv@gmail.com','0123456789',NULL,'2017-09-21'),(2,'Nguyễn Văn Bình','1999-05-29','Nam','Long Biên','bnv@gmail.com','012121212',NULL,'2017-09-21'),(3,'Hà Thị Thảo','1988-09-11','Nữ','Cầu Giấy - Hà Nội','thaoht@gmail.com','0909989789',NULL,'2017-09-21'),(4,'Trần Thị Lan','1991-09-13','Nữ','Hoàng Mai - Hà Nội','lantt@gmail.com','0123123112','đã xóa','2017-09-21'),(5,'Văn Ngọc Linh','1993-09-01','Nam','TP Hà Nam','linhvn@gmail.com','01235774593',NULL,'2017-09-21'),(6,'Lê Huy Hải','1994-09-02','Nam','Phúc Yên, Vĩnh Phúc','hailh@gmail.com','0123123123',NULL,'2017-09-21'),(7,'Trần Lê lan','1990-09-17','Nữ','Bắc Kạn','lantl@gmail.com','067777776',NULL,'2017-10-02'),(8,'Nguyễn Phương Anh','1995-05-25','Nữ','Hà Nam','anhnp@gmail.com','0123123456',NULL,'2017-09-21'),(9,'Nguyễn Linh Loan','1994-07-07','Nữ','Ninh Bình','loannl@gmail.com','096785564',NULL,'2017-09-21'),(10,'sdfsgf','2017-09-02','Nam','fgh n ','bnmngh','0789789',NULL,'2017-09-21'),(11,'sadmkj jgh','2005-09-02','Nam','asfdas','dfhgfhfgh','0567567456',NULL,'2017-09-21'),(12,'Lê Như Ngọc','1994-09-01','Nữ','Thanh Xuân - Hà Nội','ngocln@gmail.com','0912121212',NULL,'2017-09-21'),(13,'Trần Văn Tuấn','1992-09-24','Nam','TP Đà Nẵng','tuantv@gmail.com','099999767',NULL,'2017-09-21'),(14,'Nguyễn Tuệ Lan','1997-12-30','Nữ','Long Biên - Hà Nội','lannt@gmail.com','0988516518',NULL,'2017-09-21'),(16,'tesst 2','1988-09-16','Nữ','Thanh Xuân','ttest2@gmail.com','098789898','Hết hạn','2012-09-21'),(17,'Lê Việt Hải','1988-09-15','Nam','Long Bien','hailv@gmail.com','098767898',NULL,'2017-09-21'),(18,'tesst 2','1988-09-16','Nữ','Thanh Xuân','ttest2@gmail.com','088887878','đã xóa','2017-09-21'),(19,'tesst 3','1988-09-17','Nam','Cầu Giấy','teest3@gmail.com','123123157','đã xóa','2017-09-21'),(20,'tesst 1','1988-09-15','Nam','Long Bien','test1@gmail.com','098767898',NULL,'2017-09-21'),(21,'tesst 2','1988-09-16','Nữ','Thanh Xuân','ttest2@gmail.com','88887878','đã xóa','2017-09-21'),(22,'tesst 3','1988-09-17','Nam','Cầu Giấy','teest3@gmail.com','0123123157',NULL,'2017-09-21'),(23,'tesst 1','1988-09-15','Nam','Long Bien','test1@gmail.com','098767898',NULL,'2017-09-21'),(24,'tesst 2','1988-09-16','Nữ','Thanh Xuân','ttest2@gmail.com','088887878',NULL,'2017-09-21'),(25,'tesst 3','1988-09-17','Nam','Cầu Giấy','teest3@gmail.com','0123123157',NULL,'2017-09-21'),(27,'Nguyễn Mạnh Linh','1997-09-02','Nam','Hoàng Mai - Hà Nội','linhnm@gmail.com','012357',NULL,'2017-09-21'),(28,'Lê Thị Mai','1988-09-21','Nữ','Hoàng Mai - Hà Nội','maitt@gmail.com','0123123133',NULL,'2017-09-21'),(29,'Lê Như Ngọc','1994-09-01','Nữ','Thanh Xuân - Hà Nội','ngocln@gmail.com','0912121212',NULL,'2017-09-21'),(30,'tesst hg','1988-09-15','Nam','Long Bien','test1@gmail.com','98767898','đã xóa','2017-09-21'),(31,'Trần Văn Nguyên','1980-01-17','Nam','Thanh Trì','atv@gmail.com','123456789',NULL,'2017-09-21'),(32,'Trần Văn Nguyên','1980-01-17','Nam','Thanh Trì','atv@gmail.com','0123456789',NULL,'2017-09-21'),(33,'Trần Văn Nguyên','1980-01-17','Nam','Thanh Trì','atv@gmail.com','0123456789',NULL,'2017-09-21'),(34,'Nguyễn Thị Lan','1994-08-15','Nữ','Long Biên','lannt@gmail.com','0967868789',NULL,'2017-09-21'),(35,'Việt Nam','1991-05-19','Nữ','Long Biên','lannt@gmail.com','0967868789',NULL,'2017-09-21'),(36,'Việt Nam','1991-05-19','Nữ','Long Biên','lannt@gmail.com','0967868789',NULL,'2017-09-21'),(37,'tesst hg1','1988-09-15','Nam','Long Bien','test1@gmail.com','098767898',NULL,'2017-09-21'),(38,'Test Hết Hạn','1980-01-17','Nam','Thanh Trì','atv@gmail.com','0123456789','Hết hạn','2012-08-01'),(39,'hết hạn test','1988-09-15','Nam','Long Bien','test1@gmail.com','098767898','Hết hạn','2012-10-05'),(40,'Trần Văn Tình','1988-09-02','Nam','fgh n ','bnmngh','0789789',NULL,'2017-09-21'),(41,'hà thi trang','1988-08-15','Nữ','hà nội','trang','09000378',NULL,'2017-10-12'),(42,'Trần Lan Hương','1992-09-03','Nữ','TP Hà Nam','huongtl@gmail.com','012357746',NULL,'2017-10-17'),(43,'Trần Hải Hà','1994-10-03','Nữ','Phú Thọ','hath@gmail.com','074359202',NULL,'2017-10-25'),(44,'Độc Giả xlsx','1988-09-15','Nam','Long Bien','test1@gmail.com','098767898',NULL,'2017-10-20'),(45,'Nguyễn Văn Bình','1988-09-15','Nam','Long Biên','anhnv@gmail.com','0987677898',NULL,'2016-09-18'),(46,'Trần Thị Lan','1990-08-10','Nữ','Cầu Giấy','lett@gmail.com','0987654567',NULL,'2015-08-20'),(47,'Lê Thị Châu','1992-10-26','Nữ','Yên Bái','chault@gmail.com','0987879456',NULL,'2017-10-26'),(48,'Độc Giả xlsx','1988-09-15','Nam','Long Bien','test1@gmail.com','098767898',NULL,'2017-10-20');
/*!40000 ALTER TABLE `docgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muontra`
--

DROP TABLE IF EXISTS `muontra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `muontra` (
  `mamuontra` int(11) NOT NULL AUTO_INCREMENT,
  `madocgia` int(10) NOT NULL,
  `masach` int(11) NOT NULL,
  `manhanvien` int(10) unsigned NOT NULL,
  `ngaymuon` date NOT NULL,
  `ngaytra` date DEFAULT NULL,
  `maphieu` int(11) NOT NULL,
  PRIMARY KEY (`mamuontra`),
  KEY `fk_muontra_docgia1_idx` (`madocgia`),
  KEY `fk_muontra_sach1_idx` (`masach`),
  KEY `fk_muontra_nhanvien1_idx` (`manhanvien`),
  CONSTRAINT `fk_muontra_docgia1` FOREIGN KEY (`madocgia`) REFERENCES `docgia` (`madocgia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_muontra_nhanvien1` FOREIGN KEY (`manhanvien`) REFERENCES `nhanvien` (`manhanvien`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_muontra_sach1` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muontra`
--

LOCK TABLES `muontra` WRITE;
/*!40000 ALTER TABLE `muontra` DISABLE KEYS */;
INSERT INTO `muontra` VALUES (1,2,3,2,'2017-09-09','2017-09-18',1),(3,5,3,2,'2017-07-15','2017-09-17',2),(4,9,2,1,'2017-08-20','2017-09-17',3),(5,2,5,2,'2017-09-09','2017-09-17',4),(6,3,3,2,'2017-08-10','2017-09-09',5),(7,3,5,3,'2017-07-19','2017-09-30',6),(9,2,2,1,'2017-09-17','2017-09-17',7),(10,2,3,1,'2017-09-17','2017-09-17',8),(11,2,6,1,'2017-09-17','2017-09-17',9),(12,2,1,1,'2017-09-17','2017-09-19',10),(14,4,3,1,'2017-09-17','2017-09-19',11),(15,4,5,1,'2017-09-17','2017-10-31',12),(16,4,6,1,'2017-09-17','2017-09-30',13),(17,3,2,1,'2017-09-17','2017-11-01',14),(18,1,2,1,'2017-09-17','2017-09-30',15),(19,10,2,2,'2017-07-01','2017-09-01',16),(20,3,6,3,'2017-08-01','2017-09-01',17),(21,3,1,1,'2017-09-17','2017-09-17',18),(22,3,5,1,'2017-09-17','2017-09-18',19),(23,3,2,1,'2017-09-17','2017-09-19',20),(24,6,1,1,'2017-09-17','2017-10-03',21),(25,6,2,1,'2017-09-17','2017-09-22',22),(26,5,1,1,'2017-09-17','2017-09-17',23),(27,5,2,1,'2017-09-17','2017-09-30',24),(34,2,3,1,'2017-09-19','2017-09-22',25),(39,2,1,1,'2017-09-22','2017-09-27',26),(40,3,1,1,'2017-09-22','2017-09-22',27),(41,5,1,1,'2017-09-22','2017-10-11',28),(42,6,1,1,'2017-09-22','2017-10-03',29),(43,2,3,1,'2017-09-24','2017-10-03',30),(44,2,2,1,'2017-09-25','2017-09-27',31),(45,3,1,1,'2017-09-25','2017-09-27',32),(46,3,6,1,'2017-09-25','2017-09-30',33),(47,12,3,1,'2017-09-25',NULL,34),(48,12,5,1,'2017-09-25',NULL,35),(49,4,4,1,'2017-09-27','2017-09-30',36),(50,14,3,1,'2017-09-27',NULL,37),(51,14,5,1,'2017-09-27','2017-10-18',38),(52,3,2,1,'2017-09-29','2017-09-30',39),(53,3,3,1,'2017-09-30','2017-10-31',40),(54,1,8,1,'2017-09-30','2017-09-30',41),(55,3,8,1,'2017-09-30','2017-09-30',42),(56,3,12,1,'2017-10-01','2017-10-01',43),(57,5,12,1,'2017-10-01','2017-10-01',44),(58,5,5,1,'2017-10-01','2017-10-04',45),(59,3,13,1,'2017-10-01','2017-10-31',46),(60,1,13,1,'2017-10-01',NULL,47),(61,2,6,1,'2017-10-01','2017-10-03',48),(62,17,3,1,'2017-10-01',NULL,49),(63,7,3,1,'2017-10-02','2017-10-04',50),(64,7,6,1,'2017-10-02',NULL,51),(65,7,4,1,'2017-10-02','2017-10-18',52),(66,5,4,1,'2017-10-04','2017-10-25',53),(68,39,6,1,'2017-10-04',NULL,55),(69,5,3,1,'2017-10-04','2017-10-04',56),(70,5,5,1,'2017-10-04','2017-10-19',57),(71,3,3,1,'2017-10-04','2017-10-04',58),(72,3,4,1,'2017-10-04','2017-10-11',59),(73,3,5,1,'2017-10-04','2017-10-04',60),(74,2,17,1,'2017-10-04','2017-10-13',61),(75,6,17,1,'2017-10-04',NULL,62),(76,12,4,1,'2017-10-04',NULL,63),(77,2,5,1,'2017-10-12','2017-10-13',64),(78,2,7,1,'2017-10-12','2017-10-28',65),(79,5,6,1,'2017-10-12','2017-10-27',66),(80,10,4,1,'2017-10-12',NULL,67),(81,34,6,1,'2017-10-12',NULL,68),(82,34,4,1,'2017-10-12',NULL,69),(83,34,3,1,'2017-10-12',NULL,70),(84,37,1,1,'2017-10-12','2017-10-12',71),(85,2,4,1,'2017-10-15','2017-10-28',72),(87,3,4,1,'2017-10-16','2017-10-28',74),(88,11,4,1,'2017-10-18',NULL,75),(89,8,3,1,'2017-10-19',NULL,76),(90,8,5,1,'2017-10-19',NULL,76),(92,22,4,1,'2017-10-19',NULL,77),(93,22,6,1,'2017-10-19',NULL,77),(94,43,4,1,'2017-10-25',NULL,78),(95,9,3,1,'2017-10-26',NULL,79),(97,9,4,1,'2017-10-26',NULL,79),(98,46,22,1,'2017-10-26',NULL,80),(99,10,5,1,'2017-10-27',NULL,81),(100,3,6,1,'2017-10-27','2017-10-28',82),(101,3,10,1,'2017-10-27','2017-10-28',82),(102,2,6,1,'2017-10-28',NULL,83),(103,5,4,1,'2017-10-28',NULL,84),(104,5,6,1,'2017-10-28','2017-10-28',84),(105,5,7,1,'2017-10-28',NULL,84);
/*!40000 ALTER TABLE `muontra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhanvien` (
  `manhanvien` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tennhanvien` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `chucvu` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gioitinh` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `dienthoai` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tendangnhap` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `matkhau` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '123456',
  `trangthai` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`manhanvien`),
  UNIQUE KEY `manhanvien_UNIQUE` (`manhanvien`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='nhân viên quản lý thư viện.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'admin','admin','Nam','1990-04-30','099999999','ádasdasda','admin','admin',NULL),(2,'Nguyễn Phương Thảo','Nhân viên','Nữ','1995-08-07','0888888888','thaonp@gmail.com','phuongthao','12345',NULL),(3,'Nguyễn Quang Vinh','Nhân viên','Nam','1990-04-30','099999977','quangvinh.gulang@gmail.com','quangvinh','123456',NULL),(4,'Trần Quang Anh','Nhân viên','Nam','1998-09-18','098998777','anhtq@gmail.com','quanganh','123456','đã xóa'),(5,'Trần Văn Quang','Nhân viên','Nam','1994-09-01','0912121212','quangtv@gmail.com','tranquang','123456','đã xóa'),(6,'Lê Đăng Khoa','Nhân viên','Nam','1992-08-07','0912341234','khoald@gmail.com','dangkhoa','123456',NULL),(7,'Nguyễn Phương Thảo','Nhân viên','Nữ','1995-08-07','0888888888','thaonp@gmail.com','phuongthao','123456','đã xóa'),(8,'Trần Hải Linh Anh','Nhân viên','Nữ','1995-10-11','0967537828','linhth@gmail.com','hailinh','123456','đã xóa');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sach` (
  `masach` int(11) NOT NULL AUTO_INCREMENT,
  `tensach` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `theloai` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tacgia` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nhaxuatban` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `namxuatban` year(4) DEFAULT NULL,
  `ngaynhap` date DEFAULT NULL,
  `ngonngu` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sotrang` int(10) unsigned DEFAULT NULL,
  `soluong` int(10) unsigned DEFAULT NULL,
  `giatien` int(10) unsigned DEFAULT '0',
  `damuon` int(11) DEFAULT '0',
  `trangthai` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`masach`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES (1,'Toán cao cấp','Toán học','Trịnh Hoàng Hải','Kim Đồng',2016,'2016-08-10','Việt',140,3,130000,0,NULL),(2,'Tin học đại cương','Tin học','Lê Thị Lan','Giáo dục và đào tạo',2013,'2017-03-03','việt',210,6,210000,0,'đã xóa'),(3,'java','Tin học','Nguyễn Văn Bé','Bách Khoa',2008,'2017-03-18','Anh',150,6,200000,6,NULL),(4,'Hệ quản trị cơ sở dữ liệu','Tin học','Nhóm tác giả','Đại học quốc gia HN',2016,'2017-09-09','Việt',210,9,210000,8,NULL),(5,'Nhật Ký Trong Tù','Văn học','Hồ Chí Minh','Giáo Dục',1999,'2016-09-17','Việt',274,3,13000,3,NULL),(6,'Thơ lục bát','Văn học','Hoàng Anh','Bách Khoa HN',2015,'2017-09-09','Việt',140,8,180000,5,NULL),(7,'Toán rời rạc','Toán học','Lưu Gia Hải','Bách Khoa HN',2015,'2017-09-09','Anh',120,3,150000,1,NULL),(8,'Thực hành Java','Tin học','Nguyễn Quang Vinh','Tại gia',2017,'2017-09-09','Việt',100,0,200000,0,'đã xóa'),(9,'Kỹ năng nuôi con','Tin học','Trần Mạnh Hải','Hồng Đức',2017,'2017-09-09','Việt',100,5,120000,0,NULL),(10,'Linux','Khác','Trần Văn Hạnh','Đại học quốc gia',2017,'2017-09-21','Việt',110,3,100000,0,NULL),(11,'Ngôn ngữ lập trình C','Tin học','Nguyễn Văn Tài','Bộ Giáo dục và đào tạo',2017,'2017-09-23','Việt',200,3,200000,0,NULL),(12,'excel import 3','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,0,100000,0,'đã xóa'),(13,'excel import 4','Toán học','Nguyễn Bá Học 2','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,1,NULL),(14,'excel import 5','Thiếu nhi','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(15,'excel import 6','Khác','Nguyễn Bá Học 2','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,NULL),(16,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,'đã xóa'),(17,'excel import 6','Khác','Nguyễn Bá Học 2','Kim Đồng',2016,'2017-09-23','Việt',100,1,100000,1,NULL),(18,'excel import 1','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,NULL),(19,'excel import 2','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,NULL),(20,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(21,'excel import 6','Khác','Nguyễn Bá Học 2','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,'đã xóa'),(22,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,1,NULL),(23,'excel import 6','Khác','Nguyễn Bá Học 2','Kim Đồng',2016,'2017-09-23','Việt',100,3,100000,0,NULL),(24,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(25,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(26,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(27,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(28,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(29,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(30,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(31,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(32,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(37,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(42,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(47,'excel import 5','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(48,'excel import 1','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,NULL),(49,'excel import 2','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,NULL),(50,'excel import 1','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,NULL),(51,'excel import 2','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,NULL),(52,'excel import 1','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,NULL),(53,'excel import 2','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,NULL),(54,'e2','Khác','Nguyễn Bá Học','Kim Đồng',2017,'2017-09-24','Việt',100,2,100000,0,'đã xóa'),(55,'e3','Khác','Nguyễn Bá Học','Kim Đồng',2018,'2017-09-25','Việt',100,2,100000,0,'đã xóa'),(56,'e4','Khác','Nguyễn Bá Học','Kim Đồng',2019,'2017-09-26','Việt',100,2,100000,0,'đã xóa'),(57,'e1','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,NULL),(58,'e2','Khác','Nguyễn Bá Học','Kim Đồng',2017,'2017-09-24','Việt',100,2,100000,0,NULL),(59,'e3','Khác','Nguyễn Bá Học','Kim Đồng',2018,'2017-09-25','Việt',100,2,100000,0,NULL),(60,'e2','Khác','Nguyễn Bá Học','Kim Đồng',2017,'2017-09-24','Việt',100,2,100000,0,NULL),(62,'Toán Phân Tích','Toán học','Nguyễn Hải Anh','Bách Khoa HN',2016,'2017-09-09','Việt',120,3,150000,0,NULL),(63,'e1','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,'đã xóa'),(64,'e1','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,2,100000,0,'đã xóa'),(65,'tet','Khác','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-23','Việt',100,5,100000,0,NULL),(66,'Linux 2','Khác','Trần Văn Hạnh','Đại học quốc gia',2017,'2017-09-21','Việt',110,3,100000,0,NULL),(67,'excel import ádasd','Thiếu nhi','Nguyễn Bá Học','Kim Đồng',2016,'2017-09-15','Việt',100,2,100000,0,NULL),(68,'Tin học đại cương','Tin học','Lê Thị Lan','Giáo dục và đào tạo',2013,'2017-03-03','việt',210,7,210000,0,NULL),(69,'Thơ Mùa Xuân','Văn học','Hồ Xuân Hạnh','Giáo dục và đào tạo',2017,'2017-09-20','việt',150,6,150000,0,'đã xóa'),(70,'Lịch Vạn Sự','Xã hội','Phương Đông','Đại học KHXH',2017,'2017-10-25','Việt',130,10,210000,0,NULL),(71,'Tin học đại cương','Tin học','Lê Thị Lan','Giáo dục và đào tạo',2013,'2017-03-03','việt',210,7,210000,0,'đã xóa'),(72,'Thơ Mùa Xuân','Văn học','Hồ Xuân Hạnh','Giáo dục và đào tạo',2017,'2017-09-20','việt',150,6,150000,0,'đã xóa'),(73,'Tin học đại cương','Tin học','Lê Thị Lan','Giáo dục và đào tạo',2013,'2017-03-03','việt',210,7,210000,0,'đã xóa'),(74,'Thơ Mùa Xuân','Văn học','Hồ Xuân Hạnh','Giáo dục và đào tạo',2017,'2017-09-20','việt',150,6,150000,0,'đã xóa'),(75,'Tin học đại cương','Tin học','Lê Thị Lan','Giáo dục và đào tạo',2013,'2017-03-03','việt',210,7,210000,0,NULL),(76,'Thơ Mùa Xuân','Văn học','Hồ Xuân Hạnh','Giáo dục và đào tạo',2017,'2017-09-20','việt',150,6,150000,0,NULL),(77,'Tin học đại cương','Tin học','Lê Thị Lan','Giáo dục và đào tạo',2013,'2017-03-03','việt',210,7,210000,0,NULL),(78,'Thơ Mùa Xuân','Văn học','Hồ Xuân Hạnh','Giáo dục và đào tạo',2017,'2017-09-20','việt',150,6,150000,0,NULL);
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vipham`
--

DROP TABLE IF EXISTS `vipham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vipham` (
  `mavipham` int(11) NOT NULL AUTO_INCREMENT,
  `mamuontra` int(11) NOT NULL,
  `quahan` int(11) DEFAULT NULL,
  `lydo` varchar(45) DEFAULT NULL,
  `xuly` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mavipham`),
  KEY `fk_vipham_muontra1_idx` (`mamuontra`),
  CONSTRAINT `fk_vipham_muontra1` FOREIGN KEY (`mamuontra`) REFERENCES `muontra` (`mamuontra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vipham`
--

LOCK TABLES `vipham` WRITE;
/*!40000 ALTER TABLE `vipham` DISABLE KEYS */;
INSERT INTO `vipham` VALUES (1,4,14,'Quá hạn','Đã xử lý'),(2,19,48,'Quá hạn',NULL),(3,20,17,'Quá hạn','Đã xử lý'),(4,17,31,'Quá hạn','Đã xử lý'),(5,15,30,'Quá hạn',NULL),(6,3,50,'Quá hạn','Đã xử lý'),(7,1,200,'Mất sách','Đã xử lý'),(8,22,13,'Mất sách','Đã xử lý'),(9,14,200,'Mất sách',NULL),(10,23,210,'Mất sách','Đã xử lý'),(11,25,210,'Mất sách','Đã xử lý'),(12,45,130,'Mất sách',NULL),(13,52,210,'Mất sách',NULL),(14,7,13,'Mất sách',NULL),(15,55,200,'Mất sách','Đã xử lý'),(16,56,100,'Mất sách',NULL),(17,57,100,'Mất sách',NULL),(18,41,5,'Quá hạn','Đã xử lý'),(19,63,200,'Mất sách',NULL),(20,65,2,'Quá hạn',NULL),(21,69,200,'Mất sách','Đã xử lý'),(22,84,130,'Mất sách',NULL),(23,74,100,'Mất sách',NULL),(24,77,13,'Mất sách','Đã xử lý'),(25,51,7,'Quá hạn',NULL),(26,70,1,'Quá hạn',NULL),(27,66,7,'Quá hạn',NULL),(28,79,1,'Quá hạn',NULL),(29,78,2,'Quá hạn','Đã xử lý'),(30,85,210,'Mất sách',NULL);
/*!40000 ALTER TABLE `vipham` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-28 20:15:31
