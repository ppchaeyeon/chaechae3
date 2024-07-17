package class272.bookmark.service;

import java.util.List;

import class272.vo.CourseVO;

public interface IBookmarkService {
	
	/**
	 * 즐겨찾기 목록 불러오기
	 * @param memId
	 * @return List<CourseVO> 담을 객체
	 */
	public List<CourseVO> MyBookmarkList(String memId);
	
	/**
	 * 강의 구매목록 불러오기
	 * @param memId
	 * @return List<CourseVO> 담을 객체
	 */
	public List<CourseVO> buyCourseList(String memId);
}
