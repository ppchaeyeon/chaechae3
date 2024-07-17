package class272.library.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.LibraryVO;

public class LibraryDaoImpl implements ILibraryDao{
	
	private static ILibraryDao libDao;
	
	public LibraryDaoImpl() {
	}
	
	public static ILibraryDao getInstance() {
		if(libDao == null) {
			libDao = new LibraryDaoImpl();
		}
		return libDao;
	}

	@Override
	public int addLibrary(LibraryVO lv) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("library.addLibrary", lv);
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
	public int refundLibrary(String libNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.update("library.refundLibrary", libNo);
			
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
	public List<LibraryVO> getMyLibrary(String memId) {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);

		List<LibraryVO> libList = new ArrayList<LibraryVO>();

		try {
			libList = session.selectList("library.getMyLibrary", memId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return libList;
	}

	@Override
	public List<LibraryVO> getAllRefund() {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);

		List<LibraryVO> refList = new ArrayList<LibraryVO>();

		try {
			refList = session.selectList("library.getAllRefund");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return refList;
	}
}