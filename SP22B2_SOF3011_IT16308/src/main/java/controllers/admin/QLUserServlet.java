package controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.mbeans.MBeanUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.jasper.tagplugins.jstl.core.If;

import beans.form.data.RegisterData;
import dao.UserDAO;
import entities.User;
import utils.EncryptUtil;

@WebServlet({ 
	"/users/index", // GET
		"/users/create", // GET
		"/users/store", // POST
		"/users/edit", // GET
		"/users/update", // POST
		"/users/delete", // GET
})
public class QLUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public QLUserServlet() {
		super();
		this.userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("view", "/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void edit(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User entity = this.userDAO.findById(id);
		System.out.println(id);
		request.setAttribute("user", entity);
		request.setAttribute("view", "/views/admin/users/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User entity = this.userDAO.findById(id);
		try {
			this.userDAO.delete(entity);
			response.sendRedirect("/SP22B2_SOF3011_IT16308" + "/users/index");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void store(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		HttpSession session = request.getSession();
		try {
			User entity = new User();
			BeanUtils.populate(entity,
				request.getParameterMap());
			
			String encrypted = EncryptUtil.encrypt(
				request.getParameter("password")
			);
			
			entity.setPassword(encrypted);
			this.userDAO.create(entity);
			session.setAttribute("message", 
				"Thêm mới thành công");
			response.sendRedirect("/SP22B2_SOF3011_IT16308"
				+ "/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", 
					"Thêm mới thất bại");
			response.sendRedirect("/SP22B2_SOF3011_IT16308"
				+ "/users/create");
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			User entity = new User();
			BeanUtils.populate(entity, request.getParameterMap());
			
			User oldUser=this.userDAO.findById(entity.getId());
			entity.setPassword(oldUser.getPassword());
			
			this.userDAO.update(entity);
			session.setAttribute("message", "Sửa thành công");
			
			response.sendRedirect("/SP22B2_SOF3011_IT16308" + "/users/index");
			System.out.println("Thanh cong");
			
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Sửa thất bại");
			
			String id = request.getParameter("id");
			response.sendRedirect("/SP22B2_SOF3011_IT16308/users/edit?id=" +id);
			
		}

	}

}
