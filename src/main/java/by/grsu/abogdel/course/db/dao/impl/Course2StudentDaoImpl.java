package by.grsu.abogdel.course.db.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.abogdel.course.db.dao.AbstractDao;
import by.grsu.abogdel.course.db.dao.IDao;
import by.grsu.abogdel.course.db.model.Course2Student;
import by.grsu.abogdel.course.web.dto.TableStateDto;



public class Course2StudentDaoImpl extends AbstractDao implements IDao<Integer, Course2Student> {
	public static final Course2StudentDaoImpl INSTANCE = new Course2StudentDaoImpl();

	private Course2StudentDaoImpl() {
		super();
	}

	@Override
	public void insert(Course2Student entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into course_2_student(course_id, student_id, grade) values(?,?,?)");
			pstmt.setInt(1, entity.getCourseId());
			pstmt.setInt(2, entity.getStudentId());
			pstmt.setInt(3, entity.getGrade());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "course_2_student"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Course2Student entity", e);
		}

	}

	@Override
	public void update(Course2Student entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("update course_2_student set course_id=?, student_id=?,  grade=? where id=?");
			pstmt.setInt(1, entity.getCourseId());
			pstmt.setInt(2, entity.getStudentId());
			pstmt.setInt(3, entity.getGrade());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Course2Student entity", e);
		}

	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from course_2_student where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Course2Student entity", e);
		}
	}

	@Override
	public Course2Student getById(Integer id) {
		Course2Student entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from course_2_student where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Course2Student entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Course2Student> getAll() {
		List<Course2Student> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from course_2_student");
			while (rs.next()) {
				Course2Student entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Course2Student entities", e);
		}

		return entitiesList;
	}

	private Course2Student rowToEntity(ResultSet rs) throws SQLException {
		Course2Student entity = new Course2Student();
		entity.setId(rs.getInt("id"));
		entity.setCourseId(rs.getInt("course_id"));
		entity.setStudentId(rs.getInt("student_id"));
		entity.setGrade(rs.getInt("grade"));
		return entity;
	}

	@Override
	public List<Course2Student> find(TableStateDto tableStateDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}