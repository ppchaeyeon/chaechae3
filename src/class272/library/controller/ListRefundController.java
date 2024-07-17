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

@WebServlet("/library/reflist.do")
public class ListRefundController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ILibraryService libService = LibraryServiceImpl.getInstance();
		
		List<LibraryVO> reflist = libService.getAllRefund();
		req.setAttribute("reflist", reflist);
		System.out.println(reflist);
		
		req.getRequestDispatcher("/views/admin/adminlibrary.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}