package cn.ekgc.sms.service;

import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.vo.Page;

public interface ClassroomService {
	Page<Classroom> getClassroomPage(Page<Classroom> page) throws Exception;
}
