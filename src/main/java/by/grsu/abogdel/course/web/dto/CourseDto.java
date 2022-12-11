
package by.grsu.abogdel.course.web.dto;

import java.sql.Timestamp;

public class CourseDto {

	private Integer id;

	private String name;
	
	private String address;
	
	private String duration;
	
	private Integer teacherId;
	
	private String teacherName;
	
	private String start;

	private Timestamp created;

	private Timestamp updated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String Address) {
		this.address = address;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String Duration) {
		this.duration = duration;
	}
	


	public Integer getteacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer roteacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String TeacherName) {
		this.teacherName = teacherName;
	}
	

		public String getStart() {
		return start;
	}

	public void setStart(String Start) {
		this.start = start;
	}
	

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

}