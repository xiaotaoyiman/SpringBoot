package cn.ekgc.sms.transport.impl;

import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.vo.Page;
import cn.ekgc.sms.service.ClassroomService;
import cn.ekgc.sms.transport.ClassroomTransport;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "3.0.0")
public class ClassroomTransportImpl implements ClassroomTransport {
	@Resource(name = "classroomService")
	private ClassroomService classroomService;

	public Page<Classroom> getClassroomPage(Page<Classroom> page) throws Exception {
		return classroomService.getClassroomPage(page);
	}
}
