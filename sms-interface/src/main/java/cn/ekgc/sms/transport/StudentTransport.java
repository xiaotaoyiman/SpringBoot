package cn.ekgc.sms.transport;

import cn.ekgc.sms.pojo.entity.Student;
import cn.ekgc.sms.pojo.vo.Page;

public interface StudentTransport {
	Page<Student> getAllStudentByPage(Page<Student> page) throws Exception;

	boolean saveStudent(Student student) throws Exception;
}
