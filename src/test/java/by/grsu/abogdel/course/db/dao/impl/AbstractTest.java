package by.grsu.abogdel.course.db.dao.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import by.grsu.abogdel.course.db.dao.AbstractDao;
import by.grsu.abogdel.course.db.dao.IDao;
import by.grsu.abogdel.course.db.dao.impl.RoleDaoImpl;
import by.grsu.abogdel.course.db.model.Role;

public abstract class AbstractTest {

	private static final IDao<Integer, Role> roleDao = RoleDaoImpl.INSTANCE;

	@BeforeAll
	private static void setup() {
		AbstractDao.init("test-db");
	}

	@BeforeEach
	private void setupThis() {
		AbstractDao.deleteDb();
		AbstractDao.createDbSchema();
	}

	protected Timestamp getCurrentTime() {
		return new Timestamp(new Date().getTime());
	}

	// "31/12/1998";
	protected Date getDateFromString(String dateStr) {
		try {
			return new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(dateStr).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	protected Role saveRole() {

		Role roleEntity = new Role();
		roleEntity.setName("role");
		roleDao.insert(roleEntity);

		return roleEntity;
	}
}