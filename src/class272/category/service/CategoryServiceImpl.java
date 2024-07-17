package class272.category.service;

import java.util.List;

import class272.category.dao.CategoryDaoImpl;
import class272.category.dao.ICategoryDao;
import class272.vo.CategoryVO;

public class CategoryServiceImpl implements ICategoryService{
	
	private ICategoryDao catDao;
	
	private static ICategoryService catService;
	
	private CategoryServiceImpl() {
		catDao = CategoryDaoImpl.getInstance();
	}
	
	public static ICategoryService getInstance() {
		if(catService == null) {
			catService = new CategoryServiceImpl();
		}
		return catService;
	}

	@Override
	public List<CategoryVO> getAllCategory() {
		return catDao.getAllCategory();
	}

	@Override
	public int addCategory(CategoryVO cv) {
		return catDao.addCategory(cv);
	}

	@Override
	public int updateCategory(CategoryVO cv) {
		return catDao.updateCategory(cv);
	}

	@Override
	public int deleteCategory(String categoryNo) {
		return catDao.deleteCategory(categoryNo);
	}

}
