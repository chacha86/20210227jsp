package board;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ArticleDao2 {
	SqlSessionFactory sqlSessionFactory = null;
	
	public ArticleDao2() throws IOException {
		String resource = "board/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public ArrayList<Article> getAllArticles() {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		ArrayList<Article> articles = mapper.selectArticles();
		
		return articles;
		
	}
	
	public Reply getReplyById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		Reply reply = mapper.getReplyById(id);
		
		return reply;
	}
	
	public void updateReplyById(Reply reply) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		mapper.updateReplyById(reply);
		
		session.commit();
		
	}
	
	public void addArticle(String title, String body, int mid) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		// map 이용 방식
//		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("title", title);
//		param.put("body", body);
//		param.put("mid", 1);
//		mapper.addArticle1(param);
		
		// DTO(VO) 객체 이용
		Article param = new Article();
		
		param.setTitle(title);
		param.setBody(body);
		param.setMid(mid);
		
		mapper.addArticle2(param);		
		
		session.commit();
	}

	public ArrayList<Article> searchArticles(String dateInterval, String sTarget, String keyword) {
		
		SqlSession session = sqlSessionFactory.openSession();
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		HashMap<String, Object> param = new HashMap<>();
		
		param.put("dateInterval", dateInterval);
		param.put("sTarget", sTarget);
		param.put("keyword", keyword);
		ArrayList<Article> list = mapper.searchArticles(param);
		
		System.out.println(list.size());
		return mapper.searchArticles(param);
	}
	
	public ArrayList<DateIntervalCode> getDateIntervalCodes() {
		ArrayList<DateIntervalCode> dateIntervalCodes = new ArrayList<>();
		
		dateIntervalCodes.add(new DateIntervalCode("all", "전체기간"));
		dateIntervalCodes.add(new DateIntervalCode("-1 day", "1일"));
		dateIntervalCodes.add(new DateIntervalCode("-1 week", "1주"));
		dateIntervalCodes.add(new DateIntervalCode("-1 month", "1개월"));
		dateIntervalCodes.add(new DateIntervalCode("-6 month", "6개월"));
		dateIntervalCodes.add(new DateIntervalCode("-1 year", "1년"));
		
		return dateIntervalCodes;
	}
	
	public ArrayList<SearchTypeCode> getSearchTypeCodes() {
		ArrayList<SearchTypeCode> searchTypeCodes = new ArrayList<>();
			
		searchTypeCodes.add(new SearchTypeCode("titleAndBody", "제목+내용"));
		searchTypeCodes.add(new SearchTypeCode("title", "제목"));       
		searchTypeCodes.add(new SearchTypeCode("body", "내용"));        
		searchTypeCodes.add(new SearchTypeCode("rbody", "댓글내용"));     
		searchTypeCodes.add(new SearchTypeCode("rnickname", "댓글작성자"));
		
		return searchTypeCodes;
		
	}
}

