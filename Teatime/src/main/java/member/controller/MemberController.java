package member.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import member.service.MemberServiceImpl;

@Controller
public class MemberController {
	
	@Autowired
	MemberServiceImpl service;
	
	// 로그인 폼 호출 메소드
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String moveLoginForm(){
		return "member/loginForm";
	}
	
	// TODO 로그인 폼에서 로그인 정보 전달 메소드
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView getLoginInfo(String userId, String userPw, HttpSession session){
		ModelAndView mav = new ModelAndView();
		String path="";
		Map<String,String> loginInfo = new HashMap<String,String>();
		loginInfo.put("user_id", userId);
		loginInfo.put("user_pw", userPw);
		
		Map<String,String> result = service.checkLogin(loginInfo);
		
		if(result.containsKey("loginFailId")==true){
			mav.addObject("loginResult", result.get("loginFailId"));
			path = "redirect:login";
		}else if(result.containsKey("loginFailPw")==true){
			mav.addObject("loginResult", result.get("loginFailPw"));
			path = "redirect:login";
		}else{
			session.setAttribute("sessionId", result.get("userId"));
			session.setAttribute("sessionNick", result.get("userNick"));
			path = "member/loginResult";
		}
		System.out.println(path);
		mav.setViewName(path);
		return mav;
	}
	
	//TODO 로그아웃 부분..Interceptor 구현시 다시한번 볼것
	@RequestMapping(value="logout")
	public String setLogout(HttpSession session){
		session.removeAttribute("sessionId");
		session.removeAttribute("sessionNick");
		return "redirect:home";
	}
	
	@RequestMapping("home")
	public void movehome(){
	}
	
}
