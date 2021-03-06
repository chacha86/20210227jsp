package board;

//DTO 
public class Member {

	private int id;
	private String loginId;
	private String loginPw;
	private String nickname;
	
	public Member() {
		
	}
	
	public Member(int id, String loginId, String loginPw, String nickname) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
	}
	
	// 게터 세터 만드는 법 : alt + s + r -> 다 체크 후 generate
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPw() {
		return loginPw;
	}
	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}

