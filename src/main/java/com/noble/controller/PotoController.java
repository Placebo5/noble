package com.noble.controller;

import java.io.IOException;
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

import com.noble.service.PotoService;
import com.noble.vo.CommVO;
import com.noble.vo.CommentsVO;
import com.noble.vo.UserselVO;


@Controller
public class PotoController {

	private static final Logger logger = LoggerFactory.getLogger(PotoController.class);
	
	@Autowired
	private PotoService service;
	
	@RequestMapping(value="/potolist",method=RequestMethod.GET)
	public String potoList(HttpSession session,Model model,String page,String hidSearchType,String hidSearchWord) {
		logger.info("potoList");
		
		HashMap<String, Object> response = service.getpotoList(page, hidSearchType, hidSearchWord);
		
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");	
		
		model.addAttribute("response", response);
		model.addAttribute("page", page);		
		return "community/poto_list";
	}
	
	@RequestMapping(value="/potowrite",method=RequestMethod.GET)
	public String potoWrite(HttpSession session,Model model) {
		logger.info("potoWrite");
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		if(sessionVO == null || sessionVO.getUser_no().equals("")) {
			return "redirect:/potolist";
		}
		return "community/poto_write";
	}
	
	@RequestMapping(value="/potoins",method=RequestMethod.POST)
	public @ResponseBody int potoIns(HttpSession session,CommVO vo,MultipartRequest multipartRequest) {
		logger.info("potoIns");
		
		return service.InsertpotoWrite(vo, multipartRequest, session);
	}
	
	@RequestMapping(value="/potofileup" , method=RequestMethod.POST)
	public @ResponseBody Object potofileup(MultipartRequest multiReq,String pgfrm) 
					throws IOException {
		logger.info("potofileup");
		
		return service.potoFileUpload(pgfrm, multiReq);
	}
	
	@RequestMapping(value="/potodetail",method=RequestMethod.GET)
	public String potoDetail(CommVO vo,Model model,HttpSession session) {
		logger.info("potoDetail");
		
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		if(sessionVO == null || sessionVO.getUser_no().equals("")) {
			return "redirect:/login";
		}

		HashMap<String, Object> response =service.potoDetail(vo);
		model.addAttribute("response", response);
		
		return "community/poto_detail";
	}
	
	@RequestMapping(value="/potolikecnt",method=RequestMethod.POST)
	public @ResponseBody String potoLikeCnt(String comm_no) {
		logger.info("potoLikeCnt");
		
		return service.potoLikeCnt(comm_no);
		
	}
	
	@RequestMapping(value="/delpoto", method=RequestMethod.POST)
	public @ResponseBody int delpoto(CommVO vo,HttpSession session) {
		logger.info("delpoto");
		
		return service.getpotoDelete(vo, session);
	}
	
	
	@RequestMapping(value="/potomodify",method=RequestMethod.GET)
	public String potoModify(Model model, CommVO vo,HttpSession session) {
		logger.info("potoModify");
		
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		if(sessionVO == null || sessionVO.getUser_no().equals("")) {
			return "redirect:/login";
		}
		
		vo = service.getPoroModify(vo);
		
		model.addAttribute("poto_vo", vo);
		return "community/poto_modify";
	}
	
	@RequestMapping(value="/modifypoto",method=RequestMethod.POST)
	public @ResponseBody int modifypoto(CommVO vo,MultipartRequest multipartRequest) {
		logger.info("modifypoto");
		
		return service.getModifypoto(vo, multipartRequest);
		
	}
	
	@RequestMapping(value="/inspotocomm", method=RequestMethod.POST)
	private @ResponseBody HashMap<String, Object> inspotoComm(CommentsVO vo, HttpSession session) {
		logger.info("inspotoComm");	
		
		return service.InsertPotoComm(vo, session);
	}
}
