CREATE TABLE `outbox` (
  `id` int NOT NULL AUTO_INCREMENT,
  `aggregate` varchar(10) NOT NULL,
  `message` text NOT NULL,
  `is_delivered` tinyint NOT NULL DEFAULT '0',
  `created_date` timestamp NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
