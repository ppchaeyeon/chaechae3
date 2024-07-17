package class272.qa.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.BoardFreeVO;
import class272.vo.BoardQaVO;
import class272.vo.ComentVO;

public class QaDaoImpl implements IQaDao{

	private static IQaDao dao;
	
	private QaDaoImpl() {}
	private SqlSession session;
	public static IQaDao getInstance() {
		if(dao==null) dao = new QaDaoImpl();
		return dao;
	}
	
	
	@Override
	public int countList() throws SQLException {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		

	    try {
	        // MyBatis를 사용하여 데이터베이스 쿼리 수행
	        cnt = session.selectOne("qa.qaCount");
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
	public List<BoardQaVO> boardList(Map<String, Object> map) throws SQLException {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		List<BoardQaVO> boardList = null;
		
		try {
	        // MyBatis를 사용하여 데이터베이스 쿼리 수행
	        boardList = session.selectList("qa.qaList", map);
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
	public int insertQa(BoardQaVO vo) {				// QA 게시판 작성
		
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.insert("qa.insertQa", vo);
			
			if(cnt > 0) {
				session.commit();
			}
			
		} catch(PersistenceException ex) {
			session.rollback();
			throw new RuntimeException("데이터 등록작업 중 예외발생!!!", ex);
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return cnt;
	}
	
	@Override
	public BoardQaVO selectQa(String qaNo) {			// 게시글 선택
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		BoardQaVO vo = null;
		
		try {
		
			vo = session.selectOne("qa.qaSelect", qaNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return vo;
	}

	@Override
	public List<ComentVO> selectComent(String qaNo) throws SQLException {

		SqlSession session = MyBatisUtil.getSqlSession();
				
		List<ComentVO> list = null;
				
		try {
					
			list = session.selectList("qa.comentList", qaNo);
					
		}catch(PersistenceException ex) {
			throw new RuntimeException("데이터 목록조회 작업 중 예외발생!!!", ex);
					
		}finally {
			session.close(); // 세션 닫기
		}
				
			return list;
	}
	
	@Override
	public int deleteQa(String qaNo) {				// 문의 게시판 글 삭제
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;		
		
		try {
			
			cnt = session.update("qa.qaDelete", qaNo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}
	
	@Override
	public int updateQa(BoardQaVO vo) {				// 수정
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;		
		
		try {
			
			cnt = session.update("qa.qaUpdate", vo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}


	@Override
	public List<BoardQaVO> searchQa(Map<String, Object> map) throws SQLException {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		List<BoardQaVO> boardList = null;
		
		try {
	        // MyBatis를 사용하여 데이터베이스 쿼리 수행
	        boardList = session.selectList("qa.searchQa", map);
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
	public int searchCountList(String searchName) throws SQLException {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;

	    try {
	        // MyBatis를 사용하여 데이터베이스 쿼리 수행
	        cnt = session.selectOne("qa.searchQaCount", searchName);
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


	


	
	

	
}
