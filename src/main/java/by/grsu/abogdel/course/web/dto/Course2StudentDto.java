package by.grsu.abogdel.course.web.dto;

import java.sql.Timestamp;

public class Course2StudentDto {

	private Integer id;
	
	private Integer courseId;
	
	private String courseName;
	
	private Integer studentId;
	
	private String studentName;
	
	private Integer grade;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	public Integer getCourseName() {
		return courseId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getStudentName() {
		return studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
		public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	

	
}