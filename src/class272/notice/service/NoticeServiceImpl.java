package class272.notice.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import class272.notice.dao.INoticeDao;
import class272.notice.dao.NoticeDaoImpl;
import class272.vo.BoardNoticeVO;
import class272.vo.BoardQaVO;

public class NoticeServiceImpl implements INoticeService{

	private INoticeDao dao;
	private static INoticeService service;
	private NoticeServiceImpl() {
		dao =  NoticeDaoImpl.getInstance();
	}
	public static INoticeService getInstance() {
		if(service==null) service = new NoticeServiceImpl();
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
	public List<BoardNoticeVO> boardList(Map<String, Object> map) {
		
		List<BoardNoticeVO> list = null;
		try {
			list = dao.boardList(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public BoardNoticeVO selectNotice(String noticeNo) {
		
		BoardNoticeVO board = null;
		
		try {
			board  = dao.selectNotice(noticeNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
	
	
}
