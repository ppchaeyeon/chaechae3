package class272.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.admin.service.AdminNoticeServiceImpl;
import class272.admin.service.IAdminNoticeService;
import class272.vo.BoardNoticeVO;

@WebServlet("/admin/adminNoList.do")
public class DetailAdminNoticeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		IAdminNoticeService adminNoService = AdminNoticeServiceImpl.getInstance();
		
		List<BoardNoticeVO> adminNoList = adminNoService.getAllNotice();
		System.out.println(adminNoList);
		
		req.setAttribute("adminNoList", adminNoList);
		
	
		req.getRequestDispatcher("/views/admin/adminnotice.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
}
