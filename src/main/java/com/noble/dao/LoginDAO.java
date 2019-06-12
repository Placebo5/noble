package com.noble.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noble.vo.UserselVO;

@Repository
public class LoginDAO {

	@Autowired
	private SqlSession sqlSession;

	public UserselVO getLoginCk(UserselVO vo) {
		return sqlSession.selectOne("userMapper.loginCheck", vo);
	}

	public int getJoinIdCheck(UserselVO vo) {
		return sqlSession.selectOne("userMapper.joinIDChk", vo);
	}

	public int getInsertJoinUser(UserselVO vo) {
		return sqlSession.insert("userMapper.insertUser", vo);
	}

	public int getInsertJoinUserComp(UserselVO vo) {
		return sqlSession.insert("userMapper.insertUserComp", vo);
	}
	
}
