package class272.bookmark.service;

import java.util.List;

import class272.bookmark.dao.BookmarkDaoImpl;
import class272.bookmark.dao.IBookmarkDao;
import class272.vo.CourseVO;

public class BookmarkServiceImpl implements IBookmarkService{
	private static IBookmarkService bookService;
	private static IBookmarkDao bookDao;
	
	private BookmarkServiceImpl() {
		bookDao = BookmarkDaoImpl.getInstance();
	}
	
	public static IBookmarkService getInstance() {
		if(bookService == null) {
			bookService = new BookmarkServiceImpl();
		}
		return bookService;
	}
	
	@Override
	public List<CourseVO> MyBookmarkList(String memId) {
		return bookDao.MyBookmarkList(memId);
	}

	@Override
	public List<CourseVO> buyCourseList(String memId) {
		return bookDao.buyCourseList(memId);
	}
	
}
