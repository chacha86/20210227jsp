package board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO, VO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	
	private int id; 
	private String title;
	private String body;  
	private String regDate;
	private int mid;
	private String nickname;
	private int hit;
	private int likeCnt; // 좋아요 갯수
	
	
}
