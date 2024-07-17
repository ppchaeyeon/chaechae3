package class272.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.member.service.ILogService;
import class272.member.service.IMemberService;
import class272.member.service.LogServiceImpl;
import class272.member.service.MemberServiceImpl;
import class272.vo.MemberVO;

@WebServlet("/deletemem.do")
public class DeleteMypage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// String memId = req.getParameter("memId");
		MemberVO login_user = (MemberVO)req.getSession().getAttribute("login_user");
		String memId = login_user.getMemId();
		IMemberService service = MemberServiceImpl.getInstance();
		String msg = "";
		int cnt = service.DeleteMember(memId);
//		if(cnt >0) {
//			msg = "회원탈퇴 처리가 완료되었습니다. 그동안 Class272를 이용해주셔서 감사합니다.";
//		} else {
//			msg = "회원탈퇴 처리가 실패되었습니다.";
//		}
		
		req.getSession().removeAttribute("login_user");
		req.getRequestDispatcher("/main.do").forward(req,resp);		
	}
	
	
}
