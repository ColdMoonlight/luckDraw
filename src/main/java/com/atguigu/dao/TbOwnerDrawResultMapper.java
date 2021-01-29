package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.TbOwnerDrawResult;

public interface TbOwnerDrawResultMapper {

    int insert(TbOwnerDrawResult record);

    TbOwnerDrawResult selectByPrimaryKey(Integer drawresultId);

    int updateByPrimaryKey(TbOwnerDrawResult record);
	
	int insertSelective(TbOwnerDrawResult record);
	
	int deleteByPrimaryKey(Integer drawresultId);
	
	int updateByPrimaryKeySelective(TbOwnerDrawResult record);
	
	int updateAllDrawResultToGradezero();

	List<TbOwnerDrawResult> selectTbOwnerDrawResultAll();

	int deleteAll();
}