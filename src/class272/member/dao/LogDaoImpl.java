package class272.member.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.MemberVO;

public class LogDaoImpl implements ILogDao {

	private static ILogDao dao;
	
	
	
	public static ILogDao getInstance() {
		if(dao == null) {
			dao = new LogDaoImpl();
		}
		return dao;
	}

	

	@Override
	public int SignUpMember(MemberVO mv) {
		return 0;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean isExist = false; // 디폴트 - false, true가 중요하기 때문에
		
		SqlSession session = MyBatisUtil.getSqlSession(true); // 오토커밋 허용

		try {
			int cnt = session.selectOne("log.checkMember", "memId");
			if(cnt>0) {
				isExist = true; // 정보가 존재하면 true
			}
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return isExist;
	}

	@Override
	public MemberVO getMember(String memId) {
		
		SqlSession session = MyBatisUtil.getSqlSession(true); // 오토커밋 허용

		MemberVO mv = new MemberVO();
		
		try {
			mv = session.selectOne("log.logMember", memId);
			System.out.println(mv);
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return mv;
	}



	@Override
	public MemberVO SerachId(MemberVO meminfo) {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		MemberVO mv = new MemberVO();
		
		try {
			
			mv = session.selectOne("log.FindId",meminfo);
			
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return mv;
				
		
	}



	@Override
	public MemberVO SearchPw(MemberVO meminfo) {
		return null;
	}
	
}
