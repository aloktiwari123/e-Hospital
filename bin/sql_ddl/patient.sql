CREATE TABLE `patient` (
  `patient_id` varchar(40) NOT NULL,
  `patient_name` varchar(40) NOT NULL,
  `age` varchar(40) NOT NULL,
  `doctor_assigned` varchar(40) NOT NULL,
  `ward_assigned` varchar(40) NOT NULL,
  `bill` int NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci