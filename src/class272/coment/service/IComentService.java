package class272.coment.service;

import class272.vo.ComentVO;

public interface IComentService {
	
	// 댓글 입력
	public int comentInsert (ComentVO vo);
	
	
	// 댓글 삭제
	public int comentDelete (int coNo);
}
