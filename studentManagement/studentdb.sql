-- MySQL dump for studentdb

DROP DATABASE IF EXISTS studentdb;
CREATE DATABASE studentdb;
USE studentdb;


DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `course` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKe2rndfrsx22acpq2ty1caeuyw` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `students` (`id`,`age`,`course`,`email`,`name`) VALUES
(1, 24, 'BICT', 'himasha@gmail.com', 'Himasha Dewmini'),
(2, 19, 'BICT', 'hasini@gmail.com', 'Hasini Sankalpana'),
(3, 20, 'BICT', 'anusha@gmail.com', 'Anusha Sudarshi'),
(4, 19, 'BICT', 'thamindu@gmail.com', 'Thamindu Prabashwara');

