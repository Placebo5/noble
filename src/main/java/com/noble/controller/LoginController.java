package com.noble.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noble.service.LoginService;
import com.noble.vo.UserselVO;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService service;

	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login(Model model, UserselVO vo, String user_id) {
		logger.info("login");

		return "join/login";
	}
	
	@RequestMapping(value="/logincheck", method= RequestMethod.POST)
	public @ResponseBody int loginCheck(UserselVO vo,HttpSession session) {
		logger.info("=== login ===");
	
		return service.getLoginCheck(vo, session);	
	}
	
	@RequestMapping(value="/joingate", method=RequestMethod.GET)
	public String join_Gate(Model model) {
		logger.info("join_Gate");
		
		return "join/join_gate";
	}
	
	@RequestMapping(value = "/joinidchk", method = RequestMethod.POST)
	public @ResponseBody int joinIDCheck(UserselVO vo)
			throws IOException {
		logger.info("=== joinIDCheck ===");
	
		return service.getJoinIdCk(vo);
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		logger.info("join");
		
		return "join/join";
	}
	
	
	@RequestMapping(value="/joincompany", method=RequestMethod.GET)
	public String joinCompany(Model model) {
		logger.info("joinCompany");
		
		return "join/joincompany";
	}
	
	@RequestMapping(value="/insjoin",method=RequestMethod.POST)
	private @ResponseBody int insJoin(UserselVO vo) {
		logger.info("insJoin");
		
		return service.getInsertUserJoin(vo);
	}
	
	@RequestMapping(value="/insjoincomp",method=RequestMethod.POST)
	private @ResponseBody int insJoinComp(UserselVO vo) {
		logger.info("insJoinComp");
		
		return service.getInsertUserCompJoin(vo);
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logOut(HttpSession session) {
		logger.info("=== logout ===");
		session.invalidate();
		return "redirect:/main";
	}//logout	
	
}







