package class272.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.admin.service.IMemberService;
import class272.admin.service.MemberServiceImpl;
import class272.vo.AtchFileVO;
import class272.vo.MemberVO;

// 일반회원 > 탈퇴회원
@WebServlet("/admin/updateout.do")
public class UpdateOutMemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 탍퇴회원일 때..
		String memId = req.getParameter("memId");
		
		MemberVO mv = new MemberVO();
		mv.setMemState(2);
		mv.setMemId(memId);
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		int cnt = memService.OutMember(memId);
		System.out.println(cnt);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath()+"/admin/detaillist.do");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
