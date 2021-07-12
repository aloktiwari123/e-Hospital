CREATE TABLE `facility` (
  `facility_id` varchar(40) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `description` varchar(40) DEFAULT NULL,
  `price` varchar(40) DEFAULT NULL,
  `availablity` varchar(20) DEFAULT NULL,
  PRIMARY KEY(`facility_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci