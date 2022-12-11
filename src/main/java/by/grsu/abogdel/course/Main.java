package by.grsu.abogdel.course;
import java.sql.Timestamp;
import java.util.Date;

import by.grsu.abogdel.course.db.model.*;
public class Main {
	public static void main(String[]args) {
		Course course = new Course();
		course.setId(1);
		course.setName("Higher mathematics");
		course.setAddress("Ozheshko,22");
		course.setDuration("3 month");
		course.setTeacherId(1);
		course.setStart("15.10.2022");
		course.setCreated(new Timestamp(new Date().getTime()));
		course.setUpdated(new Timestamp(new Date().getTime()));
		System.out.println (course.toString());
		////////////////////
		Person person = new Person();
		person.setId(1);
		person.setFirstName("Andrey");
		person.setLastName("Ivanov");
		person.setNoun("Olegovich");
		person.setEmail("ivanyshka@mail.ru");
		person.setRoleId(1);
		person.setCreated(new Timestamp(new Date().getTime()));
		person.setUpdated(new Timestamp(new Date().getTime()));
		System.out.println(person.toString());
		/////////////////////
		Course2Student course2student = new Course2Student();
		course2student.setId(1);
		course2student.setCourseId(1);
		course2student.setStudentId(1);
		course2student.setGrade(9);
		System.out.println(course2student.toString());
		///////////////////////
		Role role = new Role();
		role.setId(1);
		role.setName("Student");
		System.out.println(role.toString());
				
	}
}