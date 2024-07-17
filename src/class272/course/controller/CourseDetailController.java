package class272.course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.common.service.AtchFileServiceimpl;
import class272.common.service.IAtchFileService;
import class272.course.service.CourseServiceImpl;
import class272.course.service.ICourseService;
import class272.vo.AtchFileVO;
import class272.vo.BookmarkVO;
import class272.vo.CourseVO;
import class272.vo.LibraryVO;
import class272.vo.ReviewVO;
import class272.vo.VideoPlayerVO;

@WebServlet("/course/detail.do")
public class CourseDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICourseService courseService = CourseServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceimpl.getInstance();
		
		String corId = req.getParameter("corId");
		String memId = req.getParameter("memId");
		
		CourseVO courseDetail = courseService.getCourseDetail(corId);
		
		String checkTea = courseService.checkTea(corId);
		
		BookmarkVO book = new BookmarkVO();
		book.setCorId(corId);
		book.setMemId(memId);
		BookmarkVO checkBook = courseService.checkBook(book);
		
		VideoPlayerVO checkVideo = courseService.checkVideo(corId);
		
		int atchFileId = -1;
		if(checkVideo != null) {
			atchFileId = checkVideo.getAtchFileId();
			
		}
		AtchFileVO atchFileVO = new AtchFileVO();
		atchFileVO.setAtchFileId(atchFileId);
		
		List<AtchFileVO> videoList = fileService.getAtchFileList(atchFileVO);
		
		
		List<LibraryVO> checkBuy = courseService.checkBuy(corId);
		
		List<ReviewVO> courseReview = (List<ReviewVO>)courseService.getCourseReview(corId);
		
		req.setAttribute("checkTea", checkTea);
		req.setAttribute("checkBuy", checkBuy);
		req.setAttribute("courseDetail", courseDetail);
		req.setAttribute("courseReview", courseReview);
		req.setAttribute("checkBook", checkBook);
		req.setAttribute("checkVideo", checkVideo);
		req.setAttribute("videoList", videoList);
		
		req.getRequestDispatcher("/views/course/courseDetail.jsp").forward(req, resp);;
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
