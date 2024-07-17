package class272.vo;

public class LibraryVO {
	private String memId;
	private String corId;
	private String libNo;
	private String libBuydate;
	private String libRefund;
	private int corPrice;
	private int finPrice;
	private String corName;

	public String getCorName() {
		return corName;
	}
	public void setCorName(String corName) {
		this.corName = corName;
	}
	public int getCorPrice() {
		return corPrice;
	}
	public void setCorPrice(int corPrice) {
		this.corPrice = corPrice;
	}
	public int getFinPrice() {
		return finPrice;
	}
	public void setFinPrice(int finPrice) {
		this.finPrice = finPrice;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getCorId() {
		return corId;
	}
	public void setCorId(String corId) {
		this.corId = corId;
	}
	public String getLibNo() {
		return libNo;
	}
	public void setLibNo(String libNo) {
		this.libNo = libNo;
	}
	public String getLibBuydate() {
		return libBuydate;
	}
	public void setLibBuydate(String libBuydate) {
		this.libBuydate = libBuydate;
	}
	public String getLibRefund() {
		return libRefund;
	}
	public void setLibRefund(String libRefund) {
		this.libRefund = libRefund;
	}
	@Override
	public String toString() {
		return "LibraryVO [memId=" + memId + ", corId=" + corId + ", libNo=" + libNo + ", libBuydate=" + libBuydate
				+ ", libRefund=" + libRefund + ", corPrice=" + corPrice + ", finPrice=" + finPrice + ", corName="
				+ corName + "]";
	}
	
}