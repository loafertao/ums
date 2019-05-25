drop database if exists stu_db;
create database stu_db;
use stu_db;
CREATE TABLE `sys_student` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `studentNo` varchar(100) NOT NULL,
  `userName` varchar(200) DEFAULT '',
  `password` varchar(500) NOT NULL DEFAULT '',
  `studentName` varchar(255) DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `gender` varchar(11) DEFAULT NULL,
  `score` double(100) DEFAULT NULL,
  `clazzId` int(11) NOT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table sys_clazz(
	clazzId int(11) not null  AUTO_INCREMENT,
	clazzNo varchar(255) not null,
	classroom varchar(255) not null,
	PRIMARY KEY (`clazzId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;