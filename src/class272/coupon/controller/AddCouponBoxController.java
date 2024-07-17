package class272.coupon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.coupon.service.CouponServiceImpl;
import class272.coupon.service.ICouponService;
import class272.vo.CouponBoxVO;

@WebServlet("/coupon/boxadd.do")
public class AddCouponBoxController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		String cpNo = req.getParameter("cpNo");
		
		CouponBoxVO cbv = new CouponBoxVO();
		cbv.setMemId(memId);
		cbv.setCouponNo(cpNo);
		
		ICouponService cpService = CouponServiceImpl.getInstance();
		
		int rst = cpService.addCouponBox(cbv);
		
//		PrintWriter writer = resp.getWriter();
//		writer.print(rst);
//		resp.sendRedirect(req.getContextPath()+"/coupon/list.do");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}