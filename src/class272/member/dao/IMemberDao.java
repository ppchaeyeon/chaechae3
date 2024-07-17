package class272.member.dao;

import class272.vo.MemberVO;

public interface IMemberDao {

	
	/** 회원정보 조회
	 * 
	 * @param memId
	 * @return
	 */
	public MemberVO SelectMember(String memId);
	
	/**
	 * 회원 탈퇴
	 * @param memId
	 * @return 성공하면 1
	 */
	public int DeleteMember (String memId);
	
}
