package com.atguigu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.TbOwnerLuckDraw;
import com.atguigu.dao.TbOwnerLuckDrawMapper;

@Service
public class TbOwnerLuckDrawService {
	
	@Autowired
	TbOwnerLuckDrawMapper TbOwnerLuckDrawMapper;

	/**
	 * @author Shinelon
	 * @param TbOwnerLuckDraw
	 * @exception add方法用户信息是否存在
	 * 	1.0
	 * */
	public int insertSelective(TbOwnerLuckDraw TbOwnerLuckDraw) {
		int intReslut = TbOwnerLuckDrawMapper.insertSelective(TbOwnerLuckDraw);
		return intReslut;
	}
	
	/**
	 * @author
	 * @exception 删除本条信息
	 * 	2.0
	 * */
	public int deleteByPrimaryKey(int CatalogId) {
		int  intReslut = TbOwnerLuckDrawMapper.deleteByPrimaryKey(CatalogId);
		return intReslut;
	}

	/**
	 * @author	3.0
	 * @param 
	 * @exception 更新本条信息
	 * */
	public int updateByPrimaryKeySelective(TbOwnerLuckDraw TbOwnerLuckDraw) {
		int  intReslut = TbOwnerLuckDrawMapper.updateByPrimaryKeySelective(TbOwnerLuckDraw);
		return intReslut;
	}

	public List<TbOwnerLuckDraw> selectTbOwnerLuckDrawNowUnLuck(TbOwnerLuckDraw tbOwnerLuckDrawReq) {
		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectTbOwnerLuckDrawNowUnLuck(tbOwnerLuckDrawReq);
		return TbOwnerLuckDrawList;
	}

	public List<TbOwnerLuckDraw> selectTbOwnerLuckDrawAll() {
		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectTbOwnerLuckDrawAll();
		return TbOwnerLuckDrawList;
	}

	public int updateAllToStatuszero() {
		int  intReslut = TbOwnerLuckDrawMapper.updateAllToStatuszero();
		return intReslut;
	}
	
	public int updateToLuckSuccess(TbOwnerLuckDraw TbOwnerLuckDraw) {
		int  intReslut = TbOwnerLuckDrawMapper.updateToLuckSuccess(TbOwnerLuckDraw);
		return intReslut;
	}

	public List<TbOwnerLuckDraw> selectTbOwnerLuckDrawAllByStatus(TbOwnerLuckDraw tbOwnerLuckDrawReq) {
		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectTbOwnerLuckDrawAllByStatus(tbOwnerLuckDrawReq);
		return TbOwnerLuckDrawList;
	}
	
}
