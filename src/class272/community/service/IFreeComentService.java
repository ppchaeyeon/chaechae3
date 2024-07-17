package class272.community.service;

import class272.vo.ComentReportVO;
import class272.vo.ComentVO;

public interface IFreeComentService {
	
	// 댓글 입력
	public int comentInsert (ComentVO vo);
	
	// 댓글 삭제
	public int comentDelete (String comentNo);
	
	// 댓글 신고
	public int comentReport(ComentReportVO crv);
}
