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
	

	
}
