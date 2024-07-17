package class272.coupon.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.CouponBoxVO;
import class272.vo.CouponVO;

public class CouponDaoImpl implements ICouponDao{
	
	private static ICouponDao cpDao;
	
	private CouponDaoImpl() {
	}
	
	public static ICouponDao getInstance() {
		if(cpDao == null) {
			cpDao = new CouponDaoImpl();
		}
		return cpDao;
	}
	
	@Override
	public int addCoupon(CouponVO cv) {

		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("coupon.addCoupon", cv);
			
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
	public int addCouponBox(CouponBoxVO cbv) {

		SqlSession session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.insert("coupon.addCouponBox", cbv);
			
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
	public List<CouponVO> getAllCoupon() {

		SqlSession session = MyBatisUtil.getSqlSession(true);

		List<CouponVO> cpList = new ArrayList<CouponVO>();

		try {
			cpList = session.selectList("coupon.getAllCoupon");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cpList;
	}

	@Override
	public List<CouponBoxVO> getAllCouponBox() {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);

		List<CouponBoxVO> cpboxList = new ArrayList<CouponBoxVO>();

		try {
			cpboxList = session.selectList("coupon.getAllCouponBox");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cpboxList;
	}

	@Override
	public int useYCouponBox(CouponBoxVO cbv) {
		
		SqlSession session = MyBatisUtil.getSqlSession();

		int cnt = 0;
		try {
			cnt = session.update("coupon.useYCouponBox", cbv);
			
			if(cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}
}