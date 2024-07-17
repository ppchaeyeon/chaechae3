package class272.library.service;

import java.util.List;

import class272.vo.LibraryVO;

public interface ILibraryService {
	
	/**
	 * 구매내역 추가하는 메서드
	 * @param lv 구매내역 추가할 회원아이디, 강의아이디 담은 LibraryVO 객체
	 * @return 작업 성공시 1, 실패시 0  반환
	 */
	public int addLibrary(LibraryVO lv);
	
	/**
	 * 환불 처리하는 메서드
	 * @param libNo 환불할 구매번호
	 * @return 작업 성공시 1, 실패시 0  반환
	 */
	public int refundLibrary(String libNo);
	
	/**
	 * 해당 수강생의 결제내역을 조회하는 메서드
	 * @param memId 결제내역 조회할 수강생 아이디
	 * @return 해당 수강생의 결제내역정보를 담은 리스트
	 */
	public List<LibraryVO> getMyLibrary(String memId);
	
	/**
	 * 전체 수강생의 환불내역을 조회하는 메서드
	 * @return 전체 수강생의 환불정보 담은 리스트
	 */
	public List<LibraryVO> getAllRefund();
}