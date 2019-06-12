package com.noble.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noble.vo.PromotionVO;
import com.noble.vo.PromotionuserVO;

@Repository
public class HosDAO {

	@Autowired
	SqlSession sqlSession;

	public List<PromotionuserVO> getHosList(HashMap<String, Object> map) {
		return sqlSession.selectList("promotionMapper.selectPromotionlist", map);
	}

	public int getHosListCnt(HashMap<String, Object> map) {
		return sqlSession.selectOne("promotionMapper.selectProListCnt", map);
	}

	public PromotionuserVO getselectPromotionDetail(PromotionuserVO puVO) {
		return sqlSession.selectOne("promotionMapper.selectPromotionDetail", puVO);
	}

	public int getInsPromotion(PromotionVO inVo) {
		return sqlSession.insert("promotionMapper.insertPromotion",inVo);
	}

	public int getInsProtime(HashMap<String, Object> tmpMap) {
		return sqlSession.insert("promotionMapper.insertProtime",tmpMap);
	}

	public int getupInsPromotion(PromotionVO inVo) {
		return sqlSession.update("promotionMapper.upInsPromotion", inVo);
	}

	public int getModifyPromotion(PromotionVO inVo) {
		return sqlSession.update("promotionMapper.modifyPromotion",inVo);
	}

	public PromotionuserVO getselectPromotionDetailAdd(PromotionuserVO puVO) {
		return sqlSession.selectOne("promotionMapper.selectPromotionDetail", puVO);
	}

	public int getDeletePromo(PromotionVO inVo) {
		return sqlSession.delete("promotionMapper.deletePromotion", inVo);
	}

	public int getdeleteProtime(PromotionVO inVo) {
		return sqlSession.delete("promotionMapper.deleteProtime", inVo);
	}

}
