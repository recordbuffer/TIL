CREATE TABLE `student` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3

INSERT INTO testdb.student(email,name) VALUES('hong@sample.com','홍길동');
INSERT INTO testdb.student(email,name) VALUES('gogogo@sample.com','고길동');
INSERT INTO testdb.student(email,name) VALUES('hahuhohi@sample.com','허균');
