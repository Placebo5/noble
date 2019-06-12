package com.noble.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noble.dao.ResDAO;
import com.noble.vo.PromotionVO;
import com.noble.vo.ProtimeVO;
import com.noble.vo.ReserveVO;

@Service
public class ResService {

	private static final Logger logger = LoggerFactory.getLogger(ResService.class);
	
	@Autowired
	private ResDAO	dao;

	public HashMap<String, Object> getResList(String user_no, String page) {
		
		int beginRNum = 0;
		int endRNum = 10;
		if(!(page == null) && !page.equals("")) {
			endRNum = Integer.parseInt(page) * 10;
			beginRNum = endRNum -10;
		} else {
			page = "1";
		}	
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("beginRNum",beginRNum);
		map.put("endRNum",endRNum);
		map.put("user_no",user_no);


		List<ReserveVO> list = dao.getSelectResList(map);
		
		int totalCnt = dao.getResListCnt(map);	
		int pagingEnd = totalCnt/10;
		if(totalCnt % 10>0) {
			pagingEnd++;
		} 
		
		HashMap<String, Object> response = new HashMap<>(map);	
		response.put("res_list", list);
		response.put("pagingEnd", pagingEnd);
		
		return response;
	}

	public HashMap<String, Object> getResListMng(String page,String hidSearchType, String hidSearchWord) {
		
		int beginRNum = 0;
		int endRNum = 10;
		if(!(page == null) && !page.equals("")) {
			endRNum = Integer.parseInt(page) * 10;
			beginRNum = endRNum -10;
		} else {
			page = "1";
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("beginRNum",beginRNum);
		map.put("endRNum",endRNum);
		map.put("hidSearchType",hidSearchType);
		map.put("hidSearchWord",hidSearchWord);
		
		List<ReserveVO> list = dao.getselectResListMng(map);
		
		int totalCnt = dao.getselectResListMngCnt(map);	
		int pagingEnd = totalCnt/10;
		if(totalCnt % 10>0) {
			pagingEnd++;
		}
		
		HashMap<String, Object> response = new HashMap<>(map);		
		response.put("res_list", list);
		response.put("pagingEnd", pagingEnd);
		response.put("hidSearchType", hidSearchType);
		response.put("hidSearchWord", hidSearchWord);
		
		return response;
	}

	public HashMap<String, Object> getResListComp(String user_no, String pro_no, String page, String hidSearchType, String hidSearchWord) {
		
		int beginRNum = 1;
		int endRNum = 10;
		if(page != null && !page.equals("")) {
			endRNum = Integer.parseInt(page) * 10;
			beginRNum = endRNum -9;
		} else {
			page = "1";
		}	
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pro_no",pro_no);
		map.put("user_no",user_no);
		map.put("beginRNum",beginRNum);
		map.put("endRNum",endRNum);
		map.put("hidSearchType",hidSearchType);
		map.put("hidSearchWord",hidSearchWord);
		
		int totalCnt = dao.getSelectResListCompCnt(map);
		
		int pagingEnd = totalCnt/10;
		if(totalCnt % 10>0) {
			pagingEnd++;
		}
		
		List<ReserveVO> list = dao.getSelectResListComp(map);		
		HashMap<String, Object> response = new HashMap<>(map);
		
		response.put("res_list_comp", list);
		response.put("pagingEnd", pagingEnd);
		response.put("hidSearchType", hidSearchType);
		response.put("hidSearchWord", hidSearchWord);
		return response;
	}

	public HashMap<String, Object> getResChose(PromotionVO vo) {

		List<PromotionVO> list = dao.getResChoseProNO(vo); 
		HashMap<String, Object> response = new HashMap<String, Object>();
		for(int i=0; i<list.size(); i++) {
			PromotionVO tmpVO = list.get(i);
			if(tmpVO.getPro_type().equals("병원")) {
				response.put("hos_pro_no", tmpVO.getPro_no());
			}else if(tmpVO.getPro_type().equals("미용실")) {
				response.put("salon_pro_no", tmpVO.getPro_no());
			}else if(tmpVO.getPro_type().equals("카페")) {
				response.put("cafe_pro_no", tmpVO.getPro_no());
			}
		}			
		return response;
	}

	public String getReserveChk(String res_no) {
		String msg = "";
		dao.updateReserveChkList(res_no);
		msg = dao.getReserveChkList(res_no);
		
		return msg;
	}

	public String getReserveCanselChk(String res_no) {
		String msg = "";
		dao.updateReserveChkCanselList(res_no);
		msg = dao.getReserveChkList(res_no);
		
		return msg;
	}

	public String getPromoReservestat(ReserveVO rvo, ProtimeVO vo) {
		int dayOffYn = 0;
		dayOffYn = dao.getHoliday(rvo);
		if(dayOffYn > 0) {
			JSONArray tmpArr = new JSONArray();
			JSONObject tmpObj = new JSONObject();
			tmpObj.put("reserve_yn", "-1");
			tmpArr.add(tmpObj);		
			String tmpJsonStr = tmpArr.toString();
			return tmpJsonStr;
		}
		
		List<ProtimeVO> list = dao.getProresList(vo);
		List<HashMap<String, String>> listCheck = dao.getTimeCheck(rvo);
		
		JSONArray arr = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			ProtimeVO tmpVO = list.get(i);
			int sTime = 0, eTime = 0, displayMmIntrval = 0, displayMm = 0;
			if(tmpVO.getStart_time() != null && !tmpVO.getStart_time().equals("")) {
				sTime = Integer.parseInt(tmpVO.getStart_time());
				eTime = Integer.parseInt(tmpVO.getEnd_time());
				displayMmIntrval = Integer.parseInt(tmpVO.getPro_unit());

				for(int k=sTime; k<eTime; k++){
					for(int j=0; j<(60/displayMmIntrval); j++){
						String tmpStr = ""+k+"시"+displayMm+"분";
						int sameFlag = 0;
						for(int x=0; x<listCheck.size(); x++) {
							HashMap<String,String> tmpMap2 = listCheck.get(x);
							if(tmpStr.equals(tmpMap2.get("res_time"))) {
								sameFlag = 1;
							}
						}
						JSONObject obj1 = new JSONObject();
						obj1.put("reserve_time", tmpStr);
						if(sameFlag == 1) {
							obj1.put("reserve_yn", "1");
						} else {
							obj1.put("reserve_yn", "0");
						}
						arr.add(obj1);		

						displayMm = displayMm + displayMmIntrval;
						if(displayMm > 59){
							displayMm = 0;
						}//if
					}//for
				}//for
			}	
		}

		String jsonStr = arr.toString();
		
		return jsonStr;
	}

