package class272.admin.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.admin.service.AdminNoticeServiceImpl;
import class272.admin.service.IAdminNoticeService;
import class272.vo.BoardNoticeVO;

@WebServlet("/admin/insertnotice.do")
public class InsertAdminNoticeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/admin/adminnoticeinsert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String noticeName = req.getParameter("noticeName");
		String noticeCon = req.getParameter("noticeCon");
		
		BoardNoticeVO nv = new BoardNoticeVO();
		nv.setNoticeName(noticeName);
		nv.setNoticeCon(noticeCon);
		
		IAdminNoticeService adminNoService = AdminNoticeServiceImpl.getInstance();
		int cnt = adminNoService.addNotice(nv);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "게시글이 성공적으로 등록되었습니다.";
		}else {
			msg = "게시글 등록에 실패했습니다.";
		}
		
		req.setAttribute("msg", msg);
		
		req.getRequestDispatcher("/admin/adminNoList.do").forward(req, resp);
		
	}
	
}
