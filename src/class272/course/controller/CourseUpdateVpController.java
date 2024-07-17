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

@WebServlet("/VPUpdate.do")
@MultipartConfig
public class CourseUpdateVpController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int atchFileId = Integer.valueOf(req.getParameter("atchFileId"));
		String corId = req.getParameter("corId");
		String memId = req.getParameter("memId");
		String vpNo = req.getParameter("vpNo");
		
		System.out.println("====================================="+vpNo);
		
		req.setAttribute("atchFileId", atchFileId);
		req.setAttribute("corId", corId);
		req.setAttribute("memId", memId);
		req.setAttribute("vpNo", vpNo);
		
		req.getRequestDispatcher("/views/course/videoUpdateForm.jsp").forward(req, resp);;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String memId = req.getParameter("memId");
		String corId = req.getParameter("corId");
		String vpNo = req.getParameter("vpNo");
		int atchFileId = Integer.valueOf(req.getParameter("atchFileId"));
		
		ICourseService courseService = CourseServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceimpl.getInstance();
		
		AtchFileVO atchFileVO = new AtchFileVO();
		
		try {
			//첨부파일 업로드 처리하기
			atchFileVO = fileService.saveAtchFileList(req.getParts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		VideoPlayerVO vp = new VideoPlayerVO();
		vp.setCorId(corId);
		vp.setVpNo(vpNo);
		
		vp.setAtchFileId((int)atchFileVO.getAtchFileId());
		
		int cnt = courseService.updateVideo(vp);
		
		req.getRequestDispatcher("/course/detail.do?corId="+corId+"&memId="+memId).forward(req, resp);
	}
}
