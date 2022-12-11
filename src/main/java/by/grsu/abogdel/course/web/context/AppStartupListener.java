package by.grsu.abogdel.course.web.context;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.grsu.abogdel.course.db.dao.AbstractDao;
import by.grsu.abogdel.course.db.dao.IDao;
import by.grsu.abogdel.course.db.dao.impl.Course2StudentDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.CourseDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.PersonDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.RoleDaoImpl;
import by.grsu.abogdel.course.db.model.Course2Student;
import by.grsu.abogdel.course.db.model.Course;
import by.grsu.abogdel.course.db.model.Role;
import by.grsu.abogdel.course.db.model.Person;

public class AppStartupListener implements ServletContextListener {

	private static final IDao<Integer, Course2Student> course2studentDao = Course2StudentDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Course> courseDao = CourseDaoImpl.INSTANCE;
	private static final IDao<Integer, Role> roleDao = RoleDaoImpl.INSTANCE;

	private static final String DB_NAME = "production-db";

	private void initDb() throws SQLException {
		AbstractDao.init(DB_NAME);
		if (!AbstractDao.isDbExist()) {
			System.out.println(String.format("DB '%s' doesn't exist and will be created", DB_NAME));
			AbstractDao.createDbSchema();
			loadInitialData();
		} else {
			System.out.println(String.format("DB '%s' exists", DB_NAME));
		}
	}

	private void loadInitialData() {

		Role roleEntity = new Role();
		roleEntity.setName("teacher");
		roleDao.insert(roleEntity);
		System.out.println("created: " + roleEntity);

		Person personEntity = new Person();
		personEntity.setFirstName("Иванов");
		personEntity.setLastName("Иван");
		personEntity.setNoun("Иванович");
		personEntity.setEmail("vanushka@mail.ru");
		personEntity.setRoleId(roleEntity.getId());
		personEntity.setCreated(getCurrentTime());
		personEntity.setUpdated(getCurrentTime());
		personDao.insert(personEntity);
		System.out.println("created: " + personEntity);

		Course courseEntity = new Course();
		courseEntity.setName("Hight Matimatimaticcccs");
		courseEntity.setAddress("Гаспадарчая,23");
		courseEntity.setDuration("3 месяца");
		courseEntity.setTeacherId(personEntity.getId());
		courseEntity.setStart("12.01.2023");
		courseEntity.setCreated(getCurrentTime());
		courseEntity.setUpdated(getCurrentTime());
		courseDao.insert(courseEntity);
		System.out.println("created: " + courseEntity);

		Course2Student course2studentEntity = new Course2Student();
		course2studentEntity.setCourseId(courseEntity.getId());
		course2studentEntity.setStudentId(personEntity.getId());
		course2studentEntity.setGrade(9);
		course2studentDao.insert(course2studentEntity);
		System.out.println("created: " + course2studentEntity);

		System.out.println("initial data created");
	}

	private Timestamp getCurrentTime() {
		return new Timestamp(new Date().getTime());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
		try {
			initDb();
		} catch (SQLException e) {
			throw new RuntimeException("can't init DB", e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}
}