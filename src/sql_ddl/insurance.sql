CREATE TABLE `insurance` (
  `patient_id` varchar(40) NOT NULL,
  `patient_name` varchar(40) NOT NULL,
  `plan_selected` varchar(40) NOT NULL,
  `bill` int NOT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci