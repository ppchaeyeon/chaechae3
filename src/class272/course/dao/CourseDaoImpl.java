package class272.course.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.BookmarkVO;
import class272.vo.CourseVO;
import class272.vo.LibraryVO;
import class272.vo.ReviewVO;
import class272.vo.VideoPlayerVO;

public class CourseDaoImpl implements ICourseDao{

	private static ICourseDao courseDao;
	
	private CourseDaoImpl() {
	}
	
	public static ICourseDao getInstance() {
		if(courseDao == null) {
			courseDao = new CourseDaoImpl();
		}
		return courseDao;
	}
	
	@Override
	public int insertCourse(CourseVO cv) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("course.insertCourse",cv);
			
			if(cnt >0) {
				session.commit();
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<CourseVO> getCourseList(String catNo) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		List<CourseVO> courseList = null;
		try {
			courseList = session.selectList("course.getCourseList", catNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return courseList;
	}

	@Override
	public CourseVO getCourseDetail(String corId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		CourseVO courseDetail = null;
		
		try {
			courseDetail = session.selectOne("course.getCourseDetail",corId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return courseDetail;
	}

	@Override
	public List<ReviewVO> getCourseReview(String corId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		List<ReviewVO> courseReview = null;
		
		try {
			courseReview = session.selectList("course.getCourseReview",corId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return courseReview;
	}

	@Override
	public String checkTea(String corId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		String checkTea = null;
		
		try {
			checkTea = session.selectOne("course.checkTea",corId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return checkTea;
	}

	@Override
	public List<LibraryVO> checkBuy(String corId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		List<LibraryVO> checkBuy = null;
		
		try {
			checkBuy = session.selectList("course.checkBuy",corId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return checkBuy;
	}

	@Override
	public int insBookmark(BookmarkVO book) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt =0;
		
		try {
			cnt = session.insert("course.insBookmark",book);
			
			if(cnt >0) {
				session.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		
		return cnt;
	}

	@Override
	public BookmarkVO checkBook(BookmarkVO book) {
		SqlSession session = MyBatisUtil.getSqlSession();
			
		BookmarkVO checkBook = null;
		try {
			checkBook = session.selectOne("course.checkBook",book);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return checkBook;
	}

	@Override
	public int delBook(BookmarkVO book) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.delete("course.delBook",book);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int insertVideo(VideoPlayerVO vp) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.insert("course.insertCourseVideo",vp);
			
			if(cnt>0) {
				session.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public VideoPlayerVO checkVideo(String corId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		VideoPlayerVO checkVideo = null;
		
		try {
			checkVideo = session.selectOne("course.checkVideo", corId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		
		return checkVideo;
	}

	@Override
	public int updateVideo(VideoPlayerVO vp) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.update("course.updateCourseVideo",vp);
			
			if(cnt>0) {
				session.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteVideo(String vpNo) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.delete("course.deleteVideo", vpNo);
			
			if(cnt>0) {
				session.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<CourseVO> searchCourse(String courseName) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		List<CourseVO> list = null;
		
		try {
			list = session.selectList("course.searchCourse",courseName);
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		
		return list;
	}

	@Override
	public List<CourseVO> teaCorList(String memId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		List<CourseVO> list = null;
		try {
			list = session.selectList("course.teaCourseList", memId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public int updateCor(CourseVO cv) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.update("course.updateCourse",cv);
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int delCor(String corId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.update("course.delCourse", corId);
			if(cnt>0) {
				session.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<CourseVO> incomeTea(String memId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		List<CourseVO> list = null;
		try {
			list = session.selectList("course.incomeTea",memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<CourseVO> incomeMon(String memId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		List<CourseVO> list = null;
		try {
			list = session.selectList("course.incomeMon",memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public int insReview(ReviewVO rv) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt =0;
		try {
			cnt = session.insert("course.insReview",rv);
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}
	
}
