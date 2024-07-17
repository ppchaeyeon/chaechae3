package class272.admin.service;

import java.util.List;

import class272.vo.BoardFreeVO;


public interface IAdminFreeService {
	
	/**
	 * 신고 1이상 자유게시판을 조회하는 메서드
	 * @return 모든 신고 1이상 자유게시판을 담은 List 객체
	 */
	public List<BoardFreeVO> getAllReport();
	
	/**
	 * 신고 1이상 자유게시판을 삭제로 변경하는 메서드
	 * @param freeNo 자유게시판 번호
	 * @param FreeDel 삭제 상태 여부
	 * @return 삭제상태변경 성공하면 1, 실패하면 0 반환됨
	 */
	public int changeStateDel(String freeNo);

}