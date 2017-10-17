package board.controller;

import java.lang.ProcessBuilder.Redirect;
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
	
	
	
	
	//전체조회
	@RequestMapping("teatime.storyBoardList")
    public ModelAndView getStoryList() {
	List<StoryBoardDTO> list = service.getStoryBoardList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("allstoryboardlist", list);
		
		mav.setViewName("storyboard/StoryBoardList");
		
		return mav;
    }
	
	
	//게시글 한개 조회
	@RequestMapping("teatime.storyBoardDetail")
	public ModelAndView getBoardDetail(int idx){
		ModelAndView mav = new ModelAndView();
		StoryBoardDTO storyDTO = service.getDetailStoryBoard(idx);
		mav.addObject("detail", storyDTO);
		mav.setViewName("storyboard/StoryBoardDeatail");
		return mav;		
	}
	
	
	//게시글 추가
	@RequestMapping(value="teatime.storyBoardInsert",method=RequestMethod.GET)
	public String moveStoryInsert(){
		
		return "storyboard/StoryBoardWrite";
	}
	
	//게시글 추가 후 게시판 전체조회로
	@RequestMapping(value="teatime.storyBoardInsert",method=RequestMethod.POST)
	public String setStoryInsert(StoryBoardDTO storyDTO){
		
		String url = service.insertStoryBoard(storyDTO);
		
		return "redirect:teatime.storyBoardList";					
	}
	
	
	
	//게시글 수정
	@RequestMapping(value="teatime.storyBoardModify",method=RequestMethod.GET)
	public ModelAndView moveStoryModify(int idx){
		
		ModelAndView mav = new ModelAndView();
		StoryBoardDTO storyDTO = service.getDetailStoryBoard(idx);
		mav.addObject("modify", storyDTO);
		mav.setViewName("storyboard/StoryBoardModify");
		return mav;	
		
		
	
	}
	
	@RequestMapping(value="teatime.storyBoardModify",method=RequestMethod.POST)
	public String setModifyStoryBoard(StoryBoardDTO storyDTO){
		
		System.out.println(storyDTO.getTitle() +":" + storyDTO.getContent());
		
		String url = service.modifyStoryBoard(storyDTO);
		
		return "redirect:teatime.storyBoardList";					
	}
	
	//게시글 삭제
	@RequestMapping("teatime.storyBoardDelet")
	
	public String setDeleteStoryBoard(int idx){
		
		String url = service.deleteStoryBoard(idx);
		
		return "redirect:teatime.storyBoardList";
	}
	
	
}
