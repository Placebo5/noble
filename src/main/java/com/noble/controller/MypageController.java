package com.noble.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noble.service.MypageService;
import com.noble.vo.UserselVO;

@Controller
public class MypageController {

	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);

	@Autowired
	private MypageService service;
	
	@RequestMapping(value="/mypagelogin", method=RequestMethod.GET)
	public String mypage_Login(Model model) {
		logger.info("=== mypage_Login ===");
		
		return "join/mypage_login";
	}
		
	@RequestMapping(value="/mypageloginCheck", method=RequestMethod.POST)
	public @ResponseBody int mypageloginCheck(UserselVO vo, HttpSession session) {
		logger.info("=== mypageloginCheck ===");
		
		return service.getMyplageIn(vo, session);
	}
	
	@RequestMapping(value="/mypagemodify", method=RequestMethod.GET)
	public String mypageModify() {
		logger.info("mypageModify");

		return "join/mypage_modify";
	}
		
	@RequestMapping(value="/updmypage", method=RequestMethod.POST)
	public @ResponseBody int updMypage(HttpSession session, UserselVO vo) {
		logger.info("=== updMypage ===");
		
		return service.getMypage(vo, session);
	}	

	@RequestMapping(value="/mbwithrawal", method=RequestMethod.POST)
	public @ResponseBody int mbWithrawal(HttpSession session, UserselVO vo) {
		logger.info("=== mbWithrawal ===");

		return service.getUserout(vo, session);
	}
}