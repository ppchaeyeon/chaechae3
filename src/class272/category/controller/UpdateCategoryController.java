package class272.category.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.category.service.CategoryServiceImpl;
import class272.category.service.ICategoryService;
import class272.vo.CategoryVO;

@WebServlet("/category/update.do")
public class UpdateCategoryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String categoryNo = req.getParameter("updnum");
		String categoryName = req.getParameter("updname");
		
		CategoryVO cv = new CategoryVO();
		cv.setCategoryNo(categoryNo);
		cv.setCategoryName(categoryName);
		
		ICategoryService catService = CategoryServiceImpl.getInstance();
		
		int cnt = catService.updateCategory(cv);
		
//		String msg = "";
//		
//		if(cnt > 0) {
//			msg = "성공";
//		}else {
//			msg = "실패";
//		}
//		
//		req.getSession().setAttribute("msg", msg);
		

	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}	
}