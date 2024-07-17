package class272.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import class272.vo.BoardNoticeVO;



public interface INoticeDao {
	
	public int countList() throws SQLException;
	
	public List<BoardNoticeVO> boardList(Map<String, Object> map) throws SQLException;
	
	public BoardNoticeVO selectNotice (String noticeNo) throws SQLException;
	
	
	
	
}
