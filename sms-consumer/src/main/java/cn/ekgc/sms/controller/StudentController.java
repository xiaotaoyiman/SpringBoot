package cn.ekgc.sms.controller;

import cn.ekgc.sms.controller.base.BaseController;
import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.entity.Student;
import cn.ekgc.sms.pojo.vo.Page;
import cn.ekgc.sms.transport.ClassroomTransport;
import cn.ekgc.sms.transport.StudentTransport;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.zookeeper.server.persistence.FileTxnSnapLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller("studentController")
@RequestMapping("/student")
public class StudentController extends BaseController {
	@Reference(version = "3.0.0")
	private StudentTransport studentTransport;
	@Reference(version = "3.0.0")
	private ClassroomTransport classroomTransport;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String forwardStudentIndex() throws Exception {
		return "student/student_index";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<Student> getAllStudentByPage(Integer pageNum, Integer pageSize, Integer draw) throws Exception {
		// 根据所给定的pageNum、pageSize以及draw创建Page对象
		Page<Student> page = new Page<Student>(pageNum, pageSize, draw);
		// 通过使用业务层完成分页查询
		page = studentTransport.getAllStudentByPage(page);
		return page;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String forwardAddForm() throws Exception {
		return "student/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveStudent(Student student, Long classroomId) throws Exception {
		// 根据班级主键，封装班级信息
		Classroom classroom = new Classroom();
		classroom.setClassroomId(classroomId);
		student.setClassroom(classroom);
		student.setStudentNo("DK" + new Date());
		// 根据身份证号码，获得该学生的性别
		Integer genderCode = Integer.parseInt(student.getIdCard().substring(16, 17));
		if (genderCode % 2 == 0) {
			student.setGender("F");
		} else {
			student.setGender("M");
		}
		// 对于学号来说，可以在保存成功学生信息之后，获得主键，在根据主键进行扩展
		// 不仅仅根据主键，也可以根据班级的编号来进行获得
		return studentTransport.saveStudent(student);
	}



}
