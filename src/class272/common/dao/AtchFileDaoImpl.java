package class272.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.AtchFileVO;

public class AtchFileDaoImpl implements IAtchFileDao{

	private static IAtchFileDao fileDao;
	
	private AtchFileDaoImpl() {
	}
	
	public static IAtchFileDao getInstance() {
		if(fileDao == null) {
			fileDao = new AtchFileDaoImpl();
		}
		return fileDao;
	}
	
	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt =0;
		try {
			cnt = session.insert("atchFile.insertAtchFile",atchFileVO);
			if(cnt>0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int insertAtchFileDetail(AtchFileVO atchFileVO) {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("atchFile.insertAtchFileDetail",atchFileVO);
			
			if(cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		List<AtchFileVO> atchFileList = new ArrayList<AtchFileVO>();
		
		try {
			
			atchFileList = session.selectList("atchFile.getAtchFileList",atchFileVO);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return atchFileList;
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		
		AtchFileVO fileVO = null;
		SqlSession session = MyBatisUtil.getSqlSession(true);
		try {
			fileVO = session.selectOne("atchFile.getAtchFileDetail",atchFileVO);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return fileVO;
	}

}
