package class272.membermypage.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import class272.util.MyBatisUtil;
import class272.vo.CouponVO;

public class MyCouponDaoImpl implements IMyCouponDao{

	private static IMyCouponDao mycpDao;
	
	private MyCouponDaoImpl() {
	}
	
	public static IMyCouponDao getInstance() {
		if(mycpDao == null) {
			mycpDao = new MyCouponDaoImpl();
		}
		return mycpDao;
	}
	
	@Override
	public List<CouponVO> getMyCoupon(String memId) {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);

		List<CouponVO> mycpList = new ArrayList<CouponVO>();

		try {
			mycpList = session.selectList("coupon.getMyCoupon", memId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return mycpList;
	}
}