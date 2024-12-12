-- db_Demo.orders definition

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `comment` varchar(100) NOT NULL,
  `delivery_date` int(11) DEFAULT NULL,
  `phone` varchar(100) NOT NULL,
  `time_start` timestamp NULL DEFAULT NULL,
  `time_end` timestamp NULL DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  `deliveryman_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orders_person_FK` (`manager_id`),
  KEY `orders_person_FK_1` (`deliveryman_id`),
  KEY `orders_person_FK_2` (`client_id`),
  CONSTRAINT `orders_person_FK` FOREIGN KEY (`manager_id`) REFERENCES `person` (`id`),
  CONSTRAINT `orders_person_FK_1` FOREIGN KEY (`deliveryman_id`) REFERENCES `person` (`id`),
  CONSTRAINT `orders_person_FK_2` FOREIGN KEY (`client_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;