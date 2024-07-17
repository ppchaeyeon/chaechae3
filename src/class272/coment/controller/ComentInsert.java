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
import class272.vo.ComentVO;

@WebServlet("/insertco.do")
public class ComentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ComentInsert() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.setCharacterEncoding("UTF-8");

    	HttpSession session = req.getSession();
        
    	String memId = req.getParameter("memId");
        String qaNo = req.getParameter("qaNo");
        String comentCon = req.getParameter("comentCon");
        
        ComentVO vo = new ComentVO();
        vo.setMemId(memId);
        vo.setQaNo(qaNo);
        vo.setComentCon(comentCon);

        IComentService comentService = ComentServiceImpl.getInstance(); 
        
		int cnt = comentService.comentInsert(vo);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "댓글이 성공적으로 등록되었습니다.";
		}else {
			msg = "댓글 등록에 실패했습니다.";
		}
		
		req.setAttribute("msg", msg);
		
		resp.sendRedirect("/Class272/QaDetailList.do?qaNo="+qaNo);
    }
    
    
}
