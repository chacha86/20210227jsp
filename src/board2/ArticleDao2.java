package board2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ArticleDao2 {
	SqlSessionFactory sqlSessionFactory;
	public void init() throws IOException {
		String resource = "board2/Mybatis_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	public ArrayList<Article> getAllArticles(){
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		ArrayList<Article> articles = mapper.selectArticles();
		
		return articles;
	}
	
	public void addArticle(String title, String body, int mid) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		//map이용 방식
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("title",title);
		param.put("body",body);
		param.put("mid",mid);
		
		mapper.addArticle1(param);
		
		//DTO(VO)객체 이용
//		Article param = new Article();
//		
//		param.setTitle(title);
//		param.setBody(body);
//		param.setMid(mid);
//		mapper.addArticle2(param);
		
		session.commit();
	}
	
	public void DeleteArticle(int id) throws ClassNotFoundException, SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		mapper.deleteArticle(id);
		session.commit();
	}
	
}
