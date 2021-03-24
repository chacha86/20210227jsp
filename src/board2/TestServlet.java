package board2;

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

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
//	HttpSession login = null;

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// http://�ּ�:��Ʈ/�����̸�?�ѱ�����������(login=hong123)
		response.setContentType("text/html; charset=utf-8");
		// PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");

		// ���� �ڵ� ó��//
		System.out.println("데이터처리");

		try {
			String action = request.getParameter("action");
			ArticleDao adao = new ArticleDao();
			ArticleDao2 adao2 = new ArticleDao2();
			adao2.init();

			if (action != null) {
				// ---------------�α���-------------------
				if (action.equals("login")) {
					HttpSession login = request.getSession();
					String login_id = request.getParameter("id");
					String login_pw = request.getParameter("pw");

					if (adao.Login(login_id, login_pw) == 0) {
						System.out.println("로그인실패");
						response.sendRedirect("test/start_page.jsp");
					} else {
						System.out.println("로그인성공");
						Member member = adao.GetLoginedName(adao.Login(login_id, login_pw));
						System.out.println(member);
						login.setAttribute("logined_member", member);
						response.sendRedirect("TestServlet?action=list");
					}
					// session.invalidate()<<---���� ���� �α׾ƿ���ɿ� ���
				}
				// -----------------------------------
				else if (action.equals("logout")) {
					//login.invalidate();
					response.sendRedirect("test/start_page.jsp");
				}

				else if (action.equals("list")) {
					// ArrayList<Article> articles = adao.ArticleList();
					ArrayList<Article> articles = adao2.getAllArticles();

					request.setAttribute("list", articles);

					RequestDispatcher rd = request.getRequestDispatcher("test/ex4.jsp");
					rd.forward(request, response);

				} else if (action.equals("read_article")) {
					String input_aid = request.getParameter("aid");
					int aid = Integer.parseInt(input_aid);

					ArrayList<Reply> replies = adao.GetReply(aid);

					request.setAttribute("replies", replies);
					RequestDispatcher rd = request.getRequestDispatcher("test/read.jsp");
					rd.forward(request, response);
				} else if (action.equals("regReply")) {

					String input_aid = request.getParameter("aid");
					String input_mid = request.getParameter("mid");
					int aid = Integer.parseInt(input_aid);
					int mid = Integer.parseInt(input_mid);
					String body = request.getParameter("body");

					adao.regReply(aid, mid, body);

					response.sendRedirect("TestServlet?action=read_article&aid=" + aid);
				}

				else if (action.equals("insert")) {
					HttpSession ss = request.getSession();

					Member m = (Member) ss.getAttribute("logined_member");

					System.out.println(m);
					String title = request.getParameter("title");
					String body = request.getParameter("body");
					String mid_input = request.getParameter("mid");
					System.out.println(mid_input);
					int mid = Integer.parseInt(mid_input);

					// adao.addArticle(title, body, mid);
					adao2.addArticle(title, body, mid);

					response.sendRedirect("TestServlet?action=list");
				} else if (action.equals("delete")) {
					String id_input = request.getParameter("id");
					int id = Integer.parseInt(id_input);

					adao2.DeleteArticle(id);

					response.sendRedirect("TestServlet?action=list");
				} else if (action.equals("update")) {
					String id = request.getParameter("id");
					String title = request.getParameter("title");
					String body = request.getParameter("body");

					adao.UpdateArticle(id, title, body);

					response.sendRedirect("TestServlet?action=list");
				} else if (action.equals("update_article")) {
					String id_input = request.getParameter("id");
					int id = Integer.parseInt(id_input);
					Article article = adao.getArticleById(id);

					request.setAttribute("article", article);

					RequestDispatcher rd = request.getRequestDispatcher("test/update_article.jsp");
					rd.forward(request, response);
				} else if (action.equals("join")) {
					String JoinId = request.getParameter("JoinId");
					String JoinPw = request.getParameter("JoinPw");
					String JoinNickname = request.getParameter("JoinNickname");

					adao.Join(JoinId, JoinPw, JoinNickname);

					response.sendRedirect("test/start_page.jsp");
				}

			} else {
				response.sendRedirect("test/start_page.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
