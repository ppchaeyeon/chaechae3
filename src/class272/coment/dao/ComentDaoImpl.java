package class272.coment.dao;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.ComentVO;

public class ComentDaoImpl implements IComentDao{

	private static IComentDao dao;
	
	private ComentDaoImpl() {}
	private SqlSession session;
	public static IComentDao getInstance() {
		if(dao==null) dao = new ComentDaoImpl();
		return dao;
	}
	
	@Override
	public int comentInsert(ComentVO vo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("qa.qaComentInsert", vo);
			
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
	public int comentDelete(int coNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("qa.qaComentDelete", coNo);
			
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
