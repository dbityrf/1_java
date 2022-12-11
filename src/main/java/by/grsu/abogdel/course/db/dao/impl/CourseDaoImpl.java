package by.grsu.abogdel.course.db.dao.impl;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.abogdel.course.db.dao.AbstractDao;
import by.grsu.abogdel.course.db.dao.IDao;
import by.grsu.abogdel.course.db.model.Course;
import by.grsu.abogdel.course.web.dto.TableStateDto;
 


public class CourseDaoImpl extends AbstractDao implements IDao<Integer, Course> {
	public static final CourseDaoImpl INSTANCE = new CourseDaoImpl();

	private CourseDaoImpl() {
		super();
	}

	@Override
	public void insert(Course entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into course(name, address, duration, teacher_id, start, created, updated) values(?,?,?,?,?,?,?)");
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getAddress());
			pstmt.setString(3, entity.getDuration());
			pstmt.setInt(4, entity.getTeacherId());
			pstmt.setString(5, entity.getStart());
			pstmt.setTimestamp(6, entity.getCreated());
			pstmt.setTimestamp(7, entity.getUpdated());
			
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "course"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Course entity", e);
		}

	}

	@Override
	public void update(Course entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
			.prepareStatement("update course set name=?, address=?, duration=?, teacher_id=?, start=?, updated=? where id=?");
			pstmt.setString(1, entity.getName());
		    pstmt.setString(2, entity.getAddress());
			pstmt.setString(3, entity.getDuration());
			pstmt.setInt(4, entity.getTeacherId());
			pstmt.setString(5, entity.getStart());
			pstmt.setTimestamp(6, entity.getUpdated());
			
			
			
			
			pstmt.setInt(7, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Course entity", e);
		}

	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from course where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Course entity", e);
		}
	}

	@Override
	public Course getById(Integer id) {
		Course entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from course where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Car entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Course> getAll() {
		List<Course> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from course");
			while (rs.next()) {
				Course entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Course entities", e);
		}

		return entitiesList;
	}

	private Course rowToEntity(ResultSet rs) throws SQLException {
		Course entity = new Course();
		entity.setId(rs.getInt("id"));
		entity.setName (rs.getString("name"));
		entity.setAddress(rs.getString("address"));
		entity.setDuration(rs.getString("duration"));
		entity.setTeacherId(rs.getInt("teacher_id"));
		entity.setStart(rs.getString("start"));
		entity.setCreated(rs.getTimestamp("created"));
		entity.setUpdated(rs.getTimestamp("updated"));
		return entity;
	}

	@Override
	public List<Course> find(TableStateDto tableStateDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}