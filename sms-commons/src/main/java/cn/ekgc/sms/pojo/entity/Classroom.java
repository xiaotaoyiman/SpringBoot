package cn.ekgc.sms.pojo.entity;

import java.io.Serializable;

public class Classroom implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long classroomId;                         // 班级主键
	private String classroomNo;                       // 班级编号

	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public String getClassroomNo() {
		return classroomNo;
	}

	public void setClassroomNo(String classroomNo) {
		this.classroomNo = classroomNo;
	}
}
