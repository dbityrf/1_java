package by.grsu.abogdel.course.web.servlet;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import by.grsu.abogdel.course.db.dao.IDao;
import by.grsu.abogdel.course.db.dao.impl.CourseDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.Course2StudentDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.PersonDaoImpl;
import by.grsu.abogdel.course.db.dao.impl.RoleDaoImpl;
import by.grsu.abogdel.course.db.model.Role;
import by.grsu.abogdel.course.db.model.Person;
import by.grsu.abogdel.course.db.model.Course;
import by.grsu.abogdel.course.db.model.Course2Student;
import by.grsu.abogdel.course.web.dto.RoleDto;

public class RoleServlet extends HttpServlet {
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
		List<Role> roles = roleDao.getAll(); // get data

		List<RoleDto> dtos = roles.stream().map((entity) -> {
			RoleDto dto = new RoleDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());

			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos);
		req.getRequestDispatcher("role-list.jsp").forward(req, res);
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String roleIdStr = req.getParameter("id");
		RoleDto dto = new RoleDto();
		if (!Strings.isNullOrEmpty(roleIdStr)) {
			Integer roleId = Integer.parseInt(roleIdStr);
			Role entity = roleDao.getById(roleId);
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			
		}
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("role-edit.jsp").forward(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Role role = new Role();
		String roleIdStr = req.getParameter("id");
		role.setName(req.getParameter("name"));
		

	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		roleDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}