package class272.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.admin.service.IMemberService;
import class272.admin.service.MemberServiceImpl;
import class272.category.service.CategoryServiceImpl;
import class272.category.service.ICategoryService;
import class272.vo.AtchFileVO;
import class272.vo.CategoryVO;
import class272.vo.MemberVO;

@WebServlet("/admin/detaillist.do")
public class DetailMemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ICategoryService catService = CategoryServiceImpl.getInstance();
		
		List<CategoryVO> catList = catService.getAllCategory();
		
		req.getSession().setAttribute("catList", catList);
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		List<MemberVO> memList = memService.getAllMember();
		req.setAttribute("memList", memList);
//		System.out.println(memList);
		
		List<MemberVO> blackMemList = memService.getAllBlackMember();
		req.setAttribute("blackMemList", blackMemList);
		
		req.getRequestDispatcher("/views/admin/adminForm.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
}
