package class272.coupon.service;

import java.util.List;

import class272.coupon.dao.CouponDaoImpl;
import class272.coupon.dao.ICouponDao;
import class272.vo.CouponBoxVO;
import class272.vo.CouponVO;

public class CouponServiceImpl implements ICouponService{
	
	private static ICouponService cpService;
	
	private ICouponDao cpDao;
	
	private CouponServiceImpl() {
		cpDao = CouponDaoImpl.getInstance();
	}
	
	public static ICouponService getInstance() {
		if(cpService == null) {
			cpService = new CouponServiceImpl();
		}
		return cpService;
	}

	@Override
	public int addCoupon(CouponVO cv) {
		return cpDao.addCoupon(cv);
	}

	@Override
	public int addCouponBox(CouponBoxVO cbv) {
		return cpDao.addCouponBox(cbv);
	}

	@Override
	public List<CouponVO> getAllCoupon() {
		return cpDao.getAllCoupon();
	}

	@Override
	public List<CouponBoxVO> getAllCouponBox() {
		return cpDao.getAllCouponBox();
	}

	@Override
	public int useYCouponBox(CouponBoxVO cbv) {
		return cpDao.useYCouponBox(cbv);
	}
}