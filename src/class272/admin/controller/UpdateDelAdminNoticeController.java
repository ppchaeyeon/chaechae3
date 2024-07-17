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

@WebServlet("/admin/deletenotice.do")
public class UpdateDelAdminNoticeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 삭제로 변환
		String noticeNo = req.getParameter("noticeNo");
		System.out.println("삭제확인>>" + noticeNo);
		IAdminNoticeService adminNoService = AdminNoticeServiceImpl.getInstance();
		
		int cnt = adminNoService.changeDelNotice(noticeNo);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath()+"/admin/adminNoList.do");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
