package class272.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import class272.category.service.CategoryServiceImpl;
import class272.category.service.ICategoryService;
import class272.community.service.BoardFreeServiceImpl;
import class272.community.service.IBoardFreeService;
import class272.vo.BoardFreeVO;
import class272.vo.CategoryVO;
	
@WebServlet("/detail.do")
public class DetailListBoardFree extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public DetailListBoardFree() {
		super();
	}
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String freeNo = req.getParameter("freeNo");
		
		IBoardFreeService boardFreeService = BoardFreeServiceImpl.getInstance();
		ICategoryService catService = CategoryServiceImpl.getInstance();
		
		List<CategoryVO> catList = catService.getAllCategory();
		//[CategoryVO [categoryNo=1, categoryName=프로그래밍, rownum=1],...
		System.out.println("catList : " + catList);
		req.setAttribute("catList", catList);
		
		HttpSession session = req.getSession();
		session.setAttribute("catList", catList);
		
		//BoardFreeVO [rnum=0, freeNo=C016, freeName=오늘 삼계탕을 먹을까 딴걸 먹을까...
		//, freeTime=2024-03-14 09:13:42, freeCon=삼계탕 너무 비싼데,, 14000원 가격 실화냐, freeDel=N, freeType=2, freeReport=0, memId=b001]
		System.out.println("detailFree : " + boardFreeService.detailFree(freeNo));
		
		//[ComentVO [comentNo=4, comentCon=삼계탕 ㄱㄱ, freeNo=C016, qaNo=null, cqaNo=null, memId=b001]]
		System.out.println("freeComent : " + boardFreeService.freeComent(freeNo));
		
		req.setAttribute("detailFree", boardFreeService.detailFree(freeNo));
		req.setAttribute("freeComent", boardFreeService.freeComent(freeNo));
		
		System.out.println("==============================" + freeNo + "=================================");
		
		req.getRequestDispatcher("views/community/detail.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
