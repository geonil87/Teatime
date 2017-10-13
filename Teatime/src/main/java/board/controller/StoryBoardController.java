package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.dto.StoryBoardDTO;
import board.service.StoryBoardServiceImpl;

@Controller
public class StoryBoardController {
	
	@Autowired
	StoryBoardServiceImpl service;
	
	@RequestMapping("teatime.storyBoardList")
    public ModelAndView getStoryList() {
	List<StoryBoardDTO> list = service.getStoryBoardList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("allstoryboardlist", list);
		
		mav.setViewName("storyboard/StoryBoardList");
		
		return mav;
    }
	
	@RequestMapping(value="teatime.storyBoardInsert",method=RequestMethod.GET)
	public String moveStoryInsert(){
		
		return "storyboard/StoryBoardWrite";
	}
	
	@RequestMapping("teatime.storyBoardDetail")
	public ModelAndView getBoardDetail(int idx){
		ModelAndView mav = new ModelAndView();
		StoryBoardDTO storyDTO = service.getDetailStoryBoard(idx);
		mav.addObject("detail", storyDTO);
		mav.setViewName("StoryBoardDeatail");
		return mav;		
	}
	
	
	@RequestMapping(value="teatime.storyBoardInsert",method=RequestMethod.POST)
	public String setStoryInsert(StoryBoardDTO storyDTO){
		
		String url = service.insertStoryBoard(storyDTO);
		
		return url;					
	}
	
	
	
	
}
