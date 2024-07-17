package class272.vo;

public class CategoryVO {
	private String categoryNo;
	private String categoryName;
	private int rownum;

	public CategoryVO() {
	}
	
	public CategoryVO(String categoryNo, String categoryName, int rownum) {
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.rownum = rownum;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	@Override
	public String toString() {
		return "CategoryVO [categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", rownum=" + rownum + "]";
	}

}