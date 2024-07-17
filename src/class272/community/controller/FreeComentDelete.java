package class272.community.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import class272.community.service.FreeComentServiceImpl;
import class272.community.service.IFreeComentService;

@WebServlet("/deletefc.do")
public class FreeComentDelete extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	public FreeComentDelete() {
		super();
	}
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	HttpSession session = req.getSession();
    
    	String comentNo = req.getParameter("comentNo");
    	String freeNo = req.getParameter("freeNo");
    	
    	System.out.print("111>>>>>>>>>>>>>" + comentNo + freeNo);
    	
    	// BoardFreeService 호출
    	IFreeComentService comentService = FreeComentServiceImpl.getInstance();
    	
    	int cnt = 0;
    	try {
			cnt = comentService.comentDelete(comentNo);
		} catch (Exception e) {
			 e.printStackTrace();
		}
    	
		resp.sendRedirect("/Class272/detail.do?freeNo="+freeNo);

    }
}
