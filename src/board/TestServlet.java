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
		
		req.setCharacterEncoding("utf-8");
		
		// 공통 코드 처리//
		System.out.println("공통코드 처리");
		ArticleDao adao = new ArticleDao();
		ArticleDao2 adao2 = new ArticleDao2();
		
		try {
			
			String action = req.getParameter("action");
			
			if(action != null) {
				if(action.equals("list")) {
					
					ArrayList<DateIntervalCode> dateIntervalCodes = adao2.getDateIntervalCodes();
					ArrayList<SearchTypeCode> sTargetCodes = adao2.getSearchTypeCodes();				
					
					ArrayList<Article> articles = adao2.getAllArticles();
				
					// list1.jsp
					//1. 데이터 담기
					req.setAttribute("list", articles);
					req.setAttribute("dateIntervalCodes", dateIntervalCodes);
					req.setAttribute("sTargetCodes", sTargetCodes);
					
					//ArrayList<Article> list = (ArrayList<Article>)request.getAttribute("list");
					
					//2. 요청데이터 넘기기
					forward(req, res, "list5.jsp");
					
				} else if(action.equals("insert")) {
					String title = req.getParameter("title");
					String body = req.getParameter("body");
					int mid = Integer.parseInt(req.getParameter("mid"));
					
					System.out.println(mid);
					
					adao2.addArticle(title, body, mid);
					
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
					String id = req.getParameter("id"); // 게시물 아이디
					
					// 로그인 체크?
					HttpSession session = req.getSession();
					Member loginedMember = (Member)session.getAttribute("loginedMember");
					
					
					
					if(loginedMember == null) {
						forward(req, res, "loginForm.jsp");
						
					} else {
						Article article = adao.getArticleById(id);
						ArrayList<Reply> replies = adao.getReplies(id);
						
						String flag = req.getParameter("flag");
						String rid = req.getParameter("rid");
						
						if(flag != null) {
							req.setAttribute("flag", flag);
						}
						req.setAttribute("rid", rid);
						req.setAttribute("article", article);
						req.setAttribute("replies", replies);
						System.out.println(replies.size());
						
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
				} else if(action.equals("test")) {
					HttpSession session = req.getSession();
					Member member = new Member(1, "user1", "pass1", "홍길동");
					
					session.setAttribute("loginedMember", member);
					res.sendRedirect("article?action=list");
				} else if(action.equals("insertReply")) {
					
					String aid = req.getParameter("aid");
					String rbody = req.getParameter("rbody");
					String mid = req.getParameter("mid");
					
					adao.insertReply(aid, rbody, mid);
					
					res.sendRedirect("article?action=detail&id=" + aid);
				} else if(action.equals("updateReply")) {
					int id = Integer.parseInt(req.getParameter("id")); // 댓글 번호
					int aid = Integer.parseInt(req.getParameter("aid")); // 댓글 번호
					String body = req.getParameter("rbody");
					
					Reply reply = new Reply();
					reply.setId(id);
					reply.setBody(body);
					
					adao2.updateReplyById(reply);

					res.sendRedirect("article?action=detail&id=" + aid);
				} else if(action.equals("doSearch")) {
					
					String dateInterval = req.getParameter("dateInterval");
					String sTarget = req.getParameter("sTarget");
					String keyword = req.getParameter("keyword");

					ArrayList<Article> searchedArticles = adao2.searchArticles(dateInterval, sTarget, keyword);
					
					req.setAttribute("dateInterval", dateInterval);
					req.setAttribute("sTarget", sTarget);
					req.setAttribute("keyword", keyword);
					
					req.setAttribute("list", searchedArticles);
					
					
					
					forward(req, res, "list5.jsp");
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
