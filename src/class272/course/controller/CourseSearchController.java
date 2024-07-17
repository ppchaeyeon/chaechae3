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

@WebServlet("/search.do")
public class CourseSearchController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ICourseService courseService = CourseServiceImpl.getInstance();
		
		String courseName = req.getParameter("courseName");
		
		List<CourseVO> CList = courseService.searchCourse(courseName);
		req.setAttribute("CList", CList);
		
		
		req.getRequestDispatcher("/views/course/searchList.jsp").forward(req, resp);;
	}
	
}
