package board;

import java.util.ArrayList;
import java.util.Map;

public interface ArticleMapper {

	ArrayList<Article> selectArticles();
	
	// 매개변수는 하나로. -> 파라미터 묶어야 함. 1.map, 2. dto
	public void addArticle1(Map<String, Object> param);
	public void addArticle2(Article param);
	public Reply getReplyById(int id);
	public void updateReplyById(Reply reply);
	public ArrayList<Article> searchArticles(Map<String, Object> param);
}
