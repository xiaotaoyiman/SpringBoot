package cn.ekgc.sms.dao;

import cn.ekgc.sms.pojo.entity.Classroom;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClassroomDao {
	List<Classroom> findClassroomListByQuery(Map<String, Object> queryMap) throws Exception;
}
