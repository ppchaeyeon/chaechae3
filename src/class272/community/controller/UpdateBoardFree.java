package class272.community.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.community.service.BoardFreeServiceImpl;
import class272.community.service.IBoardFreeService;
import class272.vo.BoardFreeVO;

@WebServlet("/updateContent.do")
public class UpdateBoardFree extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String freeName = req.getParameter("freeName");
	    String freeCon = req.getParameter("freeCon");
	    String memId = req.getParameter("memId");
	    String freeNo = req.getParameter("freeNo");
	    
	    System.out.println(freeName);
	    System.out.println(freeCon);
	    System.out.println(memId);
	    // 가져온 값들을 request attribute로 설정
	    req.setAttribute("freeName", freeName);
	    req.setAttribute("freeCon", freeCon);
	    req.setAttribute("memId", memId);
	    req.setAttribute("freeNo", freeNo);
	    
	    
	    req.getRequestDispatcher("views/community/update.jsp").forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		// 폼 데이터 추출
		String freeName = req.getParameter("freeName");
		String freeCon = req.getParameter("freeCon");
		String memId = req.getParameter("memId");
		String freeNo = req.getParameter("freeNo");
		
		// 커뮤니티용
		int freeType = Integer.parseInt(req.getParameter("category"));
		
		// 객체 생성 및 값 설정
		BoardFreeVO fv = new BoardFreeVO();
		fv.setFreeName(freeName);
		fv.setFreeCon(freeCon);
		fv.setMemId(memId);
		
		fv.setFreeNo(freeNo);
		System.out.println("=====================================================================================" + freeNo);
		
		// 커뮤니티용
		fv.setFreeType(freeType);
		
		// BoardFreeService 호출
		IBoardFreeService freeService = BoardFreeServiceImpl.getInstance();
		int cnt = 0;
		try {
			cnt = freeService.updateFree(fv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 결과 메세지 초기화
		String msg = "";
		
		// cnt 값을 이용한 성공 여부 판단 및 메세지 설정
		if(cnt > 0) {
			msg = "게시글 수정이 성공적으로 등록되었습니다.";
		}else {
			msg = "게시글 수정 등록에 실패하였습니다";
		}
		
		// 결과 메세지를  request에 저장
		req.setAttribute("msg", msg);

		resp.sendRedirect("/Class272/detail.do?freeNo=" + freeNo);
		
	}
}
