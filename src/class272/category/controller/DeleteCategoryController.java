package class272.category.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.category.service.CategoryServiceImpl;
import class272.category.service.ICategoryService;

@WebServlet("/category/delete.do")
public class DeleteCategoryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String categoryNo = req.getParameter("delnum");
		
		ICategoryService catService = CategoryServiceImpl.getInstance();
		
		int cnt = catService.deleteCategory(categoryNo);
		
//		String msg = "";
//		
//		if(cnt > 0) {
//			msg = "성공";
//		}else {
//			msg = "실패";
//		}
//		
//		req.getSession().setAttribute("msg", msg);
		
//		resp.sendRedirect(req.getContextPath()+"/category/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}