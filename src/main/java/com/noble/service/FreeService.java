package com.noble.service;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.noble.dao.FreeDAO;
import com.noble.noble.UtilForFile;
import com.noble.vo.CommVO;
import com.noble.vo.CommentsVO;

@Service
public class FreeService {

	private static final Logger logger = LoggerFactory.getLogger(FreeService.class);
	
	@Autowired
	private FreeDAO FreeDAO;
	
	public HashMap<String, Object> getFreeList(Integer page,String hidSearchType,String hidSearchWord){
		if(page == null) {
			page = 1;
		}
		
		int beginRNum = 0;
		int endRNum = 10;
		
		endRNum = page * 10;
		beginRNum = endRNum -10;
		
		logger.info(hidSearchType);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("beginRNum",beginRNum);
		map.put("endRNum",endRNum);
		map.put("hidSearchType",hidSearchType);
		map.put("hidSearchWord",hidSearchWord);

		int totalCnt = FreeDAO.getFreeListCnt(map);
		int pagingEnd = totalCnt/10;
		if(totalCnt % 10>0) {
			pagingEnd++;
		}
		
		List<CommVO> list = FreeDAO.getFreeList(map);
		List<CommVO> listvo = FreeDAO.getFreeBastList(map);
		HashMap<String, Object> response = new HashMap<>(map);
		
		response.put("free_list", list);
		response.put("best_list", listvo);
		response.put("pagingEnd", pagingEnd);
		response.put("hidSearchType", hidSearchType);
		response.put("hidSearchWord", hidSearchWord);
		
		return response;
	}

	public int getInsFreeWrite(CommVO vo) {
		int successCnt = 0;	
		successCnt = FreeDAO.InsFreeWrite(vo); 
		
		return successCnt;
	}

	public HashMap<String, Object> getSelectFreeDetail(CommVO vo) {
		
		FreeDAO.UpdateFreeViewCount(vo);
		
		vo = FreeDAO.getFreeDetail(vo);
		List<CommentsVO> list = FreeDAO.getSelectFreeCommList(vo);
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put("vo", vo);
		response.put("list", list);
		
		return response;
	}

	public String getFreeLike(String comm_no) {
		
		String likeCnt = "";
		
		FreeDAO.getFreeLikeCnt(comm_no);
		likeCnt = FreeDAO.getFreeLikeCntSelect(comm_no);

		return likeCnt;
	}

	public int getDeleteFree(CommVO vo) {
		int successCnt = 0;
		successCnt = FreeDAO.getFreeDelete(vo);
		
		return successCnt;
	}

	public CommVO getBoardFreeModify(CommVO vo) {

		vo = FreeDAO.getFreeModify(vo);
		
		return vo;
	}

	public int getFreeModify(CommVO vo) {

		int successCnt = 0;
		successCnt = FreeDAO.getFreeModifyUpdate(vo);
		
		return successCnt;
	}

	public HashMap<String, Object> getInsFreeComm(CommentsVO vo) {
		int successCnt = 0;
		successCnt = FreeDAO.getInsFreeComments(vo);
		HashMap<String, Object> response = new HashMap<>();
		logger.info(""+successCnt);
		logger.info("getCome_no : "+vo.getCome_no());
			
		if(successCnt>0) {
			vo = FreeDAO.getselectfreecommDetail(vo);
			JSONObject obj = new JSONObject();
			obj.put("user_no", vo.getUser_no());
			obj.put("come_contents", vo.getCome_contents());
			obj.put("come_no", vo.getCome_no());
			obj.put("comm_no", vo.getComm_no());
			obj.put("come_date", vo.getCome_date());
			obj.put("user_id", vo.getUser_id());
			response.put("jsonStr", obj);
		}else {	
			response.put("successCnt", successCnt);
		}	
		
		return response;
	}

	public Object freeFileUpload(String pgfrm, MultipartRequest multiReq) {
		MultipartFile file = multiReq.getFile("upload");
		
		String upFilePath = "";
		String upFileName = "";
		upFilePath = UtilForFile.fileUpByType(file, pgfrm, "tmp");
		upFileName = upFilePath.substring(upFilePath.lastIndexOf("/")+1, upFilePath.length());
		logger.info("/" + upFileName);
		JSONObject json = new JSONObject();
		json.put("uploaded", 1);
		json.put("fileName", upFileName);
		json.put("url", "/" + upFilePath);
		logger.info(""+json);
		return json;
	}
	
	

}
