package class272.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signup.do")
public class SignUp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	/*
	 * 회원 가입 
	 * 최초 작성자 : 박채연
	 * 최초 작성일 : 2024.03.11
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 회원가입 코드 생성 인덱스 보냄
	//	req.setAttribute("joincode", "join");
		
		// 요청을 원하는 위치로 전달하기 위해 requestDispatcher객체 활용
		req.getRequestDispatcher("/views/login/signup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
