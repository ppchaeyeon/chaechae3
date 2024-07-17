package class272.category.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.CategoryVO;

public class CategoryDaoImpl implements ICategoryDao{
	
	private static ICategoryDao catDao;
	
	private CategoryDaoImpl() {
	}
	
	public static ICategoryDao getInstance() {
		if(catDao == null) {
			catDao = new CategoryDaoImpl();
		}
		return catDao;
	}

	@Override
	public List<CategoryVO> getAllCategory() {

		SqlSession session = MyBatisUtil.getSqlSession(true);

		List<CategoryVO> catList = new ArrayList<CategoryVO>();

		try {
			catList = session.selectList("category.getAllCategory");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return catList;
	}

	@Override
	public int addCategory(CategoryVO cv) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("category.addCategory", cv);
			
			if(cnt > 0) {
				session.commit();
			}
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateCategory(CategoryVO cv) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.update("category.updateCategory", cv);
			
			if(cnt > 0) {
				session.commit();
			}
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteCategory(String categoryNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.delete("category.deleteCategory", categoryNo);
			
			if(cnt > 0) {
				session.commit();
			}
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

}