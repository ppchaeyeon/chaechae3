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

@WebServlet("/admin/updatenotice.do")
public class UpdateAdminNoticeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String noticeNo = req.getParameter("noticeNo");
		String noticeName = req.getParameter("noticeName");
		String noticeCon = req.getParameter("noticeCon");
		System.out.println(noticeNo);
		
		req.setAttribute("noticeNo", noticeNo);
		req.setAttribute("noticeName", noticeName);
		req.setAttribute("noticeCon", noticeCon);
		
		req.getRequestDispatcher("/views/admin/adminnoticeupdate.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String noticeNo = req.getParameter("noticeNo");
		String noticeName = req.getParameter("noticeName");
		String noticeCon = req.getParameter("noticeCon");
		
		BoardNoticeVO nv = new BoardNoticeVO();
		nv.setNoticeNo(noticeNo);
		nv.setNoticeName(noticeName);
		nv.setNoticeCon(noticeCon);
		
		IAdminNoticeService adminNoService = AdminNoticeServiceImpl.getInstance();
		int cnt = adminNoService.updateNotice(nv);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "게시글이 성공적으로 수정되었습니다.";
		}else {
			msg = "게시글 수정에 실패했습니다.";
		}
		
		req.setAttribute("msg", msg);
		
//		req.getRequestDispatcher("/admin/adminNoList.do").forward(req, resp);
		resp.sendRedirect(req.getContextPath()+"/admin/adminNoList.do");
	}
	
}
