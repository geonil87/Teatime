package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.StoryBoardDAO;
import board.dto.StoryBoardDTO;

@Service
public class StoryBoardServiceImpl implements StoryBoardService{



	@Autowired
	StoryBoardDAO storyBoardDAO;
	
	
	//게시글 전체조회
	public List<StoryBoardDTO> getStoryBoardList() {
		return storyBoardDAO.getAllStoryBoard();
		
	}
	
	
	//게시글 한개 조회
	public StoryBoardDTO getDetailStoryBoard(int idx) {
		return storyBoardDAO.getDetailStoryBoard(idx);
	}
	
	
	//게시글 추가
	public String insertStoryBoard(StoryBoardDTO storyDTO) {
		int result =storyBoardDAO.insertStoryBoard(storyDTO);
		System.out.println(result);
		String url = "";
		if(result == 1){
			url = "storyboard/StoryBoardList";
		}
		else{
			url = "storyboard/StoryBoardWriteFail";
		}
		return url;
	}
		
		//게시글 수정
		public String modifyStoryBoard(StoryBoardDTO storyDTO){
			int result = storyBoardDAO.modifyStoryBoard(storyDTO);
			System.out.println(result);
			String url = "";
			if(result == 1){
				url = "storyboard/StoryBoardList";
			}else{
				url = "storyboard/StoryBoardWriteFail";
			}
			return url;
		}
	
	
	//게시글 삭제
	public String deleteStoryBoard(int idx){
		int result = storyBoardDAO.deleteStoryBoard(idx);
		System.out.println(result);
		String url = "";
		if(result == 1){
			url = "storyboard/StoryBoardDelete";
		}else{
			url = "storyboard/StoryBoardWriteFail";
		}
		return url;
	}


	}
	

