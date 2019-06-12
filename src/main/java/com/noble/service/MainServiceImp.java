package com.noble.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noble.dao.MainDAO;
import com.noble.vo.CommVO;

@Service
public class MainServiceImp implements MainService {
	
	private static final Logger logger = LoggerFactory.getLogger(MainServiceImp.class);
	
	@Autowired
	private MainDAO dao;

	@Override
	public HashMap<String, Object> getBoardList(CommVO vo) {
		List<CommVO> list = dao.getMainfreelist(vo);
		List<CommVO> listpoto = dao.getMainpotolist(vo);
		HashMap<String, Object> response = new HashMap<>();
		
		response.put("list", list);
		response.put("potolist", listpoto);
		return response;
	}
}
