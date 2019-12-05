package cn.ekgc.sms.service.impl;

import cn.ekgc.sms.dao.StudentDao;
import cn.ekgc.sms.pojo.entity.Student;
import cn.ekgc.sms.pojo.vo.Page;
import cn.ekgc.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	public Page<Student> getAllStudentByPage(Page<Student> page) throws Exception {
		// 封装查询参数
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("begin", page.getBegin());
		paramMap.put("size", page.getSize());
		// 进行查询
		List<Student> list = studentDao.findStudentListByQuery(paramMap);
		// 获得总条数
		Long totalNum = (long) studentDao.findStudentListByQuery(null).size();
		page.setList(list);
		page.setTotalNum(totalNum);
		page.setTotalPage();
		return page;
	}

	public boolean saveStudent(Student student) throws Exception {
		try {
			studentDao.saveStudent(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
