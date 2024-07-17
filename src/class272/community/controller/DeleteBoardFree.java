package class272.community.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import class272.community.service.BoardFreeServiceImpl;
import class272.community.service.IBoardFreeService;
import class272.vo.BoardFreeVO;

@WebServlet("/deleteBoard.do")
public class DeleteBoardFree extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		// JSON으로 요청 받음
		BufferedReader reader = req.getReader();
		String data = reader.readLine();
		
		System.out.println("1111>>>>" + data);
		
		JsonParser parser = new JsonParser();
		JsonObject jsonObj = (JsonObject)parser.parse(data);
		
		System.out.println("2222>>>>" + jsonObj.get("freeNo").getAsString());
		
		
		// 폼 데이터 추출
		String freeNo = jsonObj.get("freeNo").getAsString();
		
		System.out.println("=============================="+freeNo);
		// BoardFreeService 호출
		IBoardFreeService freeService = BoardFreeServiceImpl.getInstance();
		int cnt = 0;
		try {
			cnt = freeService.deleteFree(freeNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		resp.sendRedirect("/Class272/community.do");
		PrintWriter writer = resp.getWriter();
		writer.print(cnt);
	}
	
}
