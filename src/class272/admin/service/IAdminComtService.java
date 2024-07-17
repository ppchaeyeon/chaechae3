package class272.admin.service;

import java.util.List;

import class272.vo.ComentReportVO;


public interface IAdminComtService {
	
	/**
	 * 신고 받은 댓글을 모두 조회하는 메서드
	 * @return 신고 받은 댓글을 담은 List 객체
	 */
	public List<ComentReportVO> getAllComt();
	
	/**
	 * 신고 받은 댓글을 삭제하는 메서드
	 * @param crNo 신고 받은 댓글 번호
	 * @return 삭제 성공하면 1, 실패하면 0 반환됨
	 */
	public int deletecomt(String crNo);

}