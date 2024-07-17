package class272.community.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.community.service.BoardFreeServiceImpl;
import class272.community.service.IBoardFreeService;
import class272.vo.BoardFreeVO;

@WebServlet("/insert.do")
public class InsertBoardFree extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// insert.jsp로 이동하는 GET 요청 처리 메서드
		req.getRequestDispatcher("views/community/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 폼으로부터 전송된 데이터를 받아오고 게시글을 등록하는 POST 요청 처리 메서드
		req.setCharacterEncoding("UTF-8");
		
		// 폼에서 전송된 데이터 추출
		String freeName = req.getParameter("freeName");
		String freeCon = req.getParameter("freeCon");
		String memId = req.getParameter("memId");
		int freeType = Integer.parseInt(req.getParameter("category"));
		
		// BoardFreeVO 객체 생성 및 값 설정
		BoardFreeVO fv = new BoardFreeVO();
		fv.setFreeType(freeType);
		fv.setFreeName(freeName);
		fv.setFreeCon(freeCon);
		fv.setMemId(memId);
		
		// BoardFreeService 호출
		IBoardFreeService freeService = BoardFreeServiceImpl.getInstance();
		int cnt = freeService.insertFree(fv);
		
		// 결과 메시지 초기화
		String msg = "";
		
		// cnt를 이용한 성공 여부 판단 및 메시지 설정
		if (cnt > 0) {
			msg = "게시글이 성공적으로 등록되었습니다.";
		} else {
			msg = "게시글 등록에 실패했습니다.";
		}
		
		// 등록 결과 메시지를 request에 저장
		req.setAttribute("msg", msg);
		
		resp.sendRedirect("/Class272/community.do");
	}
}
