package by.grsu.abogdel.course.db.dao.impl;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.abogdel.course.db.dao.IDao;
import by.grsu.abogdel.course.db.dao.impl.Course2StudentDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.CourseDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.PersonDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.RoleDaoImpl;
import by.grsu.abogdel.course.db.model.Course;
import by.grsu.abogdel.course.db.model.Course2Student;
import by.grsu.abogdel.course.db.model.Person;
import by.grsu.abogdel.course.db.model.Role;


public class Course2StudentDaoTest extends AbstractTest {
	private static final IDao<Integer, Course2Student> course2studentDao = Course2StudentDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao =PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Course> courseDao = CourseDaoImpl.INSTANCE;
	private static final IDao<Integer, Role> roleDao = RoleDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Course2Student entity = new Course2Student();
		entity.setCourseId(saveCourse().getId());
		entity.setStudentId(savePerson().getId());
		entity.setGrade(9);
		course2studentDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testInsertWithoutOwner() {
		Course2Student entity = new Course2Student();
		entity.setCourseId(saveCourse().getId());
		entity.setStudentId(savePerson().getId());
		entity.setGrade(9);
			course2studentDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Course2Student entity = new Course2Student();
		entity.setCourseId(saveCourse().getId());
		entity.setStudentId(savePerson().getId());
		entity.setGrade(9);
		course2studentDao.insert(entity);

		Integer newGrade = 9;
		entity.setGrade(newGrade);
		course2studentDao.update(entity);

		Course2Student updatedEntity = course2studentDao.getById(entity.getId());
		Assertions.assertEquals(newGrade, updatedEntity.getGrade()); 
	}

	@Test
	public void testDelete() {
		Course2Student entity = new Course2Student();
		entity.setCourseId(saveCourse().getId());
		entity.setStudentId(savePerson().getId());
		entity.setGrade(9);
		course2studentDao.insert(entity);

		course2studentDao.delete(entity.getId());

		Assertions.assertNull(course2studentDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Course2Student entity = new Course2Student();
		entity.setStudentId(savePerson().getId());
		entity.setCourseId(saveCourse().getId());
		entity.setGrade(9);
		course2studentDao.insert(entity);

		Course2Student selectedEntity = course2studentDao.getById(entity.getId());

		Assertions.assertEquals(entity.getStudentId(), selectedEntity.getStudentId());
		Assertions.assertEquals(entity.getCourseId(), selectedEntity.getCourseId());
		Assertions.assertEquals(entity.getGrade(), selectedEntity.getGrade());

	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Course2Student entity = new Course2Student();
			entity.setCourseId(saveCourse().getId());
			entity.setStudentId(savePerson().getId());
			entity.setGrade(9);
			course2studentDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, course2studentDao.getAll().size());
	}

	private Person savePerson() {
		Role roleEntity = new Role();
		roleEntity.setName("kjbk");
		roleDao.insert(roleEntity);
		
		Person personEntity = new Person();
		personEntity.setFirstName("hgchg");
		personEntity.setLastName("gchg");
		personEntity.setNoun("jhv");
		personEntity.setEmail("dgv");
		personEntity.setRoleId(roleEntity.getId());
		personEntity.setCreated(getCurrentTime());
		personEntity.setUpdated(getCurrentTime());
		personDao.insert(personEntity);
		return personEntity;
	}

	private Course saveCourse() {
		Role roleEntity = new Role();
		roleEntity.setName("kjbk");
		roleDao.insert(roleEntity);
		
		Person personEntity = new Person();
		personEntity.setFirstName("hgchg");
		personEntity.setLastName("gchg");
		personEntity.setNoun("jhv");
		personEntity.setEmail("dgv");
		personEntity.setRoleId(roleEntity.getId());
		personEntity.setCreated(getCurrentTime());
		personEntity.setUpdated(getCurrentTime());
		personDao.insert(personEntity);
		
		Course courseEntity = new Course();
		courseEntity.setName("Hight Matimatimaticcccs");
		courseEntity.setAddress("hgchgc");
		courseEntity.setDuration("jgfjf");
		courseEntity.setTeacherId(personEntity.getId());
		courseEntity.setStart("12.01.2023");
		courseEntity.setCreated(getCurrentTime());
		courseEntity.setUpdated(getCurrentTime());
		courseDao.insert(courseEntity);

		
		return courseEntity;
	}
}