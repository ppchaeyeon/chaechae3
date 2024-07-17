package class272.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.member.service.ILogService;
import class272.member.service.LogServiceImpl;
import class272.vo.MemberVO;

@WebServlet("/findid.do")
public class FindId extends HttpServlet{

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	req.getRequestDispatcher("/views/login/searchid.jsp").forward(req,resp);
	
	
//	if(id == null) { // 아이디가 없다면 - 알람창 - 아이디찾기화면 다시
//		resp.sendRedirect(req.getContextPath()+"/findid.do");
//	} else { // 아이디가 존재하면 - 알람창 - 로그인화면
//		resp.sendRedirect(req.getContextPath()+"/login.do");
//		
//	}
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String name = req.getParameter("memName"); // form 제출 id req
	String tel = req.getParameter("memTel"); // form 제출 tel
	
	MemberVO mv = new MemberVO(); 
	mv.setMemName(name); 
	mv.setMemTel(tel);
	
	ILogService service = LogServiceImpl.getInstance();
	MemberVO id = service.SearchId(mv); // db 결과값
	req.setAttribute("findId", id);
	
	
	
}


}
