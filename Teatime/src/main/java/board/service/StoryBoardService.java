package board.service;

import java.util.List;

import board.dto.StoryBoardDTO;

public interface StoryBoardService {
	
	
	//전체조회
	public List<StoryBoardDTO> getStoryBoardList();

	//게시글 한개 조회
	public StoryBoardDTO getDetailStoryBoard(int idx);
	
	//게시글 추가
	public String insertStoryBoard(StoryBoardDTO storyDTO);
	
	//게시글 수정
	public String modifyStoryBoard(StoryBoardDTO storyDTO);
	
	//게시글 삭제
	public String deleteStoryBoard(int idx);
	

}
