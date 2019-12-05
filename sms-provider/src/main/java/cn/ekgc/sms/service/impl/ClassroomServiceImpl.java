package cn.ekgc.sms.service.impl;

import cn.ekgc.sms.dao.ClassroomDao;
import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.vo.Page;
import cn.ekgc.sms.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("classroomService")
@Transactional
public class ClassroomServiceImpl implements ClassroomService {
	@Autowired
	private ClassroomDao classroomDao;

	public Page<Classroom> getClassroomPage(Page<Classroom> page) throws Exception {
		// 设定查询参数
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("begin", page.getBegin());
		queryMap.put("size", page.getSize());

		// 查询列表
		List<Classroom> list = classroomDao.findClassroomListByQuery(queryMap);
		// 获得总条数
		queryMap.put("begin", null);
		queryMap.put("size", null);
		Long totalNum = (long) classroomDao.findClassroomListByQuery(queryMap).size();
		// 插入相应的结果
		page.setList(list);
		page.setTotalNum(totalNum);
		page.setTotalPage();
		return page;
	}
}
