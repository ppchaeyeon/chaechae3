package class272.vo;

public class ComentVO {
	 private int comentNo;
	 private String comentCon;
	 private String freeNo;
	 private String qaNo;
	 private String cqaNo;
	 private String memId;
	
	 public int getComentNo() {
		return comentNo;
	}
	public void setComentNo(int comentNo) {
		this.comentNo = comentNo;
	}
	public String getComentCon() {
		return comentCon;
	}
	public void setComentCon(String comentCon) {
		this.comentCon = comentCon;
	}
	public String getFreeNo() {
		return freeNo;
	}
	public void setFreeNo(String freeNo) {
		this.freeNo = freeNo;
	}
	public String getQaNo() {
		return qaNo;
	}
	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
	}
	public String getCqaNo() {
		return cqaNo;
	}
	public void setCqaNo(String cqaNo) {
		this.cqaNo = cqaNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	@Override
	public String toString() {
		return "ComentVO [comentNo=" + comentNo + ", comentCon=" + comentCon + ", freeNo=" + freeNo + ", qaNo=" + qaNo
				+ ", cqaNo=" + cqaNo + ", memId=" + memId + "]";
	}
	 
	 
	 
}
