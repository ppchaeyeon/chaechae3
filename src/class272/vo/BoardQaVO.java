package class272.vo;

public class BoardQaVO {
	 private String qaNo;		// 문의게시글번호
	 private String qaName;		// 문의게시글제목
	 private String qaTime;		// 문의게시글작성시간
	 private String qaCon;		// 문의게시글내용
	 private String qaDel;		// 문의게시글삭제
	 private int qaReport;		// 문의게시글신고
	 private String memId;		// 회원아이디 (FK)
	
	 
	public String getQaNo() {
		return qaNo;
	}
	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
	}
	public String getQaName() {
		return qaName;
	}
	public void setQaName(String qaName) {
		this.qaName = qaName;
	}
	public String getQaTime() {
		return qaTime;
	}
	public void setQaTime(String qaTime) {
		this.qaTime = qaTime;
	}
	public String getQaCon() {
		return qaCon;
	}
	public void setQaCon(String qaCon) {
		this.qaCon = qaCon;
	}
	public String getQaDel() {
		return qaDel;
	}
	public void setQaDel(String qaDel) {
		this.qaDel = qaDel;
	}
	public int getQaReport() {
		return qaReport;
	}
	public void setQaReport(int qaReport) {
		this.qaReport = qaReport;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	 
	 
}
