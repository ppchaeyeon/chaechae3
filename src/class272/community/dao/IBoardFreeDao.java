package class272.community.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import class272.vo.BoardFreeVO;
import class272.vo.ComentVO;

public interface IBoardFreeDao {
	
	/**
	 * 자유게시글 등록
	 * @param fv 추가할 게시글 정보를 담은 BoardFreeVO 객체
	 * @return
	 */
	public int insertFree(BoardFreeVO fv) throws SQLException;
	
	
	/**
	 * 자유게시글 수정
	 * @param fv 수정할 게시글 정보를 담은 BoardFreeVO 객체
	 * @return
	 */
	public int updateFree(BoardFreeVO fv) throws SQLException;
	
	
	/**
	 * 게시글 상세보기
	 * @param fv
	 * @return
	 */
	public BoardFreeVO detailFree(String freeNo);
	
	
	/**
	 * 댓글
	 * @param freeNo
	 * @return
	 */
	public List<ComentVO> freeComent(String freeNo);
	
	
	/**
	 * (페이징)게시물 카운트 조회
	 * @return
	 * @throws SQLException
	 */
	public int countList() throws SQLException;
		
	
	/**
	 * 범위별 게시물 조회
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public List<BoardFreeVO> boardList(Map<String, Object> map) throws SQLException;
	
	
	/**
	 * 자유게시글 삭제
	 * @param fv
	 * @return
	 */
	public int deleteFree(String freeNo);
	
	
	/**
	 * 게시글 신고
	 * @param fv
	 * @return
	 */
	public int reportFree(String freeNo);
	
	/**
	 * 게시글 검색
	 * @param map 페이징처리
	 * @param freeName 게시글 제목
	 * @return 검색된 게시글 리스트
	 */
	public List<BoardFreeVO> searchList(Map<String, Object> map);
	
	/**
	 * 검색 게시글 페이징 처리를 위한 게시글 갯수 세기
	 * @param freeName
	 * @return
	 */
	public int countSearch(String freeName);
}
