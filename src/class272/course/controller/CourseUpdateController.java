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

@WebServlet("/course/update.do")
@MultipartConfig
public class CourseUpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		ICourseService courseService = CourseServiceImpl.getInstance();
		
		String corId = req.getParameter("corId");
		
		CourseVO courseDetail = courseService.getCourseDetail(corId);
		
		req.setAttribute("courseDetail", courseDetail);
		
		req.getRequestDispatcher("/views/course/updateForm.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String corId = req.getParameter("corId");
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
		
		CourseVO cv = new CourseVO();
		cv.setCorId(corId);
		cv.setCorCon(corCon);
		cv.setCorCuri(corCuri);
		cv.setCorName(corName);
		cv.setCorPrice(corPrice);
		cv.setMemId(memId);
		cv.setCategoryNo(categoryNo);
		
		cv.setAtchFileId((int) atchFileVO.getAtchFileId());
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+cv);
		
		int cnt = courseService.updateCor(cv);
		
		resp.sendRedirect(req.getContextPath()+"/course/detail.do?corId="+corId+"&memId="+memId);
	
	
	}
}
