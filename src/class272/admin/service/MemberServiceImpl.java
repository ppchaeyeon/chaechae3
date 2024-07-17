package class272.admin.service;

import java.util.List;

import class272.admin.dao.IMemberDao;
import class272.admin.dao.MemberDaoImpl;
import class272.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{

	private static IMemberService memService;
	
	private IMemberDao memDao;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(memService == null) {
			memService = new MemberServiceImpl();
		}
		return memService;
	}

	@Override
	public List<MemberVO> getAllMember() {
		return memDao.getAllMember();
	}

	@Override
	public List<MemberVO> getAllBlackMember() {
		return memDao.getAllBlackMember();
	}
	
	@Override
	public MemberVO getMember(String memId) {
		return memDao.getMember(memId);
	}

	@Override
	public int unblackMember(String memId) {
		int cnt = memDao.changeStateMember(memId, 1);
		return cnt;
	}

	@Override
	public int OutMember(String memId) {
		int cnt = memDao.changeStateMember(memId, 2);
		return cnt;
	}
	
	@Override
	public int blackMember(String memId) {
		int cnt = memDao.changeStateMember(memId, 3);
		return cnt;
	}
}