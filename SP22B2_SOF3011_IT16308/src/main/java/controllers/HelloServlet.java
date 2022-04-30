package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

@WebServlet("/HelloServlet") // Đường dẫn
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Integer> list;

	public HelloServlet() {
		super();

	}

// doPost & doGet la http method
	protected void doGet(HttpServletRequest request, // request thuộc về lớp HttpServletRequest, dựa vào lớp
			// HttpServletRequest sẽ có phương thức đấy lấy dữ liệu toàn bộ
			// dữ liệu thông tin về request
			// request la đối tượng đại diện cho cái yêu cầu được gửi đến và toàn bộ dữ liệu
			// mà ng dùng gửi lên thì sẽ nằm trong đối tượng request đấy
			HttpServletResponse response // response Đại diện cho phản hồi server trả về, những cái muốn phản hồi cho
											// người dùng
	// thì sử dụng response
	) throws ServletException, IOException {
		java.util.Date now = new java.util.Date();

		request.setAttribute("now", now);

// String name = "FPoly";
		// Truyền name sang jsp
		// ví dụ về nhập vào form
		String name = request.getParameter("ho_ten");
		// get:Lấy ---Parameter:Tham số| Mọi dữ liệu ng dùng gửi lên đều nằm trong
		// request
		request.setAttribute("name", name);// Attribute :Thuộc tính
		// Đưa vào trong đối tượng request một cái thuộc tính có tên là name

		// response.getWriter().append("Hello IT16308!");
		request.setAttribute("view", "/views/welcome.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		// Muốn từ servlet sang jsp để hiển thị gia diện-->Sử dụng request gọi hàm get
		// và điều hướng sang file /views/welcome.jsp
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() {
		System.out.println("Init....");
		this.list = new ArrayList<Integer>();

	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Service.....");
		super.service(request, response);
		// todo
		this.list.add(1);
		this.list.add(2);
		this.list.add(3);

		System.out.println(this.list.size());
	}

	public void destroy() {
		System.out.println("Destroy .....");
	}

}
