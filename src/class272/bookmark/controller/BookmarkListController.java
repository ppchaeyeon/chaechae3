package class272.bookmark.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import class272.bookmark.service.BookmarkServiceImpl;
import class272.bookmark.service.IBookmarkService;
import class272.vo.CourseVO;
import class272.vo.MemberVO;

@WebServlet("/BookmarkList.do")
public class BookmarkListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		IBookmarkService bookService = BookmarkServiceImpl.getInstance();
		
		HttpSession session = req.getSession(false);
		MemberVO mv = (MemberVO) session.getAttribute("login_user");
		String memId = mv.getMemId();
		
		List<CourseVO> CList = bookService.MyBookmarkList(memId);
		req.setAttribute("CList", CList);
		
		req.getRequestDispatcher("/views/member/bookmarkList.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
