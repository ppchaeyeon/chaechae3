package class272.bookmark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.CourseVO;

public class BookmarkDaoImpl implements IBookmarkDao{
	private static IBookmarkDao bookDao;
	
	private BookmarkDaoImpl() {
	}
	
	public static IBookmarkDao getInstance() {
		if(bookDao == null) {
			bookDao = new BookmarkDaoImpl();
		}
		return bookDao;
	}
	
	@Override
	public List<CourseVO> MyBookmarkList(String memId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		List<CourseVO> list = null;
		try {
			list = session.selectList("course.bookmarkList", memId);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		
		return list;
	}

	@Override
	public List<CourseVO> buyCourseList(String memId) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		List<CourseVO> list = null;
		try {
			list = session.selectList("course.buyCourseList",memId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

}
