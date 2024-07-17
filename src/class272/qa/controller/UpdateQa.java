package class272.qa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import class272.qa.service.IQaService;
import class272.qa.service.QaServiceImpl;
import class272.vo.BoardQaVO;

@WebServlet("/updateQa.do")
public class UpdateQa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public UpdateQa() {
        super();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("utf-8");

		String qaNo = req.getParameter("qaNo");
		String qaName = req.getParameter("qaName");
	    String qaCon = req.getParameter("qaCon");
	    
	    BoardQaVO vo = new BoardQaVO();
	    vo.setQaNo(qaNo);
	    vo.setQaName(qaName);
	    vo.setQaCon(qaCon);
	    
	    System.out.println("또 여기냐 >>>>>>>>" + qaNo + qaName + qaCon);
	    
		IQaService qaService = QaServiceImpl.getInstance();
		
		int cnt = qaService.updateQa(vo);
		
		resp.sendRedirect("/Class272/QaDetailList.do?qaNo="+qaNo);
		
	}
	
}
