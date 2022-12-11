package by.grsu.abogdel.course.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import by.grsu.abogdel.course.db.dao.IDao;
import by.grsu.abogdel.course.db.dao.impl.CourseDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.PersonDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.RoleDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.Course2StudentDaoImpl;
import by.grsu.abogdel.course.db.model.Course;
import by.grsu.abogdel.course.db.model.Person;
import by.grsu.abogdel.course.db.model.Role;
import by.grsu.abogdel.course.db.model.Course2Student;
import by.grsu.abogdel.course.web.dto.CourseDto;
import by.grsu.abogdel.course.web.dto.PersonDto;
import by.grsu.abogdel.course.web.dto.RoleDto;
import by.grsu.abogdel.course.web.dto.TableStateDto;
import by.grsu.abogdel.course.web.dto.Course2StudentDto;

public class CourseServlet extends AbstractListServlet {
	
	private static final IDao<Integer, Role> roleDao = RoleDaoImpl.INSTANCE;
	private static final IDao<Integer, Course> courseDao = CourseDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Course2Student> course2studentDao = Course2StudentDaoImpl.INSTANCE;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet");
		String viewParam = req.getParameter("view");
		if ("edit".equals(viewParam)) {
			handleEditView(req, res);
		} else {
			handleListView(req, res);
		}
	}

	private void handleListView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int totalCourses = courseDao.count(); 

		final TableStateDto tableStateDto = resolveTableStateDto(req, totalCourses); 

		List<Course> courses = courseDao.find(tableStateDto); 

		List<CourseDto> dtos = courses.stream().map((entity) -> {
			CourseDto dto = new CourseDto();
			
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setAddress(entity.getAddress());
			dto.setStart(entity.getStart());
			dto.setDuration(entity.getDuration());
			dto.setTeacherId(entity.getTeacherId());
			dto.setCreated(entity.getCreated());
			dto.setUpdated(entity.getUpdated());

		     //build data for complex fields
			Person person = personDao.getById(entity.getTeacherId());
			dto.setTeacherName(person.getLastName() + " " + person.getFirstName());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); 
		req.getRequestDispatcher("person.jsp").forward(req, res); 
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String courseIdStr = req.getParameter("id");
		CourseDto dto = new CourseDto();
		if (!Strings.isNullOrEmpty(courseIdStr)) {
			// object edit
			Integer courseId = Integer.parseInt(courseIdStr);
			Course entity = courseDao.getById(courseId);
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setAddress(entity.getAddress());
			dto.setDuration(entity.getDuration());
			dto.setStart(entity.getStart());
			dto.setTeacherId(entity.getTeacherId());
			
		
		}
		req.setAttribute("dto", dto);
		req.setAttribute("allPersons", getAllPersonsDtos());
		req.getRequestDispatcher("course-edit.jsp").forward(req, res);
	}


	private List<PersonDto> getAllPersonsDtos() {
		return personDao.getAll().stream().map((entity) -> {
			PersonDto dto = new PersonDto();
			dto.setId(entity.getId());
			dto.setFirstName(entity.getFirstName());
			dto.setLastName(entity.getLastName());
			dto.setNoun(entity.getNoun());
			dto.setEmail(entity.getEmail());
			dto.setRoleId(entity.getRoleId());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Course course = new Course();
		String courseIdStr = req.getParameter("id");
		String nameStr = req.getParameter("name");
		String addressStr = req.getParameter("address");
		String durationStr = req.getParameter("duration");
		String startStr = req.getParameter("start");
		String teacherIdInt = req.getParameter("teacher_id");
		
		//course.setTeacherId(null);
		
		course.setUpdated(new Timestamp(new Date().getTime()));
		if (Strings.isNullOrEmpty(courseIdStr)) {
			// new entity
			course.setCreated(new Timestamp(new Date().getTime()));
			courseDao.insert(course);
		} else {
			// updated entity
			course.setId(Integer.parseInt(courseIdStr));
			courseDao.update(course);
		}
		res.sendRedirect("/course"); // will send 302 back to client and client will execute GET /car
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		courseDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}