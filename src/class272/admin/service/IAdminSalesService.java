package class272.admin.service;

import java.util.List;
import java.util.Map;

import class272.vo.LibraryVO;

public interface IAdminSalesService {
	
		
		/**
		 * 모든 매출을 조회하는 메서드
		 * @return 모든 매출현황을 담은 List 객체
		 */
		public List<Map<String, Long>> getMMsales();
		
}