package class272.course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.course.service.CourseServiceImpl;
import class272.course.service.ICourseService;
import class272.vo.ReviewVO;

@WebServlet("/insReview.do")
public class CourseReviewInsController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ICourseService courseService = CourseServiceImpl.getInstance();
		
		String memId = req.getParameter("memId");
		String corId = req.getParameter("corId");
		int reviewStar = Integer.valueOf(req.getParameter("reviewStar"));
		String reviewCon = req.getParameter("reviewCon");
		
		ReviewVO rv = new ReviewVO();
		rv.setCorId(corId);
		rv.setMemId(memId);
		rv.setReviewCon(reviewCon);
		rv.setReviewStar(reviewStar);
		
		courseService.insReview(rv);
		
		resp.sendRedirect("/Class272/course/detail.do?corId="+corId+"&memId="+memId);
	}
}
