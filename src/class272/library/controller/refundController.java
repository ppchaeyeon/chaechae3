package class272.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.library.service.ILibraryService;
import class272.library.service.LibraryServiceImpl;

@WebServlet("/library/refund.do")
public class refundController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String libNo = req.getParameter("libNo");
		
		ILibraryService libService = LibraryServiceImpl.getInstance();
		
		int cnt = libService.refundLibrary(libNo);
		if(cnt > 0) {
			System.out.println("db반영 성공");
		}else {
			System.out.println("실패ㅜㅜㅜ");			
		}
		
		resp.sendRedirect(req.getContextPath()+"/library/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
