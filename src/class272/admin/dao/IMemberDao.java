package class272.admin.dao;

import java.util.List;

import class272.vo.MemberVO;

public interface IMemberDao {
	
	/**
	 * 회원상태를 변경하는 메서드 (1: 일반회원 2: 탈퇴회원 3: 블랙회원)
	 * @param memId 상태변경할 회원ID
	 * @return 회원상태변경 성공하면 1, 실패하면 0 반환됨
	 */
	public int changeStateMember(String memId, int memState);
	
	/**
	 * 한명의 회원정보를 가져오기 위한 메서드
	 * @param memId 회원정보 가져올 회원ID
	 * @return 회원정보가 존재하면 MemberVO객체 반환됨
	 */
	public MemberVO getMember(String memId);
	
	/**
	 * 모든 블랙회원을 가져오기 위한 메서드
	 * @return 모든 블랙회원을 담은 List객체
	 */
	public List<MemberVO> getAllBlackMember();
	
	/**
	 * 블랙회원을 제외한 모든 회원정보를 가져오기 위한 메서드
	 * @return 모든 회원정보를 담은 List객체
	 */
	public List<MemberVO> getAllMember();
	
}