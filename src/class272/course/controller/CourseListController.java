package class272.course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.course.service.CourseServiceImpl;
import class272.course.service.ICourseService;
import class272.vo.CourseVO;

@WebServlet("/CList.do")
public class CourseListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String catNo = req.getParameter("catNo");
		
		ICourseService courseService = CourseServiceImpl.getInstance();
		
		List<CourseVO> CList = courseService.getCourseList(catNo);
	
		req.setAttribute("CList", CList);
		req.setAttribute("catNo", catNo);
		
		req.getRequestDispatcher("/views/course/courseList.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
	}
}
