package class272.member.service;

import class272.vo.MemberVO;

public interface IMemberService {

	/** 회원정보 조회
	 * 
	 * @param memId
	 * @return
	 */
	public MemberVO SelectMember(String memId);

	/**
	 *  회원 탈퇴
	 */
	public int DeleteMember(String memId);

}


