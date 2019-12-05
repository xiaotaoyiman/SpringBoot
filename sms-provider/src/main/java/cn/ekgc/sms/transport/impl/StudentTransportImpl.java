package cn.ekgc.sms.transport.impl;

import cn.ekgc.sms.pojo.entity.Student;
import cn.ekgc.sms.pojo.vo.Page;
import cn.ekgc.sms.service.StudentService;
import cn.ekgc.sms.transport.StudentTransport;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "3.0.0")
public class StudentTransportImpl implements StudentTransport {
	@Resource(name = "studentService")
	private StudentService studentService;

	public Page<Student> getAllStudentByPage(Page<Student> page) throws Exception {
		return studentService.getAllStudentByPage(page);
	}

	public boolean saveStudent(Student student) throws Exception {
		return studentService.saveStudent(student);
	}
}
