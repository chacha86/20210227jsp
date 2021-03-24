package board2;

import java.util.ArrayList;
import java.util.Map;

public interface ArticleMapper {
	//1. sql
	//2. 리턴
	//3. 매개변수
	
	
	ArrayList<Article> selectArticles();
	
	//매개변수는 하나로 통일 -> 파라미터 묶어야함. 1. map 2. dto
	public void addArticle1(Map<String, Object> param);
	public void addArticle2(Article param);
	
	//삭제
	public void deleteArticle(int id);
	
}
