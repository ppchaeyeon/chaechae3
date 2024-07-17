package class272.common.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import class272.common.service.AtchFileServiceimpl;
import class272.common.service.IAtchFileService;
import class272.vo.AtchFileVO;

@WebServlet("/download.do")
public class downloadController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		long atchFileId = req.getParameter("fileId") == null ? -1 : Long.parseLong(req.getParameter("fileId"));
		int fileSn = req.getParameter("fileSn") == null ? -1 : Integer.valueOf(req.getParameter("fileSn"));
		
		// 파일 상세정보 조회
		IAtchFileService fileService = AtchFileServiceimpl.getInstance();
		
		AtchFileVO atchFileVO = new AtchFileVO();
		atchFileVO.setAtchFileId(atchFileId);
		atchFileVO.setFileSn(fileSn);
		
		atchFileVO = fileService.getAtchFileDetail(atchFileVO);
		
		/////////////////////////////////////////////////////////
		
		// 파일 다운로드처리를 위한 응답헤더 정보 설정하기
				// URL에는 공백문자를 포함할 수 없다. URLEncoding을 이용하여 인코딩 작업을 하면
				// 공백문자는 (+)로 표시되기 때문에 + 문자를 공백문자인 %20으로 바꿔준다.
				
				resp.setContentType("application/octet-stream");
				resp.setHeader("Content-Disposition", "attachment; filename=\""
						+URLEncoder.encode(atchFileVO.getOrignlFileNm(),"utf-8").replaceAll("\\+","%20")
						+"\"");
				
				BufferedInputStream bis = 
						new BufferedInputStream(
								new FileInputStream(atchFileVO.getFileStreCours()));
				
				BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
				
				int data =0;
				while((data = bis.read()) != -1) {
					
					bos.write(data);
				}
				
				bis.close();
				bos.close();
				
			}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
