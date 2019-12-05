package cn.ekgc.sms.service;

import cn.ekgc.sms.pojo.entity.Student;
import cn.ekgc.sms.pojo.vo.Page;

public interface StudentService {
	Page<Student> getAllStudentByPage(Page<Student> page) throws Exception;

	boolean saveStudent(Student student) throws Exception;
}
