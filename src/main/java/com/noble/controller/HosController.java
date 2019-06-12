package com.noble.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartRequest;

import com.noble.service.HosService;
import com.noble.vo.PromotionVO;
import com.noble.vo.PromotionuserVO;


@Controller
public class HosController {
	
	private static final Logger logger = LoggerFactory.getLogger(HosController.class);

	@Autowired
	private HosService service;
	
	@RequestMapping(value="/hoslist", method=RequestMethod.GET)	
	public String hosList(Model model, String page, String hidProSearchType, String hidProSearchWord,PromotionuserVO puVO) {
		logger.info("=== hosList ===");
		
		HashMap<String, Object> response = service.getHosList(page, hidProSearchType, hidProSearchWord);
		
		model.addAttribute("response", response);
		model.addAttribute("page", page);
		model.addAttribute("hos_detail_vo", puVO);
		return "reservation/hoslist";
	}
	
	@RequestMapping(value="/hosdetail", method=RequestMethod.GET)	
	public String hosdDetail(Model model, PromotionuserVO puVO) {
		logger.info("=== hosdDetail ===");
		
		puVO = service.getPromotionDetail(puVO);
		model.addAttribute("hos_detail_vo", puVO);
		
		return "reservation/hosdetail";
	}
	
	
	@RequestMapping(value="/hosmodify", method=RequestMethod.GET)	
	public String hosModify() {
		logger.info("hosModify");
		return "reservation/hosmodify";
	}
	
	
	@RequestMapping(value="/promowrite", method=RequestMethod.GET)	
	public String promoWrite(HttpSession session, Model model) {
		
		ArrayList<String> listDay = service.getPromList(session);
		model.addAttribute("listDay", listDay);
		
		return "reservation/promo_write";
	}

	@RequestMapping(value="/inspromowrite", method=RequestMethod.POST)	
	public @ResponseBody int insPromoWrite(HttpSession session, PromotionVO inVo, MultipartRequest multipartRequest) {
		logger.info("=== insPromoWrite ===");
		
		int successCnt = service.getInsertPromotin(inVo, session, multipartRequest);
		logger.info(inVo.getPro_no());
		
		return successCnt;
	}//insPromoWrite
	
	@RequestMapping(value="/promomodify", method=RequestMethod.GET)	
	public String promoModify(HttpSession session, Model model) {
		logger.info("=== promoModify ===");

		ArrayList<String> listDay = service.getPromList(session);
		model.addAttribute("listDay", listDay);
		
		return "reservation/promo_modify";
	}
	
	@RequestMapping(value="/updpromowrite", method=RequestMethod.POST)	
	public @ResponseBody int updPromowrite(HttpSession session, PromotionVO inVo) {
		logger.info("=== updPromowrite ===");
		
		return service.getUpdatePromotion(inVo, session);
	}
	
	@RequestMapping(value="/delpromo", method=RequestMethod.POST)
	public @ResponseBody int delPromo(PromotionVO inVo, HttpSession session) {
		logger.info("=== delPromo ===");

		return service.getDeletePromotion(inVo, session);
	}
	@RequestMapping(value="/hosadd", method=RequestMethod.GET)
	public String hosAdd(PromotionuserVO puVO,Model model) {
		logger.info("hosAdd");
		
		puVO = service.PromotionAddDetail(puVO);
		model.addAttribute("vo", puVO);
		
		return "reservation/hos_add";
	}
	
}//class

