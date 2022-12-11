package by.grsu.abogdel.course.db.model;

import java.sql.Timestamp;

public class Course {
	private Integer id;
	private String name;
	private String address;
	private String duration;
	private Integer teacherId;
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
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
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
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", address=" + address + ", duration=" + duration
				+ ", teacherId=" + teacherId + ", start=" + start + ", created=" + created + ", updated=" + updated
				+ "]";
	}

}