CREATE TABLE `book` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(255) NOT NULL,
   `price` decimal(10,2) NOT NULL,
   `picture` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1425 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci