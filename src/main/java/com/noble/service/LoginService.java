package com.noble.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noble.dao.LoginDAO;
import com.noble.vo.UserselVO;

@Service
public class LoginService {

	@Autowired
	private LoginDAO dao;

	public int getLoginCheck(UserselVO vo,HttpSession session) {
		vo = dao.getLoginCk(vo);
		
		int successCnt = 0;
		if(vo != null && vo.getUser_no() != null && !vo.getUser_no().equals("")) {
			successCnt = 1;
			session.setAttribute("userSession", vo);
		}
		
		return successCnt;
	}

	public int getJoinIdCk(UserselVO vo) {
		int cnt = dao.getJoinIdCheck(vo);
		return cnt;
	}

	public int getInsertUserJoin(UserselVO vo) {
		int successCnt = 0;
		successCnt = dao.getInsertJoinUser(vo);
		
		return successCnt;
	}

	public int getInsertUserCompJoin(UserselVO vo) {
		int successCnt = 0;
		successCnt = dao.getInsertJoinUserComp(vo);

		return successCnt;
	}	
}
