package class272.admin.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import class272.util.MyBatisUtil;
import class272.vo.BoardNoticeVO;

public class AdminNoticeDaoImpl implements IAdminNoticeDao  {
	
	private static IAdminNoticeDao adminNoDao;
	
	private AdminNoticeDaoImpl() {
	}
	
	public static IAdminNoticeDao getInstance() {
		if(adminNoDao == null) {
			adminNoDao = new AdminNoticeDaoImpl();
		}
		return adminNoDao;
	}

	@Override
	public List<BoardNoticeVO> getAllNotice() {

		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		List<BoardNoticeVO> adminNoList = new ArrayList<BoardNoticeVO>();
		
		try {
			adminNoList = session.selectList("adminnotice.getAllNotice");
			
		}catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return adminNoList;
	}

	@Override
	public int addNotice(BoardNoticeVO nv) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("adminnotice.addNotice", nv);
			
			if(cnt > 0) {
				session.commit();
			}
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int changeDelNotice(String noticeNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.update("adminnotice.changeDelNotice", noticeNo);
			
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
	public int updateNotice(BoardNoticeVO nv) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.update("adminnotice.updateNotice", nv);
			
			if(cnt > 0) {
				session.commit();
			}
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}
}