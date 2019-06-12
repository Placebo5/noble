package com.noble.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;	
import org.springframework.web.multipart.MultipartRequest;

import com.noble.dao.PotoDAO;
import com.noble.noble.UtilForFile;
import com.noble.noble.UtilForSession;
import com.noble.vo.CommVO;
import com.noble.vo.CommentsVO;
import com.noble.vo.UserselVO;

@Service
public class PotoService {

	private static final Logger logger = LoggerFactory.getLogger(PotoService.class);
	
	@Autowired
	private PotoDAO dao;

	public HashMap<String, Object> getpotoList(String page, String hidSearchType, String hidSearchWord) {
		
		int beginRNum = 0;
		int endRNum = 12;
		if(!(page == null) && !page.equals("")) {
			endRNum = Integer.parseInt(page) * 12;
			beginRNum = endRNum - 12;
		} else {
			page = "1";
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("beginRNum",beginRNum);
		map.put("endRNum",endRNum);
		map.put("hidSearchType",hidSearchType);
		map.put("hidSearchWord",hidSearchWord);
		
		List<CommVO> list = dao.getpotoList(map);
		List<CommVO> listvo = dao.getToppotoList(map);
		
		int totalCnt = dao.getpotoListCnt(map);
		
		int pagingEnd = totalCnt/12;
		if(totalCnt % 12>0) {
			pagingEnd++;
		}
		
		HashMap<String, Object> response = new HashMap<>(map);
		
		response.put("potolist", list);
		response.put("best_list", listvo);
		response.put("pagingEnd", pagingEnd);
		response.put("hidSearchType", hidSearchType);
		response.put("hidSearchWord", hidSearchWord);
		
		return response;
	}

//	@Transactional(propagation = Propagation.REQUIRED)
	public int InsertpotoWrite(CommVO vo, MultipartRequest multipartRequest, HttpSession session) {
		int successCnt = 0;
		if(UtilForSession.chkSession(session) == false) {
			return successCnt;
		}
		if(vo.getComm_contents().indexOf(',') == 0) {
			vo.setComm_contents(vo.getComm_contents().substring(1, vo.getComm_contents().length()));
		}		
		
		successCnt = dao.Insertpoto(vo);
		if(successCnt == 0) {
			return successCnt;
		}
		//////////////////////////////////file start
		String upFilePath = "";
		MultipartFile file = multipartRequest.getFile("fileat_nm");
		logger.info("file : "+file);
		if(file.getOriginalFilename() !=null && file.getOriginalFilename().length() > 0) {
			upFilePath = UtilForFile.fileUpByType(file, "poto", vo.getComm_no());
			vo.setFileat(upFilePath);
		}//if
		//////////////////////////////////file end
		//////////////////////////////////ck file start
		int ckFlag = 0;
		if(vo.getComm_contents().indexOf("src=\"") > 0) {
			UtilForFile.tmpPathToRealPath(vo.getComm_contents(), vo.getComm_no());
			ckFlag++;
		}
		//////////////////////////////////ck file end
		 
		if(upFilePath.length() > 0 || ckFlag > 0) {
			successCnt = dao.UpInspotoWrite(vo);
		}

		return successCnt;
	}

	public Object potoFileUpload(String pgfrm, MultipartRequest multiReq) {
		
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

	public HashMap<String, Object> potoDetail(CommVO vo) {
	
		dao.UpdatepotoViewCnt(vo);
		vo = dao.selectpotoDetail(vo);
		List<CommentsVO> list = dao.getfreecommList(vo);
		
		HashMap<String, Object> response = new HashMap<>();
		
		response.put("poro_detail_vo", vo);
		response.put("reply_list", list);
		return response;
	}

	public String potoLikeCnt(String comm_no) {
		
		String likeCnt = "";

		dao.UpDatepotoLikeCnt(comm_no);
		likeCnt = dao.getFreeLikeCnt(comm_no);
		
		return likeCnt;
	}

	public CommVO getPoroModify(CommVO vo) {
		
		vo = dao.getpotoDetail(vo);
		
		//////////////////////////////////ck file start
		if(vo.getComm_contents().indexOf("src=\"") > 0) {
			UtilForFile.realPathToTmpPathForUpdate(vo.getComm_contents(), vo.getComm_no());
			vo.setComm_contents(vo.getComm_contents().replaceAll("/"+vo.getComm_no()+"/", "/tmp/"));
		}
		//////////////////////////////////ck file end
		
		return vo;
	}

	public int getpotoDelete(CommVO vo, HttpSession session) {

		int successCnt = 0;		
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		if(sessionVO == null || sessionVO.getUser_no().equals("")) {
			return successCnt;
		}
		
		successCnt = dao.DeleteFree(vo); 
				
		if(successCnt > 0) {
			if(vo.getFileat() != null && !vo.getFileat().equals("")) {
				File fileForDel = new File("C:/"+vo.getFileat());
				fileForDel.delete();
			}
		}
		
		//////////////////////////////////ck file start
		if(vo.getComm_contents().indexOf("src=\"") > 0) {
			UtilForFile.delPath(vo.getComm_contents(), vo.getComm_no());
			UtilForFile.clearFolder("poto", vo.getComm_no());
		}
		//////////////////////////////////ck file end
		
		return successCnt;
	}

	public int getModifypoto(CommVO vo, MultipartRequest multipartRequest) {

		int successCnt = 0;
		//////////////////////////////////file start
		String upFilePath = "";
		MultipartFile file = multipartRequest.getFile("fileat_nm");
		logger.info("file : "+file);
		if(file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0) {
			upFilePath = UtilForFile.fileUpByType(file, "poto", vo.getComm_no());
		}//if
		//////////////////////////////////file end
		vo.setFileat(upFilePath);
		vo.setComm_contents(
			vo.getComm_contents().substring(
					vo.getComm_contents().indexOf(",")+1));
		//////////////////////////////////ck file start
		if(vo.getComm_contents().indexOf("src=\"") > 0) {
			UtilForFile.tmpPathToRealPath(vo.getComm_contents(), vo.getComm_no());
		}
		//////////////////////////////////ck file end
		successCnt = dao.Modifypoto(vo);
		
		return successCnt;
	}

	public HashMap<String, Object> InsertPotoComm(CommentsVO vo, HttpSession session) {

		HashMap<String, Object> response = new HashMap<>();
		
		int successCnt = 0;
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		if(sessionVO == null || sessionVO.getUser_no().equals("")) {
			successCnt = -1;
			return (HashMap<String, Object>) response.put("successCnt", successCnt);
		}	
		
		vo.setUser_no(sessionVO.getUser_no());
		successCnt = dao.Insfreecomm(vo);
		if(successCnt>0){
			vo = dao.getPotocommDetail(vo);
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
	
}
