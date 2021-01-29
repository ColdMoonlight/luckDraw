package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.TbOwnerNew;

public interface TbOwnerNewMapper {
    int deleteByPrimaryKey(Integer newId);

    int insert(TbOwnerNew record);

    int insertSelective(TbOwnerNew record);

    TbOwnerNew selectByPrimaryKey(Integer newId);

    int updateByPrimaryKeySelective(TbOwnerNew record);

    int updateByPrimaryKey(TbOwnerNew record);

	List<TbOwnerNew> selectTbOwnerNewAll();

	int setAllToOne();

	int setAllToZero();
}