package cn.ekgc.sms.dao;

import cn.ekgc.sms.pojo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentDao {
	public List<Student> findStudentListByQuery(Map<String, Object> paramMap) throws Exception;

	void saveStudent(Student student) throws Exception;
}
