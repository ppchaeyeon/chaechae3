package class272.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.coment.service.ComentServiceImpl;
import class272.community.service.FreeComentServiceImpl;
import class272.community.service.IFreeComentService;
import class272.vo.ComentVO;

@WebServlet("/insertfc.do")
public class FreeComentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FreeComentInsert() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.setCharacterEncoding("UTF-8");
        
    	String memId = req.getParameter("memId");
        String freeNo = req.getParameter("freeNo");
        String comentCon = req.getParameter("comentCon");
        
        System.out.println("===================================="+memId + freeNo +comentCon);
        
        ComentVO vo = new ComentVO();
        vo.setMemId(memId);
        vo.setFreeNo(freeNo);
        vo.setComentCon(comentCon);

        IFreeComentService comentService =FreeComentServiceImpl.getInstance(); 
        
		int cnt = comentService.comentInsert(vo);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "댓글이 성공적으로 등록되었습니다.";
		}else {
			msg = "댓글 등록에 실패했습니다.";
		}
		
		req.setAttribute("msg", msg);
		
		resp.sendRedirect("/Class272/detail.do?freeNo="+freeNo);
		req.getRequestDispatcher("/Class272/detail.do?freeNo="+freeNo);
    }
    
}
