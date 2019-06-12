package com.noble.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noble.vo.UserselVO;

@Repository
public class MypageDAO {

	@Autowired
	private SqlSession sqlSession;

	public UserselVO getMypageInChk(UserselVO vo) {
		return sqlSession.selectOne("userMapper.MypagePwdCheck", vo);
	}

	public int getMyPageUpdate(UserselVO vo) {
		return sqlSession.update("userMapper.updMypageUser", vo);
	}

	public int getmemberWithrawal(UserselVO vo) {
		return sqlSession.update("userMapper.memberWithrawal", vo);
	}
	
	
}
