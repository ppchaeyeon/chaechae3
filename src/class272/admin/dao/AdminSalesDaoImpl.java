package class272.admin.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.LibraryVO;

public class AdminSalesDaoImpl implements IAdminSalesDao  {
	
	private static IAdminSalesDao adminSalesDao;
	
	private AdminSalesDaoImpl() {
	}
	
	public static IAdminSalesDao getInstance() {
		if(adminSalesDao == null) {
			adminSalesDao = new AdminSalesDaoImpl();
		}
		return adminSalesDao;
	}

	@Override
	public List<Map<String, Long>> getMMsales() {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		List<Map<String, Long>> libList = new ArrayList<Map<String, Long>>();
		
		try {
			libList = session.selectList("adminsales.getMMsales");
//			System.out.println(memList);
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return libList;
	}
}