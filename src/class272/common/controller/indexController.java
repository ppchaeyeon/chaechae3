package class272.common.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.category.service.CategoryServiceImpl;
import class272.category.service.ICategoryService;
import class272.course.service.CourseServiceImpl;
import class272.course.service.ICourseService;
import class272.vo.CategoryVO;
import class272.vo.CourseVO;

@WebServlet("/main.do")
public class indexController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICategoryService catService = CategoryServiceImpl.getInstance();
		
		List<CategoryVO> catList = catService.getAllCategory();
		
		req.getSession().setAttribute("catList", catList);
		
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	}
	
}
