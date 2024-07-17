package class272.notice.service;

import java.util.List;
import java.util.Map;

import class272.vo.BoardNoticeVO;

public interface INoticeService {


	// 공지글 카운트 조회
	public int countList();
	
	// 범위 별 공지글 조회
	public List<BoardNoticeVO> boardList(Map<String, Object> map);
	
	// 공지글 선택
	public BoardNoticeVO selectNotice (String noticeNo);

	
	
	
	
	
}
