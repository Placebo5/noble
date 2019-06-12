package com.noble.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noble.vo.CommVO;
import com.noble.vo.CommentsVO;

@Repository
public class FreeDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<CommVO> getFreeList(HashMap<String, Object> map) {
		return sqlSession.selectList("communityMapper.selectFreeList", map);
	}

	public int getFreeListCnt(HashMap<String, Object> map){
		return sqlSession.selectOne("communityMapper.selectFreeListCnt", map);
	}

	public List<CommVO> getFreeBastList(HashMap<String, Object> map) {
		return sqlSession.selectList("communityMapper.selectfreetoplist",map);
	}

	public int InsFreeWrite(CommVO vo) {
		return sqlSession.insert("communityMapper.insertWrite",vo);
	}

	public CommVO getFreeDetail(CommVO vo) {
		return sqlSession.selectOne("communityMapper.selectFreeDetail", vo);
	}

	public void UpdateFreeViewCount(CommVO vo) {
		sqlSession.update("communityMapper.updateFreeViewCnt", vo);
	}

	public void getFreeLikeCnt(String comm_no) {
		sqlSession.update("communityMapper.updateFreeLikeCnt", comm_no);
	}	
	public String getFreeLikeCntSelect(String comm_no) {
		return sqlSession.selectOne("communityMapper.selectFreeLikeCnt", comm_no);
	}

	public int getFreeDelete(CommVO vo) {
		return sqlSession.delete("communityMapper.deleteFree", vo);
	}

	public CommVO getFreeModify(CommVO vo) {
		return sqlSession.selectOne("communityMapper.selectFreeDetail", vo);
	}

	public int getFreeModifyUpdate(CommVO vo) {
		return sqlSession.update("communityMapper.modifyFree", vo);
	}

	public int getInsFreeComments(CommentsVO vo) {
		return sqlSession.insert("communityMapper.insfreecomm", vo);
	}

	public List<CommentsVO> getSelectFreeCommList(CommVO vo) {
		return sqlSession.selectList("communityMapper.selectfreecommList", vo);
	}
	
	public CommentsVO getselectfreecommDetail(CommentsVO vo) {
		return sqlSession.selectOne("communityMapper.selectfreecommDetail", vo);
	}
}
