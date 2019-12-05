DROP DATABASE IF EXISTS sms_db;
CREATE DATABASE sms_db CHARACTER SET 'utf8mb4';
USE sms_db;

-- 创建班级信息表：sys_classroom
DROP TABLE IF EXISTS sys_classroom;
CREATE TABLE sys_classroom(
	classroom_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '班级主键',
	classroom_no VARCHAR(100) NOT NULL COMMENT '班级编号',
	PRIMARY KEY(classroom_id)
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='班级信息表';
INSERT INTO sys_classroom(classroom_no) VALUES('DK0J190701Q');
INSERT INTO sys_classroom(classroom_no) VALUES('DK0J190801Q');
INSERT INTO sys_classroom(classroom_no) VALUES('DK0J190901Q');

-- 创建学生信息表：sys_student
DROP TABLE IF EXISTS sys_student;
CREATE TABLE sys_student(
	student_id INT(10) NOT NULL AUTO_INCREMENT COMMENT'学生主键',
	student_no VARCHAR(100) NOT NULL COMMENT '学号',
	student_name VARCHAR(255) NOT NULL COMMENT '学生姓名',
	gender VARCHAR(10) NOT NULL COMMENT '性别：M-男，F-女',
	id_card VARCHAR(255) NOT NULL COMMENT '身份证号码',
	classroom_id INT(10) NOT NULL COMMENT '班级主键',
	PRIMARY KEY(student_id)
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='学生信息表';