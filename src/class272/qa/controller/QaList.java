package class272.qa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

// 문의게시판 조회창입니다.

@WebServlet("/QaList.do")
public class QaList extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public QaList() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 	int currentPage = 1; // 페이지 기본값 설정
	        currentPage = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));

	        IQaService qaService = QaServiceImpl.getInstance();
	        int totalCount = qaService.countList();

	        System.out.println("전체 게시글 갯수 : " + totalCount);

	        // 한 페이지 당 출력할 글 갯수
	        int perList = 10;

	        // 화면에 표시될 페이지 수
	        int perPage = 5;

	        // 전체 페이지 수
	        int totalPage = (int) Math.ceil((double) totalCount / (double) perList);
	        
	        System.out.println("=============================totalCount================================================"+ totalCount);
	        System.out.println("perList" + perList);
	        System.out.println("totalPage" + totalPage);

	        // 페이지 당 출력할 게시글의 범위(start ~ end)
	        int start = (currentPage - 1) * perList + 1;
	        int end = start + perList - 1;
	        if (end > totalCount)
	            end = totalCount;

	        System.out.println("start" + start);
	        System.out.println("end" + end);
	        
	        // 화면에 표시할 페이지 범위(startPage ~ endPage)
	        int startPage = ((currentPage - 1) / perPage * perPage) + 1;
	        int endPage = startPage + perPage - 1;
	        if (endPage > totalPage)
	            endPage = totalPage;
	        if (startPage < 1)
	            startPage = 1;
	        
	        System.out.println("startPage" + startPage);
	        System.out.println("endPage" + endPage);

	        // 페이지 이동 관련 로직
	        int nextPage = currentPage + 1;
	        int prevPage = currentPage - 1;

	        // 결과를 request에 저장
	        req.setAttribute("currentPage", currentPage);
	        req.setAttribute("startPage", startPage);
	        req.setAttribute("endPage", endPage);
	        req.setAttribute("totalPage", totalPage);
	        req.setAttribute("nextPage", nextPage);
	        req.setAttribute("prevPage", prevPage);

	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("str", start);
	        map.put("end", end);
	        System.out.println(map);

	        // 범위 별 게시물 가져오기
	        List<BoardQaVO> list = qaService.boardList(map);
	        System.out.println(">>>>" + list);

	        // request객체에 결과 값을 담아서 페이지로 전달
	        req.setAttribute("list", list);
	        req.setAttribute("sPage", startPage);
	        req.setAttribute("ePage", endPage);
	        req.setAttribute("cPage", currentPage);
	        req.setAttribute("ttPage", totalPage);
	        req.setAttribute("str", start);

	        req.getRequestDispatcher("/views/qa/qaList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	}
}
