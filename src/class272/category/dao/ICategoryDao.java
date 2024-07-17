package class272.category.dao;

import java.util.List;

import class272.vo.CategoryVO;

public interface ICategoryDao {
	
	/**
	 * 모든 카테고리를 가져오는 메서드
	 * @return 모든 카테고리를 담은 List객체
	 */
	public List<CategoryVO> getAllCategory();
	
	/**
	 * 카테고리 추가하는 메서드
	 * @param cv 새로 생성할 카테고리 정보 담은 CategoryVO객체
	 * @return 작업 성공시 1, 실패시 0  반환
	 */
	public int addCategory(CategoryVO cv);
	
	/**
	 * 카테고리 수정하는 메서드
	 * @param cv 수정할 카테고리 정보 담은 CategoryVO객체
	 * @return 작업 성공시 1, 실패시 0  반환
	 */
	public int updateCategory(CategoryVO cv);
	
	/**
	 * 카테고리 삭제하는 메서드
	 * @param categoryNo 삭제할 카테고리 번호
	 * @return 작업 성공시 1, 실패시 0  반환
	 */
	public int deleteCategory(String categoryNo);
}