package com.noble.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noble.vo.CommVO;
import com.noble.vo.CommentsVO;

@Repository
public class PotoDAO {

	@Autowired
	private SqlSession sqlSession;

	public List<CommVO> getpotoList(HashMap<String, Object> map) {
		return sqlSession.selectList("communityMapper.selectpotolist", map);
	}

	public List<CommVO> getToppotoList(HashMap<String, Object> map) {
		return sqlSession.selectList("communityMapper.selectpototoplist",map);
	}

	public int getpotoListCnt(HashMap<String, Object> map) {
		return sqlSession.selectOne("communityMapper.selectpotoListCnt", map);
	}

	public int Insertpoto(CommVO vo) {
		return sqlSession.insert("communityMapper.insertpotoWrite",vo);
	}

	public int UpInspotoWrite(CommVO vo) {
		return sqlSession.update("communityMapper.upInspotoWrite",vo);
	}

	public void UpdatepotoViewCnt(CommVO vo) {
		sqlSession.update("communityMapper.updateFreeViewCnt", vo);		
	}

	public CommVO selectpotoDetail(CommVO vo) {
		return sqlSession.selectOne("communityMapper.selectFreeDetail", vo);
	}

	public List<CommentsVO> getfreecommList(CommVO vo) {
		return sqlSession.selectList("communityMapper.selectfreecommList", vo);
	}

	public void UpDatepotoLikeCnt(String comm_no) {
		sqlSession.update("communityMapper.updateFreeLikeCnt", comm_no);
	}

	public String getFreeLikeCnt(String comm_no) {
		return sqlSession.selectOne("communityMapper.selectFreeLikeCnt", comm_no);
	}

	public CommVO getpotoDetail(CommVO vo) {
		return sqlSession.selectOne("communityMapper.selectFreeDetail", vo);
	}

	public int DeleteFree(CommVO vo) {
		return sqlSession.delete("communityMapper.deleteFree", vo);
	}

	public int Modifypoto(CommVO vo) {
		return sqlSession.update("communityMapper.modifypoto",vo);
	}

	public int Insfreecomm(CommentsVO vo) {
		return sqlSession.insert("communityMapper.insfreecomm", vo);
	}

	public CommentsVO getPotocommDetail(CommentsVO vo) {
		return sqlSession.selectOne("communityMapper.selectfreecommDetail", vo);
	}
}
