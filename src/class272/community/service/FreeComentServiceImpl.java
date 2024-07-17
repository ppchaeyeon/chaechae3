package class272.community.service;
import class272.community.dao.FreeComentDaoImpl;
import class272.community.dao.IFreeComentDao;
import class272.vo.ComentReportVO;
import class272.vo.ComentVO;

public class FreeComentServiceImpl implements IFreeComentService{

	private IFreeComentDao fdao;
	
	private static IFreeComentService service;
	private FreeComentServiceImpl() {
		fdao =  FreeComentDaoImpl.getInstance();
	}
	
	
	public static IFreeComentService getInstance() {
		if(service==null) service = new FreeComentServiceImpl();
		return service;
	}
	
	
	@Override
	public int comentInsert(ComentVO vo) {
		 return fdao.comentInsert(vo);
	}


	@Override
	public int comentDelete(String comentNo) {
		return fdao.comentDelete(comentNo);
	}
	
	
	@Override
	public int comentReport(ComentReportVO crv) {
		return fdao.comentReport(crv);
	}
	
}
