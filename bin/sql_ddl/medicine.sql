CREATE TABLE `medicine` (
  `medicine_name` varchar(40) NOT NULL,
  `brand` varchar(40) DEFAULT NULL,
  `mfd_date` varchar(40) DEFAULT NULL,
  `expiry_date` varchar(40) DEFAULT NULL,
  `price` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`medicine_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci