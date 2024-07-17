package class272.community.controller;

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
import class272.community.service.BoardFreeServiceImpl;
import class272.community.service.IBoardFreeService;
import class272.vo.BoardFreeVO;
import class272.vo.CategoryVO;

@WebServlet("/searchFree.do")
public class SearchBoardFree extends HttpServlet{
	
	public SearchBoardFree() {
		 super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int currentPage = 1; // 페이지 기본값 설정
        currentPage = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
        String freeName = req.getParameter("freeName");
        
        IBoardFreeService service = BoardFreeServiceImpl.getInstance();
        int totalCount = service.countSearch(freeName);

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

        // 임시 (나중에 제거)
        ICategoryService catService = CategoryServiceImpl.getInstance();
        List<CategoryVO> catList = catService.getAllCategory();
        req.setAttribute("catList", catList);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("str", start);
        map.put("end", end);
        map.put("freeName",freeName);
        System.out.println(map);

        // 범위 별 게시물 가져오기
        List<BoardFreeVO> list = service.searchList(map);
        System.out.println(">>>>" + list);

        // request객체에 결과 값을 담아서 페이지로 전달
        req.setAttribute("list", list);
        req.setAttribute("sPage", startPage);
        req.setAttribute("ePage", endPage);
        req.setAttribute("cPage", currentPage);
        req.setAttribute("ttPage", totalPage);
        req.setAttribute("str", start);

        req.getRequestDispatcher("/views/community/searchFree.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	}
}
