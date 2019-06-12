package com.noble.service;

import java.util.HashMap;

import com.noble.vo.CommVO;

public interface MainService {
	/**
	 * 
	 * @param vo
	 * @return
	 */
	public HashMap<String, Object> getBoardList(CommVO vo);
}
