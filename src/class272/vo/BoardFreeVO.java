package class272.vo;

public class BoardFreeVO {
	 private int rnum;
	 private String freeNo;		// 게시글 번호
	 private String freeName;	// 게시글 제목
	 private String freeTime;	// 게시글 작성 시간
	 private String freeCon;    // 게시글 내용
	 private String freeDel;	// 게시글 삭제 유무
	 private int freeType;		// 말머리
	 private int freeReport;	// 신고누적횟수
	 private String memId;		// 회원id
	
	 
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getFreeNo() {
		return freeNo;
	}
	public void setFreeNo(String freeNo) {
		this.freeNo = freeNo;
	}
	public String getFreeName() {
		return freeName;
	}
	public void setFreeName(String freeName) {
		this.freeName = freeName;
	}
	public String getFreeTime() {
		return freeTime;
	}
	public void setFreeTime(String freeTime) {
		this.freeTime = freeTime;
	}
	public String getFreeCon() {
		return freeCon;
	}
	public void setFreeCon(String freeCon) {
		this.freeCon = freeCon;
	}
	public String getFreeDel() {
		return freeDel;
	}
	public void setFreeDel(String freeDel) {
		this.freeDel = freeDel;
	}
	public int getFreeType() {
		return freeType;
	}
	public void setFreeType(int freeType) {
		this.freeType = freeType;
	}
	public int getFreeReport() {
		return freeReport;
	}
	public void setFreeReport(int freeReport) {
		this.freeReport = freeReport;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	@Override
	public String toString() {
		return "BoardFreeVO [rnum=" + rnum + ", freeNo=" + freeNo + ", freeName=" + freeName + ", freeTime=" + freeTime
				+ ", freeCon=" + freeCon + ", freeDel=" + freeDel + ", freeType=" + freeType + ", freeReport="
				+ freeReport + ", memId=" + memId + "]";
	}
	 
	
}

