package class272.admin.service;

import java.util.List;

import class272.vo.BoardNoticeVO;


public interface IAdminNoticeService {
   
   /**
    * 모든 공지사항을 조회하는 메서드
    * @return 모든 공지사항을 담은 List 객체
    */
   public List<BoardNoticeVO> getAllNotice();
   
   
   /**
    * 공지사항 추가하는 메서드
    * @param nv 새로 생성할 공지사항 정보 담은 BoardNoticeVO객체
    * @return 작업 성공시 1, 실패시 0 반환
    */
   public int addNotice(BoardNoticeVO nv);
   
   
   /**
    * 공지사항 삭제로 변환하는 메서드
    * @param noticeNo 삭제 변환할 공지사항 번호
    * @return 작업 성공시 1, 실패시 0 반환
    */
   public int changeDelNotice(String noticeNo);
   
   /**
    * 공지사항 수정하는 메서드
    * @param nv 새로 생성할 카테고리 정보 담은 BoardNoticeVO객체
    * @return 작업 성공시 1, 실패시 0반환
    */
   public int updateNotice(BoardNoticeVO nv);

}