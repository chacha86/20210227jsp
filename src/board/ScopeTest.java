package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test")
public class ScopeTest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			return ;
		}
		
		if(action.equals("req")) {			
			// 포워딩 -> 요청을 위임. 이어가는 것.
			request.setAttribute("data1", "hello");
			
		} else if(action.equals("session")) {
			HttpSession session = request.getSession();
			
			String data = request.getParameter("data");
			
			session.setAttribute("data2", data);
			
		} else if(action.equals("app")) {
			ServletContext application = request.getServletContext();
			String data = request.getParameter("data");
			application.setAttribute("data3", data);
		}
		
		else if(action.equals("show")) {
			HttpSession session = request.getSession();
			ServletContext application = request.getServletContext();
			
			PrintWriter out = response.getWriter();
			out.println("request : " + request.getAttribute("data1"));
			out.println("session : " + session.getAttribute("data2"));
			out.println("application: " + application.getAttribute("data3"));
		}
		
	}


}
