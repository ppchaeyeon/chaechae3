package class272.vo;

public class CourseVO {
	 private String corId;
	 private String corName;
	 private String corCon;
	 private String corCuri;
	 private String corDate;
	 private int corStd;
	 private int corPrice;
	 private String corDel;
	 private String memId;
	 private String categoryNo;
	 private int atchFileId;
	 private String memName;
	 private int sum;
	 private String month;
	 
	 public CourseVO() {
	}
	 
	public CourseVO(String corName, String corCon, String corCuri, int corPrice, String memId, String categoryNo) {
		this.corName = corName;
		this.corCon = corCon;
		this.corCuri = corCuri;
		this.corPrice = corPrice;
		this.memId = memId;
		this.categoryNo = categoryNo;
	}

	
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCorId() {
		return corId;
	}
	public void setCorId(String corId) {
		this.corId = corId;
	}
	public String getCorName() {
		return corName;
	}
	public void setCorName(String corName) {
		this.corName = corName;
	}
	public String getCorCon() {
		return corCon;
	}
	public void setCorCon(String corCon) {
		this.corCon = corCon;
	}
	public String getCorCuri() {
		return corCuri;
	}
	public void setCorCuri(String corCuri) {
		this.corCuri = corCuri;
	}
	public String getCorDate() {
		return corDate;
	}
	public void setCorDate(String corDate) {
		this.corDate = corDate;
	}
	public int getCorStd() {
		return corStd;
	}
	public void setCorStd(int corStd) {
		this.corStd = corStd;
	}
	public int getCorPrice() {
		return corPrice;
	}
	public void setCorPrice(int corPrice) {
		this.corPrice = corPrice;
	}
	public String getCorDel() {
		return corDel;
	}
	public void setCorDel(String corDel) {
		this.corDel = corDel;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public int getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(int atchFileId) {
		this.atchFileId = atchFileId;
	}

	@Override
	public String toString() {
		return "CourseVO [corId=" + corId + ", corName=" + corName + ", corCon=" + corCon + ", corCuri=" + corCuri
				+ ", corDate=" + corDate + ", corStd=" + corStd + ", corPrice=" + corPrice + ", corDel=" + corDel
				+ ", memId=" + memId + ", categoryNo=" + categoryNo + ", atchFileId=" + atchFileId + "]";
	}
	 
	 
}
