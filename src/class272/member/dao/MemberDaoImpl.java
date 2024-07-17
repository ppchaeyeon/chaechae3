package class272.member.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private static IMemberDao dao;
	
	public static IMemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}

	
	// 마이페이지 조회
	@Override
	public MemberVO SelectMember(String memId) {
		
		SqlSession session = MyBatisUtil.getSqlSession(true); // 오토커밋 허용
		
		MemberVO mv = new MemberVO();
		
		try {
			mv = session.selectOne("member2.selectMember", memId);
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return mv;
	}

	// 회원 탈퇴
	@Override
	public int DeleteMember(String memId) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			
			cnt = session.delete("member2.deleteMember", memId);
			
			if(cnt > 0) {
				session.commit();
			}
			
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}
	
}
