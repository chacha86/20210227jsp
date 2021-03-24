package board2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// DB ���� ���� ó��
public class ArticleDao {

	Connection conn = null;

	// JDBC ���� ����
	// ====================== DB ���� ����============================================
	String url = "jdbc:mysql://127.0.0.1:3306/t1?serverTimezone=UTC"; // ������ DBMS �ּ�
	String id = "root";
	String pw = "";
	// ==============================================================================

	// ===============================���� �õ�======================================
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		if (conn == null) {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysqlDriver �� ã�ƾ��մϴ�.
			conn = DriverManager.getConnection(url, id, pw); // Ư�� DBMS�� ����
		}

		return conn;
		// ==============================================================================
	}

	public void addArticle(String title, String body, int mid) throws SQLException, ClassNotFoundException {

		Statement stmt = getConnection().createStatement();

		String sql = "INSERT INTO article \r\n" + "SET title = '" + title + "',\r\n" + "`body` = '" + body + "',\r\n" + "`mid` = 1,\r\n"
				+ "hit = 0,\r\n" + "regDate = NOW()";
		// ��ȸ ����� �ִ� ��� : select -> executeQuery() - ResultSet���� ����
		// ��ȸ ����� ���� ��� : update, delete, insert -> executeUpdate() - ���� X
		stmt.executeUpdate(sql);

		if (stmt != null) {
			stmt.close();
		}

	}

	public ArrayList<Article> ArticleList() throws SQLException, ClassNotFoundException {

		Statement stmt = getConnection().createStatement();
		String sql = "SELECT a.*,m.nickname\r\n" + 
				"FROM article a\r\n" + 
				"INNER JOIN `member` m\r\n" + 
				"ON a.mid = m.id";
		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<Article> articles = new ArrayList<>();
		
		while (rs.next()) {
			// Ŀ���� �̵����� �� ��� ������ true, false
			
			Article a = new Article();
			
			a.setId(rs.getInt("id"));
			a.setTitle(rs.getString("title"));
			a.setBody(rs.getString("body"));
			a.setMid(rs.getInt("mid"));
			a.setHit(rs.getInt("hit"));
			a.setRegDate(rs.getString("regDate"));
			a.setNickname(rs.getString("nickname"));
			
			articles.add(a);

		}

		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		
		return articles;
	}

	// ȸ������
	public void addMember(String id, String pw, String nick) throws ClassNotFoundException, SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "INSERT INTO `member`\r\n" + 
				"SET loginId = '" + id + "',\r\n" + 
				"loginPw = '" + pw + "',\r\n" + 
				"nickname = '" + nick + "',\r\n" + 
				"regDate = NOW();";
		
		stmt.executeUpdate(sql);
		if (stmt != null) {
			stmt.close();
		}
	}
	
	// �α���
	public Member loginCheck(String id, String pw) throws ClassNotFoundException, SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM `member` WHERE loginId = '" + id + "' AND loginPw = '" + pw + "'";
		
		ResultSet rs = stmt.executeQuery(sql);
		// �ܰ��� if�� next ó��
		Member m = new Member();
		
		if(rs.next()) {	
			//m.loginId = rs.getString("loginId");
			m.setLoginId(rs.getString("loginId"));
			m.setNickname(rs.getString("nickname"));
		}
		
		if (stmt != null) {
			stmt.close();
		}
		
		return m;
	}
	
	// Ư�� �Խù� ��������
	public Article getArticleById(int aid) throws ClassNotFoundException, SQLException {
		
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * \r\n" + "FROM article \r\n" + "WHERE id = " + aid;
		ResultSet rs = stmt.executeQuery(sql);

		Article a = new Article();
		
		if (rs.next()) {
			int targetId = rs.getInt("id");
			String title = rs.getString("title");
			String body = rs.getString("body");
			String regDate = rs.getString("regDate");
			
			a.setId(targetId);
			a.setTitle(title);
			a.setBody(body);
			a.setRegDate(regDate);
			
		}
		
		return a;
	}
	
	public void DeleteArticle(int id) throws ClassNotFoundException, SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "DELETE FROM article\r\n" + 
				"WHERE id="+ id;

		stmt.executeUpdate(sql);

		if (stmt != null) {
			stmt.close();
		}
	}
	
	public void UpdateArticle(String id, String title, String body) throws ClassNotFoundException, SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "UPDATE article\r\n" + 
				"SET title='" + title +"',\r\n" + 
				"`body`='" + body + "'\r\n" + 
				"WHERE id=" + id;

		stmt.executeUpdate(sql);

		if (stmt != null) {
			stmt.close();
		}
	}
	
	public int Login(String id, String pw) throws ClassNotFoundException, SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT id FROM `member`\r\n" + 
				"WHERE loginId='"+ id +"'\r\n" + 
				"AND loginPw='" + pw + "'";

		ResultSet rs = stmt.executeQuery(sql);
		int login_idx = 0;
		
		while (rs.next()) {
			login_idx=rs.getInt("id");
		}

		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		
		return login_idx;
		
	}
	
	public Member GetLoginedName(int num) throws ClassNotFoundException, SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM `member`\r\n" + 
				"WHERE id=" + num;

		ResultSet rs = stmt.executeQuery(sql);
		Member member = new Member();
		
		while (rs.next()) {
			member.setId(rs.getInt("id"));
			member.setLoginId(rs.getString("loginId"));
			member.setLoginPw(rs.getString("loginPw"));
			member.setNickname(rs.getString("nickname"));
			member.setRegDate(rs.getString("regDate"));
		}

		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		
		return member;
	}
	
	public Article read_article(int num) throws SQLException, ClassNotFoundException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT *FROM article where id=" + num;

		ResultSet rs = stmt.executeQuery(sql);
		Article article = new Article();
		
		while (rs.next()) {
			article.setId(rs.getInt("id"));
			article.setTitle(rs.getString("title"));
			article.setBody(rs.getString("body"));
			article.setMid(rs.getInt("mid"));
			article.setHit(rs.getInt("hit"));
			article.setRegDate(rs.getString("regDate"));
		}
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		return article;
	}
	
	public void Join(String JoinId, String JoinPw, String JoinNickname) throws ClassNotFoundException, SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "INSERT INTO `member`\r\n" + 
				"SET loginId='" + JoinId + "',\r\n" + 
				"loginPw='" + JoinPw +"',\r\n" + 
				"nickname='" + JoinNickname +"',\r\n" + 
				"regDate=NOW();";

		stmt.executeUpdate(sql);
		if (stmt != null) {
			stmt.close();
		}		
	}
	
	public ArrayList<Reply> GetReply(int aid) throws ClassNotFoundException, SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT r.*, m.nickname FROM reply r\r\n" + 
				"INNER JOIN `member` m\r\n" + 
				"ON r.mid=m.id\r\n" + 
				"WHERE aid=" + aid;
		
		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<Reply> replies = new ArrayList<>();
		
		while (rs.next()) {
			Reply r = new Reply();
			
			r.setId(rs.getInt("id"));
			r.setAid(rs.getInt("aid"));
			r.setBody(rs.getString("body"));
			r.setMid(rs.getInt("mid"));
			r.setRegDate(rs.getString("regDate"));
			r.setNickname(rs.getString("nickname"));
			
			replies.add(r);
		}

		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		
		return replies;
	}
	
	public void regReply(int aid, int mid, String body) throws ClassNotFoundException, SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "INSERT INTO reply\r\n" + 
				"SET aid=" + aid + ",\r\n" + 
				"`body`='" + body + "',\r\n" + 
				"`mid`=" + mid + ",\r\n" + 
				"regDate=NOW()";

		stmt.executeUpdate(sql);
		if (stmt != null) {
			stmt.close();
		}				
	}
	
	
	
	
	
	
	
	
	
	
	
}

