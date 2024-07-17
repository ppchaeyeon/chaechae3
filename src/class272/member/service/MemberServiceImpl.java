package class272.member.service;

import class272.member.dao.ILogDao;
import class272.member.dao.IMemberDao;
import class272.member.dao.LogDaoImpl;
import class272.member.dao.MemberDaoImpl;
import class272.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	private static IMemberService service;
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		
		if(service==null) service = new MemberServiceImpl();
		return service;
		
	}

	@Override
	public MemberVO SelectMember(String memId) {
		return dao.SelectMember(memId);
	}

	@Override
	public int DeleteMember(String memId) {
		return dao.DeleteMember(memId);
	}

}
