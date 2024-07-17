package class272.qa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import class272.category.service.CategoryServiceImpl;
import class272.category.service.ICategoryService;
import class272.qa.service.IQaService;
import class272.qa.service.QaServiceImpl;
import class272.vo.BoardQaVO;
import class272.vo.CategoryVO;

// QA 게시판 삭제입니다.

@WebServlet("/DeleteQa.do")
public class DeleteQa extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public DeleteQa() {
        super();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String qaNo = req.getParameter("qaNo");
		
		System.out.println("컨트롤러 >>>>>>>>" + qaNo);
		
		IQaService qaService = QaServiceImpl.getInstance();
		req.setAttribute("deleteQa", qaService.deleteQa(qaNo));
		
		resp.sendRedirect("/Class272/QaList.do");
		
	}
	
}
