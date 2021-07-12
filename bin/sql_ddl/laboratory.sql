CREATE TABLE `laboratory` (
  `lab_id` varchar(40) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `specification` varchar(40) DEFAULT NULL,
  `equipments` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`lab_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci