package class272.membermypage.dao;

import java.util.List;

import class272.vo.CouponVO;

public interface IMyCouponDao {
	
	/**
	 * 해당 회원의 사용가능한 쿠폰을 가져오는 메서드
	 * @return 쿠폰 리스트 객체
	 */
	public List<CouponVO> getMyCoupon(String memId);
}