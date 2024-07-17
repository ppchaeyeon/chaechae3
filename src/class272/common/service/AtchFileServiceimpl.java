package class272.common.service;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import class272.common.dao.AtchFileDaoImpl;
import class272.common.dao.IAtchFileDao;
import class272.vo.AtchFileVO;

public class AtchFileServiceimpl implements IAtchFileService{
	private static IAtchFileService fileService;
	private static IAtchFileDao fileDao;
	private AtchFileServiceimpl() {
		fileDao = AtchFileDaoImpl.getInstance();
	}

	public static IAtchFileService getInstance() {
		if(fileService == null) {
			fileService = new AtchFileServiceimpl();
		}
		return fileService;
	}
	
	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) {
		return fileDao.getAtchFileList(atchFileVO);
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		return fileDao.getAtchFileDetail(atchFileVO);
	}

	@Override
	public AtchFileVO saveAtchFileList(Collection<Part> parts) throws Exception {

		String uploadPath = "d:/D_Other/upload_files";
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		AtchFileVO atchFileVO = null;
		
		boolean isFirstFile = true; // 첫번째 파일인지 체크
		
		for(Part part : parts) {
			
			System.out.println("Content-Disposition =>"+part.getHeader("Content-Disposition"));
			
			String fileName = part.getSubmittedFileName(); // 전송된 파일명 가져오기
			
			if(fileName != null && !fileName.equals("")) {
				// 폼필드가 아니거나 파일명이 존재하는 경우...(첨부파일이 존재하는 경우...)
				
				if(isFirstFile) {	// 첫번째 첨부파일 인 경우...
					
					isFirstFile = false;
					
					// 기본 첨부파일 정보 저장
					atchFileVO = new AtchFileVO();
					fileDao.insertAtchFile(atchFileVO);
				}
				
				///////////////////////////////////////////////////////////
				
				String orignFileName = fileName; // 원본 파일명
				long fileSize = part.getSize();  // 파일 크기
				String saveFileName = ""; 		// 저장 파일명
				String saveFilePath = "";		// 저장 파일 경로
				
				saveFileName = UUID.randomUUID().toString().replace("-", "");
				saveFilePath = uploadPath + "/" + saveFileName;
				
				// 확장자 추출하기
				String fileExtension = orignFileName.lastIndexOf(".") < 0 ? ""
						: orignFileName.substring(orignFileName.lastIndexOf(".")+1);
				
				part.write(saveFilePath); // 파일 저장
			 	
				atchFileVO.setFileStreCours(saveFilePath);
				atchFileVO.setStreFileNm(saveFileName);
				atchFileVO.setOrignlFileNm(orignFileName);
				atchFileVO.setFileExtsn(fileExtension);
				atchFileVO.setFileSize(fileSize);
				atchFileVO.setFileCn("");
				
				// 첨부파일 세부정보 저장
				fileDao.insertAtchFileDetail(atchFileVO);
				
				part.delete(); // 임시 업로드 파일 삭제하기
			}
		}
		
		return atchFileVO;
	}

}
