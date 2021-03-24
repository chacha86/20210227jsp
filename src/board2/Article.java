package board2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Article {
	
	private int id; 
	private String title;
	private String body;  
	private String regDate;
	private int mid;
	private int hit;
	private int likeCnt;
	private String Nickname;

	
}
