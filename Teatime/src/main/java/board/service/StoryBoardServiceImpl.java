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
	
	@Override
	public List<StoryBoardDTO> getStoryBoardList() {
		return storyBoardDAO.getAllStoryBoard();
		
	}
	
	public StoryBoardDTO getDetailStoryBoard(int idx) {
		return storyBoardDAO.getDetailStoryBoard(idx);
	}
	
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


	}
	

