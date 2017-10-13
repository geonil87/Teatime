package board.dao;




import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import board.dto.StoryBoardDTO;

@Component
public class StoryBoardDAO {
	
	@Autowired
	SqlSession session;
	
	
	//전체조회
	public List<StoryBoardDTO> getAllStoryBoard(){
		
	List<StoryBoardDTO> list = session.selectList("storyboard.all");
	
	return list;
	
	}
	
	
	//한개조회
	public StoryBoardDTO getDetailStoryBoard(int idx){
		StoryBoardDTO storyDTO = session.selectOne("storyboard.detail", idx);
		return storyDTO;
	}
	
	//글쓰기
	public int insertStoryBoard(StoryBoardDTO storyDTO){
		
	return session.insert("storyboard.insert", storyDTO);
	
	}
	
	


}

