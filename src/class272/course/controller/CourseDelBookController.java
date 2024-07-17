package class272.course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.course.service.CourseServiceImpl;
import class272.course.service.ICourseService;
import class272.vo.BookmarkVO;

@WebServlet("/delBookmark.do")
public class CourseDelBookController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ICourseService courseService = CourseServiceImpl.getInstance();
		
		String memId = req.getParameter("memId");
		String corId = req.getParameter("corId");
		
		BookmarkVO book = new BookmarkVO();
		book.setMemId(memId);
		book.setCorId(corId);
		
		int cnt = courseService.delBook(book);
		
		req.getRequestDispatcher("/course/detail.do?corId="+corId).forward(req, resp);
	}
}
