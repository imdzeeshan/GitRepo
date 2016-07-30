/*
SQLyog Community v9.51 
MySQL - 5.1.54-community : Database - carrental_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`carrental_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `carrental_db`;

/*Table structure for table `tbl_car` */

DROP TABLE IF EXISTS `tbl_car`;

CREATE TABLE `tbl_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `seating_capacity` int(11) DEFAULT '4',
  `luggage_capacity` int(11) DEFAULT '0',
  `trip_charge_perday` double DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_car` */

insert  into `tbl_car`(`id`,`company`,`model`,`seating_capacity`,`luggage_capacity`,`trip_charge_perday`,`status`) values (1,'Volkswagon','Jetta',4,2,90,'open'),(2,'Mercedese','S350',4,2,120,'open'),(3,'Mercedese','C220',4,2,118,'open'),(4,'BMW','M3',4,2,125,'open'),(5,'BMW','X5',4,1,140,'open');

/*Table structure for table `tbl_trip_info` */

DROP TABLE IF EXISTS `tbl_trip_info`;

CREATE TABLE `tbl_trip_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `car` int(11) DEFAULT NULL,
  `pickup_place` varchar(200) DEFAULT NULL,
  `pickup_datetime` datetime DEFAULT NULL,
  `drop_place` varchar(200) DEFAULT NULL,
  `drop_datetime` datetime DEFAULT NULL,
  `total_charge` double DEFAULT NULL,
  `days_on_trip` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_trp_usr` (`user`),
  KEY `fk_trp_car` (`car`),
  CONSTRAINT `fk_trp_car` FOREIGN KEY (`car`) REFERENCES `tbl_car` (`id`),
  CONSTRAINT `fk_trp_usr` FOREIGN KEY (`user`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_trip_info` */

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `ssn` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'active',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
