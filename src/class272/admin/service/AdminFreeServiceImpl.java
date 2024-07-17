package class272.admin.service;

import java.util.List;

import class272.admin.dao.AdminFreeDaoImpl;
import class272.admin.dao.IAdminFreeDao;
import class272.vo.BoardFreeVO;


public class AdminFreeServiceImpl implements IAdminFreeService {
	
	private IAdminFreeDao admFreeDao;
	
	private static AdminFreeServiceImpl admFreeService;
	
	private AdminFreeServiceImpl() {
		admFreeDao = AdminFreeDaoImpl.getInstance();
	}
	
	public static IAdminFreeService getInstance() {
		if(admFreeService == null) {
			admFreeService = new AdminFreeServiceImpl();
		}
		return admFreeService;
	}

	@Override
	public List<BoardFreeVO> getAllReport() {
		return admFreeDao.getAllReport();
	}

	@Override
	public int changeStateDel(String freeNo) {
		int cnt = admFreeDao.changeStateDel(freeNo, "Y");
		return cnt;
	}
	
	
}