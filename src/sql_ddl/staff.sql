CREATE TABLE `staff` (
  `ep_id` varchar(40) NOT NULL,
  `ep_name` varchar(40) DEFAULT NULL,
  `staff_type` varchar(40) DEFAULT NULL,
  `ward_assigned` varchar(40) DEFAULT NULL,
  `shift` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci