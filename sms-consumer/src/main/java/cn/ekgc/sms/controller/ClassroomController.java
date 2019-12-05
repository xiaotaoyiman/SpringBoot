package cn.ekgc.sms.controller;

import cn.ekgc.sms.controller.base.BaseController;
import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.vo.Page;
import cn.ekgc.sms.transport.ClassroomTransport;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("classroomController")
@RequestMapping("/classroom")
public class ClassroomController extends BaseController {
	@Reference(version = "3.0.0")
	private ClassroomTransport classroomTransport;

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<Classroom> getClassroomPage(Integer pageNum, Integer pageSize, Integer draw) throws Exception {
		// 封装分页对象
		Page<Classroom> page = new Page<Classroom>(pageNum, pageSize, draw);
		// 如果用户携带了draw这个参数，那么就是想按照分页进行查询，否则不进行分页查询
		if (draw == null) {
			// 不进行分页查询
			page.setBegin(null);
			page.setSize(null);
		}
		// 通过dubbo进行远程调用，分页查询
		page = classroomTransport.getClassroomPage(page);
		return page;
	}
}
