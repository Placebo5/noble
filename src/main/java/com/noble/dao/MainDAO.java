package com.noble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noble.vo.CommVO;

@Repository
public class MainDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CommVO> getMainfreelist(CommVO vo) {
		return sqlSession.selectList("communityMapper.mainfreelist", vo);
	}
	
	public List<CommVO> getMainpotolist(CommVO vo) {
		return sqlSession.selectList("communityMapper.mainpotolist", vo);
	}

}
