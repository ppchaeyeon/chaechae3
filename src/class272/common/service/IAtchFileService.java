package class272.common.service;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import class272.vo.AtchFileVO;

public interface IAtchFileService {
	
	/**
	 * 첨부파일 저장
	 * @param atchFileVO
	 * @return
	 */
	public AtchFileVO saveAtchFileList(Collection<Part> parts) throws Exception;
	
	/**
	 * 첨부파일 목록 조회하기
	 * @param atchFileVO
	 * @return
	 */
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO);
	
	/**
	 * 첨부파일 세부정보 조회하기
	 * @param atchFileVO
	 * @return
	 */
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO);
	
}
