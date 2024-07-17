package class272.vo;

import java.time.LocalDate;

public class MemberVO {
	
	private String memId;		// 아이디
	private String memPw;		// 비밀번호
	private String memName;		// 이름
	private String memMail;		// 이메일
	private String memAddr;		// 주소
	private String memAddr2;	// 상세주소
	private LocalDate memBir;	// 생년월일
	private String memGender;	// 성별
	private String memTel;		// 핸드폰번호
	private int memGubun;		// 구분코드	1 수강생	2 강사 	3 관리자
	private int memState;		// 회원상태	1 회원 	2 탈퇴회원 3 블랙리스트    관리자만수정가능
	
	public MemberVO() {
	}
	
	public MemberVO(String memId, int memState) {
		this.memId = memId;
		this.memState = memState;
	}

	public MemberVO(String memId, String memPw, String memName, String memMail, String memAddr, String memAddr2,
			LocalDate memBir, String memGender, String memTel, int memGubun, int memState) {
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memMail = memMail;
		this.memAddr = memAddr;
		this.memAddr2 = memAddr2;
		this.memBir = memBir;
		this.memGender = memGender;
		this.memTel = memTel;
		this.memGubun = memGubun;
		this.memState = memState;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public String getMemAddr2() {
		return memAddr2;
	}

	public void setMemAddr2(String memAddr2) {
		this.memAddr2 = memAddr2;
	}

	public LocalDate getMemBir() {
		return memBir;
	}

	public void setMemBir(LocalDate memBir) {
		this.memBir = memBir;
	}

	public String getMemGender() {
		return memGender;
	}

	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public int getMemGubun() {
		return memGubun;
	}

	public void setMemGubun(int memGubun) {
		this.memGubun = memGubun;
	}

	public int getMemState() {
		return memState;
	}

	public void setMemState(int memState) {
		this.memState = memState;
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + ", memMail=" + memMail
				+ ", memAddr=" + memAddr + ", memAddr2=" + memAddr2 + ", memBir=" + memBir + ", memGender=" + memGender
				+ ", memTel=" + memTel + ", memGubun=" + memGubun + ", memState=" + memState + "]";
	}

}