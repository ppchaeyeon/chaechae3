package class272.membermypage.service;

import java.util.List;

import class272.membermypage.dao.IMyCouponDao;
import class272.membermypage.dao.MyCouponDaoImpl;
import class272.vo.CouponVO;

public class MyCouponServiceImpl implements IMyCouponService{

	private IMyCouponDao mycpDao;
	
	private static IMyCouponService mycpService;
	
	private MyCouponServiceImpl() {
		mycpDao = MyCouponDaoImpl.getInstance();
	}
	
	public static IMyCouponService getInstance() {
		if(mycpService == null) {
			mycpService = new MyCouponServiceImpl();
		}
		return mycpService;
	}
	
	@Override
	public List<CouponVO> getMyCoupon(String memId) {
		return mycpDao.getMyCoupon(memId);
	}
}