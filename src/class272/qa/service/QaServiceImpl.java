package class272.qa.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import class272.qa.dao.IQaDao;
import class272.qa.dao.QaDaoImpl;
import class272.vo.BoardQaVO;
import class272.vo.ComentVO;



public class QaServiceImpl implements IQaService{

	private IQaDao dao;
	private static IQaService service;
	private QaServiceImpl() {
		dao =  QaDaoImpl.getInstance();
	}
	public static IQaService getInstance() {
		if(service==null) service = new QaServiceImpl();
		return service;
	}
	

	@Override
	public int countList() {
		
		int countList = 0;
		try {
			countList = dao.countList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countList;	
	}
	
	@Override
	public List<BoardQaVO> boardList(Map<String, Object> map) {
		
		List<BoardQaVO> list = null;
		try {
			list = dao.boardList(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int insertQa(BoardQaVO vo) {

		int cnt = 0;
		try {
			cnt = dao.insertQa(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public BoardQaVO selectQa(String qaNo) {

		BoardQaVO board = null;
		try {
			board  = dao.selectQa(qaNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public List<ComentVO> selectComent(String qaNo) {

		List<ComentVO> list = null;
		try {
			list = dao.selectComent(qaNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int deleteQa(String qaNo) {

		return dao.deleteQa(qaNo);
	}

	@Override
	public int updateQa(BoardQaVO vo) {
		
		return dao.updateQa(vo);
	}
	
	@Override
	public List<BoardQaVO> searchQa(Map<String, Object> map) {
		
		List<BoardQaVO> list = null;
		try {
			list = dao.searchQa(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int searchCountList(String searchName) {
		
		int countList = 0;
		try {
			countList = dao.searchCountList(searchName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countList;	
		
	}
	
	
	
	
	
	
	
	
	

	
	

	
}
	
	
	
	