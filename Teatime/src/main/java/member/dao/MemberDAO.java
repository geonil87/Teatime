package member.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession session;
	
	public Map<String,String> checkLogin(Map<String,String> loginInfo){
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap = session.selectOne("login.checkLoginInfo", loginInfo.get("user_id"));	
		return resultMap;
	}
}
