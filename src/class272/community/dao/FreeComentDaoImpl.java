package class272.community.dao;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.ComentReportVO;
import class272.vo.ComentVO;

public class FreeComentDaoImpl implements IFreeComentDao{

	private static IFreeComentDao fdao;
	
	private FreeComentDaoImpl() {}
	private SqlSession session;
	public static IFreeComentDao getInstance() {
		if(fdao==null) fdao = new FreeComentDaoImpl();
		return fdao;
	}
	
	// free댓글 입력
	@Override
	public int comentInsert(ComentVO vo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("free.freeComentInsert", vo);
			
			if(cnt > 0) {
				session.commit();
			}
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}
	
	// free댓글 삭제
	@Override
	public int comentDelete(String comentNo) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("free.deleteComentFree",comentNo);
			if(cnt > 0) session.commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}


	@Override
	public int comentReport(ComentReportVO crv) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("free.reportComentFree", crv);
			if(cnt > 0) session.commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

}
