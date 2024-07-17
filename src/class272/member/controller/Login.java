package class272.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

@WebServlet("/login.do")
public class Login extends HttpServlet {

	public Login() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String memId = req.getParameter("memId");
		String memPw = req.getParameter("memPw");
		ILogService service = LogServiceImpl.getInstance();

		// 해당 회원정보 가져오기(id를 얻어서 전체 정보를 얻음)
		MemberVO mv = service.getMember(memId);

		if(mv == null) {
			resp.sendRedirect(req.getContextPath() + "/login.do");
		}else {
			// db에서 가져온 사용자 정보를 이용하여 패스워드 일치여부 확인
			boolean isAthneticated = false; // 인증된 사용자 여부
			if (mv != null) {
				if (memPw.equals(mv.getMemPw())) { // 입력 pw와 db pw가 같으면
					isAthneticated = true;
				}
			}
			
			if (isAthneticated) { // 인증 성공
				if(mv.getMemGubun()==3) {
					// 세션에 로그인 정보 설정하기
					req.getSession().setAttribute("login_user", mv);
					
					// 메인페이지 이동(관리자페이지)
					resp.sendRedirect("/Class272/admin/detaillist.do");
				}else {
					// 세션에 로그인 정보 설정하기
					req.getSession().setAttribute("login_user", mv);
					req.getSession().setAttribute("login_gubun", mv.getMemGubun());
					req.getSession().setAttribute("login_name", mv.getMemName());
					System.out.println(mv.getMemGubun());
					
					// 메인페이지 이동
					resp.sendRedirect(req.getContextPath() + "/main.do");
				}
			} else { // 인증 실패 (회원x, 아이디랑 비밀번호가 다르면)
				// 로그인 페이지로 이동
				req.getSession().setAttribute("login_error", 0);
				System.out.println(req.getSession().getAttribute("login_error"));
				
				resp.sendRedirect(req.getContextPath() + "/login.do");
			}
			
		}


	}

}
