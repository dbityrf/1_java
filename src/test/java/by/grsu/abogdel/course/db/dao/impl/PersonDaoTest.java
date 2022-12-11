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

public class PersonDaoTest extends AbstractTest {
	
	
	private static final IDao<Integer, Person> personDao =PersonDaoImpl.INSTANCE;
	

	@Test
	public void testInsert() {
		Person entity = new Person();
		entity.setFirstName("KMkmd");
		entity.setLastName("JDsa");
		entity.setNoun("gbd");
		entity.setEmail("dfsdf");
		entity.setRoleId(saveRole().getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testInsertWithoutOwner() {
		Person entity = new Person();
		entity.setFirstName("KMkmd");
		entity.setLastName("JDsa");
		entity.setNoun("gbd");
		entity.setEmail("dfsdf");
		entity.setRoleId(saveRole().getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Person entity = new Person();
		entity.setFirstName("KMkmd");
		entity.setLastName("JDsa");
		entity.setNoun("gbd");
		entity.setEmail("dfsdf");
		entity.setRoleId(saveRole().getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
		

		Role newRole = saveRole();
		entity.setFirstName("fws");
		entity.setLastName("sef");
		entity.setNoun("wer");
		entity.setEmail("fqwwww");
		entity.setRoleId(newRole.getId());
		entity.setUpdated(getCurrentTime());
		personDao.update(entity);

		Person updatedEntity = personDao.getById(entity.getId());
		Assertions.assertEquals(newRole.getId(), updatedEntity.getRoleId());
		Assertions.assertEquals("fws", updatedEntity.getFirstName());
		Assertions.assertNotEquals(updatedEntity.getUpdated(), updatedEntity.getCreated());
	}

	@Test
	public void testDelete() {
		Person entity = new Person();
		entity.setFirstName("KMkmd");
		entity.setLastName("JDsa");
		entity.setNoun("gbd");
		entity.setEmail("dfsdf");
		entity.setRoleId(saveRole().getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
		personDao.insert(entity);

		personDao.delete(entity.getId());

		Assertions.assertNull(personDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Person entity = new Person();
		entity.setFirstName("KMkmd");
		entity.setLastName("JDsa");
		entity.setNoun("gbd");
		entity.setEmail("dfsdf");
		entity.setRoleId(saveRole().getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
		

		Person selectedEntity = personDao.getById(entity.getId());

		Assertions.assertEquals(entity.getFirstName(), selectedEntity.getFirstName());
		Assertions.assertEquals(entity.getLastName(), selectedEntity.getLastName());
		Assertions.assertEquals(entity.getNoun(), selectedEntity.getNoun());
		Assertions.assertEquals(entity.getEmail(), selectedEntity.getEmail());
		Assertions.assertEquals(entity.getRoleId(), selectedEntity.getRoleId());
		Assertions.assertEquals(entity.getCreated(), selectedEntity.getCreated());
		Assertions.assertEquals(entity.getUpdated(), selectedEntity.getUpdated());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Person entity = new Person();
			entity.setFirstName("KMkmd");
			entity.setLastName("JDsa");
			entity.setNoun("gbd");
			entity.setEmail("dfsdf");
			entity.setRoleId(saveRole().getId());
			entity.setCreated(getCurrentTime());
			entity.setUpdated(getCurrentTime());
			personDao.insert(entity);
			Assertions.assertNotNull(entity.getId());
		
		}

		Assertions.assertEquals(expectedCount, personDao.getAll().size());

	}


}