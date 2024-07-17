package class272.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.admin.service.AdminComtServiceImpl;
import class272.admin.service.IAdminComtService;

@WebServlet("/admin/deletecomt.do")
public class DeleteAdminComtController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String crNo = req.getParameter("crNo");
		System.out.println("delete >>" + crNo);
		
		IAdminComtService admComtService = AdminComtServiceImpl.getInstance();
		
		int cnt = admComtService.deletecomt(crNo);
//		System.out.println(cnt);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath()+"/admin/adminRepFree.do");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
