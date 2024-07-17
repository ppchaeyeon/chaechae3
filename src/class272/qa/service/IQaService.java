package class272.qa.service;

import java.util.List;
import java.util.Map;

import class272.vo.BoardQaVO;
import class272.vo.ComentVO;

	public interface IQaService {
	
	
	// 게시물 카운트 조회
	public int countList();
	
	// 범위 별 게시물 조회
	public List<BoardQaVO> boardList(Map<String, Object> map);
	
	// 게시글 입력
	public int insertQa (BoardQaVO vo);

	// 게시글 선택
	public BoardQaVO selectQa (String qaNo);
	
	// 댓글 선택
	public List<ComentVO> selectComent (String qaNo);
	
	// 게시글 제거
	public int deleteQa (String qaNo);
	
	// 게시글 수정
	public int updateQa (BoardQaVO vo);
	
	// 검색 게시물 조회
	public List<BoardQaVO> searchQa(Map<String, Object> map);
	
	// 검색 게시물 카운트 조회
	public int searchCountList(String searchName);
	
	
	
	


	 
	
}
