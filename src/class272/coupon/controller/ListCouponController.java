package class272.coupon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.coupon.service.CouponServiceImpl;
import class272.coupon.service.ICouponService;
import class272.vo.CouponBoxVO;
import class272.vo.CouponVO;

@WebServlet("/coupon/list.do")
public class ListCouponController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ICouponService cpService = CouponServiceImpl.getInstance();
		
		List<CouponVO> cpList = cpService.getAllCoupon();
		List<CouponBoxVO> cpboxList = cpService.getAllCouponBox();
		
		req.setAttribute("cpList", cpList);
		req.setAttribute("cpboxList", cpboxList);
		
		req.getRequestDispatcher("/views/admin/admincoupon.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}