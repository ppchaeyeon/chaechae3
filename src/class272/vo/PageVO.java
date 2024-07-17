package class272.vo;

public class PageVO {
	
	private int start;
	private int end;
	private int page = 1;
	
	private int startPage;
	private int endPage;
	private int totalPage;
	private int count;
	
	private static int perList = 3; // 한 페이지에 보여질 항목 수
	private static int perPage = 2; // 한 번에 보여질 페이지 수
	
	// 페이지 번호 설정
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	// 시작 항목 인덱스 반환
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	// 끝 항목 인덱스 반환
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	// 시작 페이지 반환
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	// 끝 페이지 반환
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	// 총 페이지 수 반환
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	// 항목 총 개수 반환
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	// 한 페이지에 보여질 항목 수 반환
	public static int getPerList() {
		return perList;
	}
	
	public static void setPerList(int perList) {
		PageVO.perList = perList;
	}
	
	// 한 번에 보여질 페이지 수 반환
	public static int getPerPage() {
		return perPage;
	}
	
	public static void setPerPage(int perPage) {
		PageVO.perPage = perPage;
	}
}