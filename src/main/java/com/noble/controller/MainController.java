package com.noble.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.noble.service.MainServiceImp;
import com.noble.vo.CommVO;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainServiceImp service;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Model model, CommVO vo) {
		logger.info("main");
		HashMap<String, Object> response = service.getBoardList(vo);
		model.addAttribute("response", response);
		return "home/main";
	}

}