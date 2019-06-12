package com.noble.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noble.vo.PromotionVO;
import com.noble.vo.ProtimeVO;
import com.noble.vo.ReserveVO;

@Repository
public class ResDAO {

	@Autowired
	private SqlSession SqlSession;

	public List<ReserveVO> getSelectResList(HashMap<String, Object> map) {
		return SqlSession.selectList("ReserveMapper.selectResList",map);
	}

	public int getResListCnt(HashMap<String, Object> map) {
		return SqlSession.selectOne("ReserveMapper.selectResListCnt", map);
	}

	public List<ReserveVO> getselectResListMng(HashMap<String, Object> map) {
		return SqlSession.selectList("ReserveMapper.selectResListMng", map);
	}

	public int getselectResListMngCnt(HashMap<String, Object> map) {
		return SqlSession.selectOne("ReserveMapper.selectResListMngCnt", map);
	}

	public List<ReserveVO> getSelectResListComp(HashMap<String, Object> map) {
		return SqlSession.selectList("ReserveMapper.selectResListComp", map);
	}

	public int getSelectResListCompCnt(HashMap<String, Object> map) {
		return SqlSession.selectOne("ReserveMapper.selectResListCompCnt", map);
	}

	public List<PromotionVO> getResChoseProNO(PromotionVO vo) {
		return SqlSession.selectList("ReserveMapper.selectHosProNO", vo);
	}

	public int updateReserveChkList(String res_no) {
		return SqlSession.update("ReserveMapper.updateReserveChk", res_no);
	}

	public String getReserveChkList(String res_no) {
		return SqlSession.selectOne("ReserveMapper.selectReserveChk", res_no);
	}

	public int updateReserveChkCanselList(String res_no) {
		return SqlSession.update("ReserveMapper.updateReserveCansel", res_no);
	}

	public List<ProtimeVO> getProresList(ProtimeVO vo) {
		return SqlSession.selectList("ReserveMapper.selectproreslist",vo);
	}

	public List<HashMap<String, String>> getTimeCheck(ReserveVO rvo) {
		return SqlSession.selectList("ReserveMapper.selectTimecheck",rvo);
	}

	public int getHoliday(ReserveVO rvo) {
		return SqlSession.selectOne("ReserveMapper.selectHoliday", rvo);
	}

	public int InsReservergs(ReserveVO vo) {
		return SqlSession.insert("ReserveMapper.insreservergs",vo);
	}

	public List<ReserveVO> getresListDayComp(PromotionVO pvo) {
		return SqlSession.selectList("ReserveMapper.selectResListDayComp", pvo);
	}

	public List<HashMap<String, String>> getHolidayList(String pro_no) {
		return SqlSession.selectList("ReserveMapper.selectHolidayList",pro_no);
	}

	public List<HashMap<String, String>> getProTimeList(String pro_no) {
		return SqlSession.selectList("ReserveMapper.selectProTimeList",pro_no);
	}

	public int getInsHoliday(JSONArray arr) {
		return SqlSession.insert("ReserveMapper.insHoliday",arr);
	}

}
