package class272.admin.service;

import java.util.List;
import java.util.Map;

import class272.admin.dao.AdminSalesDaoImpl;
import class272.admin.dao.IAdminSalesDao;
import class272.vo.LibraryVO;

public class AdminSalesServiceImpl implements IAdminSalesService {

	private static IAdminSalesService admSalesService;
	
	private IAdminSalesDao adminSalesDao;
	
	private AdminSalesServiceImpl() {
		adminSalesDao = AdminSalesDaoImpl.getInstance();
	}
	
	public static IAdminSalesService getInstance() {
		if(admSalesService == null) {
			admSalesService = new AdminSalesServiceImpl();
		}
		return admSalesService;
	}
	
	
	@Override
	public List<Map<String, Long>> getMMsales() {
		return adminSalesDao.getMMsales();
	}
}