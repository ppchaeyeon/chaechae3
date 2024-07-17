package class272.course.dao;

import java.util.List;

import class272.vo.BookmarkVO;
import class272.vo.CourseVO;
import class272.vo.LibraryVO;
import class272.vo.ReviewVO;
import class272.vo.VideoPlayerVO;

public interface ICourseDao {
	
	/**
	 * 강의 정보를 등록하는 메소드
	 * @param cv 등록할 강의 정보를 담은 객체
	 * @return 성공하면 1, 실패하면 0 반환
	 */
	public int insertCourse(CourseVO cv);
	
	
	/**
	 * 강의 리스트를 출력하는 메소드
	 * @param catNo 출력할 카테고리 번호
	 * @return List<CourseVO> 형식에 담긴 데이터 반환
	 */
	public List<CourseVO> getCourseList(String catNo);
	
	/**
	 * 강의 상세정보를 출력하는 메소드
	 * @param corId 강의 번호
	 * @return CourseVO vo데이터로 반환
	 */
	public CourseVO getCourseDetail(String corId);
	
	/**
	 * 수강후기를 출력하는 메소드
	 * @param corId
	 * @return ReviewVO
	 */
	public List<ReviewVO> getCourseReview(String corId);
	
	/**
	 * 강의 주인 체크하는 메소드
	 * @param corId
	 * @return String 강의 주인 리턴
	 */
	public String checkTea(String corId);
	
	/**
	 * 강의 구매 체크를 위한 메소드
	 * @param corId
	 * @return 구매 기록 리스트 리턴
	 */
	public List<LibraryVO> checkBuy(String corId);
	
	/**
	 * 강의 즐겨찾기 추가 메소드
	 * @param book
	 * @return 성공하면 1, 실패하면 0 반환
	 */
	public int insBookmark(BookmarkVO book);
	
	/**
	 * 즐겨찾기 등록 여부 확인 메소드
	 * @param book
	 * @return BookmarkVO 객체
	 */
	public BookmarkVO checkBook(BookmarkVO book);
	
	/**
	 * 즐겨찾기 해제 메소드
	 * @param book
	 * @return int 실행 여부 확인값
	 */
	public int delBook(BookmarkVO book);
	
	/**
	 * 강의영상 등록 메소드
	 * @param vp 영상 정보 저장 객체
	 * @return int값 반환
	 */
	public int insertVideo(VideoPlayerVO vp);
	
	/**
	 * 영상 존재 여부 체크
	 * @param corId
	 * @return VideoPlayerVO 로 반환
	 */
	public VideoPlayerVO checkVideo(String corId);
	
	/**
	 * 강의영상 수정
	 * @param vp
	 * @return int 1 성공 0 실패
	 */
	public int updateVideo(VideoPlayerVO vp);
	
	/**
	 * 이전 강의 영상 삭제
	 * @param atchFileId
	 * @return int 1 성공 0 실패
	 */
	public int deleteVideo(String vpNo);
	
	/**
	 * 강의명으로 강의 검색하는 메소드
	 * @param courseName
	 * @return List<CourseVO> 검색된 강의 리스트 리턴
	 */
	public List<CourseVO> searchCourse(String courseName);
	
	/**
	 * 강사 아이디로 해당 강사의 강의 리스트 출력
	 * @param memId
	 * @return List<CourseVO> 검색된 강의 리스트 리턴
	 */
	public List<CourseVO> teaCorList(String memId);
	
	/**
	 * 강의 수정
	 * @param cv 수정될 값 담을 변수
	 * @return 1 성공 0 실패
	 */
	public int updateCor(CourseVO cv);
	
	/**
	 * 강의 삭제
	 * @param corId 삭제할 강의 번호
	 * @return 1성공 0실패
	 */
	public int delCor(String corId);
	
	/**
	 * 강사의 강의별 income조회
	 * @param memId
	 * @return
	 */
	public List<CourseVO> incomeTea(String memId);
	
	/**
	 * 강사의 월별 income조회
	 * @param memId
	 * @return
	 */
	public List<CourseVO> incomeMon(String memId);
	
	/**
	 * 구매한 강의 강의평 등록
	 * @param rv
	 * @return 성공 1 실패 0
	 */
	public int insReview (ReviewVO rv);
}
