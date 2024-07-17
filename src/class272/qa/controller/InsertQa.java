package class272.qa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.category.service.CategoryServiceImpl;
import class272.category.service.ICategoryService;
import class272.qa.service.IQaService;
import class272.qa.service.QaServiceImpl;
import class272.vo.BoardQaVO;
import class272.vo.CategoryVO;

// QA 게시판 글 작성입니다.

@WebServlet("/insertQa.do")
public class InsertQa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsertQa() {
        super();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("views/qa/qaInsert.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String qaName = req.getParameter("qaName");
	    String qaCon = req.getParameter("qaCon");
		String memId = req.getParameter("memId");
		
		BoardQaVO vo = new BoardQaVO();
		vo.setQaName(qaName);
		vo.setQaCon(qaCon);
		vo.setMemId(memId);
		
		IQaService qaService = QaServiceImpl.getInstance();
		
		int cnt = qaService.insertQa(vo);
		
		if(cnt > 0) {
			System.out.println("등록 성공");
		}else {
			System.out.println("등록 실패");
		}
		
		resp.sendRedirect("/Class272/QaList.do");
		
		
		
		
	}
	
}
	
