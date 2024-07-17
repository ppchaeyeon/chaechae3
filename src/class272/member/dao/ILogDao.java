package class272.member.dao;

import class272.vo.MemberVO;

public interface ILogDao {

	
	/** 로그인 메서드 (회원 정보 get)
	 * 
	 * @param memId 회원정보 가져올 회원ID
	 * @return 회원정보 존재하면 MemberVo 객체 반환, 실패하면 0 반환
	 */
	
	public MemberVO getMember(String memId); 

	
	
	/**
	 * 회원 가입
	 * @param mv : 등록할 회원 정보를 담은 MemberVO 객체
	 * @return 회원 등록 작업이 성공하면 1, 실패하면 0이 반환됨
	 */
	public int SignUpMember(MemberVO mv);
	
	
	
	/** 회원가입시 아이디 중복체크
	 *  회원 정보가 존재하는지 체크하기 위한 메서드
	 * 
	 * @param memId 존재여부 체크할 회원id
	 * @return 회원 정보가 존재하면 true, 존재하지 않으면 false 반환
	 */
	
	public boolean checkMember(String memId); 
	
	
	/**
	 * 아이디 찾는 메서드
	 * @param 회원이름,회원전화번호
	 * @return memId 회원아이디
	 */
	
	public MemberVO SerachId(MemberVO meminfo);
	
	/**
	 * 비밀번호 찾는 메서드
	 * @param 회원아이디,회원이메일
	 * @return memPw 회원비밀번호
	 */
	
	public MemberVO SearchPw(MemberVO meminfo);
}
