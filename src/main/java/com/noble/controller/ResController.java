package com.noble.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noble.service.ResService;
import com.noble.vo.PromotionVO;
import com.noble.vo.ProtimeVO;
import com.noble.vo.ReserveVO;
import com.noble.vo.UserselVO;

@Controller
public class ResController {

	private static final Logger logger = LoggerFactory.getLogger(ResController.class);
	
	@Autowired
	private ResService service;
	SqlSession SqlSession;
	
	@RequestMapping(value="/reservergs", method=RequestMethod.GET)
	public String reservergs(Model model,HttpSession session,String pro_no) {
		logger.info("reservergs");
	
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		if(sessionVO == null || sessionVO.getUser_no().equals("")) {
			return "redirect:/login";
		}
		
		model.addAttribute("pro_no", pro_no);
		
		return "reservation/reservergs";
	}
	
	@RequestMapping(value="/holiday", method=RequestMethod.GET)
	public String holiDay(String pro_no,Model model) {
		logger.info("holiDay");
		
		model.addAttribute("pro_no",pro_no);
		
		return "reservation/holiday";
	}
	
	@RequestMapping(value="/insholiday", method=RequestMethod.POST)
	public @ResponseBody int insHoliday(String myJson) throws ParseException {
		logger.info("insHoliday");
		
		return service.InsertHolday(myJson);
	}
	
	@RequestMapping(value="/holidaychklist", method=RequestMethod.GET)
	public @ResponseBody JSONArray holidayChkList(String pro_no, String nowDate) {
		logger.info("holidayChkList");
		
		return service.getHoliday(pro_no, nowDate);
	}
	
	@RequestMapping(value="/reslist", method=RequestMethod.GET)
	public String resList(Model model,String user_no,String page) {
		logger.info("resList");
		
		HashMap<String, Object> response = service.getResList(user_no, page);
		
		model.addAttribute("response", response);
		model.addAttribute("page", page);
		
		return "reservation/reslist";
	}
	
	@RequestMapping(value="/reslistcomp", method=RequestMethod.GET)
	public String resListComP(Model model,String user_no, String pro_no,String page,String hidSearchType,String hidSearchWord) {
		logger.info("resListComP");
		
		HashMap<String, Object> response = service.getResListComp(user_no, pro_no, page, hidSearchType, hidSearchWord);
		
		model.addAttribute("pro_no", pro_no);
		model.addAttribute("page", page);
		model.addAttribute("response", response);
		
		return "reservation/reslist_comp";
	}
	
	
	
	@RequestMapping(value="/reslistmng", method=RequestMethod.GET)
	public String resListMng(Model model,String page,String hidSearchType, String hidSearchWord) {
		logger.info("resListMng");
		
		HashMap<String, Object> response = service.getResListMng(page, hidSearchType, hidSearchWord);
		
		model.addAttribute("page", page);
		model.addAttribute("response", response);
		
		return "reservation/reslist_mng";
	}
	
	
	@RequestMapping(value="/insreservergs", method=RequestMethod.POST)
	public @ResponseBody int insReservergs(HttpSession session, ReserveVO vo) {
		logger.info("insReservergs");
		
		return service.InsertReservergs(vo);
	}

	@RequestMapping(value="/rescheck", method=RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String resCheck(String res_no) {
		logger.info("resCheck");
		
		return service.getReserveChk(res_no);
	}

	@RequestMapping(value="/rescansel", method=RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String resCansel(String res_no) {
		logger.info("resCansel");
		
		return service.getReserveCanselChk(res_no);
	}
	
	@RequestMapping(value="/promoreservestat", method=RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String promoReserveStat(ReserveVO rvo, ProtimeVO vo) {
		logger.info("promoReserveStat");
		
		return service.getPromoReservestat(rvo, vo);	
	}
	
	@RequestMapping(value="/resCompList", method=RequestMethod.POST,produces = "application/text; charset=utf8")
	public @ResponseBody String resCompList(PromotionVO pvo) {
		logger.info("resCompList");	

		return service.getResListDayComp(pvo);
	}
	
	@RequestMapping(value="/reschose", method=RequestMethod.GET)
	public String resChose(PromotionVO vo,Model model) {
		logger.info("resChose");

		HashMap<String, Object> response = service.getResChose(vo);
		model.addAttribute("chose", response);

		return "reservation/reschose";
	}
	
	
}
