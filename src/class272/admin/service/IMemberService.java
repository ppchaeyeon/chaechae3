package class272.admin.service;

import java.util.List;

import class272.vo.MemberVO;

public interface IMemberService {
	
	/**
	 * 한명의 회원정보를 가져오는 메서드
	 * @param memId 회원정보 가져올 회원ID
	 * @return 회원정보가 존재하면 MemberVO객체 반환됨
	 */
	public MemberVO getMember(String memId);
	
	/**
	 * 블랙회원을 제외한 모든 일반회원 정보를 가져오는 메서드
	 * @return 모든 회원정보를 담은 List객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 모든 블랙회원 정보를 가져오는 메서드
	 * @return 모든 블랙회원 정보를 담은 List객체
	 */
	public List<MemberVO> getAllBlackMember();
	
	/**
	 * 회원 블랙리스트 등록(= 일반회원 > 블랙회원,3)
	 * @param memId 블랙리스트 처리할 회원ID
	 * @return 처리 성공하면 1, 실패하면 0 반환됨
	 */
	public int blackMember(String memId);
	
	/**
	 * 회원 블랙리스트 해제 (= 일반회원으로 전환,1)
	 * @param memId 블랙리스트 해제할 회원ID
	 * @return 처리 성공하면 1, 실패하면 0 반환됨
	 */
	public int unblackMember(String memId);
	
	/**
	 * 회원 탈퇴 등록(= 일반회원 > 탈퇴회원,2)
	 * @param memId 탈퇴처리할 회원ID
	 * @return
	 */
	public int OutMember(String memId);
	

}