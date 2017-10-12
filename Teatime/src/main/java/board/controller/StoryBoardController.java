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
	
	@RequestMapping("teatime.storyboardlist")
    public ModelAndView getBoardList() {
	List<StoryBoardDTO> list = service.getStoryBoardList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("allstoryboardlist", list);
		
		mav.setViewName("storyboard/StoryBoardList");
		
		return mav;
    }
	
	
}
