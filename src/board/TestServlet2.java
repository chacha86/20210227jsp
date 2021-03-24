package board;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// http://�ּ�:��Ʈ/�����̸�?�ѱ�����������(login=hong123)
		response.setContentType("text/html; charset=utf-8");
		// PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");

		// ���� �ڵ� ó��//
		System.out.println("데이터처리");

		HttpSession login = null;
		String action = request.getParameter("action");
		ArticleDao adao = new ArticleDao();
		ArticleDao2 adao2 = new ArticleDao2();
		System.out.println("action : " + action);
		if (action != null) {
			// ---------------�α���-------------------
			if (action.equals("login")) {
				login = request.getSession();
				String login_id = request.getParameter("id");
				String login_pw = request.getParameter("pw");
				
				System.out.println("로그인성공");
				Member member = new Member(1, "user1", "pass1", "홍길동");
				login.setAttribute("logined_member", member);
				response.sendRedirect("TestServlet2?action=list");						
			
				//session.invalidate()<<---���� ���� �α׾ƿ���ɿ� ���
			}
			// -----------------------------------
			else if(action.equals("logout")) {
				if(login!=null)
					login.invalidate();
				response.sendRedirect("start_page.jsp");
			}
			
			else if (action.equals("list")) {
				//ArrayList<Article> articles = adao.ArticleList();
				ArrayList<Article> articles = adao2.getAllArticles();
				
				request.setAttribute("list", articles);

				RequestDispatcher rd = request.getRequestDispatcher("list7.jsp");
				rd.forward(request, response);

			} 				
			else if (action.equals("insert")) {
				String title = request.getParameter("title");
				String body = request.getParameter("body");
				String mid_input = request.getParameter("mid");
				System.out.println(mid_input);
				int mid = Integer.parseInt(mid_input);

				//adao.addArticle(title, body, mid);
				adao2.addArticle(title, body, mid);

				response.sendRedirect("TestServlet2?action=list");
			} 		
			
		} else {
			response.sendRedirect("start_page.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
