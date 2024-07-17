package class272.coupon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.coupon.service.CouponServiceImpl;
import class272.coupon.service.ICouponService;
import class272.vo.CouponVO;

@WebServlet("/coupon/add.do")
public class AddCouponController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String couponName = req.getParameter("cpName");
		int couponDc = Integer.parseInt(req.getParameter("cpDc"));
		
		CouponVO cv = new CouponVO();
		cv.setCouponType(couponName);
		cv.setCouponDc(couponDc);
		
		ICouponService cpService = CouponServiceImpl.getInstance();
		
		cpService.addCoupon(cv);
		
//		resp.sendRedirect(req.getContextPath()+"/coupon/list.do");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}