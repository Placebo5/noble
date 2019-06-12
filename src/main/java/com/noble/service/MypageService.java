package com.noble.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noble.dao.MypageDAO;
import com.noble.vo.UserselVO;

@Service
public class MypageService {
	
	@Autowired
	private MypageDAO dao;

	public int getMyplageIn(UserselVO vo, HttpSession session) {
		vo = dao.getMypageInChk(vo);
		
		int successCnt = 0;		
		if(vo != null && vo.getUser_pwd() != null && !vo.getUser_pwd().equals("")) {
			successCnt = 1;
			session.setAttribute("userSession", vo);
		}
		
		return successCnt;
	}

	public int getMypage(UserselVO vo, HttpSession session) {
		
		int successCnt = 0;
		successCnt = dao.getMyPageUpdate(vo);
		
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		
		return successCnt;
	}

	public int getUserout(UserselVO vo, HttpSession session) {
		int successCnt = 0;
			
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		if(sessionVO == null || sessionVO.getUser_id().equals("")) {
			successCnt = -1;
			return successCnt;
		}
		if(!sessionVO.getUser_id().equals(vo.getUser_id())) {
			successCnt = -1;
			return successCnt;
		}	
		
		successCnt = dao.getmemberWithrawal(vo);
		if(successCnt > 0) {
			session.invalidate();
		}
		
		return successCnt;
	}
	
	
}
