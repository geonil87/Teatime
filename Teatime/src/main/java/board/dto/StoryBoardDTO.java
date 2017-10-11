package board.dto;

public class StoryBoardDTO {
	
	int idx;
	String title;
	String content;
	String user_nick;
	String wdate;
	int hit;
	
	
	public StoryBoardDTO(){}
	
	public StoryBoardDTO(int idx, String title, String content, String user_nick, String wdate, int hit) {
		super();
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.user_nick = user_nick;
		this.wdate = wdate;
		this.hit = hit;
	}
	
	
	

}
