package class272.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.admin.service.AdminFreeServiceImpl;
import class272.admin.service.IAdminFreeService;
import class272.vo.BoardFreeVO;


@WebServlet("/admin/updatefreedel.do")
public class UpdateAdminFreeDelController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String freeNo = req.getParameter("freeNo");
		
		BoardFreeVO fv = new BoardFreeVO();
		fv.setFreeNo(freeNo);
		
		IAdminFreeService admFreeService = AdminFreeServiceImpl.getInstance();
		
		int cnt = admFreeService.changeStateDel(freeNo);
//		System.out.println(cnt);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath()+"/admin/adminRepFree.do");
		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
