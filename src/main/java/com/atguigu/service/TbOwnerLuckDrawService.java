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
	 * 	3.0
	 * */
	public int insertSelective(TbOwnerLuckDraw TbOwnerLuckDraw) {
		int intReslut = TbOwnerLuckDrawMapper.insertSelective(TbOwnerLuckDraw);
		return intReslut;
	}
	
	/**
	 * @author
	 * @param 
	 * @exception 删除本条信息
	 * 	3.0
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
	
//	/**
//	 * @author Shinelon
//	 * @param TbOwnerLuckDraw
//	 * @exception 查看用户信息是否存在
//	 * 	3.0
//	 * */
//	public List<TbOwnerLuckDraw> selectTbOwnerLuckDraw(TbOwnerLuckDraw TbOwnerLuckDraw) {
//		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectTbOwnerLuckDraw(TbOwnerLuckDraw);
//		return TbOwnerLuckDrawList;
//	}
//	/**
//	 * @author Shinelon
//	 * @param TbOwnerLuckDraw
//	 * @exception 查看用户信息是否存在
//	 * 	3.0
//	 * */
//	public TbOwnerLuckDraw selectTbOwnerLuckDrawById(TbOwnerLuckDraw TbOwnerLuckDraw) {
//		TbOwnerLuckDraw  TbOwnerLuckDrawOne = TbOwnerLuckDrawMapper.selectTbOwnerLuckDrawById(TbOwnerLuckDraw);
//		return TbOwnerLuckDrawOne;
//	}
	
	
//	/**
//	 * @author Shinelon
//	 * @param 
//	 * @exception 查看全部用户信息
//	 * 	3.0
//	 * */
//	public List<TbOwnerLuckDraw> selectTbOwnerLuckDrawGetAll() {
//		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectTbOwnerLuckDrawGetAll();
//		return TbOwnerLuckDrawList;
//	}
//	/**
//	 * @author Shinelon
//	 * @param 
//	 * @exception 查看全部用户信息
//	 * 
//	 * */
//	public List<TbOwnerLuckDraw> selectTbOwnerLuckDrawGetAllByParentId() {
//		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectTbOwnerLuckDrawGetAllByParentId();
//		return TbOwnerLuckDrawList;
//	}
//	
//	/**
//	 * @author
//	 * @param 
//	 * @exception 查看全部用户信息
//	 * 	3.0
//	 * */
//	public List<TbOwnerLuckDraw> selectMenuTbOwnerLuckDrawGetAll() {
//		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectMenuTbOwnerLuckDrawGetAll();
//		return TbOwnerLuckDrawList;
//	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 通过CatalogBySeo查找该类的详情
	 * 	3.0
	 * */
//	public List<TbOwnerLuckDraw> selectTbOwnerLuckDrawBySeo(TbOwnerLuckDraw TbOwnerLuckDraw) {
//		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectTbOwnerLuckDrawBySeo(TbOwnerLuckDraw);
//		return TbOwnerLuckDrawList;
//	}
//	/**
//	 * @autho	onuse	20191226	检查
//	 * @param TbOwnerLuckDraw
//	 * @exception	
//	 * 	3.0
//	 * */
//	public List<TbOwnerLuckDraw> selectCataloglistByParam(TbOwnerLuckDraw TbOwnerLuckDraw) {
//		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectCataloglistByParam(TbOwnerLuckDraw);
//		return TbOwnerLuckDrawList;
//	}
//	
//	/**
//	 * @autho	3.0
//	 * @param TbOwnerLuckDraw
//	 * @exception
//	 * 	3.0	
//	 * */
//	public List<TbOwnerLuckDraw> selectTbOwnerLuckDrawBackSearch(TbOwnerLuckDraw TbOwnerLuckDrawReq) {
//		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectTbOwnerLuckDrawBackSearch(TbOwnerLuckDrawReq);
//		return TbOwnerLuckDrawList;
//	}
//	/**
//	 * @autho	3.0
//	 * @param TbOwnerLuckDraw
//	 * @exception
//	 * 	3.0	
//	 * */
//	public List<TbOwnerLuckDraw> selectMenuTbOwnerLuckDrawGetAllOnlyFrontUsed() {
//		List<TbOwnerLuckDraw>  TbOwnerLuckDrawList = TbOwnerLuckDrawMapper.selectMenuTbOwnerLuckDrawGetAllOnlyFrontUsed();
//		return TbOwnerLuckDrawList;
//	}

}
