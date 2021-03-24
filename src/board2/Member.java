package board2;

//DTO 
public class Member {

	private int id;
	private String loginId;
	private String loginPw;
	private String nickname;
	private String regDate;
	
	// ���� ���� ����� �� : alt + s + r -> �� üũ �� generate
	
	public String getLoginId() {
		return loginId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginPw() {
		return loginPw;
	}
	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}

