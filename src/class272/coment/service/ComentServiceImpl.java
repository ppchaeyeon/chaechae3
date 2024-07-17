package class272.coment.service;
import class272.coment.dao.ComentDaoImpl;
import class272.coment.dao.IComentDao;
import class272.vo.ComentVO;

public class ComentServiceImpl implements IComentService{

	private IComentDao dao;
	
	private static IComentService service;
	private ComentServiceImpl() {
		dao =  ComentDaoImpl.getInstance();
	}
	public static IComentService getInstance() {
		if(service==null) service = new ComentServiceImpl();
		return service;
	}
	
	@Override
	public int comentInsert(ComentVO vo) {
		 return dao.comentInsert(vo);
	}


	@Override
	public int comentDelete(int coNo) {
		return dao.comentDelete(coNo);
	}
	
}
