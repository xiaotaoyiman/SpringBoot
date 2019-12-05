package cn.ekgc.sms.pojo.entity;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long studentId;                            // 学生主键
	private String studentNo;                          // 学号
	private String studentName;						   // 学生姓名
	private String gender;                             // 性别
	private String idCard;							   // 身份证号码
	private Classroom classroom;					   // 所在班级

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
}
