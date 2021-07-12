CREATE TABLE `doctor` (
  `doctor_id` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `qualification` varchar(40) NOT NULL,
  `specialization` varchar(40) NOT NULL,
  `ward` varchar(20) Default NULL,
   PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci