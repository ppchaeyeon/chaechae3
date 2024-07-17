package class272.member.service;

import java.util.Map;

import class272.member.dao.ILogDao;
import class272.member.dao.LogDaoImpl;
import class272.member.dao.MemberDaoImpl;
import class272.vo.MemberVO;
import sun.security.jca.GetInstance;

public class LogServiceImpl implements ILogService {

	private static ILogService service;
	private ILogDao dao;
	
	private LogServiceImpl() {
		dao = LogDaoImpl.getInstance();
	}
	
	public static ILogService getInstance() {
		
		if(service==null) service = new LogServiceImpl();
		return service;
		
	}
	// 회원가입
	@Override
	public String loginCheck(Map<String, Object> map) {
		return null;
	}
	// 회원가입 - 아이디 중복체크
	@Override
	public boolean checkMember(String memId) {
		return dao.checkMember(memId);
	}

	// 로그인
	@Override
	public MemberVO getMember(String memId) {
		return dao.getMember(memId);
	}


	
	// 아이디찾기
	@Override
	public MemberVO SearchId(MemberVO meminfo) {
		return dao.SerachId(meminfo);
	}
	
	
	// 비밀번호 찾기
	@Override
	public MemberVO SearchPw(MemberVO meminfo) {
		return dao.SearchPw(meminfo);
	}
	
	
	


}
