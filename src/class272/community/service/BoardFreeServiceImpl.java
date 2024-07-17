package class272.community.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.community.dao.BoardFreeDaoImpl;
import class272.community.dao.IBoardFreeDao;
import class272.util.MyBatisUtil;
import class272.vo.BoardFreeVO;
import class272.vo.ComentVO;

public class BoardFreeServiceImpl implements IBoardFreeService{

	
	// BoardFree 싱글톤
		private static IBoardFreeService freeService ;
		
		private IBoardFreeDao freeDao;
		
		private BoardFreeServiceImpl() {
			freeDao = BoardFreeDaoImpl.GetInstance();
		}
		
		public static IBoardFreeService getInstance() {
			if(freeService == null) {
				freeService = new BoardFreeServiceImpl();
			}
			return freeService;
		}
		
	@Override
	public int insertFree(BoardFreeVO fv) {
		
		int cnt = 0;
		try {
			cnt = freeDao.insertFree(fv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int countList() {
		int countList = 0;
		try {
			countList = freeDao.countList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countList;
	}
	@Override
	public List<BoardFreeVO> boardList(Map<String, Object> map) {
		List<BoardFreeVO> list = null;
		try {
			list = freeDao.boardList(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public BoardFreeVO detailFree(String freeNo) {
		
		return freeDao.detailFree(freeNo);
	}

	@Override
	public List<ComentVO> freeComent(String freeNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		List<ComentVO> comentList = null;
		
		try {
			comentList = freeDao.freeComent(freeNo);
			System.out.println(comentList);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return comentList;
	}

	@Override
	public int updateFree(BoardFreeVO fv) throws SQLException {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = freeDao.updateFree(fv);
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteFree(String freeNo) {
		return freeDao.deleteFree(freeNo);
	}

	@Override
	public int reportFree(String freeNo) {
		return freeDao.reportFree(freeNo);
	}

	@Override
	public List<BoardFreeVO> searchList(Map<String, Object> map) {
		return freeDao.searchList(map);
	}

	@Override
	public int countSearch(String freeName) {
		return freeDao.countSearch(freeName);
	}

}
