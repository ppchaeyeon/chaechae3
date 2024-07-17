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

@WebServlet("/updateContent2.do")
public class UpdateBoardFree2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
}
