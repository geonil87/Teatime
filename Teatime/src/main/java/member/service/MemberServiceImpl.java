package member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.dao.MemberDAO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;

	public Map<String,String> checkLogin(Map<String,String> loginInfo) {
		Map<String, String> resultMap = dao.checkLogin(loginInfo);
		if(resultMap==null){
			//id 조회 후 실패시 resultMap 초기화 후, resultMap에 로그인 결과 저장 후 반환
			resultMap = new HashMap<String,String>();
			resultMap.put("loginFailId", "아이디가 잘못되거나 존재하지 않습니다.");
		}else if(!resultMap.get("userPw").equals(loginInfo.get("user_pw"))){
			resultMap.clear();
			resultMap.put("loginFailPw", "비밀번호가 잘못되었습니다.");
		}
		return resultMap;
	}

}
