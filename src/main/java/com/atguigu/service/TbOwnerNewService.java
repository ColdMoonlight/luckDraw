package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.TbOwnerNew;
import com.atguigu.dao.TbOwnerNewMapper;

@Service
public class TbOwnerNewService {
	
	@Autowired
	TbOwnerNewMapper TbOwnerNewMapper;

	/**
	 * @author Shinelon
	 * @param TbOwnerNew
	 * @exception add方法用户信息是否存在
	 * 	3.0
	 * */
	public int insertSelective(TbOwnerNew TbOwnerNew) {
		int intReslut = TbOwnerNewMapper.insertSelective(TbOwnerNew);
		return intReslut;
	}
	
	/**
	 * @author
	 * @param 
	 * @exception 删除本条信息
	 * 	3.0
	 * */
	public int deleteByPrimaryKey(int CatalogId) {
		int  intReslut = TbOwnerNewMapper.deleteByPrimaryKey(CatalogId);
		return intReslut;
	}

	/**
	 * @author	3.0
	 * @param 
	 * @exception 更新本条信息
	 * */
	public int updateByPrimaryKeySelective(TbOwnerNew TbOwnerNew) {
		int  intReslut = TbOwnerNewMapper.updateByPrimaryKeySelective(TbOwnerNew);
		return intReslut;
	}

	public int setAllToOne() {
		int  intReslut = TbOwnerNewMapper.setAllToOne();
		return intReslut;
	}

	public int setAllToZero() {
		int  intReslut = TbOwnerNewMapper.setAllToZero();
		return intReslut;
	}

}
