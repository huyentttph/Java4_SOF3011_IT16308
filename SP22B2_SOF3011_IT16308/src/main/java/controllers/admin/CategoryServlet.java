package controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.UserDAO;
import entities.Category;
import entities.User;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private CategoryDAO categoryDAO;
    public CategoryServlet() {
        super();
        this.userDAO = new UserDAO();
        this.categoryDAO = new CategoryDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		request.getRequestDispatcher(
			"/views/admin/categories/create.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ten = request.getParameter("ten");
		String userIdStr = request.getParameter("user_id");
		int userId = Integer.parseInt(userIdStr);
		User u = this.userDAO.findById(userId);
		
		Category c = new Category();
		c.setTen(ten);
		c.setUser(u);
		try {
			this.categoryDAO.create(c);
			response.sendRedirect("/SP22B2_SOF3011_IT16308" + "/users/index");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/SP22B2_SOF3011_IT16308/categories/create.jsp");
		}
	}

}
