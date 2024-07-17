package class272.qa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.qa.service.IQaService;
import class272.qa.service.QaServiceImpl;

@WebServlet("/QaDetailList.do")
public class QaDetailList extends HttpServlet {
private static final long serialVersionUID = 1L;

public QaDetailList() {
	super();
}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 	String qaNo = req.getParameter("qaNo");
		 	
		    IQaService qaService = QaServiceImpl.getInstance();
		    
		    
		    req.setAttribute("selectQa", qaService.selectQa(qaNo));
		    req.setAttribute("selectComent", qaService.selectComent(qaNo));
		    
		    req.getRequestDispatcher("/views/qa/qaDetailList.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	   
		
	}
}
