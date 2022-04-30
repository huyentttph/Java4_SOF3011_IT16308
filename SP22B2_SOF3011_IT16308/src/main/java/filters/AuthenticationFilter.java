package filters;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;
@WebFilter(
		urlPatterns = "/users/*",
		filterName="authen_filter"
		//   /*  :  10:03 video buoi 13
		
		)
//@WebFilter dinh nghia duong dan ma se su dung filter nay
public class AuthenticationFilter extends HttpFilter implements Filter {//Xac nhan xem day la nguoi dung nao
	//implements thuc thi filter interface
    public AuthenticationFilter() {
       
    }

	public void destroy() {//khi xoa doi tuong filter này đi
	}
	
	//cho de kiem tra
	public void doFilter(ServletRequest request,//req nhận yêu cầu
			ServletResponse response,//phản hồi 
			FilterChain chain //địa diện cho cái filter thứ 3
	) throws IOException, ServletException {

		//Check
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
	HttpSession session=httpRequest.getSession();
	User user =(User) session.getAttribute("user");
	
	if (user == null) {
		httpResponse.sendRedirect("/SP22B2_SOF3011_IT16308" + "/login");
		return;
	}
		
		chain.doFilter(request, response);//Đẩy req sang thành phần tiếp theo trong điều kiện được thỏa mãn
	}

	public void init(FilterConfig fConfig
	) throws ServletException {
		
		//
		
		
	}

}
