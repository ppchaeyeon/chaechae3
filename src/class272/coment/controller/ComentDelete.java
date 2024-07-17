package class272.coment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import class272.coment.service.ComentServiceImpl;
import class272.coment.service.IComentService;
import class272.qa.service.IQaService;
import class272.qa.service.QaServiceImpl;

@WebServlet("/deleteCo.do")
public class ComentDelete extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public ComentDelete() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	HttpSession session = req.getSession();
		
    	int coNo = Integer.parseInt(req.getParameter("coNo")); 		// req 값은 무조건 String 이라서 int 값으로 변환 필요
    	String qaNo = req.getParameter("qaNo");
    	
		
		System.out.println(" 체크  >>>>>>>>>>>>>" + coNo + qaNo);
		
		IComentService comentService = ComentServiceImpl.getInstance(); 
		
		int cnt = comentService.comentDelete(coNo);
		
		if(cnt > 0) {
			System.out.println("삭제성공");
		} else {
			System.out.println("삭제실패");
			
		}
		
//		req.setAttribute("deleteQa", comentService.comentDelete(coNo));
		
		resp.sendRedirect("/Class272/QaDetailList.do?qaNo="+qaNo);
    	
    }
}
