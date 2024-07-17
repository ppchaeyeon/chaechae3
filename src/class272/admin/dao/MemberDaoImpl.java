package class272.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	private static IMemberDao memDao;
	
	private MemberDaoImpl() {
	}
	
	public static IMemberDao getInstance() {
		if(memDao == null) {
			memDao = new MemberDaoImpl();
		}
		return memDao;
	}

	@Override
	public int changeStateMember(String memId, int memState) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemState(memState);
		
		int cnt = 0;
		try {
			cnt = session.update("member.changeStateMember", mv);
			
			if(cnt > 0) {
				session.commit();
			}
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	
	@Override
	public MemberVO getMember(String memId) {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		MemberVO mv = new MemberVO();
		
		try {
			mv = session.selectOne("member.getMember", memId);
			
		}catch(PersistenceException ex){
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return mv;
	}
	
	
	@Override
	public List<MemberVO> getAllMember() {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			memList = session.selectList("member.getAllMember");
//			System.out.println(memList);
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return memList;
	}

	@Override
	public List<MemberVO> getAllBlackMember() {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			memList = session.selectList("member.getAllBlackMember");
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return memList;
	}

}