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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartRequest;

import com.noble.service.FreeService;
import com.noble.vo.CommVO;
import com.noble.vo.CommentsVO;
import com.noble.vo.UserselVO;

@Controller
public class FreeController {
	
	private static final Logger logger = LoggerFactory.getLogger(FreeController.class);
	
	@Autowired
	private FreeService service;
	
	@RequestMapping(value="/freelist", method=RequestMethod.GET)
	public String freeList(Model model, @RequestParam(required=false) Integer page,String hidSearchType,String hidSearchWord) {
		logger.info("freelist");
		
		HashMap<String, Object> response = service.getFreeList(page, hidSearchType, hidSearchWord);
		model.addAttribute("response", response);
		model.addAttribute("page", page);

		return "community/free_list";
	}

	@RequestMapping(value="/freewrite",method=RequestMethod.GET)
	public String freeWrite(HttpSession session,Model model) {
		logger.info("freeWrite");	

		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		if(sessionVO == null || sessionVO.getUser_no().equals("")) {
			return "redirect:/freelist";
		}

		return "community/free_write";
	}
	
	@RequestMapping(value="/insfree",method=RequestMethod.POST)
	public @ResponseBody int insfree(CommVO vo) {	
		logger.info("insfree");
						
		return service.getInsFreeWrite(vo);
	}
	
	@RequestMapping(value="/freedetail",method=RequestMethod.GET)
	public String freeDetail(Model model, CommVO vo) {
		logger.info("freeDetail");
		
		HashMap<String, Object> response = service.getSelectFreeDetail(vo);
		model.addAttribute("reply_list", response);
				
		
		return "community/free_detail";
		
	}
	
	@RequestMapping(value="/freelikecnt",method=RequestMethod.POST)
	public @ResponseBody String freeLikeCnt(String comm_no) {
		logger.info("freeLikeCnt");
		
		return service.getFreeLike(comm_no);	
	}
	
	@RequestMapping(value="/delfree", method=RequestMethod.POST)
	public @ResponseBody int delFree(CommVO vo,HttpSession session) {
		logger.info("delFree");

		return service.getDeleteFree(vo);
	}
	
	@RequestMapping(value="/freemodify",method=RequestMethod.GET)
	public String freeModify(Model model, CommVO vo) {
		logger.info("freeModify");
		
		model.addAttribute("vo", service.getBoardFreeModify(vo));

		return "community/free_modify";
	}	
	
	@RequestMapping(value="/writeupload",method=RequestMethod.POST)
	public @ResponseBody Object writeUpload(MultipartRequest multiReq,String pgfrm) throws IOException {
		logger.info("writeUpload");
		
		return service.freeFileUpload(pgfrm, multiReq);
	}
	
	@RequestMapping(value="/modifyfree", method=RequestMethod.POST)
	public @ResponseBody int modifyFree(CommVO vo) {
		logger.info("modifyFree");
		
		return service.getFreeModify(vo);		
	}
	
	@RequestMapping(value="/insfreecomm", method=RequestMethod.POST)
	private @ResponseBody HashMap<String, Object> insFreeComm(CommentsVO vo, HttpSession session) {
		logger.info("insFreeComm");
		
		HashMap<String, Object> response = service.getInsFreeComm(vo);
		
		return response;
	}
	
}
