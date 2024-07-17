package class272.community.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.BoardFreeVO;
import class272.vo.ComentVO;

public class BoardFreeDaoImpl implements IBoardFreeDao{

	// BoardFree 싱글톤
	private static IBoardFreeDao freeDao;
	
	private BoardFreeDaoImpl() {
	}
	
	public static IBoardFreeDao GetInstance() {
		if(freeDao == null) {
			freeDao = new BoardFreeDaoImpl();
		}
		return freeDao;
	}
	
	
	// free게시글 등록
	@Override
	public int insertFree(BoardFreeVO fv) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("free.insertBoardFree", fv);
			
			if(cnt >0) {
				session.commit();
			}
		} catch (PersistenceException ex) {
			ex.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return cnt;
	}

	
	// free게시글 수정
	@Override
	public int updateFree(BoardFreeVO fv) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("free.updateBoardFree", fv);
			if(cnt>0) {
				session.commit();	// 커밋을 생활화 하자!!
			}
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	
	// free게시글 리스트 페이징
	@Override
	public int countList() throws SQLException {	// selectOne
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;		

	    try {
	        // MyBatis를 사용하여 데이터베이스 쿼리 수행
	        cnt = session.selectOne("free.countList");
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
	
	
	// free게시글 전체 리스트
	@Override
	public List<BoardFreeVO> boardList(Map<String, Object> map) throws SQLException {	// selectList
		
		SqlSession session = MyBatisUtil.getSqlSession();
		List<BoardFreeVO> boardList = null;
		
		try {
	        // MyBatis를 사용하여 데이터베이스 쿼리 수행
	        boardList = session.selectList("free.boardList", map);
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

	
	// free게시글 상세페이지
	@Override
	public BoardFreeVO detailFree(String freeNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		BoardFreeVO freeDetail = null;
		
		try {
			freeDetail = (BoardFreeVO) session.selectOne("free.detailFree", freeNo);
			System.out.println(freeDetail);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		
		
		return freeDetail;
	}

	
	// free게시글 상세 페이지 댓글
	@Override
	public List<ComentVO> freeComent(String freeNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		List<ComentVO> comentList = null;
		
		try {
			comentList = session.selectList("free.freeComent", freeNo); // xml 가져오는 코드
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

	// free게시글 삭제
	@Override
	public int deleteFree(String freeNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("free.deleteBoardFree", freeNo);
			if(cnt > 0) session.commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	// free게시글 신고
	@Override
	public int reportFree(String freeNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("free.reportBoardFree", freeNo);
			if(cnt>0) {
				session.commit();
			}
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		 return cnt;
	}

	@Override
	public List<BoardFreeVO> searchList(Map<String, Object> map) {
		SqlSession session = MyBatisUtil.getSqlSession();
		List<BoardFreeVO> list = null;
		try {
			list = session.selectList("free.searchFree",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public int countSearch(String freeName) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.selectOne("free.countSearch",freeName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}


}
