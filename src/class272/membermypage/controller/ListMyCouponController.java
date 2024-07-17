package class272.membermypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import class272.membermypage.service.IMyCouponService;
import class272.membermypage.service.MyCouponServiceImpl;
import class272.vo.CouponVO;
import class272.vo.MemberVO;

@WebServlet("/member/mypage/coupon.do")
public class ListMyCouponController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IMyCouponService mycpService = MyCouponServiceImpl.getInstance();
		
		HttpSession session = req.getSession(false);
		MemberVO mv = (MemberVO) session.getAttribute("login_user");
		String memId = mv.getMemId();
		
		List<CouponVO> mycpList = mycpService.getMyCoupon(memId);
		req.setAttribute("mycpList", mycpList);
		
		req.getRequestDispatcher("/views/member/mypagecoupon.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}