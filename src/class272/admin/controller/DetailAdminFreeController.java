package class272.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.admin.service.AdminComtServiceImpl;
import class272.admin.service.AdminFreeServiceImpl;
import class272.admin.service.IAdminComtService;
import class272.admin.service.IAdminFreeService;
import class272.vo.BoardFreeVO;
import class272.vo.ComentReportVO;

@WebServlet("/admin/adminRepFree.do")
public class DetailAdminFreeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		IAdminComtService admComtService = AdminComtServiceImpl.getInstance();
		
		IAdminFreeService admFreeService = AdminFreeServiceImpl.getInstance();
		
		List<ComentReportVO> admComtList = admComtService.getAllComt();
		req.setAttribute("admComtList", admComtList);
		
		List<BoardFreeVO> admFreeList = admFreeService.getAllReport();
		req.setAttribute("admFreeList", admFreeList);
	
		req.getRequestDispatcher("/views/admin/adminrepfree.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
}
