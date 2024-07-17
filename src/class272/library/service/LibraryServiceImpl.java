package class272.library.service;

import java.util.List;

import class272.library.dao.ILibraryDao;
import class272.library.dao.LibraryDaoImpl;
import class272.vo.LibraryVO;

public class LibraryServiceImpl implements ILibraryService{
	
	private ILibraryDao libDao;
	
	private static ILibraryService libService;
	
	private LibraryServiceImpl() {
		libDao = LibraryDaoImpl.getInstance();
	}
	
	public static ILibraryService getInstance() {
		if(libService == null) {
			libService = new LibraryServiceImpl();
		}
		return libService;
	}

	@Override
	public int addLibrary(LibraryVO lv) {
		return libDao.addLibrary(lv);
	}

	@Override
	public int refundLibrary(String libNo) {
		return libDao.refundLibrary(libNo);
	}

	@Override
	public List<LibraryVO> getMyLibrary(String memId) {
		return libDao.getMyLibrary(memId);
	}

	@Override
	public List<LibraryVO> getAllRefund() {
		return libDao.getAllRefund();
	}
}