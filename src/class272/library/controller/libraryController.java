package class272.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import class272.coupon.service.CouponServiceImpl;
import class272.coupon.service.ICouponService;
import class272.library.service.ILibraryService;
import class272.library.service.LibraryServiceImpl;
import class272.vo.CouponBoxVO;
import class272.vo.LibraryVO;
import class272.vo.MemberVO;

@WebServlet("/library/payok.do")
public class libraryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String corId = req.getParameter("corId");
		int finPrice = Integer.parseInt(req.getParameter("finPrice"));
		String couponNo = req.getParameter("couponNo");
		
		ILibraryService libService = LibraryServiceImpl.getInstance();
		ICouponService cpService = CouponServiceImpl.getInstance();
		
		HttpSession session = req.getSession(false);
		MemberVO mv = (MemberVO) session.getAttribute("login_user");
		String memId = mv.getMemId();
		
		//결제내역에 추가
		LibraryVO lv = new LibraryVO();
		lv.setCorId(corId);
		lv.setMemId(memId);
		lv.setFinPrice(finPrice);
		
		libService.addLibrary(lv);
		
		//쿠폰선택하고 결제했을 때만 사용완료처리
		if(!couponNo.equals("0")) {
			CouponBoxVO cbv = new CouponBoxVO();
			cbv.setMemId(memId);
			cbv.setCouponNo(couponNo);
			
			int cnt = cpService.useYCouponBox(cbv);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}