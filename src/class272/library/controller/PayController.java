package class272.library.controller;

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

@WebServlet("/library/pay.do")
public class PayController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사용가능쿠폰 가져오기
		IMyCouponService mycpService = MyCouponServiceImpl.getInstance();
		
		HttpSession session = req.getSession(false);
		MemberVO mv = (MemberVO) session.getAttribute("login_user");
		String memid = mv.getMemId();//수강생
		
		List<CouponVO> mycpList = mycpService.getMyCoupon(memid);
		req.setAttribute("mycpList", mycpList);
		
		//강의정보 가져오기
		String corId = req.getParameter("corId");
		String memName = req.getParameter("memName");//강사
		String corName = req.getParameter("corName");
		String atchFileId = req.getParameter("atchFileId");
		int corPrice = Integer.parseInt(req.getParameter("corPrice"));
				
		req.setAttribute("corId", corId);
		req.setAttribute("memName", memName);//강사
		req.setAttribute("corName", corName);
		req.setAttribute("atchFileId", atchFileId);
		req.setAttribute("corPrice", corPrice);
		req.setAttribute("memId", memid);//수강생
		
		req.getRequestDispatcher("/views/pay/pay.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}