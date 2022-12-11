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
import by.grsu.abogdel.course.db.dao.impl.Course2StudentDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.PersonDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.RoleDaoImpl;
import by.grsu.abogdel.course.db.model.Course;
import by.grsu.abogdel.course.db.model.Person;
import by.grsu.abogdel.course.db.model.Course2Student;
import by.grsu.abogdel.course.db.model.Role;
import by.grsu.abogdel.course.web.dto.CourseDto;
import by.grsu.abogdel.course.web.dto.PersonDto;
import by.grsu.abogdel.course.web.dto.RoleDto;
import by.grsu.abogdel.course.web.dto.Course2StudentDto;
import by.grsu.abogdel.course.web.dto.TableStateDto;

public class Course_2_StudentServlet extends AbstractListServlet {
	private static final IDao<Integer, Course> courseDao = CourseDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Course2Student> course2studentDao = Course2StudentDaoImpl.INSTANCE;
	private static final IDao<Integer, Role> roleDao = RoleDaoImpl.INSTANCE;

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
		int totalCourse2Students = course2studentDao.count(); 

		final TableStateDto tableStateDto = resolveTableStateDto(req, totalCourse2Students);
		List<Course2Student> course2students = course2studentDao.find(tableStateDto); 
		List<Course2StudentDto> dtos = course2students.stream().map((entity) -> {
			Course2StudentDto dto = new Course2StudentDto();
	
			dto.setId(entity.getId());
			dto.setCourseId(entity.getCourseId());
			dto.setStudentId(entity.getStudentId());
			dto.setGrade(entity.getGrade());

			Course course = courseDao.getById(entity.getCourseId());
			dto.setCourseName(course.getName());

			Person person = personDao.getById(entity.getStudentId());
			dto.setStudentName(person.getLastName() + " " + person.getFirstName());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); // set data as request attribute (like "add to map") to be used later in JSP
		req.getRequestDispatcher("course2student-list.jsp").forward(req, res); // delegate request processing to JSP
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String course2studentIdStr = req.getParameter("id");
		Course2StudentDto dto = new Course2StudentDto();
		if (!Strings.isNullOrEmpty(course2studentIdStr)) {
			
			Integer course2studentId = Integer.parseInt(course2studentIdStr);
			Course2Student entity = course2studentDao.getById(course2studentId);
			dto.setId(entity.getId());
			dto.setCourseId(entity.getCourseId());
			dto.setStudentId(entity.getStudentId());
			dto.setGrade(entity.getGrade());
		}
		req.setAttribute("dto", dto);
		req.setAttribute("allCourses", getAllCoursesDtos());
		req.getRequestDispatcher("course-edit.jsp").forward(req, res);
		
		req.setAttribute("dto", dto);
		req.setAttribute("allPersons", getAllPersonsDtos());
		req.getRequestDispatcher("course-edit.jsp").forward(req, res);
	}

	private List<CourseDto> getAllCoursesDtos() {
		return courseDao.getAll().stream().map((entity) -> {
			CourseDto dto = new CourseDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setAddress(entity.getAddress());
			dto.setDuration(entity.getDuration());
			dto.setTeacherId(entity.getTeacherId());
			dto.setStart(entity.getStart());
			return dto;
		}).collect(Collectors.toList());}
		
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
		Course2Student course2student = new Course2Student();
		String course2studentIdStr = req.getParameter("id");
		
		String courseIdStr = req.getParameter("courseId");
		String studentIdStr = req.getParameter("studentId");
     
		
		course2student.setCourseId(courseIdStr == null ? null : Integer.parseInt(courseIdStr));
		course2student.setStudentId(studentIdStr == null ? null : Integer.parseInt(studentIdStr));
       
        
		if (Strings.isNullOrEmpty(course2studentIdStr)) {

			course2studentDao.insert(course2student);
		} else {
			
			course2student.setId(Integer.parseInt(course2studentIdStr));
			course2studentDao.update(course2student);
		}
		res.sendRedirect("/course2student"); 
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		course2studentDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}