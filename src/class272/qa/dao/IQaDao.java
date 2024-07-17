package class272.qa.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import class272.vo.BoardQaVO;
import class272.vo.ComentVO;


public interface IQaDao {
	
	public int countList() throws SQLException;
	
	public List<BoardQaVO> boardList(Map<String, Object> map) throws SQLException;
	
	public int insertQa (BoardQaVO vo) throws SQLException;
	
	public BoardQaVO selectQa (String qaNo) throws SQLException;
	
	public List<ComentVO> selectComent(String qaNo) throws SQLException;
	
	public int deleteQa (String qaNo);

	public int updateQa (BoardQaVO vo);
	
	public List<BoardQaVO> searchQa(Map<String, Object> map) throws SQLException;
	
	public int searchCountList(String searchName) throws SQLException;
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
}
