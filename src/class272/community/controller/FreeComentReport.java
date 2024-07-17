package class272.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import class272.community.service.FreeComentServiceImpl;
import class272.community.service.IFreeComentService;
import class272.vo.ComentReportVO;

@WebServlet("/reportfc.do")
public class FreeComentReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FreeComentReport() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.setCharacterEncoding("UTF-8");
    	
    	HttpSession session = req.getSession();
    	
    	String freeNo = req.getParameter("freeNo");
    	String crReason = req.getParameter("crReason");
    	int comentNo = Integer.parseInt(req.getParameter("comentNo"));
    	
    	ComentReportVO crv = new ComentReportVO();
    	crv.setCrReason(crReason);
    	crv.setComentNo(comentNo);
    	
        IFreeComentService comentService =FreeComentServiceImpl.getInstance();
        
        int cnt = 0;
        try {
			cnt = comentService.comentReport(crv);
		} catch (Exception e) {
			 e.printStackTrace();
		}
 
        resp.sendRedirect("/Class272/detail.do?freeNo="+freeNo);
    }
}
