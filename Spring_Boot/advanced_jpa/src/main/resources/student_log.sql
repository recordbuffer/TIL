CREATE TABLE `sample`.`student_log` (
  `log_id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `log_date` datetime,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3

INSERT INTO sample.student_log(email,ip,log_date)
VALUES
('hong@sample.com', '127.0.0.1', '2023-06-17 11:27:09'),
('hong@sample.com', '127.0.0.1', '2023-06-17 11:39:19'),
('hong@sample.com', '127.0.0.1', '2023-06-17 11:47:37'),
('hong@sample.com', '127.0.0.1', '2023-06-17 11:50:11'),
('gogogo@sample.com', '127.0.0.1', '2023-06-17 11:50:13'),
('hahuhohi@sample.com', '127.0.0.1', '2023-06-17 11:52:19'),
('hahuhohi@sample.com', '127.0.0.1', '2023-06-17 12:11:11'),
('gogogo@sample.com', '127.0.0.1', '2023-06-17 13:10:13')
