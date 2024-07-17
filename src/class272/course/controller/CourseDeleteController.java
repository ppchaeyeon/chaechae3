package class272.course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.course.service.CourseServiceImpl;
import class272.course.service.ICourseService;

@WebServlet("/delCor.do")
public class CourseDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String corId = req.getParameter("corId");
		ICourseService courseService = CourseServiceImpl.getInstance();
		
		int cnt = courseService.delCor(corId);
		
		req.getRequestDispatcher("/manageCor.do").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