	public int InsertReservergs(ReserveVO vo) {
		int successCnt = 0;
		successCnt = dao.InsReservergs(vo);
		
		return successCnt;
	}

	public String getResListDayComp(PromotionVO pvo) {
		List<ReserveVO> list = dao.getresListDayComp(pvo);
		JSONArray array = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			ReserveVO vo = list.get(i);
			JSONObject object = new JSONObject();
				object.put("nm", vo.getRes_nm());
				object.put("add", vo.getComp_add());
				object.put("date", vo.getRes_date());
				object.put("tel", vo.getRes_tel());
				object.put("time", vo.getRes_time());
				object.put("contents", vo.getRes_contents());
				object.put("yn", vo.getRes_yn());
				object.put("comp_nm", vo.getComp_name());
				object.put("user_id", vo.getUser_id());
				object.put("res_no", vo.getRes_no());
			array.add(object);
		}
		
		String jsonStr = array.toString();
		return jsonStr;
	}

	public JSONArray getHoliday(String pro_no, String nowDate) {
		int year = Integer.parseInt(nowDate.substring(0, 4));
		int month = Integer.parseInt(nowDate.substring(5, 7));
		int dayOfMonth = Integer.parseInt(nowDate.substring(8, 10));
		GregorianCalendar cal = new GregorianCalendar(year, month-1, dayOfMonth);
		
		// 지정휴일 정보
		List<HashMap<String, String>> listholiday = dao.getHolidayList(pro_no);
		
		// 고정휴일 정보
		List<HashMap<String, String>> list = dao.getProTimeList(pro_no);
		
		JSONArray arr = new JSONArray();
		
		// 지정휴일
		for(HashMap<String, String> temp : listholiday) {
			JSONObject obj1 = new JSONObject();
			obj1.put("start", temp.get("holiday_date"));
			obj1.put("title", temp.get("holiday_desc"));
			arr.add(obj1);
		}
		
		// 고정휴일
		for(HashMap<String, String> temp : list) {
			HashMap<String, String> listMap = temp;
			for(int i = 0; i < 31; i++) {
				// 1
				cal.add(Calendar.DATE, 1);
				
				// 2
				if(cal.get(Calendar.DAY_OF_WEEK) == Integer.parseInt(listMap.get("week_day"))+1) {
					JSONObject obj1 = new JSONObject();
					String monthlen = "" + (cal.get(Calendar.MONTH) + 1);
					if(monthlen.length() < 2) {
						monthlen = "0" + monthlen;
					}
					String datelen = "" + cal.get(Calendar.DAY_OF_MONTH);
					if(datelen.length() < 2) {
						datelen = "0" + datelen;
					}
					obj1.put("start", cal.get(Calendar.YEAR) + "-" + monthlen + "-" + datelen);
					obj1.put("title", "휴무");
					arr.add(obj1);
				}//if
			}//for
		}
		
		return arr;
	}

	public int InsertHolday(String myJson) throws ParseException {
		JSONArray arr = new JSONArray();
		JSONParser parser = new JSONParser();
		arr = (JSONArray) parser.parse(myJson);
		int successCnt = 0;
		successCnt = dao.getInsHoliday(arr);
		
		return successCnt;
	}

}
