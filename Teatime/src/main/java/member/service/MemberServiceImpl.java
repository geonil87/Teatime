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
			//id ��ȸ �� ���н� resultMap �ʱ�ȭ ��, resultMap�� �α��� ��� ���� �� ��ȯ
			resultMap = new HashMap<String,String>();
			resultMap.put("loginFailId", "���̵� �߸��ǰų� �������� �ʽ��ϴ�.");
		}else if(!resultMap.get("userPw").equals(loginInfo.get("user_pw"))){
			resultMap.clear();
			resultMap.put("loginFailPw", "��й�ȣ�� �߸��Ǿ����ϴ�.");
		}
		return resultMap;
	}

}
