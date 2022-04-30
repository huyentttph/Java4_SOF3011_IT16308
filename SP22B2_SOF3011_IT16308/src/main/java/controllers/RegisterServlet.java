package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import beans.form.data.RegisterData;
import dao.UserDAO;
import entities.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public RegisterServlet() {
		super();
		this.userDAO= new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("view", "/views/register.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);

	}

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// getParameter:Lấy dữ liệu của 1 tham số
		// BeanUtils_thư viện
		// request.getParameterMap() Toàn bộ dữ liệu đem về Map key_value
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());//Bóc hết từ cho vào entity
			this.userDAO.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		System.out.println(bean.getHo_ten());
//		System.out.println(bean.getDia_chi());
//		System.out.println(bean.getEmail());
//		System.out.println(bean.getPassword());
//		System.out.println(bean.getSdt());
//		System.out.println(bean.getGioi_tinh());
//		System.out.println(bean.getLoaiKH());

//		String email = request.getParameter("email"),
//				password = request.getParameter("password"),
//				ho_ten = request.getParameter("ho_ten"),
//				dia_chi = request.getParameter("dia_chi"),
//				sdt = request.getParameter("sdt"),
//				gioi_tinh = request.getParameter("gioi_tinh"),
//				loaiKH = request.getParameter("loaiKH");
		// Lấy ra tất cả các giá trị request.getParameterValues

	}

}
