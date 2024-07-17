package class272.admin.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import class272.util.MyBatisUtil;
import class272.vo.BoardFreeVO;
import class272.vo.ComentReportVO;

public class AdminComtDaoImpl implements IAdminComtDao  {

	private static IAdminComtDao admComtDao;
	
	private AdminComtDaoImpl() {
	}
	
	public static IAdminComtDao getInstance() {
		if(admComtDao == null) {
			admComtDao = new AdminComtDaoImpl();
		}
		return admComtDao;
	}
	
	@Override
	public List<ComentReportVO> getAllComt() {

		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		List<ComentReportVO> admComtList = new ArrayList<ComentReportVO>();
		
		try {
			admComtList = session.selectList("admincomt.getAllComt");
//			System.out.println("admComtList >> " + admComtList);
			
		}catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		return admComtList;
	}

	@Override
	public int deletecomt(String crNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.delete("admincomt.deletecomt", crNo);
			
			if(cnt>0) {
				session.commit();
			}
			System.out.println("deletecomtdao>>" + crNo);
		}catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}
	
}