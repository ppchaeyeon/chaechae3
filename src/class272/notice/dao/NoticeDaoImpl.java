package class272.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.BoardNoticeVO;
import class272.vo.BoardQaVO;

public class NoticeDaoImpl extends MyBatisUtil implements INoticeDao{

	private static INoticeDao dao;
	
	private NoticeDaoImpl() {}
	private SqlSession session;
	public static INoticeDao getInstance() {
		if(dao==null) dao = new NoticeDaoImpl();
		return dao;
	}
	
	@Override
	public int countList() throws SQLException {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
	    try {
	        // MyBatis를 사용하여 데이터베이스 쿼리 수행
	        cnt = session.selectOne("notice.noticeCount");
	    } catch (PersistenceException ex) {
	        // SQLException 또는 MyBatis에서 발생하는 예외 처리
	        ex.printStackTrace();
	    } finally {
	        // 세션 닫기
	        if (session != null) {
	            session.close();
	        }
	    }
	    return cnt;
		
	}

	@Override
	public List<BoardNoticeVO> boardList(Map<String, Object> map) throws SQLException {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		List<BoardNoticeVO> boardList = null;
		
		try {
	        // MyBatis를 사용하여 데이터베이스 쿼리 수행
	        boardList = session.selectList("notice.noticeList", map);
	        System.out.println(boardList);
	        
	    } catch (Exception ex) {
	        // SQLException 또는 MyBatis에서 발생하는 예외 처리
	        ex.printStackTrace();
	        throw new SQLException("게시물 목록 조회 중 오류 발생", ex);
	    } finally {
	        // 세션 닫기
	        if (session != null) {
	            session.close();
	        }
	    }
		
	    return boardList;
		
	}

	@Override
	public BoardNoticeVO selectNotice(String noticeNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		BoardNoticeVO vo = null;
		
		try {
		
			vo = session.selectOne("notice.noticeSelect", noticeNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return vo;
	}
	
	
	
	
}
