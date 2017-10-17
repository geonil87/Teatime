package member.service;

import java.util.Map;

public interface MemberService {
	
	public Map<String,String> checkLogin(Map<String,String> loginInfo);
	
}
