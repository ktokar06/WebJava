-- db_Demo.review definition

CREATE TABLE `review` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `orders` int(11) NOT NULL,
  `stars` int(11) NOT NULL,
  `review` text DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `review_orders_FK` (`orders`),
  CONSTRAINT `review_orders_FK` FOREIGN KEY (`orders`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;