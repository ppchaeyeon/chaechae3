package class272.course.service;

import java.util.List;

import class272.course.dao.CourseDaoImpl;
import class272.course.dao.ICourseDao;
import class272.vo.BookmarkVO;
import class272.vo.CourseVO;
import class272.vo.LibraryVO;
import class272.vo.ReviewVO;
import class272.vo.VideoPlayerVO;

public class CourseServiceImpl implements ICourseService{

	private static ICourseService courseService;
	private static ICourseDao courseDao;
	
	private CourseServiceImpl() {
		courseDao = CourseDaoImpl.getInstance();
	}
	
	public static ICourseService getInstance() {
		if(courseService == null) {
			courseService = new CourseServiceImpl();
		}
		return courseService;
	}
	
	
	
	@Override
	public int insertCourse(CourseVO cv) {
		int cnt = courseDao.insertCourse(cv);
		return cnt;
	}

	@Override
	public List<CourseVO> getCourseList(String catNo) {
		List<CourseVO> list = null;
		list = courseDao.getCourseList(catNo);
		return list;
	}

	@Override
	public CourseVO getCourseDetail(String corId) {
		
		return courseDao.getCourseDetail(corId);
	}

	@Override
	public List<ReviewVO> getCourseReview(String corId) {
		
		return courseDao.getCourseReview(corId);
	}

	@Override
	public String checkTea(String corId) {
		
		return courseDao.checkTea(corId);
	}

	@Override
	public List<LibraryVO> checkBuy(String corId) {
		return courseDao.checkBuy(corId);
	}

	@Override
	public int insBookmark(BookmarkVO book) {
		return courseDao.insBookmark(book);
	}

	@Override
	public BookmarkVO checkBook(BookmarkVO book) {
		return courseDao.checkBook(book);
	}

	@Override
	public int delBook(BookmarkVO book) {
		return courseDao.delBook(book);
	}

	@Override
	public int insertVideo(VideoPlayerVO vp) {
		return courseDao.insertVideo(vp);
	}

	@Override
	public VideoPlayerVO checkVideo(String corId) {
		return courseDao.checkVideo(corId);
	}

	@Override
	public int updateVideo(VideoPlayerVO vp) {
		return courseDao.updateVideo(vp);
	}

	@Override
	public int deleteVideo(String vpNo) {
		return courseDao.deleteVideo(vpNo);
	}

	@Override
	public List<CourseVO> searchCourse(String courseName) {
		return courseDao.searchCourse(courseName);
	}

	@Override
	public List<CourseVO> teaCorList(String memId) {
		return courseDao.teaCorList(memId);
	}

	@Override
	public int updateCor(CourseVO cv) {
		return courseDao.updateCor(cv);
	}

	@Override
	public int delCor(String corId) {
		return courseDao.delCor(corId);
	}

	@Override
	public List<CourseVO> incomeTea(String memId) {
		return courseDao.incomeTea(memId);
	}

	@Override
	public List<CourseVO> incomeMon(String memId) {
		return courseDao.incomeMon(memId);
	}

	@Override
	public int insReview(ReviewVO rv) {
		return courseDao.insReview(rv);
	}

}
