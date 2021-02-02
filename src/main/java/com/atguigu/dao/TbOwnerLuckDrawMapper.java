package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.TbOwnerLuckDraw;

public interface TbOwnerLuckDrawMapper {
    int deleteByPrimaryKey(Integer luckdrawId);

    int insert(TbOwnerLuckDraw record);

    int insertSelective(TbOwnerLuckDraw record);

    TbOwnerLuckDraw selectByPrimaryKey(Integer luckdrawId);

    int updateByPrimaryKeySelective(TbOwnerLuckDraw record);

    int updateByPrimaryKey(TbOwnerLuckDraw record);

	List<TbOwnerLuckDraw> selectTbOwnerLuckDrawNowUnLuck(TbOwnerLuckDraw tbOwnerLuckDrawReq);

	List<TbOwnerLuckDraw> selectTbOwnerLuckDrawAll();

	int updateAllToStatuszero();
	
    int updateToLuckSuccess(TbOwnerLuckDraw record);

	List<TbOwnerLuckDraw> selectTbOwnerLuckDrawAllByStatus(TbOwnerLuckDraw tbOwnerLuckDrawReq);
}