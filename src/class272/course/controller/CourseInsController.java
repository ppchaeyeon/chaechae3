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
import class272.vo.CourseVO;

@WebServlet("/course/ins.do")
@MultipartConfig
public class CourseInsController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/course/insertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String corName = req.getParameter("corName");
		String corCon = req.getParameter("corCon");
		String corCuri = req.getParameter("corCuri");
		int corPrice = Integer.parseInt(req.getParameter("corPrice"));
		String memId = req.getParameter("memId");
		String categoryNo = req.getParameter("categoryNo");
		String atchFileId = req.getParameter("atchFileId");
		
		ICourseService courseService = CourseServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceimpl.getInstance();
		
		AtchFileVO atchFileVO = new AtchFileVO();
		
		try {
			// 첨부파일 업로드
			atchFileVO = fileService.saveAtchFileList(req.getParts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CourseVO cv = new CourseVO(corName, corCon, corCuri, corPrice, memId, categoryNo);
		
		cv.setAtchFileId((int) atchFileVO.getAtchFileId());
		
		int cnt = courseService.insertCourse(cv);
		
		resp.sendRedirect(req.getContextPath()+"/manageCor.do");
	}
		
		

}
