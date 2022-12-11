package by.grsu.abogdel.course.db.model;

public class Course2Student {
	private Integer id;
	private Integer courseId;
	private Integer studentId;
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
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Course2Student [id=" + id + ", courseId=" + courseId + ", studentId=" + studentId + ", grade=" + grade
				+ ", getId()=" + getId() + ", getCourseId()=" + getCourseId() + ", getStudentId()=" + getStudentId()
				+ ", getGrade()=" + getGrade() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
