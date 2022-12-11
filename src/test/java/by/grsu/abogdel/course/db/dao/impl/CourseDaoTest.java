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



public class CourseDaoTest extends AbstractTest {
	
	private static final IDao<Integer, Person> personDao =PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Course> courseDao = CourseDaoImpl.INSTANCE;
	private static final IDao<Integer, Role> roleDao = RoleDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Course entity = new Course();
		entity.setName("Hight Matimaticcccs");
		entity.setAddress("WAUZZZ8K0BA003806");
		entity.setDuration("WAUZZZ86");
		entity.setTeacherId(savePerson().getId());
		entity.setStart("12.12.2022");
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		courseDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testInsertWithoutOwner() {
		Course entity = new Course();
		entity.setName("Hight Matimaticcccs");
		entity.setAddress("WAUZZZ8K0BA003806");
		entity.setDuration("WAUZZZ86");
		entity.setTeacherId(savePerson().getId());
		entity.setStart("12.12.2022");
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		courseDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Person person = new Person();
		person.setFirstName("KMkmd");
		person.setLastName("JDsa");
		person.setNoun("gbd");
		person.setEmail("dfsdf");
		person.setRoleId(saveRole().getId());
		person.setCreated(getCurrentTime());
		person.setUpdated(getCurrentTime());
		personDao.insert(person);
		
		
		
		
		
		Course entity = new Course();
		entity.setName("Hight Matimaticcccs");
		entity.setAddress("WAUZZZ8K0BA003806");
		entity.setDuration("WAUZZZ86");
		entity.setTeacherId(person.getId());
	    entity.setStart("12.02.2023");
	    entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		courseDao.insert(entity);

		
		
		
		
		Person newPerson = savePerson();
		String newName = "T";
		String newAddress = "vvsdmv";
		String newDuration = "DKsl";
		String newStart = "12.03.2022";
		
		entity.setName(newName);
		entity.setAddress(newAddress);
		entity.setDuration(newDuration);
		entity.setTeacherId(newPerson.getId());
		entity.setStart(newStart);
		courseDao.update(entity);

		
		
		
		
		
		
		Course updatedEntity = courseDao.getById(entity.getId());
		Assertions.assertEquals(newName, updatedEntity.getName());
		Assertions.assertEquals(newAddress, updatedEntity.getAddress());
		Assertions.assertEquals(newDuration, updatedEntity.getDuration());
		Assertions.assertEquals(newPerson.getId(), updatedEntity.getTeacherId());
	}

	@Test
	public void testDelete() {
		Course entity = new Course();
		entity.setName("Hight Matimaticcccs");
		entity.setAddress("WAUZZZ8K0BA003806");
		entity.setDuration("WAUZZZ86");
		entity.setTeacherId(savePerson().getId());
		entity.setStart("12.12.2022");
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		courseDao.insert(entity);

		courseDao.delete(entity.getId());

		Assertions.assertNull(courseDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Course entity = new Course();
		entity.setName("Hight Matimaticcccs");
		entity.setAddress("WAUZZZ8K0BA003806");
		entity.setDuration("WAUZZZ86");
		entity.setTeacherId(savePerson().getId());
		entity.setStart("12.12.2022");
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		courseDao.insert(entity);
		Course selectedEntity = courseDao.getById(entity.getId());

		Assertions.assertEquals(entity.getName(), selectedEntity.getName());
		Assertions.assertEquals(entity.getAddress(), selectedEntity.getAddress());
		Assertions.assertEquals(entity.getDuration(), selectedEntity.getDuration());
		Assertions.assertEquals(entity.getTeacherId(), selectedEntity.getTeacherId());
		Assertions.assertEquals(entity.getStart(), selectedEntity.getStart());
		Assertions.assertEquals(entity.getCreated(), selectedEntity.getCreated());
		Assertions.assertEquals(entity.getUpdated(), selectedEntity.getUpdated());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Course entity = new Course();
			entity.setName("Hight Matimaticcccs");
			entity.setAddress("WAUZZZ8K0BA003806");
			entity.setDuration("WAUZZZ86");
			entity.setTeacherId(savePerson().getId());
			entity.setStart("12.12.2022");
			entity.setCreated(getCurrentTime());
			entity.setUpdated(getCurrentTime());
			courseDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, courseDao.getAll().size());
	
	}

	private Person savePerson() {
	
			Role roleEntity = new Role();
			roleEntity.setName("kjbk");
			roleDao.insert(roleEntity);
			
			Person personEntity = new Person();
			personEntity.setFirstName( "first_name");
			personEntity.setLastName("last_name");
			personEntity.setNoun("jhv");
			personEntity.setEmail("dgv");
			personEntity.setRoleId(roleEntity.getId());
			personEntity.setCreated(getCurrentTime());
			personEntity.setUpdated(getCurrentTime());
			personDao.insert(personEntity);
		return personEntity;
	}
}