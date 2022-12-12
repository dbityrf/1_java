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
import by.grsu.abogdel.course.web.dto.PersonDto;
import by.grsu.abogdel.course.web.dto.RoleDto;
import by.grsu.abogdel.course.web.dto.TableStateDto;

public class PersonServlet extends AbstractListServlet {
	
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
		int totalPersons = personDao.count(); 

		final TableStateDto tableStateDto = resolveTableStateDto(req, totalPersons); 

		List<Person> persons = personDao.find(tableStateDto); 

		List<PersonDto> dtos = persons.stream().map((entity) -> {
			PersonDto dto = new PersonDto();
			
			dto.setId(entity.getId());
			dto.setFirstName(entity.getFirstName());
			dto.setLastName(entity.getLastName());
			dto.setNoun(entity.getNoun());
			dto.setEmail(entity.getEmail());
			dto.setRoleId(entity.getRoleId());
			dto.setCreated(entity.getCreated());
			dto.setUpdated(entity.getUpdated());

		     //build data for complex fields
			Role role = roleDao.getById(entity.getRoleId());
			dto.setRoleName(role.getName());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos); // set data as request attribute (like "add to map") to be used later in JSP
		req.getRequestDispatcher("person.jsp").forward(req, res); // delegate request processing to JSP
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String personIdStr = req.getParameter("id");
		PersonDto dto = new PersonDto();
		if (!Strings.isNullOrEmpty(personIdStr)) {
			// object edit
			Integer personId = Integer.parseInt(personIdStr);
			Person entity = personDao.getById(personId);
			dto.setId(entity.getId());
			dto.setFirstName(entity.getFirstName());
			dto.setLastName(entity.getLastName());
			dto.setNoun(entity.getNoun());
			dto.setEmail(entity.getEmail());
			dto.setRoleId(entity.getRoleId());
		
		}
		req.setAttribute("dto", dto);
		req.setAttribute("allRoles", getAllRolesDtos());
		req.getRequestDispatcher("person-edit.jsp").forward(req, res);
	}


	private List<RoleDto> getAllRolesDtos() {
		return roleDao.getAll().stream().map((entity) -> {
			RoleDto dto = new RoleDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Person person = new Person();
		String personIdStr = req.getParameter("id");
		String firstNameStr = req.getParameter("first_name");
		String lastNamedStr = req.getParameter("last_name");
		String nounStr = req.getParameter("noun");
		String emailStr = req.getParameter("email");
		String roleIdInt = req.getParameter("role_id");
		
		person.setRoleId(roleIdInt == null ? null : Integer.parseInt(roleIdInt));
		
		person.setUpdated(new Timestamp(new Date().getTime()));
		if (Strings.isNullOrEmpty(personIdStr)) {
			// new entity
			person.setCreated(new Timestamp(new Date().getTime()));
			personDao.insert(person);
		} else {
			// updated entity
			person.setId(Integer.parseInt(personIdStr));
			personDao.update(person);
		}
		res.sendRedirect("/person"); // will send 302 back to client and client will execute GET /car
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		personDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}