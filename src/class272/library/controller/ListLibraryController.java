package class272.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import class272.library.service.ILibraryService;
import class272.library.service.LibraryServiceImpl;
import class272.vo.LibraryVO;
import class272.vo.MemberVO;

@WebServlet("/library/list.do")
public class ListLibraryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ILibraryService libService = LibraryServiceImpl.getInstance();
		
		HttpSession session = req.getSession(false);
		MemberVO mv = (MemberVO) session.getAttribute("login_user");
		String memId = mv.getMemId();
		
		List<LibraryVO> libList = libService.getMyLibrary(memId);
		req.setAttribute("libList", libList);
		
		req.getRequestDispatcher("/views/member/mypagelibrary.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}