package class272.coupon.dao;

import java.util.List;

import class272.vo.CouponBoxVO;
import class272.vo.CouponVO;

public interface ICouponDao {
	
	/**
	 * 모든 쿠폰종류 리스트 가져오는 메서드
	 * @return 모든 쿠폰 담은 List객체
	 */
	public List<CouponVO> getAllCoupon();
	
	/**
	 * 쿠폰종류 추가하는 메서드
	 * @param cv 추가할 쿠폰의 정보를 담은 CouponVO 객체
	 * @return 작업 성공시 1, 실패시 0  반환
	 */
	public int addCoupon(CouponVO cv);
	
	/**
	 * 회원에게 쿠폰 발급하는 메서드
	 * @param cbv 발급할 회원과 쿠폰번호를 담은 CouponBoxVO 객체
	 * @return 작업 성공시 1, 실패시 0  반환
	 */
	public int addCouponBox(CouponBoxVO cbv);
	
	/**
	 * 수강생 보유 쿠폰 사용완료 처리하는 메서드
	 * @param cbv 사용완료처리할 쿠폰번호와 해당 수강생아이디를 담은 CouponBoxVO 객체
	 * @return 작업 성공시 1, 실패시 0  반환
	 */
	public int useYCouponBox(CouponBoxVO cbv);
	
	/**
	 * 모든 쿠폰발급 리스트 가져오는 메서드
	 * @return 모든 쿠폰발급정보 담은 List객체
	 */
	public List<CouponBoxVO> getAllCouponBox();
}