package class272.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.admin.service.AdminSalesServiceImpl;
import class272.admin.service.IAdminSalesService;
import class272.admin.service.IMemberService;
import class272.admin.service.MemberServiceImpl;
import class272.vo.AtchFileVO;
import class272.vo.LibraryVO;
import class272.vo.MemberVO;

@WebServlet("/admin/sales.do")
public class DetailAdminSalesController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		IAdminSalesService admSalesService = AdminSalesServiceImpl.getInstance();

		List<Map<String, Long>> libList = admSalesService.getMMsales();
		req.setAttribute("libList", libList);
//		System.out.println(libList);
		
		req.getRequestDispatcher("/views/admin/adminSaleMan.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
}
