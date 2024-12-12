-- db_Demo.complaint definition

CREATE TABLE `complaint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders` int(11) NOT NULL,
  `complaint` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `complaint_orders_FK` (`orders`),
  CONSTRAINT `complaint_orders_FK` FOREIGN KEY (`orders`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;