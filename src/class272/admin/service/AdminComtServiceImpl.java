package class272.admin.service;

import java.util.List;

import class272.admin.dao.AdminComtDaoImpl;
import class272.admin.dao.IAdminComtDao;
import class272.vo.ComentReportVO;

public class AdminComtServiceImpl implements IAdminComtService  {
	
	private IAdminComtDao admComtDao;
	
	private static AdminComtServiceImpl admComtService;
	
	private AdminComtServiceImpl() {
		admComtDao = AdminComtDaoImpl.getInstance();
	}
	
	public static IAdminComtService getInstance() {
		if(admComtService == null) {
			admComtService = new AdminComtServiceImpl();
		}
		return admComtService;
	}

	@Override
	public List<ComentReportVO> getAllComt() {
		return admComtDao.getAllComt();
	}

	@Override
	public int deletecomt(String crNo) {
		int cnt = admComtDao.deletecomt(crNo);
		return cnt;
	}
	
	

	
}