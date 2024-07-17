package class272.admin.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import class272.util.MyBatisUtil;
import class272.vo.BoardFreeVO;

public class AdminFreeDaoImpl implements IAdminFreeDao {
	
	private static IAdminFreeDao admFreeDao;
	
	private AdminFreeDaoImpl() {
	}
	
	public static IAdminFreeDao getInstance() {
		if(admFreeDao == null) {
			admFreeDao = new AdminFreeDaoImpl();
		}
		return admFreeDao;
	}

	@Override
	public List<BoardFreeVO> getAllReport() {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		List<BoardFreeVO> admFreeList = new ArrayList<BoardFreeVO>();
		
		try {
			admFreeList = session.selectList("adminfree.getAllReport");
			
		}catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		return admFreeList;
	}

	@Override
	public int changeStateDel(String freeNo, String FreeDel) {
		SqlSession session = MyBatisUtil.getSqlSession();
		BoardFreeVO fv = new BoardFreeVO();
		fv.setFreeNo(freeNo);
		fv.setFreeDel(FreeDel);
		
		int cnt = 0;
		try {
			cnt = session.update("adminfree.changeStateDel", fv);
			
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
	
	
}