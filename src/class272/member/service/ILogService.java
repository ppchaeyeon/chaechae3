package class272.member.service;

import java.util.Map;

import class272.vo.MemberVO;

public interface ILogService {

	/**
	 * 로그인 메서드 (회원 상세정보 get)
	 * @param memId 상세정보를 가져올 회원id
	 * @return 상세회원정보를 담은 MemberVo객체
	 */
	public MemberVO getMember(String memId);
	
	
	/**
	 * 로그인 id/pw 검증
	 * @param map
	 * @return
	 */
	public String loginCheck(Map<String, Object> map);
	
	
	/**회원 정보가 존재하는지 체크하기 위한 메서드
	 * @param memId 존재여부 체크할 회원id
	 * @return 회원정보가 존재하면 true, 존재하지 않으면 false 반환
	 */
	public boolean checkMember(String memId); 
	
	/**
	 * 아이디 찾는 메서드
	 * @param memName, memTel
	 * @return memId 회원아이디
	 */
	
	public MemberVO SearchId(MemberVO meminfo);
	
	/**
	 * 비밀번호 찾는 메서드
	 * @param memId, memMail
	 * @return memPw 회원비밀번호
	 */
	
	public MemberVO SearchPw(MemberVO meminfo);
	
	
}
