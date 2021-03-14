package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/article")
public class TestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();

		// 공통 코드 처리//
		System.out.println("공통코드 처리");
		ArticleDao adao = new ArticleDao();
		
		try {
			
			String action = req.getParameter("action");
			
			if(action != null) {
				if(action.equals("list")) {
					ArrayList<Article> articles = adao.ArticleList();
				
					// list1.jsp
					//1. 데이터 담기
					req.setAttribute("list", articles);
					
					//ArrayList<Article> list = (ArrayList<Article>)request.getAttribute("list");
					
					//2. 요청데이터 넘기기
					forward(req, res, "list5.jsp");
					
				} else if(action.equals("insert")) {
					
					String title = req.getParameter("title");
					String body = req.getParameter("body");
					String mid = req.getParameter("mid");
					
					adao.addArticle(title, body, mid);
					
					// 리다이렉팅
					res.sendRedirect("article?action=list");
					
				} else if(action.equals("update")) {
					String id = req.getParameter("id");
					String title = req.getParameter("title");
					String body = req.getParameter("body");
					
					adao.updateArticle(title, body, id);
					
					res.sendRedirect("article?action=list");
					
				} else if(action.equals("updateForm")) {
					String id = req.getParameter("id");
					Article article = adao.getArticleById(id);
					
					req.setAttribute("article", article);
					
					forward(req, res, "updateForm.jsp");
					
				} else if(action.equals("delete")) {
					String id = req.getParameter("id");
					// adao.deleteArticle(id);
					
					res.sendRedirect("article?action=list");
					
				} else if(action.equals("detail")) {
					String id = req.getParameter("id");
					
					// 로그인 체크?
					HttpSession session = req.getSession();
					Member loginedMember = (Member)session.getAttribute("loginedMember");
					
					System.out.println(loginedMember);
					
					if(loginedMember == null) {
						forward(req, res, "loginForm.jsp");
						
					} else {
						Article article = adao.getArticleById(id);
						req.setAttribute("article", article);
						forward(req, res, "detail.jsp");
						
					}
				} else if(action.equals("doLogin")) {
					String id = req.getParameter("loginId");
					String pw = req.getParameter("loginPw");
					
					Member member = adao.loginCheck(id, pw);
					if(member == null) {
						// 에러 페이지로
						forward(req, res, "error.jsp");
					} else {
						
						HttpSession session = req.getSession();
						session.setAttribute("loginedMember", member);
						
						res.sendRedirect("article?action=list");						
					}
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	
	private void forward(HttpServletRequest req, HttpServletResponse res, String path) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}