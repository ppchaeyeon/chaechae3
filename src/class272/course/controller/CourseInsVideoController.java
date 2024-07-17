package class272.course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.common.service.AtchFileServiceimpl;
import class272.common.service.IAtchFileService;
import class272.course.service.CourseServiceImpl;
import class272.course.service.ICourseService;
import class272.vo.AtchFileVO;
import class272.vo.VideoPlayerVO;

@WebServlet("/videoInsert.do")
@MultipartConfig
public class CourseInsVideoController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String corId = req.getParameter("corId");
		String memId = req.getParameter("memId");
		
		ICourseService courseService = CourseServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceimpl.getInstance();
		
		AtchFileVO atchFileVO = new AtchFileVO();
		
		try {
			atchFileVO = fileService.saveAtchFileList(req.getParts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		VideoPlayerVO vp = new VideoPlayerVO();
		vp.setCorId(corId);
		vp.setAtchFileId((int)atchFileVO.getAtchFileId());
		
		int cnt = courseService.insertVideo(vp);
		
		req.getRequestDispatcher("/course/detail.do?corId="+corId+"&memId="+memId).forward(req, resp);
	}
}
