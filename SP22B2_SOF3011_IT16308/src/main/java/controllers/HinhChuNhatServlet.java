package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/HinhChuNhatServlet")
public class HinhChuNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HinhChuNhatServlet() {
        super();
    }
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response
	) throws ServletException, IOException {

	request.getRequestDispatcher("/views/form-chu-nhat.jsp")
	.forward(request, response);
	}
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
	)throws ServletException, IOException {

	String chieu_dai=request.getParameter("chieu_dai");
	double dai=Double.parseDouble(chieu_dai);
	String chieu_rong=request.getParameter("chieu_rong");
	double rong=Double.parseDouble(chieu_rong);
	 double dien_tich = dai*rong;
	 double chu_vi = (dai+ rong)/2;
	
	request.setAttribute("s", dien_tich);
	request.setAttribute("c", chu_vi);
	
	}

}
