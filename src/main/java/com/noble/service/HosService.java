package com.noble.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.noble.dao.HosDAO;
import com.noble.noble.UtilForFile;
import com.noble.noble.UtilForSession;
import com.noble.vo.PromotionVO;
import com.noble.vo.PromotionuserVO;
import com.noble.vo.UserselVO;

@Service
public class HosService {

	private static final Logger logger = LoggerFactory.getLogger(HosService.class);
	
	@Autowired
	private HosDAO dao;
	
	public HashMap<String, Object> getHosList(String page, String hidProSearchType, String hidProSearchWord) {
		
		int beginRNum = 0;
		int endRNum = 16;
		if(!(page == null) && !page.equals("")) {
			endRNum = Integer.parseInt(page) * 16;
			beginRNum = endRNum -16;
		} else {
			page = "1";
		}
				
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("beginRNum",beginRNum);
		map.put("endRNum",endRNum);
		map.put("hidProSearchType",hidProSearchType);
		map.put("hidProSearchWord",hidProSearchWord);
		
		int totalCnt = dao.getHosListCnt(map);
		int pagingEnd = totalCnt/16;
		if(totalCnt % 16>0) {
			pagingEnd++;
		}
		
		List<PromotionuserVO> list = dao.getHosList(map);
		HashMap<String, Object> response = new HashMap<>(map);

		response.put("hoslist", list);
		response.put("pagingEnd", pagingEnd);
		response.put("hidProSearchType", hidProSearchType);
		response.put("hidProSearchWord", hidProSearchWord);
		
		return response;
	}

	public PromotionuserVO getPromotionDetail(PromotionuserVO puVO) {
		puVO = dao.getselectPromotionDetail(puVO);

		return puVO;
	}

	public ArrayList<String> getPromList(HttpSession session) {
		
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		
		ArrayList<String> listDay = new ArrayList<String>();
		listDay.add("일");listDay.add("월");listDay.add("화");listDay.add("수");listDay.add("목");
		listDay.add("금");listDay.add("토");
		
		return listDay;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int getInsertPromotin(PromotionVO inVo, HttpSession session, MultipartRequest multipartRequest) {
		
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		int successCnt = 0;
		if(UtilForSession.chkSession(session) == false) {
			return successCnt;
		}
		if(inVo.getPro_contents1().indexOf(',') == 0) {
			inVo.setPro_contents1(inVo.getPro_contents1().substring(1, inVo.getPro_contents1().length()));
		}
		
		successCnt = dao.getInsPromotion(inVo);

		String [] week_day = inVo.getWeek_day();
		String [] start_time = inVo.getStart_time(); 
		String [] end_time = inVo.getEnd_time();
		String [] holiday = inVo.getHoliday();
		String [] holidayArr = inVo.getHolidayArr();
		
		for(int i = 0; i < start_time.length; i++) {
			HashMap<String, Object> tmpMap = new HashMap<String, Object>();
			tmpMap.put("pro_no", inVo.getPro_no());
			tmpMap.put("pro_unit", inVo.getPro_unit());
			tmpMap.put("week_day", week_day[i]);
			tmpMap.put("start_time", start_time[i]);
			tmpMap.put("end_time", end_time[i]);
			tmpMap.put("holiday", holidayArr[i]);
			dao.getInsProtime(tmpMap);
		}

		successCnt = 1;
		
		//////////////////////////////////file start
		String upFilePath = "";
		MultipartFile file1 = multipartRequest.getFile("atch_file1");
		if(file1.getOriginalFilename() != null && file1.getOriginalFilename().length() > 0) {
		upFilePath = UtilForFile.fileUpByType(file1, "free", inVo.getPro_no());
		inVo.setAtch_file1_nm(upFilePath);
		}//if
		MultipartFile file2 = multipartRequest.getFile("atch_file2");
		if(file2.getOriginalFilename() != null && file2.getOriginalFilename().length() > 0) {
		upFilePath = UtilForFile.fileUpByType(file2, "free", inVo.getPro_no());
		inVo.setAtch_file2_nm(upFilePath);
		}//if
		//////////////////////////////////file end
		//////////////////////////////////ck file start
		int ckFlag = 0;
		if(inVo.getPro_contents1().indexOf("src=\"") > 0) {
		UtilForFile.tmpPathToRealPath(inVo.getPro_contents1(), inVo.getPro_no());
		ckFlag++;
		}
		//////////////////////////////////ck file end
			
		if(upFilePath.length() > 0 || ckFlag > 0) {
			successCnt = dao.getupInsPromotion(inVo);
		}
		
		return successCnt;
	}

	public int getUpdatePromotion(PromotionVO inVo, HttpSession session) {
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		int successCnt = 0;
		if(inVo.getPro_contents1().indexOf(',') == 0) {
			inVo.setPro_contents1(inVo.getPro_contents1().substring(1, inVo.getPro_contents1().length()));
		}
		if(inVo.getPro_contents2().indexOf(',') == 0) {
			inVo.setPro_contents2(inVo.getPro_contents2().substring(1, inVo.getPro_contents2().length()));
		}
		
		successCnt = dao.getModifyPromotion(inVo);
		String [] week_day = inVo.getWeek_day();
		String [] start_time = inVo.getStart_time();
		String [] end_time = inVo.getEnd_time();
		String [] holiday = inVo.getHoliday();
		String [] holidayArr = inVo.getHolidayArr();
		for(int i=0;i<start_time.length; i++) {
			HashMap<String, Object> tmpMap = new HashMap<String, Object>();
			tmpMap.put("pro_no", inVo.getPro_no());
			tmpMap.put("pro_unit", inVo.getPro_unit());
			tmpMap.put("week_day", week_day[i]);
			tmpMap.put("start_time", start_time[i]);
			tmpMap.put("end_time", end_time[i]);
			tmpMap.put("holiday", holidayArr[i]);
			
			dao.getInsProtime(tmpMap);
		}
		successCnt = 1;
		
		return successCnt;
	}

	public PromotionuserVO PromotionAddDetail(PromotionuserVO puVO) {
		puVO = dao.getselectPromotionDetailAdd(puVO);
		return puVO;
	}

	public int getDeletePromotion(PromotionVO inVo, HttpSession session) {
		int successCnt = 0;		
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		if(sessionVO == null || sessionVO.getUser_no().equals("")) {
			return successCnt;
		}
		if(!sessionVO.getUser_no().equals(inVo.getUser_no())) {
			return successCnt = -1;
		}	
		successCnt = dao.getDeletePromo(inVo) +1;
		
		successCnt = dao.getdeleteProtime(inVo) +1;
		
		return successCnt;
	} 
	
	
}
