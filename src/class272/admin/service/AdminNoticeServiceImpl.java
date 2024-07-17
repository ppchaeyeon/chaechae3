package class272.admin.service;

import java.util.List;

import class272.admin.dao.AdminNoticeDaoImpl;
import class272.admin.dao.IAdminNoticeDao;
import class272.vo.BoardNoticeVO;

public class AdminNoticeServiceImpl implements IAdminNoticeService {
	
	private IAdminNoticeDao adminNoDao;
	
	private static AdminNoticeServiceImpl adminNoService;
	
	private AdminNoticeServiceImpl() {
		adminNoDao = AdminNoticeDaoImpl.getInstance();
	}
	
	public static IAdminNoticeService getInstance() {
		if(adminNoService == null) {
			adminNoService = new AdminNoticeServiceImpl();
		}
		return adminNoService;
	}

	@Override
	public List<BoardNoticeVO> getAllNotice() {
		return adminNoDao.getAllNotice();
	}

	@Override
	public int addNotice(BoardNoticeVO nv) {
		return adminNoDao.addNotice(nv);
	}

	@Override
	public int changeDelNotice(String noticeNo) {
		int cnt = adminNoDao.changeDelNotice(noticeNo);
		return cnt;
	}

	@Override
	public int updateNotice(BoardNoticeVO nv) {
		return adminNoDao.updateNotice(nv);
	}

	
}