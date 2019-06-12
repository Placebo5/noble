package com.noble.noble;

import javax.servlet.http.HttpSession;

import com.noble.vo.UserselVO;

public class UtilForSession {

	public static boolean chkSession(HttpSession session) {
		UserselVO sessionVO = (UserselVO) session.getAttribute("userSession");
		boolean chkSessionResult = true;
		if(sessionVO == null || sessionVO.getUser_no().equals("")) {
			chkSessionResult = false;
		}
		return chkSessionResult;
	}//chkSession

}
