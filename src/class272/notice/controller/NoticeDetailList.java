package class272.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.notice.service.INoticeService;
import class272.notice.service.NoticeServiceImpl;

@WebServlet("/noticeDetailList.do")
public class NoticeDetailList extends HttpServlet {
private static final long serialVersionUID = 1L;

public NoticeDetailList() {
	super();
}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String noticeNo = req.getParameter("noticeNo");
		
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		
		req.setAttribute("selectNotice", noticeService.selectNotice(noticeNo));
	
		req.getRequestDispatcher("/views/notice/noticeDetailList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	}
}
