package cn.ekgc.sms.transport;

import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.vo.Page;

public interface ClassroomTransport {
	Page<Classroom> getClassroomPage(Page<Classroom> page) throws Exception;
}
