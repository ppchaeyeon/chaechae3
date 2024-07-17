package class272.category.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import class272.category.service.CategoryServiceImpl;
import class272.category.service.ICategoryService;
import class272.vo.CategoryVO;

@WebServlet("/category/add.do")
public class AddCategoryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BufferedReader reader = req.getReader();
		String readLine = reader.readLine();
		JsonParser parser = new JsonParser();
		JsonArray jsonArr = (JsonArray)parser.parse(readLine);
		
		ICategoryService catService = CategoryServiceImpl.getInstance();
		
		for (int i = 0; i < jsonArr.size(); i++) {
			String categoryName = jsonArr.get(i).getAsString();
			
			CategoryVO cv = new CategoryVO();
			cv.setCategoryName(categoryName);
			
			catService.addCategory(cv);
		};
		
//		resp.sendRedirect(req.getContextPath()+"/category/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}